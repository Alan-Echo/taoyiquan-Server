package com.qiongqi.taoyiquan.common.mybatisplus.page;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.commons.collections4.MapUtils;

import java.util.Map;

public class PageUtils {
    private static final Long PAGE_NO_DEFAULT = 1L;
    private static final Long PAGE_SIZE_DEFAULT = 10L;

    public PageUtils() {
    }

    public static Long getStartIndex(Map<String, Object> queryParams) {
        IPage page = initPage(queryParams);
        return (page.getCurrent() - 1L) * page.getSize();
    }

    public static IPage initPage(Map<String, Object> queryParams) {
        IPage page = new Page();
        page.setCurrent(MapUtils.getLong(queryParams, "index", PAGE_NO_DEFAULT));
        page.setSize(MapUtils.getLong(queryParams, "limit", PAGE_SIZE_DEFAULT));
        queryParams.put("startIndex", (page.getCurrent() - 1L) * page.getSize());
        queryParams.put("pageTotal", page.getSize());
        return page;
    }
}
