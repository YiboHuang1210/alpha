package com.hyb.alpha.service.impl;

import com.hyb.alpha.dao.ZooMapper;
import com.hyb.alpha.domain.bo.ZooBO;
import com.hyb.alpha.domain.condition.ZooCondition;
import com.hyb.alpha.domain.consts.Constants;
import com.hyb.alpha.exception.AlphaException;
import com.hyb.alpha.service.ZooService;
import com.hyb.alpha.util.CopyUtil;
import com.hyb.alpha.util.PageHelperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @Author: Huang Yibo
 * @Date: 2018/8/6 23:42
 * @Description:
 */
@Service
public class ZooServiceImpl implements ZooService {

    @Autowired
    private ZooMapper zooMapper;

    @Override
    public ZooBO query(Integer id) {
        return CopyUtil.transfer(zooMapper.select(id), ZooBO.class);
    }

    @Override
    public ZooBO queryName(String name) {
        return CopyUtil.transfer(zooMapper.selectName(name), ZooBO.class);
    }

    @Override
    public ZooBO queryWithValid(Integer id) throws AlphaException {
        ZooBO zooBO = CopyUtil.transfer(zooMapper.select(id), ZooBO.class);
        if (zooBO == null){
            throw new AlphaException(id + "对应的记录为空!");
        }
        return zooBO;
    }

    @Override
    public int queryCount(ZooCondition condition) {
        condition.setIsDeleted(Constants.DEL_FLAG.UN_DELETE);
        PageHelperUtil.startPage(0, 0);
        return zooMapper.count(condition);
    }

    /**
     * 查询列表
     *
     * @param condition
     * @return
     */
    @Override
    public List<ZooBO> queryList(ZooCondition condition) {
        condition.setIsDeleted(Constants.DEL_FLAG.UN_DELETE);
        PageHelperUtil.startPage(condition.getPageNo(), condition.getPageSize());
        return CopyUtil.transferList(zooMapper.selectList(condition),ZooBO.class);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public int update(ZooBO bo) {
        bo.setGmtModified(new Date());
        return zooMapper.update(bo);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void updateWithValid(ZooBO bo) throws AlphaException {
        bo.setGmtModified(new Date());
        int row = zooMapper.update(bo);
        if (row == 0) {
            throw new AlphaException("修改失败!");
        }
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void insert(ZooBO bo) {
        zooMapper.insert(bo);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void insertWithValid(ZooBO bo) throws AlphaException {
        bo.setIsDeleted(Constants.DEL_FLAG.UN_DELETE);
        bo.setGmtCreate(new Date());
        bo.setGmtModified(new Date());
        int row = zooMapper.insert(bo);
        if (row == 0) {
            throw new AlphaException("创建失败!");
        }
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void delete(Integer id) {
        zooMapper.delete(id);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void fakeDelete(Integer id) throws AlphaException {
        ZooBO bo = new ZooBO();
        bo.setId(id);
        bo.setIsDeleted(Constants.DEL_FLAG.DELETED);
        bo.setGmtModified(new Date());
        int row = zooMapper.update(bo);
        if (row == 0) {
            throw new AlphaException("删除失败!");
        }
    }
}
