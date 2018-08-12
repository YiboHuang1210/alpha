package com.hyb.alpha.dao;

import com.hyb.alpha.domain.condition.BaseCondition;

import java.util.List;

/**
 * XXXXX
 *
 * @author Yibo
 * @version 1.0
 * @since 2018/8/4 14:05
 **/
public interface BaseMapper<T, C extends BaseCondition> {
    /**
     * 获得bean
     *
     * @param id
     * @return
     */
    T select(Object id);

    /**
     * 根据name获得bean
     * @param name
     * @return
     */
    T selectName(Object name);

    /**
     * 获得数量
     *
     * @param condition
     * @return
     */
    int count(C condition);
    /**
     * 获得列表
     *
     * @param condition
     * @return
     */
    List<T> selectList(C condition);
    /**
     * 新增记录
     *
     * @param po
     */
    int insert(T po);
    /**
     * 修改记录
     *
     * @param po
     * @return
     */
    int update(T po);
    /**
     * 删除记录
     *
     * @param id
     * @return
     */
    int delete(Object id);
}
