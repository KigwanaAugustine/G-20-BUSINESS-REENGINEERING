/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.August.entities;

import lombok.Data;
import java.util.Date;

/**
 *
 * @author Tanuki
 */
@Data
public class Sale 
{
    private int saleID;
    private int customerID;
    private Date date;
    private int quantity;

    public Sale() {
    }

    public Sale(int saleID, int customerID, Date date, int quantity) {
        this.saleID = saleID;
        this.customerID = customerID;
        this.date = date;
        this.quantity = quantity;
    }
    
    
}
