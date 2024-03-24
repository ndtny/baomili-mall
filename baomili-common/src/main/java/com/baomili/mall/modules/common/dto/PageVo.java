package com.baomili.mall.modules.common.dto;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

import java.io.Serializable;
import java.security.PublicKey;
import java.util.List;

@Data
public class PageVo<T> implements Serializable {
    private static final long serialVersionUID = 2259153884062361053L;

    private Long current;
    private Long size;
    private Integer total;
    private List<T> list;

    public PageVo(Long current, Long size, Integer total, List<T> list) {
        this.current = current;
        this.size = size;
        this.total = total;
        this.list = list;
        Page<T> page = new Page<>(current, size, total);
        page.setRecords(list);
    }
}
