package com.example.viewpagerwithjson;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity  {

    private static final String TAG = "Sheriff";
    final List<Fragment> fragmentList = new ArrayList<>();
    private CompositeDisposable compositeDisposable;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        compositeDisposable = new CompositeDisposable();


        getPlanets();
        viewPager = findViewById(R.id.mainActivity_viewPager);
    }


    private void getPlanets(){
        Disposable disposable = PlanetClient.getInstance()
                .getPlanetResponse()
                .subscribeOn(Schedulers.io())
                .map(response -> response.getPlanets())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(list->{
                    Log.d(TAG,list.size() + " ");
                    getFragments(list);
                }, error-> {error.printStackTrace();});
        compositeDisposable.add(disposable);



    }

    private void getFragments(List<Planet> list) {
        for (Planet planet : list) {
            PlanetsFragment planetsFragment = PlanetsFragment.newInstance(planet.getName(),planet.getImage());
            fragmentList.add(planetsFragment);
        }

        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(),fragmentList));
    }


}
