package com.itstep.firstapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.itstep.firstapp.countries.Country;
import com.itstep.firstapp.countries.CountryAdapter;

import java.util.ArrayList;

public class CountryActivity extends AppCompatActivity {

    private ArrayList<String> countriesInActivity = new ArrayList<>();
    private ArrayList<Country> countries = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.country_main);

        loadCountries();
        createCountries();

        Spinner spinner = findViewById(R.id.country_spinner);
        CountryAdapter spinnerAdapter = new CountryAdapter(
                this,
                android.R.layout.simple_spinner_item,
                countries
        );
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);



        // CountryAdapter countryAdapter = new CountryAdapter(this, R.layout.counties_list_item, countries);
        // ListView countryListView = findViewById(R.id.country_list_view);
        // countryListView.setAdapter(countryAdapter);
    }



    protected void loadCountries() {
        countries.add(new Country(
                "Ukraine",
                "https://flagcdn.com/w320/ua.png",
                "Kyiv",
                44134693,
                603628,
                "Hryvnia"
        ));
        countries.add(new Country(
                "USA",
                "https://flagcdn.com/w320/us.png",
                "Washington, D.C.",
                331002651,
                9833520,
                "Dollar"
        ));
        countries.add(new Country(
                "Germany",
                "https://flagcdn.com/w320/de.png",
                "Berlin",
                83166711,
                357022,
                "Euro"
        ));
        countries.add(new Country(
                "France",
                "https://flagcdn.com/w320/fr.png",
                "Paris",
                65273511,
                551695,
                "Euro"
        ));
        countries.add(new Country(
                "Italy",
                "https://flagcdn.com/w320/it.png",
                "Rome",
                60317116,
                301340,
                "Euro"
        ));
        countries.add(new Country(
                "Spain",
                "https://flagcdn.com/w320/es.png",
                "Madrid",
                47351567,
                505990,
                "Euro"
        ));
        countries.add(new Country(
                "Canada",
                "https://flagcdn.com/w320/ca.png",
                "Ottawa",
                38005238,
                9984670,
                "Canadian Dollar"
        ));
        countries.add(new Country(
                "Australia",
                "https://flagcdn.com/w320/au.png",
                "Canberra",
                25687041,
                7692024,
                "Australian Dollar"
        ));
        countries.add(new Country(
                "Japan",
                "https://flagcdn.com/w320/jp.png",
                "Tokyo",
                125960000,
                377975,
                "Yen"
        ));
        countries.add(new Country(
                "Brazil",
                "https://flagcdn.com/w320/br.png",
                "Brasília",
                213993437,
                8515767,
                "Real"
        ));
        countries.add(new Country(
                "South Africa",
                "https://flagcdn.com/w320/za.png",
                "Pretoria",
                59308690,
                1219090,
                "Rand"
        ));
        countries.add(new Country(
                "India",
                "https://flagcdn.com/w320/in.png",
                "New Delhi",
                1393409038,
                3287263,
                "Indian Rupee"
        ));
        countries.add(new Country(
                "Mexico",
                "https://flagcdn.com/w320/mx.png",
                "Mexico City",
                126014024,
                1964375,
                "Mexican Peso"
        ));
    }



//    // Data (countries) initialization
//    String [] countriesLoadFromResources = getResources().getStringArray(R.array.countries);
//    createCountries();
//
//    ListView countryListView = findViewById(R.id.country_list_view);
//
//    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
//            this,
//            android.R.layout.simple_list_item_activated_1,
//            // R.layout.my_string_list_item,
//            // countriesLoadFromResources
//            countriesInActivity
//    );
//
//        countryListView.setAdapter(arrayAdapter);
//
//        countryListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//        @Override
//        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//            Toast.makeText(view.getContext(),
//                    "Clicked: " + countriesLoadFromResources[position], Toast.LENGTH_SHORT).show();
//        }
//    });
//
//    Button btnAddCountry = findViewById(R.id.btn_add_country);
//
//        btnAddCountry.setOnClickListener(v -> {
//        String newCountry = ((EditText) findViewById(R.id.country_name)).getText().toString();
//        if (newCountry.isEmpty()) {
//            Toast.makeText(this, "Please enter a country name", Toast.LENGTH_SHORT).show();
//        } else {
//            countriesInActivity.add(newCountry);
//            arrayAdapter.notifyDataSetChanged();
//            ((EditText) findViewById(R.id.country_name)).setText("");
//        }
//    });



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