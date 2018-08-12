package com.hyb.alpha.dao;

import com.hyb.alpha.domain.condition.ZooCondition;
import com.hyb.alpha.domain.po.ZooPO;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @Author: Huang Yibo
 * @Date: 2018/8/5 16:47
 * @Description:
 */
@Repository
public interface ZooMapper extends BaseMapper<ZooPO, ZooCondition> {
}
