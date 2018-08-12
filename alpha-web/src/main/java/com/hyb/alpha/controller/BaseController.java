package com.hyb.alpha.controller;

import com.hyb.alpha.exception.AlphaException;
import com.hyb.alpha.util.JSONUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collections;
import java.util.Map;

/**
 * <p>
 * 场景: 控制层基类
 * </p>
 *
 * @author Yibo
 * @version 1.0
 * @since 2018/8/3 11:51
 **/
public class BaseController {

    /**
     * 系统日志配置.
     */
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 失败的Status Code.
     */
    private static final int RESCODE_FAIL = 201;
    /**
     * 成功的Status Code.
     */
    private static final int RESCODE_OK = 200;

    /**
     * 获取默认ajax成功信息.
     * 只返回操作信息为操作成功
     * @return
     */
    protected Map<String, Object> successResult() {
        return successResult("操作成功！");
    }

    /**
     * 获取默认ajax失败信息.
     * 只返回操作信息为操作失败
     * @return
     */
    protected Map<String, Object> failResult() {
        return successResult("操作失败！");
    }

    /**
     * 获取ajax成功信息.
     * 默认状态码为200
     * @return
     */
    protected Map<String, Object> successResult(String msg) {
        return JSONUtil.createJson(true, RESCODE_OK, msg, Collections.EMPTY_MAP);
    }

    /**
     * 获取ajax失败的信息
     * 默认状态码为201
     * @param msg
     * @return
     */
    protected Map<String, Object> failResult(String msg) {
        return JSONUtil.createJson(false, RESCODE_FAIL, msg, Collections.EMPTY_MAP);
    }

    /**
     * 获取成功信息.
     * 只返回数据，默认状态码200且操作信息为操作成功
     * @param obj
     * @return
     */
    protected Map<String, Object> successDataResult(Object obj) {
        return JSONUtil.createJson(true, RESCODE_OK, "操作成功", obj);
    }

    /**
     * 获取ajax失败的内容.
     * @param errCode
     * @param msg
     * @return
     */
    protected Map<String, Object> failResult(int errCode,String msg) {
        return JSONUtil.createJson(false, errCode, msg, Collections.EMPTY_MAP);
    }

    /**
     * 业务异常控制
     *
     */
    @ExceptionHandler(AlphaException.class)
    public @ResponseBody
    Map<String,Object> saleCrmExceptionHandler(AlphaException e) {
        logger.warn(e.getLocalizedMessage());
        return this.failResult(e.getErrCode(), e.getMessage());
    }

    /**
     * 运行期异常控制
     *
     */
    @ExceptionHandler(RuntimeException.class)
    public @ResponseBody
    Map<String,Object> runtimeExceptionHandler(RuntimeException e) {
        logger.error("发生系统异常", e);
        return this.failResult("系统异常，请和管理员联系！");
    }

    /**
     * 绑定异常控制
     *
     */
    @ExceptionHandler(BindException.class)
    public @ResponseBody
    Map<String,Object> bindExceptionHandler(BindException e) {
        logger.error(e.getLocalizedMessage());
        return this.failResult(e.getFieldError().getDefaultMessage());
    }
}
