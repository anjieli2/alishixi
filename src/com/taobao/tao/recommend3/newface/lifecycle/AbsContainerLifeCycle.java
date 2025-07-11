package com.taobao.tao.recommend3.newface.lifecycle;

import android.view.View;

import com.alibaba.fastjson.JSONObject;

import android.view.ViewGroup;
import com.taobao.android.dinamicx.DXRootView;

/**
 * 容器生命周期
 *
 * @author jojo
 */
public abstract class AbsContainerLifeCycle {
    /**
     * renderFirstFrame
     *
     * @param offset icon横滑位移
     */
    public void onIconScroll(int offset) {}

    /**
     * 容器滑动状态变化
     * @param view 视图
     * @param newState 新状态
     */
    public void onSubScrollStateChanged(ViewGroup view, int newState){

    }

    /**
     * 容器滑动
     *
     * @param dx 横向偏移量
     * @param dy 纵向偏移量
     */
    public void onScroll(int dx, int dy) {}

    /**
     * 数据绑定
     *
     * @param position   位置
     * @param data       数据
     * @param dxRootView dx视图
     */
    public void onBindData(int position, JSONObject data, DXRootView dxRootView) {}

    /**
     * 卡片上屏
     *
     * @param position 位置
     * @param cardView 卡片视图
     * @param data     数据
     */
    public void onCardAttached(int position, View cardView, JSONObject data) {}

    /**
     * 卡片离屏
     *
     * @param position 位置
     * @param cardView 卡片视图
     * @param data     数据
     */
    public void onCardDetached(int position, View cardView, JSONObject data) {}
}
