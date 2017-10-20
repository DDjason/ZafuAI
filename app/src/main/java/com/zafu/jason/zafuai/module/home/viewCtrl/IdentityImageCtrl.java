package com.zafu.jason.zafuai.module.home.viewCtrl;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.airbnb.lottie.LottieAnimationView;
import com.amap.api.location.AMapLocation;
import com.zafu.jason.zafuai.BR;
import com.zafu.jason.zafuai.R;
import com.zafu.jason.zafuai.commom.StartCallBack;
import com.zafu.jason.zafuai.commom.tool.AndroidUtil;
import com.zafu.jason.zafuai.commom.tool.MyLocationUtil;
import com.zafu.jason.zafuai.databinding.IdentityImageActBinding;
import com.zafu.jason.zafuai.module.home.viewmodel.IdentityImageActModel;
import com.zafu.jason.zafuai.module.home.viewmodel.RecycleViewItemVM;

import java.util.ArrayList;
import java.util.List;

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
    private List<RecycleViewItemVM> data;

    public IdentityImageCtrl(String photoPath, final IdentityImageActBinding binding) {
        viewModel = new IdentityImageActModel();
        viewModel.setImageSrc(photoPath);
        this.binding = binding;
        MyLocationUtil.initLocation(new StartCallBack() {
            @Override
            public void onStartCamera(AMapLocation aMapLocation) {
                viewModel.setImageLocation(aMapLocation.getAddress());
                viewModel.setaMapLocation(aMapLocation);
                //接收到位置信息，开始界面动画
                StartImageViewAnimate(binding.imageRelative);
            }
        });

        data = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            data.add(new RecycleViewItemVM());
        }
    }

    /**
     * 进入界面视图收缩
     *
     * @param view
     */
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
                //界面动画结束开始分析动画和网咯连接
                startIdetityAnimation(binding.animationView);
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });

        animator.setDuration(30);

        animator.start();
    }

    /**
     * 显示分析中的lottie动画
     *
     * @param animationView
     */
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
                //分析动画被结束 , 展示分析结果
                Log.i("onAnimationCancel", "分析动画被结束 , 展示分析结果\n");
                showIdentityResult();
            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
        animationView.playAnimation();
    }

    /**
     * 分析结束关闭动画
     *
     * @param animationView
     */
    private void stopIdentityAnimation(final LottieAnimationView animationView) {
        animationView.cancelAnimation();
        animationView.setVisibility(View.GONE);
    }

    /**
     * recycleView 生成
     */
    private void initRecycleView() {

       /* LinearLayoutManager manager = new LinearLayoutManager(binding.getRoot().getContext());
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        binding.recycleView.setLayoutManager(manager);

        binding.recycleView.setAdapter(new IdentityViewAdapter(binding.getRoot().getContext()));*/
    }

    class IdentityViewAdapter extends RecyclerView.Adapter<IdentityViewAdapter.MyViewHolder>{

        private Context mContext;

        public IdentityViewAdapter(Context context){
            mContext = context;
        }
        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(mContext),R.layout.recycle_view_item,parent,false);
            MyViewHolder vh = new MyViewHolder(binding);
            return vh;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.binding.setVariable(BR.item,data.get(position));
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {
            ViewDataBinding binding;

            public MyViewHolder(ViewDataBinding binding) {
                super(binding.getRoot());
                this.binding = binding;
            }
        }

    }


    class MyPageAdapter extends PagerAdapter{

        private Context mContext;
        public MyPageAdapter(Context context){
            this.mContext = context;
        }

        @Override
        public int getCount() {
            return viewModel.getViewList().size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(viewModel.getViewList().get(position));
            return viewModel.getViewList().get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(viewModel.getViewList().get(position));
        }
    }

    private int wHeight;
    /**
     * 开始分析结果展示 viewPage部分
     */
    private void showIdentityResult() {
        processViewList();
        binding.viewpagerUse.setOffscreenPageLimit(3);
        viewModel.setPagerAdapter(new MyPageAdapter(binding.getRoot().getContext()));

        viewModel.setPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.i("onPageScrolled",position + "   "+ positionOffset + "  " + positionOffsetPixels);
                viewModel.getViewList().get(position).getLayoutParams().height = (int )(wHeight + 300 * positionOffset);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        initRecycleView();
    }

    /**
     * viewPage结果viewList获取
     */
    private void processViewList() {

        LayoutInflater inflater = LayoutInflater.from(binding.getRoot().getContext());
        List<View> viewList = new ArrayList<View>();// 将要分页显示的View装入数组中

        for (int i = 0 ; i < 7 ; i ++) {
            ViewDataBinding mBinding = DataBindingUtil
                    .inflate(inflater, R.layout.view_page_layout, binding.viewpagerFather, false);
            mBinding.setVariable(BR.item, new RecycleViewItemVM());
            viewList.add(mBinding.getRoot());

        }
        wHeight = viewList.get(0).getHeight();


        viewModel.setViewList(viewList);
    }

    /**
     * 点击X返回
     *
     * @param view
     */
    public void onClickBack(View view) {
        AndroidUtil.getActivity(view).finish();
    }

    /**
     * 点击相机
     *
     * @param view
     */
    public void onStartCamera(View view) {
        stopIdentityAnimation(binding.animationView);
    }

    /**
     * 点击相册
     *
     * @param view
     */
    public void onStartAlbum(View view) {

    }

    /**
     * @return viewModel
     */
    public IdentityImageActModel getViewModel() {
        return viewModel;
    }
}
/*
new PagerAdapter() {
            @Override
            public int getCount() {
                return viewModel.getViewList().size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {

                //用DataBinding
                ViewDataBinding  mBinding = DataBindingUtil
                        .inflate(LayoutInflater.from(binding.getRoot().getContext()),R.layout.view_page_layout,container,false);
                mBinding.setVariable(BR.item,new RecycleViewItemVM());
                container.addView(viewModel.getViewList().get(position));

                return viewModel.getViewList().get(position);
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(viewModel.getViewList().get(position));
            }

            @Override
            public float getPageWidth(int position) {
                return super.getPageWidth(position);
            }
        }
 */