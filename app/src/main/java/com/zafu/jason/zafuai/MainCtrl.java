package com.zafu.jason.zafuai;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.widget.ImageView;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.zafu.jason.zafuai.databinding.ActivityMainBinding;

/**
 * Author: Yangyd
 * E-mail: yangyd@erongdu.com
 * Date: 2017/10/13$ 14:01$
 * <p/>
 */
public class MainCtrl {
    private ActivityMainBinding binding;
    private FragmentManager     fragmentManager;

    public MainCtrl(ActivityMainBinding binding, FragmentManager fragmentManager) {
        this.binding = binding;
        this.fragmentManager = fragmentManager;
        init_NavigationBar();
    }

    /**
     * 初始化底部导航栏
     */
    private void init_NavigationBar() {

        ImageView view = new ImageView(binding.getRoot().getContext());
        view.setImageDrawable(binding.getRoot().getContext().getResources().getDrawable(R.drawable.np_image_photo_taker_center));

        // 设置导航栏模式 + 背景（需要在添加tab前面，不然不会有效果）
        // MODE_FIXED + BACKGROUND_STYLE_STATIC：icon 和 text 全部显示，单个item上展示点击效果          BACKGROUND_STYLE_STATIC - 单个item上展示点击效果
        // MODE_FIXED + BACKGROUND_STYLE_RIPPLE：icon 和 text 全部显示，全部item上展示点击效果          BACKGROUND_STYLE_RIPPLE - 全部item上展示点击效果
        // MODE_SHIFTING + BACKGROUND_STYLE_STATIC：只在选中的item上显示text，单个item上展示点击效果    MODE_FIXED    - icon 和 text 全部显示
        // MODE_SHIFTING + BACKGROUND_STYLE_RIPPLE：只在选中的item上显示text，全部item上展示点击效果    MODE_SHIFTING - 只在选中的item上显示text
        binding.tabs
                .setMode(BottomNavigationBar.FOCUSABLES_TOUCH_MODE)
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE);

        // 添加标记
        // numberBadgeItem = new BadgeItem()
        //         .setBorderWidth(4)
        //         .setBackgroundColorResource(R.color.red)
        //         .setText("9")
        //         .setHideOnSelect(true);

        // InActiveColor - 图标和文字的默认颜色

        // ActiveColor
        // BACKGROUND_STYLE_STATIC 模式下是 选中时图标和文字的颜色
        // BACKGROUND_STYLE_RIPPLE 模式下是 底部导航栏的背景色

        // BarBackgroundColor
        // BACKGROUND_STYLE_STATIC 模式下是 底部导航栏的背景色
        // BACKGROUND_STYLE_RIPPLE 模式下是 选中时图标和文字的颜色
        binding.tabs
                .setInActiveColor(R.color.gray)
                .setActiveColor(R.color.green)
                .setBarBackgroundColor(R.color.greenyellow);
        binding.tabs
                .addItem(new BottomNavigationItem(R.drawable.ic_find_select, R.string.app_news)
                        .setInactiveIconResource(R.drawable.ic_find_unselect).setActiveColorResource(R.color.white))
                .addItem(new BottomNavigationItem(R.drawable.ic_near_select, R.string.app_near)
                        .setInactiveIconResource(R.drawable.ic_near_unselect).setActiveColorResource(R.color.white))
                .addItem(new BottomNavigationItem(R.drawable.np_image_photo_taker_shutter_icon, null)
                        .setInactiveIconResource(R.drawable.np_image_photo_taker_shutter_icon).setActiveColorResource(R.color.white))
                .addItem(new BottomNavigationItem(R.drawable.ic_near_select, R.string.app_share)
                        .setInactiveIconResource(R.drawable.ic_near_unselect).setActiveColorResource(R.color.white))
                .addItem(new BottomNavigationItem(R.drawable.ic_user_select, R.string.app_mine)
                        .setInactiveIconResource(R.drawable.ic_user_unselect).setActiveColorResource(R.color.white))
                .setTabSelectedListener(new BottomNavigationBar.SimpleOnTabSelectedListener() {
                    @Override
                    public void onTabSelected(int position) {
                        super.onTabSelected(position);
                        Log.i("TAG", "onTabSelected() called with position = [ " + position + " ]");

                        barTabSelected(position);

                    }

                    @Override
                    public void onTabUnselected(int position) {
                        super.onTabUnselected(position);
                        barTabUnSelect(position);
                    }

                    @Override
                    public void onTabReselected(int position) {
                        super.onTabReselected(position);
                        barTabReselected(position);
                    }
                })
                .setFirstSelectedPosition(0)
                .initialise();
        binding.tabs.selectTab(0);
    }

    /**
     * Tab 点击选择
     *
     * @param position
     */
    private void barTabSelected(int position) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        switch (position){
        }
        transaction.commitAllowingStateLoss();
    }

    /**
     * Tab 取消选择
     *
     * @param position
     */
    private void barTabUnSelect(int position) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.commitAllowingStateLoss();
    }

    /**
     * Tab 重复点击
     *
     * @param position
     */
    private void barTabReselected(int position) {

    }

}

