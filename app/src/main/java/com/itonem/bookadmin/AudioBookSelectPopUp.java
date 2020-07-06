package com.itonem.bookadmin;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class AudioBookSelectPopUp extends BottomSheetDialogFragment {
 RecyclerView rclist;

 FirebaseFirestore db = FirebaseFirestore.getInstance();
 CollectionReference audiobookSelect;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.audiobookselectpopup,container,false);

        rclist=myView.findViewById(R.id.audiolists);

        FirebaseFirestore fm =FirebaseFirestore.getInstance();
        CollectionReference db = fm.collection(getString(R.string.audio_book));

        db.addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {

                ArrayList<AudioBookModel> audiomodels = new ArrayList<>();
                for (DocumentSnapshot  s: queryDocumentSnapshots){
                    AudioBookModel model =s.toObject(AudioBookModel.class);
                    audiomodels.add(model);

                }

                AudioBookListAdapter audioBookListAdapter  = new AudioBookListAdapter(audiomodels);
                rclist.setAdapter(audioBookListAdapter);
                rclist.setLayoutManager(new LinearLayoutManager(
                        getContext(),
                        RecyclerView.VERTICAL,
                        false
                ));
            }
        });

        return myView;
    }
}

