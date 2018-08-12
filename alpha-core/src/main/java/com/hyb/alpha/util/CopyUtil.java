package com.hyb.alpha.util;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 对象属性拷贝 工具类
 *
 * @Author: Huang Yibo
 * @Date: 2018/8/6 23:37
 *
 */
public class CopyUtil {
    public static <T>T transfer(Object source, Class<T> targetClass){
        if (source == null){
            return null;
        }
        try {
            T t = targetClass.newInstance();
            BeanUtils.copyProperties(source,t);
            return t;
        } catch (InstantiationException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T>List<T> transferList(List<?> sourceList, Class<T> targetClass){
        if (CollectionUtils.isEmpty(sourceList)){
            return new ArrayList<T>();
        }
        return sourceList.stream().map((source)->transfer(source,targetClass)).collect(Collectors.toList());
    }
}
