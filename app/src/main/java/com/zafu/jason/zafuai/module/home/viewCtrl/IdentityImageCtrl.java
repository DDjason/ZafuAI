package com.zafu.jason.zafuai.module.home.viewCtrl;

import android.view.View;

import com.amap.api.location.AMapLocation;
import com.zafu.jason.zafuai.commom.StartCallBack;
import com.zafu.jason.zafuai.commom.tool.AndroidUtil;
import com.zafu.jason.zafuai.commom.tool.MyLocationUtil;
import com.zafu.jason.zafuai.module.home.viewmodel.IdentityImageActModel;
/**
 * @author: Yangyd
 * E-mail: yangyd@erongdu.com
 * Date: 2017/10/19$ 15:45$
 * <p/>
 * Description: 图片分析页面 {@link com.zafu.jason.zafuai.module.home.ui.act.IdentityImageAct}
 */
public class IdentityImageCtrl {
    private IdentityImageActModel viewModel;


    public IdentityImageCtrl(String photoPath){
        viewModel = new IdentityImageActModel();
        viewModel.setImageSrc(photoPath);

        MyLocationUtil.initLocation(new StartCallBack() {
            @Override
            public void onStartCamera(AMapLocation aMapLocation) {
                viewModel.setImageLocation(aMapLocation.getAddress());
                viewModel.setaMapLocation(aMapLocation);
            }
        });

    }

    public void onClickBack(View view){
        AndroidUtil.getActivity(view).finish();
    }

    public void onStartCamera(View view){
    }

    public void onStartAlbum(View view){

    }

    public IdentityImageActModel getViewModel() {
        return viewModel;
    }
}
