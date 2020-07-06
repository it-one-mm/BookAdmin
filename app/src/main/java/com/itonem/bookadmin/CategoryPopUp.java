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

public class CategoryPopUp extends BottomSheetDialogFragment {
    Button btnsave,btncancel;
    EditText name,image;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    CollectionReference categoryRef;
    CategoryDAO dao;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.categorypopup,container,false);
        btnsave  = myView.findViewById(R.id.btnsave);
        categoryRef = db.collection(getString(R.string.cataegory_str));
        name = myView.findViewById(R.id.name);
        image =myView.findViewById(R.id.image);
        dao = new CategoryDAO(getContext());
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CategoryModel model = new CategoryModel();
                model.Name=name.getText().toString().trim();
                model.Image = image.getText().toString().trim();
                model.Id = (int)dao.saveData(model);
                categoryRef.add(model);
                name.setText("");
                image.setText("");

            }
        });
        return  myView;
    }
}
