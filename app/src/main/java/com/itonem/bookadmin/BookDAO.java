package com.itonem.bookadmin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class BookDAO {

    String ColId="Id",ColName="Name",TbName="BookTable",ColImage="Image",ColLink="Link",
            ColAuthor="Author",ColCategory="Category",ColDes="Desc";

    SQLiteDatabase db;
    public BookDAO(Context context) {
        MyDatabase dbhelper = new MyDatabase(context);
        db = dbhelper.getWritableDatabase();
    }

    public long saveData(BookModel model)
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


    public ArrayList<BookModel> getModels ()
    {
        Cursor cursor = db.rawQuery("select * from "+TbName,null);
        ArrayList<BookModel> BookModels = new ArrayList<>();
        while (cursor.moveToNext())
        {
            BookModel model = new BookModel();
            model.Id=cursor.getInt(cursor.getColumnIndex(ColId));
            model.Name = cursor.getString(cursor.getColumnIndex(ColName));
            model.Image = cursor.getString(cursor.getColumnIndex(ColImage));
            model.Link=cursor.getString(cursor.getColumnIndex(ColLink));
            model.Author=cursor.getString(cursor.getColumnIndex(ColAuthor));
            model.Category=cursor.getString(cursor.getColumnIndex(ColCategory));
            model.Desc=cursor.getString(cursor.getColumnIndex(ColDes));

            BookModels.add(model);
            BookModels.add(model);
        }
        return  BookModels;
    }

    public long updateModel(BookModel edtiModel)
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
