package com.itonem.bookadmin;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import static com.itonem.bookadmin.R.string.author_str;
import static com.itonem.bookadmin.R.string.book_str;
import static com.itonem.bookadmin.R.string.cataegory_str;

public class AudioBookPopUp  extends BottomSheetDialogFragment {
    EditText name,image,link,desc;
    Button btnsave,btncancel;
    Spinner author,category;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    CollectionReference bookRef;
    AudioBookDAO dao;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.audiobookpopup,container,false);

        author=myView.findViewById(R.id.author);
        category=myView.findViewById(R.id.category);
        btnsave  = myView.findViewById(R.id.btnsave);

        bookRef = db.collection(getString(R.string.audio_book));
        link=myView.findViewById(R.id.link);
        desc=myView.findViewById(R.id.Desc);
        name = myView.findViewById(R.id.name);
        image =myView.findViewById(R.id.image);
        dao = new AudioBookDAO(getContext());




        FirebaseFirestore fm = FirebaseFirestore.getInstance();
        CollectionReference db =fm.collection(getString(cataegory_str));
        db.addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {

                ArrayList<String> categoryNames = new ArrayList<>();
                for(DocumentSnapshot s : queryDocumentSnapshots){
                    CategoryModel model = s.toObject(CategoryModel.class);
                    categoryNames.add(model.Name);

                }
                ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(),
                        android.R.layout.simple_dropdown_item_1line,
                        categoryNames);
                category.setAdapter(adapter);
            }
        });

        CollectionReference ds = fm.collection(getString(author_str));
        ds.addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {

                ArrayList<String> authorNames = new ArrayList<>();
                for (DocumentSnapshot d : queryDocumentSnapshots){
                    AuthorModel model = d.toObject(AuthorModel.class);
                    authorNames.add(model.Name);


                }
                ArrayAdapter<String> adapter = new ArrayAdapter<>(
                        getContext(),
                        android.R.layout.simple_dropdown_item_1line,
                        authorNames
                );
                author.setAdapter(adapter);
            }
        });





        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AudioBookModel model = new AudioBookModel();
                model.Name=name.getText().toString().trim();
                model.Image = image.getText().toString().trim();
                model.Link=link.getText().toString().trim();
                model.Desc=desc.getText().toString().trim();
                model.Category=category.getSelectedItem().toString();
                model.Author=author.getSelectedItem().toString();
                model.Id = (int)dao.saveData(model);
                bookRef.add(model);
                name.setText("");
                image.setText("");
                link.setText("");
                desc.setText("");


            }
        });


        return  myView;
    }
}
