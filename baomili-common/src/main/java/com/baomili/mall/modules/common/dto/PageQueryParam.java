package com.baomili.mall.modules.common.dto;

import lombok.Data;
import org.springframework.jdbc.support.lob.LobCreator;

import java.io.Serializable;

@Data
public class PageQueryParam implements Serializable {
    private static final long serialVersionUID = 3615550979808428344L;

    /**
     * 当前页
     */
    private Long current = 1L;

    /**
     * 每页显示条数
     */
    private Long pageSize = 50L;
}
