package com.sprinbootcourse.Pos.dto;

import com.sprinbootcourse.Pos.model.enums.MeasuringType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemDTO {

    private int itemId;
    private String itemName;
    private MeasuringType measuringType;
    private double balanceQty;
    private double cost;
    private double sellingPrice;
    private boolean status;
}
