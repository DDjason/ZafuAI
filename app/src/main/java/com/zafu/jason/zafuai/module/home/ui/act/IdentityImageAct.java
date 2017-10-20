package com.zafu.jason.zafuai.module.home.ui.act;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.WindowManager;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.zafu.jason.zafuai.R;
import com.zafu.jason.zafuai.databinding.IdentityImageActBinding;
import com.zafu.jason.zafuai.module.home.viewCtrl.IdentityImageCtrl;
import com.zafu.jason.zafuai.router.RouterURL;
import com.zafu.jason.zafuai.uibase.BaseActivity;

/**
 * @author: Yangyd
 * E-mail: yangyd@erongdu.com
 * Date: 2017/10/19$ 15:43$
 * <p/>
 */
@Route(path = RouterURL.IDENTITY)
public class IdentityImageAct extends BaseActivity {
    @Autowired
    public String photo_path;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        IdentityImageActBinding binding = DataBindingUtil.setContentView(this, R.layout.identity_image_act);

        binding.setViewCtrl(new IdentityImageCtrl(photo_path,binding));
    }
}
