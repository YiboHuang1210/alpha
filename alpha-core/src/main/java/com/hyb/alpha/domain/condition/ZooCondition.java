package com.hyb.alpha.domain.condition;

import lombok.Data;

/**
 * @Author: Huang Yibo
 * @Date: 2018/8/5 16:59
 * @Description:
 */
@Data
public class ZooCondition extends BaseCondition {

    /**
     * id
     */
    private Integer id;

    /**
     * 动物园名称
     */
    private String name;

    /**
     * 删除标记  0 未删除 1 已删除
     */
    private Integer isDeleted;


    /**
     * 查询创建时间开始时间
     */
    private String createStartTime;

    /**
     * 查询创建时间结束时间
     */
    private String createEndTime;

    /**
     * 查询修改时间开始时间
     */
    private String modifiedStartTime;

    /**
     * 查询修改时间结束时间
     */
    private String modifiedEndTime;
}
