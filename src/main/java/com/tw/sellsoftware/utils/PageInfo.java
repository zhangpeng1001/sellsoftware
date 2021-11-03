package com.tw.sellsoftware.utils;

import com.tw.sellsoftware.utils.enums.SellSoftwareExceptionEnum;

public class PageInfo {

    private int pageNum;
    private int pageSize;
    private int start;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        if (pageNum < 0) {
            throw new SellSoftwareException(SellSoftwareExceptionEnum.PAGE_NUM_ERROR);
        } else {
            this.pageNum = pageNum;
        }
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        if (pageSize < 1 || pageSize > 100) {
            throw new SellSoftwareException(SellSoftwareExceptionEnum.PAGE_SIZE_ERROR);
        } else {
            this.pageSize = pageSize;
        }
    }

    public void getStart(int start) {
        this.start = pageNum * pageSize;
    }
}
