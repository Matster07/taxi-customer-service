package com.matster.taxi.order.system.customerservice.util;

import java.util.List;

public class Utils {

    public static Long prepareUniqId(List<Long> ids) {
        Long id = 123L;

        if (!ids.contains(123L)) {
            return id;
        }

        return prepareUniqId(ids);
    }
}
