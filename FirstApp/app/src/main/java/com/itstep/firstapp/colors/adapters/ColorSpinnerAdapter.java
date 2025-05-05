package com.itstep.firstapp.colors.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.itstep.firstapp.colors.Color;
import com.itstep.firstapp.colors.ColorRepository;
import com.itstep.firstapp.colors.MyColorUtils;

public class ColorSpinnerAdapter extends ArrayAdapter<Color> {

    private final int resource;

    public ColorSpinnerAdapter(@NonNull Context context, int resource) {
        super(context, resource, ColorRepository.getInstance().getColors());
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = View.inflate(getContext(), resource, null);
        }

        Color color = getItem(position);

        if (color != null) {
            convertView.setBackgroundColor(android.graphics.Color.parseColor(color.getHexCode()));

            int textColor = MyColorUtils.getContrastingColor(color.getHexCode());
            ((TextView) convertView).setTextColor(textColor);

            ((TextView) convertView).setText(color.getName());
        }

        return convertView;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {
            convertView = View.inflate(getContext(), resource, null);
        }

        Color color = getItem(position);

        if (color != null) {
//            convertView.setBackgroundColor(android.graphics.Color.parseColor(color.getHexCode()));
//
//            int textColor = MyColorUtils.getContrastingColor(color.getHexCode());
//            ((TextView) convertView).setTextColor(textColor);

            ((TextView) convertView).setText(color.getName());
        }

        return convertView;
    }
}
