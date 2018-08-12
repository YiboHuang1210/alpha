package com.hyb.alpha.response;

/**
 * XXXXX
 *
 * @author Yibo
 * @version 1.0
 * @since 2018/8/4 14:10
 **/
import com.alibaba.fastjson.JSON;
import java.io.Serializable;

public class CentreSerializable implements Serializable {
    private static final long serialVersionUID = -9006756275701089041L;

    public CentreSerializable() {
    }

    public final String toString() {
        return JSON.toJSONString(this);
    }
}