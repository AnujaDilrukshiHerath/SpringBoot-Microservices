package com.example.shop.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "grn_has_product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GrnProdcutEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "grn_grnId")
    Integer id;
    @Column(name = "product_productId")
    Integer proId;
    @Column(name = "grn_has_productId")
    Integer grnProId;
    @Column(name = "productQuentity")
    Integer quantity;
}
