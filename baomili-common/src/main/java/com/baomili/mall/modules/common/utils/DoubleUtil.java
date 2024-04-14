package com.baomili.mall.modules.common.utils;

import java.io.Serializable;
import java.math.BigDecimal;

public class DoubleUtil implements Serializable {
    private static final long serialVersionUID = 1578236569768532769L;

    public static double add(Double d1, Double d2) {
        BigDecimal bigDecimal1 = new BigDecimal(d1.toString());
        BigDecimal bigDecimal2 = new BigDecimal(d2.toString());
        return bigDecimal1.add(bigDecimal2).doubleValue();
    }
}
