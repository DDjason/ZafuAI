package com.zafu.jason.zafuai.commom;

/**
 * Author: Yangyd
 * E-mail: yangyd@erongdu.com
 * Date: 2017/10/16$ 14:28$
 * <p/>
 */
//useless
public class BaseViewModel<T> {
    private T viewModel;

    public T getViewModel() {
        return viewModel;
    }

    public void setViewModel(T viewModel) {
        this.viewModel = viewModel;
    }
}
