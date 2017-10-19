package com.zafu.jason.zafuai.uibase;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * Author: Yangyd
 * E-mail: yangyd@erongdu.com
 * Date: 2017/10/13$ 14:12$
 * <p/>
 */
public class BaseActivity extends AppCompatActivity {
    public static final int REQUEST_CODE_CLOSED = 0x1234;
    public static final int REQUEST_CODE        = 0x4321;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            // 透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }


           ARouter.getInstance().inject(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_CLOSED && resultCode == RESULT_OK) {
            setResult(RESULT_OK);
            finish();
        }
    }
}
