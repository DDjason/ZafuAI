package com.zafu.jason.zafuai.commom;

import com.amap.api.location.AMapLocation;

/**
 * @author: Yangyd
 * E-mail: yangyd@erongdu.com
 * Date: 2017/10/17$ 15:59$
 * <p/>
 */
public interface StartCallBack {
    /**
     * 启动相机
     */
    void onStartCamera(AMapLocation aMapLocation);
}
