package com.zafu.jason.zafuai.commom.tool;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.zafu.jason.zafuai.commom.StartCallBack;

/**
 * @author: Yangyd
 * E-mail: yangyd@erongdu.com
 * Date: 2017/10/17$ 14:24$
 * <p/>
 */
public class MyLocationUtil {

    //内部静态类形式实现单例

    private MyLocationUtil() {
    }

    private static class MyLocationUtilHolder {
        public static MyLocationUtil instance = new MyLocationUtil();
    }

    public static MyLocationUtil getInstance() {
        return MyLocationUtilHolder.instance;
    }

    public static void initLocation(final StartCallBack callBack) {
        //声明AMapLocationClient类对象
        AMapLocationClient mLocationClient = null;
        //声明定位回调监听器
        AMapLocationListener mLocationListener = new AMapLocationListener() {
            @Override
            public void onLocationChanged(AMapLocation aMapLocation) {

                callBack.onStartCamera(aMapLocation);
            }
        };
        //初始化定位
        mLocationClient = new AMapLocationClient(ContextHolder.getContext());
        //设置定位回调监听
        mLocationClient.setLocationListener(mLocationListener);

        //声明AMapLocationClientOption对象
        AMapLocationClientOption mLocationOption = null;
        //初始化AMapLocationClientOption对象
        mLocationOption = new AMapLocationClientOption();

        //设置定位模式为AMapLocationMode.Hight_Accuracy，高精度模式。
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);

        //获取一次定位结果：
        //该方法默认为false。
        mLocationOption.setOnceLocation(true);

        //获取最近3s内精度最高的一次定位结果：
        //设置setOnceLocationLatest(boolean b)接口为true，启动定位时SDK会返回最近3s内精度最高的一次定位结果。如果设置其为true，setOnceLocation(boolean b)接口也会被设置为true，反之不会，默认为false。
        mLocationOption.setOnceLocationLatest(true);

        mLocationClient.setLocationOption(mLocationOption);
        mLocationClient.startLocation();
    }
}
