package com.itonem.bookadmin;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import static com.itonem.bookadmin.R.string.author_str;
import static com.itonem.bookadmin.R.string.cataegory_str;

public class AuthorPopUp  extends BottomSheetDialogFragment {

    Button btnsave,btncanel;
    EditText name,image;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    CollectionReference authorRef;
    AuthorDAO dao;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      View myView = inflater.inflate(R.layout.author,container,false);

        btnsave  = myView.findViewById(R.id.btnsave);
        authorRef = db.collection(getString(author_str));
        name = myView.findViewById(R.id.name);
        image =myView.findViewById(R.id.image);
        dao = new AuthorDAO(getContext());
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AuthorModel model = new AuthorModel();
                model.Name=name.getText().toString().trim();
                model.Image = image.getText().toString().trim();
                model.Id = (int)dao.saveData(model);
             authorRef.add(model);
                name.setText("");
                image.setText("");

            }
        });


        return  myView;
    }
}
