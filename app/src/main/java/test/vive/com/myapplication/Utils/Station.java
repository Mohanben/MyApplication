package test.vive.com.myapplication.Utils;

public class Station {
    private String mStationName;
    private String mStationId;
    private String mStationSubtitle;

    public Station(String stationName, String stationId, String stationSubtile) {
        mStationName = stationName;
        mStationId = stationId;
        mStationSubtitle = stationSubtile;
    }

    public String getStationName() {
        return mStationName;
    }

    public String getStationId() {
        return mStationId;
    }

    public String getStationSubtitle() {
        return mStationSubtitle;
    }
}
