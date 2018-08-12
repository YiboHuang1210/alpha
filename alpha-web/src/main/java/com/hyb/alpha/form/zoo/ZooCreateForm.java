package com.hyb.alpha.form.zoo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 创建 form
 *
 * @author Yibo
 * @version 1.0
 * @since 2018/8/3 14:27
 **/
@Data
public class ZooCreateForm {

    /**
     * 动物园名称
     */
    @ApiModelProperty(value = "动物园名称")
    @NotBlank(message = "动物园名称不能为空")
    private String name;
}
