package test.vive.com.myapplication.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.Handler;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import test.vive.com.myapplication.Utils.Station;

public class SampleDemoViewModel extends ViewModel {
    private final Handler mHandler = new Handler();
    private MutableLiveData<List<String>> mFruitsList;

    private MutableLiveData<List<Station>> mStationMutableLiveData;


    public MutableLiveData<List<Station>> getStationMutableLiveData() {
        if (mStationMutableLiveData == null) {
            mStationMutableLiveData = new MutableLiveData<>();
            loadStation();
        }
        return mStationMutableLiveData;
    }

    public LiveData<List<String>> getFruitsList() {
        if (mFruitsList == null) {
            mFruitsList = new MutableLiveData<>();
            loadFruits();
        }
        return mFruitsList;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.e("Mohan", "OnCleared is Called");
    }

    private void loadStation() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Station station = new Station("RIX FM", "11", "109.9 MHz");
                Station station1 = new Station("STAR FM", "111", "100.6 MHz");
                Station station2 = new Station("ROCK", "11", "99.6 MHz");
                List<Station> stationList = new ArrayList<>();
                stationList.add(station);
                stationList.add(station1);
                stationList.add(station2);
                long seed = System.nanoTime();
                Collections.shuffle(stationList, new Random(seed));
                mStationMutableLiveData.setValue(stationList);
                mHandler.postDelayed(this, 1000);

            }
        }, 1000);
    }

    private void loadFruits() {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                List<String> fruits = new ArrayList<>();
                fruits.add("Mango");
                fruits.add("Apple");
                fruits.add("Orange");
                fruits.add("PineApple");
                fruits.add("Berry");
                fruits.add("BlueBerry");
                long seed = System.nanoTime();
                Log.e("SeedTime", "" + seed);
                Collections.shuffle(fruits, new Random(seed));
                mFruitsList.setValue(fruits);
                mHandler.postDelayed(this, 5000);
            }
        }, 1000);
    }

}
