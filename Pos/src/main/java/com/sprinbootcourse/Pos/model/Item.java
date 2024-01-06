package com.sprinbootcourse.Pos.model;

import com.sprinbootcourse.Pos.model.enums.MeasuringType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "item")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Item {

    @Id
    @Column(name = "item_id",length = 50)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int itemId;

    @Column(name = "item_name",length = 150,nullable = false)
    private String itemName;

    @Enumerated(EnumType.STRING)
    @Column(name = "measuring_type",length = 40,nullable = false)
    private MeasuringType measuringType;

    @Column(name = "balance_qty",length = 40,nullable = false)
    private double balanceQty;

    @Column(name = "cost",length = 40,nullable = false)
    private double cost;

    @Column(name = "selling_price",length = 40,nullable = false)
    private double sellingPrice;

    @Column(name = "status",length = 20,nullable = false)
    private boolean status;

}
