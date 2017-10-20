package com.zafu.jason.zafuai.module.home.viewCtrl;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;

import com.airbnb.lottie.LottieAnimationView;
import com.amap.api.location.AMapLocation;
import com.zafu.jason.zafuai.commom.StartCallBack;
import com.zafu.jason.zafuai.commom.tool.AndroidUtil;
import com.zafu.jason.zafuai.commom.tool.MyLocationUtil;
import com.zafu.jason.zafuai.databinding.IdentityImageActBinding;
import com.zafu.jason.zafuai.module.home.viewmodel.IdentityImageActModel;

/**
 * @author: Yangyd
 * E-mail: yangyd@erongdu.com
 * Date: 2017/10/19$ 15:45$
 * <p/>
 * Description: 图片分析页面 {@link com.zafu.jason.zafuai.module.home.ui.act.IdentityImageAct}
 */
public class IdentityImageCtrl {
    private IdentityImageActModel   viewModel;
    private IdentityImageActBinding binding;

    public IdentityImageCtrl(String photoPath, final IdentityImageActBinding binding) {
        viewModel = new IdentityImageActModel();
        viewModel.setImageSrc(photoPath);
        this.binding = binding;
        MyLocationUtil.initLocation(new StartCallBack() {
            @Override
            public void onStartCamera(AMapLocation aMapLocation) {
                viewModel.setImageLocation(aMapLocation.getAddress());
                viewModel.setaMapLocation(aMapLocation);
                StartImageViewAnimate(binding.imageRelative);
            }
        });
    }

    private void StartImageViewAnimate(final View view) {
        //属性动画
        ValueAnimator animator = ValueAnimator.ofInt(view.getLayoutParams().height, view.getLayoutParams().height / 2);

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int h = (Integer) valueAnimator.getAnimatedValue();
                view.getLayoutParams().height = h;
                view.requestLayout();
            }
        });
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                startIdetityAnimation(binding.animationView);
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });

        animator.setDuration(3000);

        animator.start();
    }

    private void startIdetityAnimation(final LottieAnimationView animationView) {
        animationView.setAnimation("simple.json");
        animationView.loop(true);
        animationView.addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {

            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
        animationView.playAnimation();
        animationView.clearAnimation();
    }

    private void stopIdentityAnimation(final LottieAnimationView animationView){
        animationView.cancelAnimation();
        animationView.setVisibility(View.GONE);
    }

    public void onClickBack(View view) {
        AndroidUtil.getActivity(view).finish();
    }

    public void onStartCamera(View view) {
        stopIdentityAnimation(binding.animationView);
    }

    public void onStartAlbum(View view) {

    }

    public IdentityImageActModel getViewModel() {
        return viewModel;
    }
}
