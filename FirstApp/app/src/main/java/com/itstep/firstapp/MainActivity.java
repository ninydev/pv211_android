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
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;
import com.itstep.firstapp.colors.adapters.ColorListAdapter;
import com.itstep.firstapp.colors.adapters.ColorSpinnerAdapter;
import com.itstep.firstapp.countries.Country;
import com.itstep.firstapp.countries.CountryAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ColorListAdapter colorListAdapter;
    ColorSpinnerAdapter colorSpinnerAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.color_list_view);
        Spinner spinner = findViewById(R.id.color_spinner);



        colorListAdapter = new ColorListAdapter(this, android.R.layout.simple_list_item_1);
        listView.setAdapter(colorListAdapter);

        colorSpinnerAdapter = new ColorSpinnerAdapter(this, android.R.layout.simple_spinner_item);
        spinner.setAdapter(colorSpinnerAdapter);


    }


}