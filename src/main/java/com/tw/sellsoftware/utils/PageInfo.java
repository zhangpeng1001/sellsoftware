package com.tw.sellsoftware.utils;

public class PageInfo {

    private int pageNum;
    private int pageSize;
    private int start;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) throws Exception {
        if (pageNum < 0) {
            throw new Exception("Paging parameter error!");
        } else {
            this.pageNum = pageNum;
        }
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) throws Exception {
        if (pageSize < 1 || pageSize >100) {
            throw new Exception("Paging parameter error!");
        } else {
            this.pageSize = pageSize;
        }
    }

    public void getStart(int start) {
        this.start = pageNum*pageSize;
    }
}
