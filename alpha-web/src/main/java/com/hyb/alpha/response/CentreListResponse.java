package com.hyb.alpha.response;

/**
 * XXXXX
 *
 * @author Yibo
 * @version 1.0
 * @since 2018/8/4 14:06
 **/
import java.util.List;

public class CentreListResponse<T> extends CentreSerializable {
    private static final long serialVersionUID = -7628952830016632166L;
    private List<T> dataList;

    public CentreListResponse() {
    }

    public List<T> getDataList() {
        return this.dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }
}
