package com.example.viewpagerwithjson;

import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * https://raw.githubusercontent.com/JDVila/storybook/master/planets.json
 */
public interface PlanetService {
    @GET("JDVila/storybook/master/planets.json")
    Single<PlanetResponse> getPlanets();



}
