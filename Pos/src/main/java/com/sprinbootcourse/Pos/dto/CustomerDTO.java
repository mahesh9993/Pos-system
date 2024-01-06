package com.sprinbootcourse.Pos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerDTO {

    private Integer customerId;

    private String customerName;

    private String customerAddress;

    private double salary;

    private ArrayList contactNumbers;

    private String nic;

    private boolean status;

}
