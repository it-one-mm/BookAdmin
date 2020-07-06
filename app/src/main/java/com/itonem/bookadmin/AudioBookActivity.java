package com.itonem.bookadmin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AudioBookActivity extends AppCompatActivity {

    FloatingActionButton add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_book);
        add=findViewById(R.id.add);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* AudioBookPopUp audiobookPopUp = new AudioBookPopUp();
                audiobookPopUp.show(getSupportFragmentManager(),"Add BookPopUp");*/
                Chapter chapter = new Chapter();
                chapter.show(getSupportFragmentManager(),"Show Chapter");
            }
        });
    }
}
