package com.hyb.alpha.domain.condition;

/**
 * XXXXX
 *
 * @author Yibo
 * @version 1.0
 * @since 2018/8/4 14:05
 **/

public class BaseCondition {

    /**
     * 分页每页长度
     */
    private int pageSize = Integer.MAX_VALUE;

    /**
     * 分页当前页码
     */
    private int pageNo;

    /**
     * 忽略记录数
     */
    private int skipResults = 0;

    /**
     * 排序字段
     */
    private String orderBy;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
        skipResults = pageSize * pageNo;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
        skipResults = pageSize * pageNo;
    }

    public int getSkipResults() {
        return skipResults;
    }


    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }


    /*
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
    */
}
