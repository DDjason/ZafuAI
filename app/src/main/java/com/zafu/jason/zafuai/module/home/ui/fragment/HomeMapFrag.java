package com.zafu.jason.zafuai.module.home.ui.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.MapFragment;
import com.amap.api.maps2d.MapView;
import com.zafu.jason.zafuai.R;
import com.zafu.jason.zafuai.databinding.HomeMapFragBinding;
import com.zafu.jason.zafuai.module.home.viewCtrl.HomeMapFragCtrl;

/**
 * Author: Yangyd
 * E-mail: yangyd@erongdu.com
 * Date: 2017/10/13$ 17:56$
 * <p/>
 */
public class HomeMapFrag extends Fragment {
    private        HomeMapFragBinding binding;
    private        View               mapLayout;
    private static HomeMapFrag        fragment;
    private        MapView            mapView;
    private        AMap               aMap;

    public static HomeMapFrag newInstance() {
        if (fragment == null) {
            synchronized (MapFragment.class) {
                if (fragment == null) {
                    fragment = new HomeMapFrag();
                }
            }
        }
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        if (binding == null) {
            Log.i("sys", "MF onCreateView() null");

            binding = DataBindingUtil.inflate(inflater, R.layout.home_map_frag, container, false);

            binding.map.onCreate(savedInstanceState);

            binding.setViewCtrl(new HomeMapFragCtrl(binding));


        } else {
            if (binding.getRoot().getParent() != null) {
                ((ViewGroup) binding.getRoot().getParent()).removeView(binding.getRoot());
            }
        }
        return binding.getRoot();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding.map.onDestroy();
    }

    @Override
    public void onResume() {
        super.onResume();
        binding.map.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        binding.map.onPause();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        binding.map.onSaveInstanceState(outState);
    }
}
