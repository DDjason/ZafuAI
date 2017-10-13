package com.zafu.jason.zafuai;

import android.os.Bundle;
import android.databinding.DataBindingUtil;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.zafu.jason.zafuai.databinding.ActivityMainBinding;
import com.zafu.jason.zafuai.router.RouterURL;
import com.zafu.jason.zafuai.uibase.BaseActivity;

@Route(path = RouterURL.MAIN)
public class MainAct extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.setViewCtrl(new MainCtrl(binding,MainAct.this.getSupportFragmentManager()));
    }
}
