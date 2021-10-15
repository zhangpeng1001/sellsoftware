package com.tw.sellsoftware.utils;

public class PageInfo {

    private int pageNum;
    private int pageSize;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        if (pageSize <= 10) {
            this.pageSize = 10;
        } else {
            this.pageSize = pageSize;
        }
    }
}
