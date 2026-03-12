package com.example.vardugina_pr_24106_16pr;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private EditText inputText;
    private TextView outputText;
    private String savedText = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputText = findViewById(R.id.inputText);
        outputText = findViewById(R.id.outputText);
        Button saveButton = findViewById(R.id.saveButton);
        Button showButton = findViewById(R.id.showButton);

        saveButton.setOnClickListener(v -> {
            savedText = inputText.getText().toString();
            Toast.makeText(MainActivity.this, "Сохранено!", Toast.LENGTH_SHORT).show();
        });

        showButton.setOnClickListener(v -> outputText.setText(savedText));
    }
}