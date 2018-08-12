package com.hyb.alpha.domain.po;

import lombok.Data;
import java.util.Date;

/**
 * @Author: Huang Yibo
 * @Date: 2018/8/5 16:51
 * @Description:
 */
@Data
public class ZooPO {

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
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 修改时间
     */
    private Date gmtModified;
}
