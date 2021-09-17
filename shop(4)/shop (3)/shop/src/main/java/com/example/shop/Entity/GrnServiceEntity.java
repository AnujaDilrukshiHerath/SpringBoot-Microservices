package com.example.shop.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "grn")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GrnServiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "grn_grnId")
    Integer id;

    @Column(name = "totalQuentity")
    Integer quantity;

    @Column(name="totalGrnAmount")
    Integer totalPrice;

    @Column(name= "grnDate")
    LocalDate grnDate;

}
