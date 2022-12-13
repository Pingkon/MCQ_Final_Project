package com.iub.mcq_final_project;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class QuizDbHelper extends SQLiteOpenHelper {
    private static QuizDbHelper instance;

    private QuizDbHelper(Context context){
        super(context,DATABASE_NAME, null,DATABASE_VERSION);
    }

    public static  synchronized  QuizDbHelper getInstance(Context context)
    {
        if(instance == null)
        {
            instance=new QuizDbHelper(context.getApplicationContext());
        }
        return  instance
    }


    public List<Category> getAllCategories()
    {
        List<Category> categoryList=new ArrayList<>();
         db =getReadableDatabase();
        Cursor c= db.rawQuery("Select * FROM " + CategoriesTable.TABLE_NAme, null);
        if(c.moveToFirst()){
            do{
                Category category =new Category();
                category.setId(c.getInt(c.getColumnIndex(CategoriesTable._ID)));
                category.setName(c.getString(c.getColumnIndex(CategoriesTable.COLUMN_NAME)));
                categoryList.add(category);
            } while(c.moveToNext());
        }
        c.close();
        return categoryList;
    }

    public ArrayList<Question> getQuestions(int categoryID, String difficulty)
    {
        String selection = QuestionsTable.COLUMN_CATEGORY_ID + " = ?" +
                " AND " + QuestionsTable.COLUMN_DIFFICULTY + " = ?";
        String[] selctionArgs = new String[]{String.valueOf(categoryID),difficulty};
        Cursor c=db.query(
                QuestionsTable.TABLE_NAME,
                null,
                selection,
                selectionArgs,
                null,
                null,
                null
        );


    }
}
