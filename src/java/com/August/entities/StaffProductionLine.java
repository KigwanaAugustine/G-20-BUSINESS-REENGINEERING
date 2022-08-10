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
public class StaffProductionLine 
{
    private int staffID;
    private String startDate;
    private String shirtCategoryName;

    public StaffProductionLine() {
    }

    public StaffProductionLine(int staffID, String startDate, String shirtCategoryName) {
        this.staffID = staffID;
        this.startDate = startDate;
        this.shirtCategoryName = shirtCategoryName;
    }
    
    
    
}
