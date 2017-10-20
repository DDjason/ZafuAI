package com.zafu.jason.zafuai.module.home.viewCtrl;

import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.model.MyLocationStyle;
import com.zafu.jason.zafuai.databinding.HomeMapFragBinding;

/**
 * @author: Yangyd
 * E-mail: yangyd@erongdu.com
 * Date: 2017/10/17$ 10:55$
 * <p/>
 */
public class HomeMapFragCtrl {
    private HomeMapFragBinding binding;
    /**
     * 地图控制器
     */
    private AMap               aMap;
    /**
     * 用户位置
     */
    private MyLocationStyle    myLocationStyle;

    public HomeMapFragCtrl(HomeMapFragBinding binding) {
        this.binding = binding;
        initMap();
    }

    private void initMap() {
        //显示地图
        if (null == aMap) {
            aMap = binding.map.getMap();
        }
        //实现定位蓝点
        myLocationStyle = new MyLocationStyle();
        myLocationStyle.interval(5000);
        aMap.setMyLocationStyle(myLocationStyle);
        //初始化开启定位蓝点
        aMap.setMyLocationEnabled(true);
    }
}
