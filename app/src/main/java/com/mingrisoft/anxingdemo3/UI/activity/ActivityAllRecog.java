package com.mingrisoft.anxingdemo3.UI.activity;

import com.mingrisoft.anxingdemo3.UI.baidu.AllRecogParams;
import com.mingrisoft.anxingdemo3.UI.baidu.AllSetting;
import com.mingrisoft.anxingdemo3.UI.recognization.CommonRecogParams;

/*
 * 展示语义功能
 *  本类可以忽略
 * ActivityRecog 识别流程，看下ActivityRecog开头的注释
*/
public class ActivityAllRecog extends ActivityRecog {
    {
        descText = "所有识别参数一起的示例。请先参照之前的3个识别示例。\n";

        enableOffline = false; // 请确认不使用离线命令词功能后，改为false
    }

    public ActivityAllRecog() {
        super();
        settingActivityClass = AllSetting.class;
    }

    @Override
    protected CommonRecogParams getApiParams() {
        return new AllRecogParams(this);
    }

}
