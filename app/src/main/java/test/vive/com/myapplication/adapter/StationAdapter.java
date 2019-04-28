package test.vive.com.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import test.vive.com.myapplication.MainActivity;
import test.vive.com.myapplication.R;
import test.vive.com.myapplication.Utils.Station;

public class StationAdapter extends ArrayAdapter {
    List<Station> mStationList;
    Context context;


    public StationAdapter(MainActivity context, List<Station> stations) {
        super(context, R.layout.custom_list_item, stations);
        this.mStationList = stations;
        this.context = context;
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewRow = layoutInflater.inflate(R.layout.custom_list_item, null,
                true);
        TextView station_name = (TextView) viewRow.findViewById(R.id.station_name);
        TextView station_title = (TextView) viewRow.findViewById(R.id.station_title);
        ImageView mimageView = (ImageView) viewRow.findViewById(R.id.image_view);
        station_name.setText(mStationList.get(i).getStationName());
        station_title.setText(mStationList.get(i).getStationSubtitle());
        mimageView.setImageResource(R.drawable.ic_launcher_background);
        return viewRow;
    }
}