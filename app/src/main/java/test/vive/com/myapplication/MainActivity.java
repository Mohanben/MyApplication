package test.vive.com.myapplication;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import java.util.List;

import test.vive.com.myapplication.Utils.Station;
import test.vive.com.myapplication.viewmodel.SampleDemoViewModel;
import test.vive.com.myapplication.adapter.StationAdapter;

public class MainActivity extends AppCompatActivity {
    private ListView mAndroidListView;

    @NonNull
    @Override
    public Lifecycle getLifecycle() {
        return super.getLifecycle();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("Mohan", "onPause is Called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("Mohan", "onResume Is Called");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.e("Mohan", "onCreate view is Called");
        setContentView(R.layout.activity_main);
        mAndroidListView = findViewById(R.id.list_item_station);

        SampleDemoViewModel sampleViewModel = ViewModelProviders.of(this).get(
                SampleDemoViewModel.class);

        sampleViewModel.getFruitsList().observe(this, new Observer<List<String>>() {
            @Override
            public void onChanged(@Nullable List<String> strings) {
                int size = strings.size();
                for (int i = 0; i < size; i++) {
                    Log.e("Fruits ", strings.get(i));
                }
            }
        });

        sampleViewModel.getStationMutableLiveData().observe(this, new Observer<List<Station>>() {
            @Override
            public void onChanged(@Nullable List<Station> stations) {
                StationAdapter androidListAdapter = new StationAdapter(MainActivity.this, stations);
                mAndroidListView.setAdapter(androidListAdapter);
            }
        });

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.e("Mohan", "ononSaveInstanceState is Called");
    }


}
