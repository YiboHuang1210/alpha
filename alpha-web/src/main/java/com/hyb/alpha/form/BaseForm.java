package com.hyb.alpha.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Range;
import javax.validation.constraints.Min;
import java.util.List;

/**
 * @Author: Huang Yibo
 * @Date: 2018/8/6 20:32
 * @Description:
 */
@Data
public class BaseForm {

    /**
     * 分页每页条数:默认20,范围(0,100]
     */
    @ApiModelProperty("分页每页条数:范围(0,100],默认为20")
    @Range(min = 1, max = 100, message = "分页每页条数输入有误! 范围应该为(0,100]")
    private Integer pageSize = 20;

    /**
     * 分页当前页码,默认为0
     */
    @ApiModelProperty("分页当前页码,默认为0")
    @Min(value = 0, message = "分页当前页码输入有误! 范围应该为非负整数")
    private Integer pageNo = 0;

    /**
     * 排序字段列表
     */
    @ApiModelProperty(value = "排序字段列表")
    private List<SortInfo> sortInfos;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BaseForm{");
        sb.append("pageSize=").append(pageSize);
        sb.append(", pageNo=").append(pageNo);
        sb.append('}');
        return sb.toString();
    }
}
