package com.hyb.alpha.form.zoo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * XXXXX
 *
 * @author Yibo
 * @version 1.0
 * @since 2018/8/3 14:28
 **/
@Data
public class ZooUpdateForm {

    /**
     * id
     */
    @ApiModelProperty(value = "动物园编号")
    @NotNull(message = "id不能为空")
    private Integer id;

    /**
     * 动物园名称
     */
    @ApiModelProperty(value = "动物园名称")
    @NotBlank(message = "动物园名称不能为空")
    private String name;
}
