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

        // Placeholder content - Part H replaces this with the real data.
        TextView topicName = findViewById(R.id.txtTopicName);
        TextView detailTitle = findViewById(R.id.txtDetailTitle);
        TextView detailContent = findViewById(R.id.txtDetailContent);
        ImageView topicIcon = findViewById(R.id.imgTopicIcon);
        ImageView topicImage = findViewById(R.id.imgTopicImage);

        topicName.setText(R.string.detail_topic_name);
        detailTitle.setText(R.string.detail_title);
        detailContent.setText(R.string.detail_content);
    }
}
