package com.itonem.bookadmin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ChapterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter);
        Chapter chapter = new Chapter();
        chapter.show(getSupportFragmentManager(),"Show Chapter");
    }
}
