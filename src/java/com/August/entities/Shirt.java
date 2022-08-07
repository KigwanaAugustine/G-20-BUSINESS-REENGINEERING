/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.August.entities;

import lombok.Data;

/**
 *
 * @author Tanuki
 */
@Data
public class Shirt 
{
    private int shirtID;
    private String color;
    private int productionLineID;
    private int cartID;
    private int saleID;
    private String shirtCategoryName;

    public Shirt() {
    }

    public Shirt(int shirtID, String color, int productionLineID, int cartID, int saleID, String shirtCategoryName) {
        this.shirtID = shirtID;
        this.color = color;
        this.productionLineID = productionLineID;
        this.cartID = cartID;
        this.saleID = saleID;
        this.shirtCategoryName = shirtCategoryName;
    }
    
    
}
