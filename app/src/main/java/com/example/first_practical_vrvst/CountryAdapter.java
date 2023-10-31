package com.example.first_practical_vrvst;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class CountryAdapter extends ArrayAdapter<Country> {
    private Context context;
    private int resource; // The custom layout resource ID

    public CountryAdapter(Context context, int resource, List<Country> countries) {
        super(context, resource, countries);
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(resource, parent, false);
        }

        TextView countryNameTextView = convertView.findViewById(R.id.titleTextView);
        TextView decriptionTextView = convertView.findViewById(R.id.descriptionTextView);
        Country country = getItem(position);
        if (country != null) {
            String countryName = country.getName().getCommon();
            String description = country.getName().getOfficial();
            countryNameTextView.setText(countryName);
            decriptionTextView.setText(description);
        }

        return convertView;
    }
}
