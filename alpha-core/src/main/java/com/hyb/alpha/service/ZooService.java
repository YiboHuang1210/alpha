package com.hyb.alpha.service;

import com.hyb.alpha.domain.bo.ZooBO;
import com.hyb.alpha.domain.condition.ZooCondition;
import com.hyb.alpha.exception.AlphaException;

import java.util.List;

/**
 * XXXXX
 *
 * @author Yibo
 * @version 1.0
 * @since 2018/8/7 18:10
 **/
public interface ZooService {

    /**
     * 查询详情
     * @param id
     * @return
     */
    ZooBO query(Integer id);

    /**
     * 根据name查询详情
     * @param name
     * @return
     */
    ZooBO queryName(String name);

    /**
     * 查询详情,失败则抛异常
     * @param id
     * @return
     * @throws AlphaException
     */
    ZooBO queryWithValid(Integer id) throws AlphaException;

    /**
     * 查询数量
     * @param condition
     * @return
     */
    int queryCount(ZooCondition condition);

    /**
     * 查询列表
     * @param condition
     * @return
     */
    List<ZooBO> queryList(ZooCondition condition);

    /**
     * 修改
     * @param bo
     * @return
     */
    int update(ZooBO bo);

    /**
     * 修改,失败则抛异常
     * @param bo
     * @throws AlphaException
     */
    void updateWithValid(ZooBO bo) throws AlphaException;

    /**
     * 创建
     * @param bo
     */
    void insert(ZooBO bo);

    /**
     * 创建,失败则抛异常
     * @param bo
     * @throws AlphaException
     */
    void insertWithValid(ZooBO bo) throws AlphaException;

    /**
     * 删除
     * @param id
     */
    void delete(Integer id);

    /**
     * 伪删除
     * @param id
     * @throws AlphaException
     */
    void fakeDelete(Integer id) throws AlphaException;
}
