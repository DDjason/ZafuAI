package com.zafu.jason.zafuai.module.home.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.zafu.jason.zafuai.BR;

/**
 * @author: Yangyd
 * E-mail: yangyd@erongdu.com
 * Date: 2017/10/20$ 15:02$
 * <p/>
 */
public class RecycleViewItemVM extends BaseObservable {
    /**
     * 进度
     */
    private float  process;
    /**
     * imageSrc
     */
    private String imageSrc;
    /**
     * id标识
     */
    private int    id;



    @Bindable
    public float getProcess() {
        return process;
    }

    public void setProcess(float process) {
        this.process = process;
        notifyPropertyChanged(BR.process);
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
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        notifyPropertyChanged(BR.id);
    }
}
