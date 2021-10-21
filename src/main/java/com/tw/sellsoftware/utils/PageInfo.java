package com.tw.sellsoftware.utils;

public class PageInfo {

    private int pageNum;
    private int pageSize;
    private int start;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        if (pageNum < 0) {
            this.pageNum = 0;
        } else {
            this.pageNum = pageNum;
        }
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

    public void getStart(int start) {
        this.start = pageNum*pageSize;
    }
}
