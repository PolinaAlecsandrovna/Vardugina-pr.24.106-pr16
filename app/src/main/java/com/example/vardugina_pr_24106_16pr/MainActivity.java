package com.example.vardugina_pr_24106_16pr;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextInput;
    private TextView textViewResult;
    private Button btnSave, btnLoad;
    private SharedPreferences sharedPreferences;
    private final String SAVED_TEXT_KEY = "saved_text";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextInput = findViewById(R.id.editTextData);
        textViewResult = findViewById(R.id.textViewResult);
        btnSave = findViewById(R.id.btnSave);
        btnLoad = findViewById(R.id.btnLoad);

        btnSave.setOnClickListener(this);
        btnLoad.setOnClickListener(this);

        loadTextData();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnSave) {
            saveTextData();
        } else if (v.getId() == R.id.btnLoad) {
            loadTextData();
        }
    }

    private void saveTextData() {
        sharedPreferences = getSharedPreferences("MyAppPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String textToSave = editTextInput.getText().toString();
        editor.putString(SAVED_TEXT_KEY, textToSave);
        editor.apply();
        Toast.makeText(this, "Текст сохранен!", Toast.LENGTH_SHORT).show();
    }

    private void loadTextData() {
        sharedPreferences = getSharedPreferences("MyAppPrefs", MODE_PRIVATE);
        String loadedText = sharedPreferences.getString(SAVED_TEXT_KEY, "");
        textViewResult.setText(loadedText);
        Toast.makeText(this, "Текст загружен", Toast.LENGTH_SHORT).show();
    }
}