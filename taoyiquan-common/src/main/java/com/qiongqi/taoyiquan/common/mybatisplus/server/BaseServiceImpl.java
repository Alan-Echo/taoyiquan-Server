package com.qiongqi.taoyiquan.common.mybatisplus.server;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qiongqi.taoyiquan.common.mybatisplus.page.PageData;
import com.qiongqi.taoyiquan.common.utils.ConvertUtils;

import java.util.List;


public class BaseServiceImpl<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> implements BaseService<T> {
    public  BaseServiceImpl(){
    }
    protected <T> PageData<T> getPageData(List<?> list, long total, long pages, long current, Class<T> target) {
        List<T> targetList = ConvertUtils.sourceToTarget(list, target);
        return new PageData(targetList, total, pages, current);
    }

    protected <T> PageData<T> getPageData(IPage page, Class<T> target) {
        return this.getPageData(page.getRecords(), page.getTotal(), page.getPages(), page.getCurrent(), target);
    }
}