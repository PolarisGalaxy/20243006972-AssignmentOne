package com.example.assignmentone;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * MainActivity of the CampusLife application.
 *
 * <p>Responsibilities:</p>
 * <ul>
 *     <li>Part B / Part D - hosts the responsive layout (portrait 2x2 grid and
 *     landscape single row of image buttons).</li>
 *     <li>Part E - every image button raises a Toast so the click can be
 *     verified.</li>
 * </ul>
 */
public class MainActivity extends AppCompatActivity {

    /**
     * The four topics are identified by their position in the arrays stored in
     * res/values/array.xml.  These constants are the "unique identifier" that
     * Part G passes to {@link DetailActivity} through the Intent extra.
     */
    public static final int TOPIC_FACILITIES = 0;
    public static final int TOPIC_EVENTS = 1;
    public static final int TOPIC_CLUBS = 2;
    public static final int TOPIC_SUPPORT = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Part E: wire up the four image buttons.  The button ids are
        // identical in the portrait and the landscape layout, so a single set
        // of listeners works for both orientations.
        ImageButton facilitiesButton = findViewById(R.id.btnFacilities);
        ImageButton eventsButton = findViewById(R.id.btnEvents);
        ImageButton clubsButton = findViewById(R.id.btnClubs);
        ImageButton supportButton = findViewById(R.id.btnSupport);

        facilitiesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTopic(TOPIC_FACILITIES);
            }
        });

        eventsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTopic(TOPIC_EVENTS);
            }
        });

        clubsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTopic(TOPIC_CLUBS);
            }
        });

        supportButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTopic(TOPIC_SUPPORT);
            }
        });
    }

    /**
     * Part E: shows a Toast confirming which image button was clicked.
     *
     * @param topicId the unique identifier of the clicked topic
     */
    private void showTopic(int topicId) {
        Toast.makeText(this, topicLabel(topicId) + " clicked", Toast.LENGTH_SHORT).show();
    }

    /**
     * Returns the human readable name of a topic.
     * The name is read from the titles array in res/values/array.xml so that
     * the Toast always uses the same wording as the rest of the application.
     *
     * @param topicId the unique identifier of the topic
     * @return the title of the topic
     */
    private String topicLabel(int topicId) {
        String[] titles = getResources().getStringArray(R.array.string_array_titles);
        return titles[topicId];
    }
}
