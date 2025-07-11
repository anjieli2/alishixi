package com.taobao.tao.topmultitab.protocol;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.UiThread;
import android.view.MotionEvent;
import android.view.View;

import com.alibaba.fastjson.JSONObject;
import com.taobao.android.tbtheme.kit.ThemeData;
import com.taobao.infoflow.protocol.engine.invoke.biz.passparams.IPassParamsModel;
import com.taobao.infoflow.protocol.model.datamodel.infoflow.ISubTabParams;
import com.taobao.infoflow.protocol.subservice.biz.IPopViewService;
import com.taobao.location.common.TBLocationDTO;
import com.taobao.tao.infoflow.RecommendSwitchHelper;

import java.util.Map;

/**
 * 子 TAB 集成此抽象类，由主容器调度
 * 此类位置不要修改，外部有依赖
 * @author : qinren
 * @Description : com.taobao.tao.topmultitab.protocol
 * @time : 2020/9/3 15:10
 */
public abstract class AbsHomeSubTabController implements IHomeSubTabController {
    protected IHomeSubTabController mDefaultSubTabController;

    public AbsHomeSubTabController(IHomeTabContainerCallBack callBack) {

    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroy() {
        if (mDefaultSubTabController != null) {
            mDefaultSubTabController.onDestroy();
            mDefaultSubTabController = null;
        }
    }

    @Override
    public void onAppToBackground() {

    }

    @Override
    public void onAppToFront() {

    }

    @Override
    public void onEnterPullSecondFloor() {}

    @Override
    public void onExitPullSecondFloor() {}

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

    }

    @Override
    public void onTabClicked() {

    }

    @Override
    public void onColdStartResume() {

    }

