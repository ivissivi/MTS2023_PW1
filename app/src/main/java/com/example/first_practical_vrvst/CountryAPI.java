package com.example.first_practical_vrvst;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface CountryAPI {
    @GET("all?fields=name")
    Call<List<Country>> getCountries();
}
