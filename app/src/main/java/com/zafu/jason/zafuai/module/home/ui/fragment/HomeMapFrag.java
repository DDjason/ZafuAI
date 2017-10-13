package com.zafu.jason.zafuai.module.home.ui.fragment;

import android.app.Fragment;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zafu.jason.zafuai.R;
import com.zafu.jason.zafuai.databinding.HomeMapFragBinding;

/**
 * Author: Yangyd
 * E-mail: yangyd@erongdu.com
 * Date: 2017/10/13$ 17:56$
 * <p/>
 */
public class HomeMapFrag extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        HomeMapFragBinding binding = DataBindingUtil.inflate(inflater, R.layout.home_map_frag,container,false);
        return binding.getRoot();
    }
}
