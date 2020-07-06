package com.itonem.bookadmin;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void goBack()
    {
        super.onBackPressed();;
    }
    @Override
    public void onBackPressed() {


        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Comfirmation");
        alert.setMessage("Are You Sure To Exit?");
        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                goBack();
            }
        });
        alert.setNegativeButton("Cancel ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alert.show();
    }

    public void buCategory(View view) {
        Intent intent = new Intent(getApplicationContext(),CategoryActivity.class);
        startActivity(intent);
    }

    public void buAuthor(View view) {
        Intent intent = new Intent(getApplicationContext(),AuthorActivity.class);
        startActivity(intent);
    }

    public void PDF(View view) {
        Intent intent = new Intent(getApplicationContext(),BookActivity.class);
        startActivity(intent);
    }

    public void buAudioBook(View view) {
        Intent intent = new Intent(getApplicationContext(),BookActivity.class);
        startActivity(intent);
    }
}
