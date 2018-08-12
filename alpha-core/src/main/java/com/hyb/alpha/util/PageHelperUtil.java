package com.hyb.alpha.util;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * @Author: Huang Yibo
 * @Date: 2018/8/5 17:17
 * @Description:
 */
public class PageHelperUtil {

    public static <E> Page<E> startPage(int pageNo, int pageSize) {
        return PageHelper.startPage(pageNo + 1, pageSize);
    }
}
