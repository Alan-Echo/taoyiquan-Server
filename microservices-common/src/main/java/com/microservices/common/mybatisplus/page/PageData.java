package com.microservices.common.mybatisplus.page;


import java.io.Serializable;
import java.util.List;

/**
 * @description: 分页数据
 * @author: 小谭
 * @time: 2020-11-27 12:10
 */
public class PageData<T> implements Serializable {

    /** 数据列表 */
    private List<T> list;

    /** 总条数 */
    private int total;

    /** 总页数 */
    private int pageTotal;

    /** 当前页 */
    private int index;

    /** 单页条数 */
    private int limit;


    public PageData(List<T> list, long total) {
        this.list = list;
        this.total = (int) total;
    }

    public PageData(List<T> list, long total,long index) {
        this.list = list;
        this.total = (int) total;
        this.index=(int)index;
    }

    public PageData(List<T> list, long total,long pageSize,long index) {
        this.list = list;
        this.total = (int) total;
        this.pageTotal=(int)pageSize;
        this.index=(int)index;
    }

    public PageData(List<T> list, long total,long pageTotal,long index,long limit) {
        this.list = list;
        this.total = (int) total;
        this.pageTotal=(int)pageTotal;
        this.index=(int)index;
        this.limit=(int)limit;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(int pageTotal) {
        this.pageTotal = pageTotal;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }


}
