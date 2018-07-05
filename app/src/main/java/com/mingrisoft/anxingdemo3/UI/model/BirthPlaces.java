package com.mingrisoft.anxingdemo3.UI.model;

import cn.bmob.v3.BmobObject;


//危险发生地类
public class BirthPlaces extends BmobObject {

    private String latitude;
    private String longitude;

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
