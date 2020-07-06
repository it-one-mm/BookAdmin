package com.itonem.bookadmin;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Chapter extends BottomSheetDialogFragment {

    EditText name,image;
    Button btnsave,btncancel,choseaudiobook;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    CollectionReference ref;

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


ref=db.collection(getString(R.string.author_str));


                ref.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                                if (queryDocumentSnapshots.size()>0){
                                    AudioBookSelectPopUp bookSelectPopUp = new AudioBookSelectPopUp();
                                    bookSelectPopUp.show(getFragmentManager(),"AudioBookSelectBook");
                                }

                    }
                });


            }
        });

        return myView;
    }
}
