package com.hyb.alpha.form.zoo;

import com.hyb.alpha.annotation.PatternEx;
import com.hyb.alpha.form.BaseForm;
import com.hyb.alpha.util.ValidUtil;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 查询 Form
 *
 * @author Yibo
 * @version 1.0
 * @since 2018/8/3 14:28
 **/
@Data
public class ZooQueryForm extends BaseForm{

    /**
     * 动物园名称
     */
    @ApiModelProperty(value = "动物园名称")
    private String name;

    /**
     * 查询创建时间开始时间
     */
    @ApiModelProperty(value = "查询创建时间开始时间:yyyy-MM-dd HH:mm:ss 或 空")
    @PatternEx(regexp = ValidUtil.DATEFORMAT, isBlank = true, message = "查询创建时间开始时间 日期格式有误! 应为 yyyy-MM-dd HH:mm:ss 或 空")
    private String createStartTime;

    /**
     * 查询创建时间结束时间
     */
    @ApiModelProperty(value = "查询创建时间结束时间:yyyy-MM-dd HH:mm:ss 或 空")
    @PatternEx(regexp = ValidUtil.DATEFORMAT, isBlank = true, message = "查询创建时间结束时间 日期格式有误! 应为 yyyy-MM-dd HH:mm:ss 或 空")
    private String createEndTime;

    /**
     * 查询修改时间开始时间
     */
    @ApiModelProperty(value = "查询修改时间开始时间:yyyy-MM-dd HH:mm:ss 或 空")
    @PatternEx(regexp = ValidUtil.DATEFORMAT, isBlank = true, message = "查询修改时间开始时间 日期格式有误! 应为 yyyy-MM-dd HH:mm:ss 或 空")
    private String modifiedStartTime;

    /**
     * 查询修改时间结束时间
     */
    @ApiModelProperty(value = "查询修改时间结束时间:yyyy-MM-dd HH:mm:ss 或 空")
    @PatternEx(regexp = ValidUtil.DATEFORMAT, isBlank = true, message = "查询修改时间结束时间 日期格式有误! 应为 yyyy-MM-dd HH:mm:ss 或 空")
    private String modifiedEndTime;
}
