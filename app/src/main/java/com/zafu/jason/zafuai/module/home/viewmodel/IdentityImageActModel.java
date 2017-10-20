package com.zafu.jason.zafuai.module.home.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.amap.api.location.AMapLocation;
import com.zafu.jason.zafuai.BR;

import java.util.List;

/**
 * @author: Yangyd
 * E-mail: yangyd@erongdu.com
 * Date: 2017/10/19$ 15:51$
 * <p/>
 */
public class IdentityImageActModel extends BaseObservable {
    /**
     * 图片的src
     */
    private String                         imageSrc;
    /**
     * 图片的地图定位
     */
    private String                         imageLocation;
    /**
     * 用户地理信息
     */
    private AMapLocation                   aMapLocation;
    /**
     * Lottie动画是否显示
     */
    private boolean                        enableAnimation;
    /**
     * 是否获取地址
     */
    private boolean                        enableLocation;
    /**
     * viewPage的视图集合
     */
    private List<View>                     viewList;
    /**
     * viewPage的适配器
     */
    private PagerAdapter                   pagerAdapter;
    /**
     * viewPage监听器
     */
    private ViewPager.OnPageChangeListener pageChangeListener;

    @Bindable
    public PagerAdapter getPagerAdapter() {
        return pagerAdapter;
    }

    public void setPagerAdapter(PagerAdapter pagerAdapter) {
        this.pagerAdapter = pagerAdapter;
        notifyPropertyChanged(BR.pagerAdapter);
    }

    @Bindable
    public ViewPager.OnPageChangeListener getPageChangeListener() {
        return pageChangeListener;
    }

    public void setPageChangeListener(ViewPager.OnPageChangeListener pageChangeListener) {
        this.pageChangeListener = pageChangeListener;
        notifyPropertyChanged(BR.pageChangeListener);
    }

    @Bindable
    public List<View> getViewList() {
        return viewList;
    }

    public void setViewList(List<View> viewList) {
        this.viewList = viewList;
        notifyPropertyChanged(BR.viewList);
    }

    @Bindable
    public boolean isEnableLocation() {
        if (null != imageLocation) {
            enableLocation = true;
        } else {
            enableLocation = false;
        }
        return enableLocation;
    }

    public void setEnableLocation(boolean enableLocation) {
        this.enableLocation = enableLocation;
        notifyPropertyChanged(BR.enableLocation);
    }

    @Bindable
    public boolean isEnableAnimation() {
        return enableAnimation;
    }

    public void setEnableAnimation(boolean enableAnimation) {
        this.enableAnimation = enableAnimation;
        notifyPropertyChanged(BR.enableAnimation);
    }

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
        notifyPropertyChanged(BR.enableLocation);
    }

    public AMapLocation getaMapLocation() {
        return aMapLocation;
    }

    public void setaMapLocation(AMapLocation aMapLocation) {
        this.aMapLocation = aMapLocation;
    }
}
