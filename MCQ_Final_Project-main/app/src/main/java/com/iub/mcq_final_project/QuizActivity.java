package com.iub.mcq_final_project;

import android.widget.TextView;

public class QuizActivity {

    private TextView textViewCategory;


    @Override
    protected  void onCreate(Bundle savedInstanceState)
    {
        textViewCategory = findViewById(R.id.text_view_category);









        int categoryID=intent.getIntExtra(StartingScreenActivity.EXTRA_CATEGORY_ID,0);
        String categoryName= intent.getStringExtra(StartingScreenActivity.EXTRA_CATEGORY_NAME);

        textViewCategory.setText("Category: "+ categoryName);
        if(savedInstanceState ==null)
        {
            QuizDbHelper dbHelper=QuizDbHelper.getInstance(this);
            questionList=dbHelper.getQuestions(categoryID,difficulty);

        }
    }

}
