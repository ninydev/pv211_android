package com.itstep.firstapp;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> countriesInActivity = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Data (countries) initialization
        String [] countriesLoadFromResources = getResources().getStringArray(R.array.countries);
        createCountries();

        ListView countryListView = findViewById(R.id.country_list_view);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_activated_1,
                // R.layout.my_string_list_item,
                // countriesLoadFromResources
                countriesInActivity
        );

        countryListView.setAdapter(arrayAdapter);

        countryListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(view.getContext(),
                        "Clicked: " + countriesLoadFromResources[position], Toast.LENGTH_SHORT).show();
            }
        });

        Button btnAddCountry = findViewById(R.id.btn_add_country);

        btnAddCountry.setOnClickListener(v -> {
            String newCountry = ((EditText) findViewById(R.id.country_name)).getText().toString();
            if (newCountry.isEmpty()) {
                Toast.makeText(this, "Please enter a country name", Toast.LENGTH_SHORT).show();
            } else {
                countriesInActivity.add(newCountry);
                arrayAdapter.notifyDataSetChanged();
                ((EditText) findViewById(R.id.country_name)).setText("");
            }
        });



    }



    protected void workSeekBar() {
//        ((SeekBar) findViewById(R.id.seek_bar)).setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//            @Override
//            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//                TextView textView = findViewById(R.id.text_view);
//                textView.setText(String.valueOf(progress));
//            }
//
//            @Override
//            public void onStartTrackingTouch(SeekBar seekBar) {
//                Log.i("SEEK_BAR", "Started tracking");
//            }
//
//            @Override
//            public void onStopTrackingTouch(SeekBar seekBar) {
//                Log.i("SEEK_BAR", "Stopped tracking");
//            }
//        });
    }

    public void onJavaClick(View v) {
        boolean isChecked = ((android.widget.CheckBox) v).isChecked();
        if (isChecked) {
            Log.i("JAVA", "Java checkbox clicked");
            Toast.makeText(this, "Java checkbox clicked", Toast.LENGTH_SHORT).show();
        } else {
            Log.i("JAVA", "Java checkbox unchecked");
            Toast.makeText(this, "Java checkbox unchecked", Toast.LENGTH_SHORT).show();
        }
    }

    protected void workTextView() {
//        EditText editText = findViewById(R.id.edit_text);
//
//        editText.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
////                String msg = "Before: '" + s + "' " + start + " " + count + " " + after;
////                Log.i("EDIT_TEXT", msg);
////                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                TextView textView = findViewById(R.id.text_view);
//                textView.setText(s);
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                String msg = "After: '" + s + "'";
//                Log.i("EDIT_TEXT", msg);
//                Snackbar.make(findViewById(android.R.id.content), msg, Snackbar.LENGTH_SHORT)
//                        .setAction("Undo", v -> {
//                            // Handle undo action
//                        })
//                        .show();
//            }
//        });
    }

    protected void createCountries() {
        countriesInActivity.add("Ukraine");
        countriesInActivity.add("USA");
        countriesInActivity.add("Germany");
        countriesInActivity.add("France");
        countriesInActivity.add("Italy");
        countriesInActivity.add("Spain");
        countriesInActivity.add("Poland");
        countriesInActivity.add("Czech Republic");
    }
}