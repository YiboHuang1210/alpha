package com.hyb.alpha.service;

import com.hyb.alpha.domain.condition.BaseCondition;
import com.hyb.alpha.exception.AlphaException;

import java.util.List;

/**
 * @Author: Huang Yibo
 * @Date: 2018/8/5 17:04
 * @Description:
 *
 * @param <T> 服务层的PO对象
 * @param <C> 服务层的条件对象
 */
public interface BaseService<T, C extends BaseCondition> {

    /**
     * 查询详情
     *
     * @param id
     * @return
     */
    T query(Object id);

    /**
     * 根据name查询详情
     *
     * @param name
     * @return
     */
    T queryName(Object name);

    /**
     * 查询验证的详情,查不到则抛异常
     *
     * @param id
     * @return
     * @throws AlphaException
     */
    T queryWithValid(Object id) throws AlphaException;

    /**
     * 查询列表
     *
     * @param condition
     * @return
     */
    List<T> queryList(C condition);

    /**
     * 查询数量
     *
     * @param condition
     * @return
     */
    int queryCount(C condition);

    /**
     * 修改
     *
     * @param po
     * @return
     */
    int update(T po);

    /**
     * 修改,失败则抛异常
     *
     * @param po
     * @throws AlphaException
     */
    void updateWithValid(T po) throws AlphaException;

    /**
     * 新增
     *
     * @param po
     */
    void insert(T po);

    /**
     * 删除
     *
     * @param id
     */
    void delete(Object id);
}
