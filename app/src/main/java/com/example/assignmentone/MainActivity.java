package com.example.assignmentone;

import android.content.Intent;
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
 *     <li>Part G - every image button also starts {@link DetailActivity} with
 *     an explicit Intent that carries a unique identifier for the topic that
 *     was clicked.</li>
 * </ul>
 *
 * <p>Part I: the class is kept small and every method has a single clear
 * purpose, with Javadoc comments explaining which part of the assignment it
 * implements.</p>
 */
public class MainActivity extends AppCompatActivity {

    /**
     * The four topics are identified by their position in the arrays stored in
     * res/values/array.xml.  These constants are the "unique identifier" that
     * is passed to {@link DetailActivity} through the Intent extra.
     */
    public static final int TOPIC_FACILITIES = 0;
    public static final int TOPIC_EVENTS = 1;
    public static final int TOPIC_CLUBS = 2;
    public static final int TOPIC_SUPPORT = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registerClickHandlers();
    }

    /**
     * Part E and Part G: wires up the four image buttons.
     *
     * <p>The button ids are identical in the portrait and the landscape
     * layout, so a single set of listeners works for both orientations.</p>
     */
    private void registerClickHandlers() {
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
     * Part G: builds an explicit Intent that starts {@link DetailActivity} and
     * passes the identifier of the clicked topic.
     *
     * @param topicId the unique identifier of the clicked topic
     */
    private void showTopic(int topicId) {
        // Part E - the Toast confirms the onClick handler is working.
        Toast.makeText(this, topicLabel(topicId) + " clicked", Toast.LENGTH_SHORT).show();

        // Part G - an explicit Intent that starts DetailActivity.  The topic
        // identifier is passed through the Intent so that DetailActivity knows
        // which content to display.
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(DetailActivity.EXTRA_TOPIC_ID, topicId);
        startActivity(intent);
    }

    /**
     * Returns the human readable name of a topic.
     * The name is read from the titles array in res/values/array.xml so that
     * the Toast and the Detail Activity always use the same wording.
     *
     * @param topicId the unique identifier of the topic
     * @return the title of the topic
     */
    private String topicLabel(int topicId) {
        String[] titles = getResources().getStringArray(R.array.string_array_titles);
        return titles[topicId];
    }
}
