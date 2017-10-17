package com.zafu.jason.zafuai.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.zafu.jason.zafuai.R;
import com.zafu.jason.zafuai.commom.tool.ImageUtil;

/**
 * @author: Yangyd
 * E-mail: yangyd@erongdu.com
 * Date: 2017/10/17$ 17:21$
 * <p/>
 */
public class PubActivity extends Activity implements View.OnClickListener {


    ImageView      mBtnPub;
    LinearLayout[] mLays;

    public static void show(Context context) {
        context.startActivity(new Intent(context, PubActivity.class));
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.home_map_click_act);
        mBtnPub = findViewById(R.id.btn_pub);
        mLays = new LinearLayout[2];
        mLays[0] = findViewById(R.id.ll_pub_blog);
        mLays[1] = findViewById(R.id.ll_pub_tweet);
        initWindow();

    }

    protected void initWindow() {

        getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
        mBtnPub.animate()
                .rotation(135.0f)
                .setDuration(180)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                    }
                })
                .start();
        show(0);
        show(1);
    }


    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_main:
                dismiss();
                break;
            case R.id.ll_pub_tweet:

                finish();
                break;
            case R.id.ll_pub_blog:

                finish();
                break;
            default:
                break;
        }
    }

    private void dismiss() {
        close();
        close(0);
        close(1);
    }

    private void close() {
        mBtnPub.clearAnimation();
        mBtnPub.animate()
                .rotation(0f)
                .setDuration(180)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        finish();
                    }
                })
                .start();
    }

    private void show(int position) {
        int            angle           = position == 0 ? 45 : 135;
        float          x               = (float) Math.cos(angle * (Math.PI / 180)) * ImageUtil.dipTopx(this, 80);
        float          y               = (float) -Math.sin(angle * (Math.PI / 180)) * ImageUtil.dipTopx(this, 80);
        ObjectAnimator objectAnimatorX = ObjectAnimator.ofFloat(mLays[position], "translationX", 0, x);
        ObjectAnimator objectAnimatorY = ObjectAnimator.ofFloat(mLays[position], "translationY", 0, y);
        AnimatorSet    animatorSet     = new AnimatorSet();
        animatorSet.setDuration(180);
        animatorSet.play(objectAnimatorX).with(objectAnimatorY);
        animatorSet.start();
    }

    private void close(int position) {
        int            angle           = position == 0 ? 45 : 135;
        float          x               = (float) Math.cos(angle * (Math.PI / 180)) * ImageUtil.dipTopx(this, 80);
        float          y               = (float) -Math.sin(angle * (Math.PI / 180)) * ImageUtil.dipTopx(this, 80);
        ObjectAnimator objectAnimatorX = ObjectAnimator.ofFloat(mLays[position], "translationX", x, 0);
        ObjectAnimator objectAnimatorY = ObjectAnimator.ofFloat(mLays[position], "translationY", y, 0);
        AnimatorSet    animatorSet     = new AnimatorSet();
        animatorSet.setDuration(180);
        animatorSet.play(objectAnimatorX).with(objectAnimatorY);
        animatorSet.start();
    }

    @Override
    public void onBackPressed() {
        dismiss();
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

}
