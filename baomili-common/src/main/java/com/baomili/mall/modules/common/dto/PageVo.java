package com.baomili.mall.modules.common.dto;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

import java.io.Serializable;
import java.security.PublicKey;
import java.util.List;

@Data
public class PageVo<T> implements Serializable {
    private static final long serialVersionUID = 2259153884062361053L;

    /**
     * 当前页
     */
    private Long current;
    /**
     * 每页显示条数
     */
    private Long pageSize;
    /**
     * 总数
     */
    private Integer total;
    /**
     * 页数
     */
    private Long pageTotal;
    /**
     * 数据集合
     */
    private List<T> list;

    public PageVo(Long current, Long pageSize, Integer total, List<T> list) {
        this.current = current;
        this.pageSize = pageSize;
        this.pageTotal = (long) Math.ceil((double) total / pageSize);
        this.total = total;
        this.list = list;
    }
}