    @Override
    public void onPageScrolled(float v, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected() {

    }

    @Override
    public void onPageUnSelected() {

    }

    @Override
    public void onPullRefresh() {

    }

    @Override
    public void onPullDistance(int distance) {

    }

    @Override
    public boolean isEnablePullReFresh() {
        return false;
    }

    @Override
    public boolean isEnableToSecondFloor() {
        return false;
    }

    @Override
    public void onClickRocket() {

    }

    @Override
    public boolean isOnRocketState() {
        return false;
    }

    @Override
    public String getUpdatePageName() {
        return null;
    }

    @Override
    public Map<String, String> getUpdatePageProperties() {
        return null;
    }

    @Override
    public Map<String, String> getUpdateNextPageProperties() {
        return null;
    }

    @Override
    public String getUpdatePageUtParam() {
        return null;
    }

    @Override
    public boolean isReachTop() {
        return true;
    }

    @Override
    public void notifyOutLinkParams(Intent intent, String params) {

    }

    @Override
    public void onCustomGlobalThemeChanged(String bizName, ThemeData customTheme, boolean isRemove) {

    }

    @Override
    public void locationChange(TBLocationDTO location) {

    }

    @Override
    public JSONObject getSubTabData() {
        return null;
    }

    /**
     * 获取TAB布局类型
     * @return
     * TBHDisplayLayoutTypeNormal = 0, // 普通形式
     * TBHDisplayLayoutTypeWaterfall = 1, // 瀑布流形式
     * TBHDisplayLayoutTypeImmersion = 2 // 沉浸式
     */
    @Override
    public int getTabLayoutType() {
        return 0;
    }

    @Override
    public boolean isHandleUpAndDownScrollingEvent() {
        return false;
    }

    @Override
    public int getSubContainerScrollY() {
        return Integer.MAX_VALUE;
    }

    /**
     * 获取子TAB导航栏数据
     */
    @Override
    public JSONObject getSubTabSearchBarData() {
        return null;
    }

    /**
     * 获取子页面名称
     * @return 子页面名称
     */
    @Override
    public String getSubPageName() {
        return null;
    }

    /**
     * 通过back键退出
     */
    @Override
    public void onWillExit() {

    }

    /**
     * 调用subTab的页面滚动能力 伴有滚动动画
     * @param infoFlowOffset 从信息流的第一张商品卡算起的往后几张
     * @return 是否滚动成功
     */
    @Override
    public boolean smoothScrollToPositionFromInfoFlow(int infoFlowOffset) {
        return false;
    }

    /**
     * 调用子tab 滚动到信息流的指定区域 从搜索栏之下的区域算起
     * @param position 位置
     * @param offset 偏移量
     * @return 是否滚动成功 无滚动动画
     */
    @Override
    public boolean scrollToPositionWithOffset(int position, int offset) {
        return false;
    }

    /**
     * 获得子容器参数
     * @return 子容器参数
     */
    @Override
    public ISubTabParams getSubTabParams(){
        return null;
    }

    /**
     * 预创建视图
     *
     * @param context 上下文
     * @return 子Tab视图
     */
    @Override
    public View preCreateView(Context context) {return null;}

    /**
     * 响应皮肤氛围刷新
     */
    @Override
    @UiThread
    public void onFestivalRefresh() {

    }

    /**
     * 是否允许操作页面回退请求 - 目前主要用于首页出现闪屏交互后，首页下次执行 PageBack
     * 避免互动替换的数据又被 PageBack 请求返回的数据二次替换
     * @return true 允许； false 不允许
     */
    @Override
    public boolean isAllowProcessPageBack() {
        // 默认允许
        return true;
    }

    /**
     * 得到底部按钮的状态 原来是boolean类型  只支持小火箭和淘字 无法新增类型
     * @return 底部按钮的状态
     */
    @Override
    public @TabBarButtonShowType String getTabBarButtonShowState() {
        return TabBarButtonShowState.TAO;
    }

    /**
     * 得到当前tab底下的子容器类型
     * @return 当前tab底下的子容器类型（比如推荐底下有推荐和b面（夜淘宝和首页即会场））
     */
    @Override
    public String getCurrentSubContainerType() {
        return RecommendSwitchHelper.DEFAULT_SUB_CONTAINER_TYPE;
    }

    /**
     * 通知刷新页面
     */
    @Override
    public void notifyRefreshPage() {

    }

    /**
     * 下拉刷新状态
     * @param oldState 老状态
     * @param newState 新状态
     */
    @Override
    public void onRefreshStateChanged(@RefreshState String oldState, @RefreshState String newState) {
    }

    @Override
    public Map<String, String> getRequestUpstreamBizParam(String event) {
        return null;
    }

    /**
     * 主容器触发pop浮层
     * @param triggerType 触发类型
     * @param popData  pop数据
     */
    @Override
    public void triggerPopShowByMain(int triggerType, JSONObject popData) {

    }

    @Override
    public void triggerPopRemoveByMain(String businessId) {

    }

    @Override
    public void addPopMessageListenerByMain(IPopViewService.ITBPopMessageListener messageListener) {

    }

    @Override
    public void removePopMessageListenerByMain(IPopViewService.ITBPopMessageListener messageListener) {

    }

    @Override
    public View getViewBySectionBizCodeAndItemBizCode(String sectionBizCode, String itemBizCode) {
        return null;
    }

    @Override
    public void selectTabByTabId(String tabId) {

    }

    @Override
    public void passThroughData(@NonNull IPassParamsModel data, String sectionBizCode, String itemBizCode) {

    }

    /**
     * 获取子TAB搜索框数据
     */
    @Override
    public JSONObject getSubTabSearchBoxData() {
        return null;
    }

    @Override
    public void syncGreyStatus(boolean isGrey) {

    }

    @Override
    public void onNavigationTabChanged(int index, String name) {

    }

    @Override
    public void onRemoveView() {

    }

    public void setSwitchOpenWeex(boolean isOpenWeexEnable) {
    }

    public void dispatchTouchEventAsync(MotionEvent ev, DispatchTouchAsyncCallback callback) {
    }

    public boolean isWeexTab() {
        return false;
    }

    /**
     * 分类Tab 由于缓存加载时序问题 默认初始HomeMainLandInfoFlowController，
     * 后续在创建MultiTabController，前后初始化两次HomeInfoFlowController
     */
    public IHomeSubTabController getDefaultSubController(){
        return mDefaultSubTabController;
    }

    public void setDefaultSubTabController(IHomeSubTabController controller) {
        if (mDefaultSubTabController != null) {
            return;
        }
        this.mDefaultSubTabController = controller;
    }

    public interface DispatchTouchAsyncCallback {
        void touchInterceptStateChange(boolean isParentIntercept);
    }

}
