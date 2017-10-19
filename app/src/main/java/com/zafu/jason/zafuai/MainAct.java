package com.zafu.jason.zafuai;

import android.content.Intent;
import android.os.Bundle;
import android.databinding.DataBindingUtil;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.zafu.jason.zafuai.databinding.ActivityMainBinding;
import com.zafu.jason.zafuai.router.RouterURL;
import com.zafu.jason.zafuai.uibase.BaseActivity;

@Route(path = RouterURL.MAIN)
public class MainAct extends BaseActivity {

    private MainCtrl viewCtrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        viewCtrl = new MainCtrl(binding,MainAct.this.getSupportFragmentManager());
        binding.setViewCtrl(viewCtrl);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        viewCtrl.onActivityResult(requestCode,resultCode,data);
    }
}
