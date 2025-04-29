package com.itstep.firstapp.countries;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.itstep.firstapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CountryAdapter extends ArrayAdapter<Country> {
    private final LayoutInflater inflater;
    private final int layout;
    private final ArrayList<Country> countries;



    public CountryAdapter(Context context, int resource, ArrayList<Country> countries) {
        super(context, 0, countries);
        this.inflater = LayoutInflater.from(context);
        this.layout = resource;
        this.countries = countries;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Country country = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.counties_list_item, parent, false);
        }

        // Lookup view for data population
        TextView tvName = convertView.findViewById(R.id.country_name);
        TextView tvCountryDetails = convertView.findViewById(R.id.country_details);

        // Populate the data into the template view using the data object
        tvName.setText(country.getName());
        tvCountryDetails.setText("" + country.getCapital() + ", \n" + country.getPopulation() +
                " people, \n" + country.getArea() + " km², \n " + country.getCurrency() +
                ", \n clickable: " + country.getClickCount());

        // Get the ImageView and set the image using a library like Picasso or Glide
        ImageView ivFlag = convertView.findViewById(R.id.country_flag);
        Picasso.get().load(country.getFlagUrl()).into(ivFlag);

        Button btnClick = convertView.findViewById(R.id.country_button);
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                country.incrementClickCount();
                tvCountryDetails.setText("" + country.getCapital() + ", \n" + country.getPopulation() +
                        " people, \n" + country.getArea() + " km², \n " + country.getCurrency() +
                        ", \n clickable: " + country.getClickCount());
            }
        });

        return convertView;
    }
}
