package com.zafu.jason.zafuai.module.home.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.amap.api.location.AMapLocation;
import com.zafu.jason.zafuai.BR;

/**
 * @author: Yangyd
 * E-mail: yangyd@erongdu.com
 * Date: 2017/10/19$ 15:51$
 * <p/>
 */
public class IdentityImageActModel extends BaseObservable{
    /**
     * 图片的src
     */
    private String       imageSrc;
    /**
     * 图片的地图定位
     */
    private String       imageLocation;

    /**
     * 用户地理信息
     * @return
     */
    private AMapLocation aMapLocation;

    @Bindable
    public String getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
        notifyPropertyChanged(BR.imageSrc);
    }

    @Bindable
    public String getImageLocation() {
        return imageLocation;
    }

    public void setImageLocation(String imageLocation) {
        this.imageLocation = imageLocation;
        notifyPropertyChanged(BR.imageLocation);
    }

    public AMapLocation getaMapLocation() {
        return aMapLocation;
    }

    public void setaMapLocation(AMapLocation aMapLocation) {
        this.aMapLocation = aMapLocation;
    }
}
