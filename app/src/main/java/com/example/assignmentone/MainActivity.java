package com.example.assignmentone;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Part A: the "Empty Views Activity" created for this assignment.
 *
 * <p>Its layout (activity_main.xml) is rebuilt in Parts B and D and its click
 * handlers are added in Part E, so this class is intentionally minimal here.</p>
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
