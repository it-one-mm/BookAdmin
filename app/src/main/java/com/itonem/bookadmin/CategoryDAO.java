package com.itonem.bookadmin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;

public class CategoryDAO {

    String ColId="Id",ColName="Name",TbName="CategoryTable",ColImage="Image";

    SQLiteDatabase db;
    public CategoryDAO(Context context) {
        MyDatabase dbhelper = new MyDatabase(context);
        db = dbhelper.getWritableDatabase();
    }

    public long saveData(CategoryModel model)
    {


        ContentValues values = new ContentValues();
        values.put(ColName,model.Name);
        values.put(ColImage,model.Image);
        long Id = db.insert(TbName,null,values);
        return Id;

    }


    public ArrayList<CategoryModel> getModels ()
    {
        Cursor cursor = db.rawQuery("select * from "+TbName,null);
        ArrayList<CategoryModel> categoryModels = new ArrayList<>();
        while (cursor.moveToNext())
        {
            CategoryModel model = new CategoryModel();
            model.Id=cursor.getInt(cursor.getColumnIndex(ColId));
            model.Name = cursor.getString(cursor.getColumnIndex(ColName));
            model.Image = cursor.getString(cursor.getColumnIndex(ColImage));

            categoryModels.add(model);
        }
        return  categoryModels;
    }

    public long updateModel(CategoryModel edtiModel)
    {
        ContentValues values = new ContentValues();
        values.put(ColName,edtiModel.Name);
        values.put(ColImage,edtiModel.Image);
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
