package com.zafu.jason.zafuai.module.home.viewCtrl;

import com.zafu.jason.zafuai.databinding.HomeNewsFragBinding;
import com.zafu.jason.zafuai.module.home.viewmodel.HomeNewsFragModel;

/**
 * @author: Yangyd
 * E-mail: yangyd@erongdu.com
 * Date: 2017/10/16$ 11:17$
 * <p/>
 */
public class HomeNewsFragCtrl {


    private HomeNewsFragModel viewModel;
    private HomeNewsFragBinding binding;


    public HomeNewsFragCtrl(HomeNewsFragBinding binding){
        this.binding = binding;
        initData();
        initBanner();
    }

    public HomeNewsFragModel getViewModel() {
        return viewModel;
    }

    void initBanner(){

    }

    private void initData() {

    }



}
