package com.sprinbootcourse.Pos.model;

import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "customer")
@TypeDefs({
        @TypeDef(name = "json",typeClass = JsonType.class)
})
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer {

    @Id
    @Column(name = "customer_id",length = 60)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer customerId;

    @Column(name = "customer_name",length = 150)
    private String customerName;

    @Column(name = "customer_address",length = 300)
    private String customerAddress;

    @Column(name = "salary")
    private double salary;

    @Type(type = "json")
    @Column(name = "contact_numbers",columnDefinition = "json")
    private ArrayList contactNumbers;

    @Column(name = "nic_no",length = 12)
    private String nic;

    @Column(name = "status",columnDefinition = "TINYINT default 0")
    private boolean status;

}
