package com.itonem.bookadmin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class AudioBookDAO {
    String ColId="Id",ColName="Name",TbName="AudioBookTable",ColImage="Image",ColLink="Link",
            ColAuthor="Author",ColCategory="Category",ColDes="Desc";

    SQLiteDatabase db;
    public AudioBookDAO(Context context) {
        MyDatabase dbhelper = new MyDatabase(context);
        db = dbhelper.getWritableDatabase();
    }

    public long saveData(AudioBookModel model)
    {


        ContentValues values = new ContentValues();
        values.put(ColName,model.Name);
        values.put(ColImage,model.Image);
        values.put(ColLink,model.Link);
        values.put(ColAuthor,model.Author);
        values.put(ColCategory,model.Category);
        values.put(ColDes,model.Desc);

        long Id = db.insert(TbName,null,values);
        return Id;

    }


    public ArrayList<AudioBookModel> getModels ()
    {
        Cursor cursor = db.rawQuery("select * from "+TbName,null);
        ArrayList<AudioBookModel> AudioBookModels = new ArrayList<>();
        while (cursor.moveToNext())
        {
            AudioBookModel model = new AudioBookModel();
            model.Id=cursor.getInt(cursor.getColumnIndex(ColId));
            model.Name = cursor.getString(cursor.getColumnIndex(ColName));
            model.Image = cursor.getString(cursor.getColumnIndex(ColImage));
            model.Link=cursor.getString(cursor.getColumnIndex(ColLink));
            model.Author=cursor.getString(cursor.getColumnIndex(ColAuthor));
            model.Category=cursor.getString(cursor.getColumnIndex(ColCategory));
            model.Desc=cursor.getString(cursor.getColumnIndex(ColDes));

            AudioBookModels.add(model);
            AudioBookModels.add(model);
        }
        return  AudioBookModels;
    }

    public long updateModel(AudioBookModel edtiModel)
    {
        ContentValues values = new ContentValues();
        values.put(ColName,edtiModel.Name);
        values.put(ColImage,edtiModel.Image);
        values.put(ColLink,edtiModel.Link);
        values.put(ColAuthor,edtiModel.Author);
        values.put(ColCategory,edtiModel.Category);
        values.put(ColDes,edtiModel.Desc);



        String where =ColId+"=?";
        String [] whereArgs = new String[]{String.valueOf(edtiModel.Id)};
        long Id = db.update(TbName,values,where,whereArgs);
        return Id;
    }

    public long deleteModel (int Id)
    {
        String where =ColId+"=?";
        String [] whereArgs = new String[]{String.valueOf(Id)};
        long count = db.delete(TbName,where,whereArgs);
        return  count;
    }

}
