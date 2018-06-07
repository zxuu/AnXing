package com.mingrisoft.anxingdemo3.UI.model;

import com.amap.api.maps.model.LatLng;
import com.mingrisoft.anxingdemo3.UI.ClusterItem;

public class RegionItem implements ClusterItem {
    private LatLng mLatLng;
    private String mTitle;
    public RegionItem(LatLng latLng, String title) {
        mLatLng=latLng;
        mTitle=title;
    }

    @Override
    public LatLng getPosition() {
        // TODO Auto-generated method stub
        return mLatLng;
    }
    public String getTitle(){
        return mTitle;
    }

}
