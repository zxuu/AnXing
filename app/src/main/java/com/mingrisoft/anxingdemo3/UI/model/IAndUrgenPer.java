package com.mingrisoft.anxingdemo3.UI.model;

import cn.bmob.v3.BmobObject;

public class IAndUrgenPer extends BmobObject{

    String Iname;
    String Itel;
    String urgenpertel;

    public String getIname() {
        return Iname;
    }

    public void setIname(String iname) {
        Iname = iname;
    }

    public String getItel() {
        return Itel;
    }

    public void setItel(String itel) {
        Itel = itel;
    }

    public String getUrgenpertel() {
        return urgenpertel;
    }

    public void setUrgenpertel(String urgenpertel) {
        this.urgenpertel = urgenpertel;
    }
}
