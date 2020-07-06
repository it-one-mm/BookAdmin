package com.itonem.bookadmin;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Chapter extends BottomSheetDialogFragment {

    EditText name,image;
    Button btnsave,btncancel,choseaudiobook;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.chapter,container,false);

        name = myView.findViewById(R.id.name);
        image= myView.findViewById(R.id.image);
        btnsave=myView.findViewById(R.id.btnsave);
        btncancel=myView.findViewById(R.id.btncancel);
        choseaudiobook=myView.findViewById(R.id.choseaudiobook);

        choseaudiobook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AudioBookSelectPopUp bookSelectPopUp = new AudioBookSelectPopUp();
                bookSelectPopUp.show(getFragmentManager(),"AudioBookSelectBook");

            }
        });

        return myView;
    }
}
