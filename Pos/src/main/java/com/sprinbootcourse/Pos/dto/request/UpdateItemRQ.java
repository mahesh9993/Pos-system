package com.sprinbootcourse.Pos.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateItemRQ {

    private int itemId;

    private double balanceQty;

    private double cost;

    private double sellingPrice;

    private boolean status;
}
