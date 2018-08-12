package com.hyb.alpha.form;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Author: Huang Yibo
 * @Date: 2018/8/6 20:33
 * @Description:
 */
public class SortInfo {

    /**
     * 排序字段
     */
    @ApiModelProperty(value = "排序字段")
    private String field;

    /**
     * 排序方式  ASC  DESC
     */
    @ApiModelProperty(value = "排序方式:ASC 或 DESC")
    private String sort;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SortInfo{");
        sb.append("field='").append(field).append('\'');
        sb.append(", sort='").append(sort).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
