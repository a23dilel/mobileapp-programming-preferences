package com.example.project;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences.Editor myPreferenceEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SharedPreferences myPreferenceRef = getPreferences(MODE_PRIVATE);
        myPreferenceEditor = myPreferenceRef.edit();

        // Grab textview id
        TextView prefTextRef = findViewById(R.id.preferenceText);

        // trying to find preference data and if data was found then print value on textView otherwise print "No preference found".
        prefTextRef.setText(myPreferenceRef.getString("data1", "No preference found."));

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Grab edit view id
                EditText editText = findViewById(R.id.editText);

                // add string value and commit.
                myPreferenceEditor.putString("data1", editText.getText().toString());
                myPreferenceEditor.commit();
            }
        });
    }
}
