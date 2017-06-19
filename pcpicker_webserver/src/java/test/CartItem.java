/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import pcpicker.Part;

/**
 *
 * @author admin
 */
public class CartItem {
    public Part part;
    public int quantity;
    
    public CartItem(Part part, int quantity)
    {
        this.part = part;
        this.quantity = quantity;
    }
    
    
}
