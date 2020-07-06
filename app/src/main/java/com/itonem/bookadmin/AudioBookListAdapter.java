package com.itonem.bookadmin;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AudioBookListAdapter extends RecyclerView.Adapter<AudioBookListAdapter.AudioBookHolder> {

    ArrayList<AudioBookModel> audioBookModels = new ArrayList<>();

    public AudioBookListAdapter(ArrayList<AudioBookModel> audioBookModels) {
        this.audioBookModels = audioBookModels;
    }

    @NonNull
    @Override
    public AudioBookHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      LayoutInflater inf = LayoutInflater.from(
                parent.getContext());
      View myView = inf.inflate(R.layout.audionumberlist,parent,false);
      AudioBookHolder myholder = new AudioBookHolder(myView);
        return myholder;
    }

    @Override
    public void onBindViewHolder(@NonNull AudioBookHolder holder, int position) {

        holder.no.setText(position+1+"");
        holder.name.setText(audioBookModels.get(position).Name);
    }

    @Override
    public int getItemCount() {
        return audioBookModels.size();
    }

    public class AudioBookHolder extends RecyclerView.ViewHolder{
     TextView no,name;

     public AudioBookHolder(@NonNull View itemView) {
         super(itemView);
         no=itemView.findViewById(R.id.number);
         name = itemView.findViewById(R.id.bookname);
     }
 }
}
