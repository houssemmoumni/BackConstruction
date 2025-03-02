package com.megaminds.notification.dto;

import java.math.BigDecimal;

public record Material(
        Integer materialId,
        String name,
        String description,
        BigDecimal price,
        double quantity
) {
}
