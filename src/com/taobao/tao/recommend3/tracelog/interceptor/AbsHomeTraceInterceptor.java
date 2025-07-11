package com.taobao.tao.recommend3.tracelog.interceptor;

import com.taobao.tao.log.TLog;
import com.taobao.tao.recommend3.tracelog.TraceModel;

import static com.taobao.tao.recommend3.tracelog.HomeTraceConstants.LOG_MODULE;
import static com.taobao.tao.recommend3.tracelog.HomeTraceConstants.LOG_TAG;

public abstract class AbsHomeTraceInterceptor {
    public static final int INTERCEPTOR_THREAD_ASYNC = 1;
    public static final int INTERCEPTOR_THREAD_CURRENT = 2;
    public static final int INTERCEPTOR_THREAD_MAIN = 3;
    protected String containerId;

    protected AbsHomeTraceInterceptor(String cid) {
        containerId = cid;
    }

    /**
     * 处理拦截器，包含数据校验和拦截
     *
     * @param model   需要处理的日志model
     * @param isStart model的状态，true代表起始点，end代表结束点
     * @return true代表处理成功，false代表处理失败
     */
    public final boolean doIntercept(TraceModel model, boolean isStart) {
        try {
            if (model == null || !valid(model, isStart)) {
                return false;
            }

            return intercept(model, isStart);
        } catch (Throwable t) {
            TLog.loge(LOG_MODULE, LOG_TAG, "do intercept error", t);
            return false;
        }
    }

    /**
     * Interceptor的执行线程，默认异步执行
     *
     * @return
     */
    public int getThreadMode() {
        return INTERCEPTOR_THREAD_ASYNC;
    }

    /**
     * 数据校验逻辑，如果数据无效，不会执行interpret方法
     *
     * @param model   需要处理的日志model
     * @param isStart 是否是起始节点
     * @return true代表数据有效，false代表数据无效
     */
    abstract boolean valid(TraceModel model, boolean isStart);

    /**
     * 具体的处理逻辑
     *
     * @param model   需要处理的日志model
     * @param isStart 是否是起始节点
     * @return 处理结果，true代表处理成功，false代表处理失败
     */
    abstract boolean intercept(TraceModel model, boolean isStart);
}
