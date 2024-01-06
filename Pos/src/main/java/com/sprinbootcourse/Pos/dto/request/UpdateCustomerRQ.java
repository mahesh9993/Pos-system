package com.sprinbootcourse.Pos.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateCustomerRQ {
    private int customerId;
    private String customerName;
    private String customerAddress;
    private ArrayList contactNumbers;
    private boolean status;
}
