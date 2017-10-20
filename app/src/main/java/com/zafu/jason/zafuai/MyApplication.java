package com.zafu.jason.zafuai;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.zafu.jason.zafuai.commom.tool.ContextHolder;

/**
 * @author: Yangyd
 * E-mail: yangyd@erongdu.com
 * Date: 2017/10/17$ 14:58$
 * <p/>
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        basicInit();
    }

    /**
     * 初始化 Application 运行所需的配置信息
     */
    private void basicInit() {
        ContextHolder.init(this);
        ARouter.openLog();     // 打印日志
        ARouter.openDebug();
        ARouter.init(this);
    }
}
