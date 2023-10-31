package com.example.first_practical_vrvst;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import java.util.ArrayList;
import java.util.List;

public class ReaderActivity extends AppCompatActivity {

    private ArrayAdapter<Country> adapter; // Declare the adapter as an instance variable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reader);

        // Create the adapter and set it to the ListView
        ListView listView = findViewById(R.id.list_view);
        adapter = new ArrayAdapter<>(this, R.layout.list_item, R.id.titleTextView);
        listView.setAdapter(adapter);

        // Make the API request to get country names
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://restcountries.com/v3.1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CountryAPI countryAPI = retrofit.create(CountryAPI.class);
        Call<List<Country>> call = countryAPI.getCountries();

        call.enqueue(new Callback<List<Country>>() {
            @Override
            public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {
                if (response.isSuccessful()) {
                    List<Country> countries = response.body();

                    // Create a custom adapter that uses your custom layout
                    CountryAdapter adapter = new CountryAdapter(ReaderActivity.this, R.layout.list_item, countries);

                    ListView listView = findViewById(R.id.list_view);
                    listView.setAdapter(adapter);
                } else {
                    Log.e("API Request", "Failed to retrieve country names.");
                }
            }


            @Override
            public void onFailure(Call<List<Country>> call, Throwable t) {
                Log.e("API Request", "Error: " + t.getMessage());
            }
        });
    }
}

