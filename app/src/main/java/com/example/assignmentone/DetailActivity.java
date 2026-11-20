package com.example.assignmentone;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Part F: the second Activity of the CampusLife application.
 *
 * <p>Part G: it is started with an explicit Intent from {@link MainActivity}
 * that carries a unique identifier for the selected topic.</p>
 *
 * <p>Part H: the identifier is used to look the topic up in the three parallel
 * arrays stored in res/values/array.xml (titles, content and image names) and
 * the Activity is populated from those arrays.  No if statements and no
 * switch cases are used - the identifier is simply used as the array index.</p>
 */
public class DetailActivity extends AppCompatActivity {

    /**
     * The key of the Intent extra that carries the unique identifier of the
     * topic that was selected in {@link MainActivity}.
     */
    public static final String EXTRA_TOPIC_ID = "com.example.assignmentone.TOPIC_ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Part G: read the unique identifier that was sent with the Intent.
        int topicId = getIntent().getIntExtra(EXTRA_TOPIC_ID, 0);

        // Part H: pull the three matching entries out of the arrays.
        String[] titles = getResources().getStringArray(R.array.string_array_titles);
        String[] contents = getResources().getStringArray(R.array.string_array_content);
        String[] imageNames = getResources().getStringArray(R.array.string_array_images);

        String title = titles[topicId];
        String content = contents[topicId];
        // The image names in array.xml are surrounded by whitespace, so they
        // are trimmed before they are turned into a resource id.
        String imageName = imageNames[topicId].trim();

        // Part H: populate the Activity with the data that was retrieved.
        TextView topicName = findViewById(R.id.txtTopicName);
        TextView detailTitle = findViewById(R.id.txtDetailTitle);
        TextView detailContent = findViewById(R.id.txtDetailContent);
        ImageView topicIcon = findViewById(R.id.imgTopicIcon);
        ImageView topicImage = findViewById(R.id.imgTopicImage);

        topicName.setText(title);
        detailTitle.setText(title);
        detailContent.setText(content);

        // The image names in array.xml are drawable resource names, so they
        // are resolved to a drawable id and then loaded.
        int imageId = getResources().getIdentifier(imageName, "drawable", getPackageName());
        topicIcon.setImageResource(imageId);
        topicImage.setImageResource(imageId);
    }
}
