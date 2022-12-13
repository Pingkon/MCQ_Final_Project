package com.iub.mcq_final_project;

import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class StartingScreenActivity extends AppCompatActivity {
public static final String EXTRA_CATEGORY_ID= "extraCategoryID";
    public static final String EXTRA_CATEGORY_NAME= "extraCategoryNAME";
    public static final String EXTRA_DIFFICULTY= "extraDifficulty";
    private Spinner SpinnerCatergory;


    private void startQuiz()
    {Category selectedCategory=(Category) spinnerCategory.getSelectedItem();
        int categoryID= selectedCategory.getId();
        String categoryName =selectedCategory.getName();
       intent.putExtra(EXTRA_CATEGORY_ID,categoryID);
        intent.putExtra(EXTRA_CATEGORY_NAME,categoryID);


    }
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        sprinnerCatergory = findViewById(R.id.spinner_difficulty);
        loadCategories();
        loadDifficultyLevels();
    }
    private  void loadCategories()
    {
        QuizDbHelper dbHelper =QuizDbHelper.getInstance(this);
        List<Category> categories =dbHelper.getAllCategories();

        ArrayAdapter<Category>adapterCategories =new ArrayAdapter<Category>(this, android.R.layout.simple_spinner_item,categories);
        adapterCategories.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategory.setAdapter(adapterCategories);

    }
    private void loadDifficultyLevels()
    {
        String[] difficultyLevels=Question.getAllDifficultyLevels();
        ArrayAdapter<String>adapterDifficulty = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,difficultyLevels);
        adapterDifficulty.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDifficulty.setAdapter(adapterDifficulty);
    }}
