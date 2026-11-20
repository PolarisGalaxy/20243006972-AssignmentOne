# CampusLife - Assignment One

**Name:** Guo Yuqi
**Student ID:** 20243006972

An Android application that guides University of Waikato students through the
four main student service areas: Facilities, Events, Clubs and Support.

---

## Part A - Project setup

A new Android application named **AssignmentOne** was created using an *Empty
Views Activity* template.

| Setting | Value |
| --- | --- |
| Language | Java |
| Minimum API level | 24 (Android 7.0 Nougat) |
| Compile / target SDK | 34 |
| Package name | `com.example.assignmentone` |
| Android Gradle Plugin | 8.4.2 |

The Gradle build files, the manifest and the default theme are all in the
repository. See commit `Part A`.

## Part B - The XML layout (portrait)

`res/layout/activity_main.xml` duplicates the UI layout shown in Figure 1 of
the assignment:

* the top half of the screen shows the banner artwork with the title
  *"Welcome to CampusLife - Your Pocket Guide to University of Waikato"*
  centred over it in **40sp** (the only size the assignment allows to be
  hard-coded);
* the bottom half shows a green panel with a **2 x 2 grid** of image buttons -
  Facilities, Events, Clubs and Support.

The layout is built from ViewGroups and Views only (`ConstraintLayout`,
`LinearLayout`, `FrameLayout`, `ImageView`, `ImageButton`, `TextView`) and
contains **no hard-coded sizes**: every dimension comes from
`res/values/dimens.xml`, from a layout weight or from a percentage
(`app:layout_constraintHeight_percent="0.5"`).

## Part C - Android resources

* The application name is **CampusLife** (`res/values/strings.xml`).
* A new launcher icon was created from `img_campusLife_logo.webp` (copied into
  the project as `img_campus_life_logo.webp`, because Android resource names
  may only contain lowercase letters, digits and underscores):
  * `res/mipmap-anydpi-v26/` holds the adaptive icon XML (API 26+),
  * `res/mipmap-mdpi` ... `res/mipmap-xxxhdpi` hold the legacy PNG icons.
* The brand colours were added to `res/values/colors.xml`:
  * `green` = `#1B5E20`,
  * `light_green` = `#66BB6A`.
* `res/color/button_selector.xml` is a `ColorStateList` that shows the buttons
  **green** when they are not pressed and **light green** while they are
  pressed.

## Part D - The landscape layout

`res/layout-land/activity_main.xml` is a copy of the portrait layout with only
the lower half changed: the four image buttons now sit **next to each other in
a single row** instead of in a 2 x 2 grid, exactly as shown in Figure 4.

Android picks the correct file automatically because of the `-land` resource
qualifier.

## Part E - The onClick handlers

Each of the four `ImageButton`s has an `onClick` listener that raises a Toast
(`"... clicked"`). Because the button ids are identical in both the portrait
and the landscape layout, one set of listeners works in both orientations.

## Part F - The Detail Activity

`DetailActivity` and `res/layout/activity_detail.xml` were added. The layout
contains a header bar with the CampusLife logo, the topic icon and the topic
name, a large topic image and a `ScrollView` with the title and the body text.

## Part G - The explicit Intent

Every click handler builds an **explicit Intent** that starts
`DetailActivity` and passes a **unique identifier** for the topic that was
clicked:

```java
Intent intent = new Intent(this, DetailActivity.class);
intent.putExtra(DetailActivity.EXTRA_TOPIC_ID, topicId);
startActivity(intent);
```

The identifier is the position of the topic in the arrays (`0` = Facilities,
`1` = Events, `2` = Clubs, `3` = Support).

## Part H - Populating the Detail Activity from `array.xml`

`res/values/array.xml` contains three **parallel arrays**:
`string_array_images`, `string_array_titles` and `string_array_content`.

`DetailActivity` uses the identifier as the array index, so **no `if`
statements and no `switch` cases** are needed:

```java
String[] titles    = getResources().getStringArray(R.array.string_array_titles);
String[] contents  = getResources().getStringArray(R.array.string_array_content);
String[] imageNames = getResources().getStringArray(R.array.string_array_images);

String title    = titles[topicId];
String content  = contents[topicId];
String imageName = imageNames[topicId].trim();

int imageId = getResources().getIdentifier(imageName, "drawable", getPackageName());
```

## Part I - Code quality

* Every class and every method carries a Javadoc comment that states which
  part of the assignment it implements.
* `onCreate` in `MainActivity` is kept short - the click handling was moved
  into a clearly named `registerClickHandlers()` method.
* Every layout file starts with a comment that documents its structure.
* All shared sizes live in `res/values/dimens.xml`.

---

## Building the project

Open the project folder in Android Studio (Hedgehog or newer) and press
**Run**, or build from the command line:

```bash
gradle assembleDebug
```

The debug APK is written to `app/build/outputs/apk/debug/app-debug.apk`.

## Repository layout

```
20243006972-AssignmentOne/
|-- app/
|   |-- build.gradle
|   `-- src/main/
|       |-- AndroidManifest.xml
|       |-- java/com/example/assignmentone/
|       |   |-- MainActivity.java
|       |   `-- DetailActivity.java
|       `-- res/
|           |-- color/button_selector.xml
|           |-- drawable/          (the supplied images)
|           |-- layout/             (portrait + detail layouts)
|           |-- layout-land/        (landscape layout)
|           |-- mipmap-*/           (launcher icons)
|           `-- values/             (strings, colors, dimens, themes, array)
|-- build.gradle
├── gradle.properties
└── settings.gradle
```
