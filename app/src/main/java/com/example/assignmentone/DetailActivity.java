package com.example.assignmentone;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Part F: the second Activity of the CampusLife application.
 *
 * <p>It shows the details of one of the four student service areas.  The
 * layout is built from ViewGroups and Views only and contains no hard-coded
 * sizes.</p>
 */
public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Placeholder content - Part H replaces this with the real data.
        TextView topicName = findViewById(R.id.txtTopicName);
        TextView detailTitle = findViewById(R.id.txtDetailTitle);
        TextView detailContent = findViewById(R.id.txtDetailContent);

        topicName.setText(R.string.detail_topic_name);
        detailTitle.setText(R.string.detail_title);
        detailContent.setText(R.string.detail_content);
    }
}
