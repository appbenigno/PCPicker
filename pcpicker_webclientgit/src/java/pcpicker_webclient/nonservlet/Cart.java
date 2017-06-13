/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pcpicker_webclient.nonservlet;

import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import pcpicker.Part;

/**
 *
 * @author admin
 */
public class Cart {
    private ArrayList<CartItem> cartItems = new ArrayList<CartItem>();
    public int numItems=0;
    public Cart(){}
    
    public void add(Part part, int quantity)
    {
        int index = partInList(part);
        if(index >=0 )
        {
            cartItems.get(index).quantity += quantity;
        }
        else
        {
           cartItems.add(new CartItem(part,quantity));
           numItems++;  
        }
       
    }
    
    public void remove(Part part)
    {
        int index = partInList(part);
        System.out.println("remove index" + index);
        if(index >= 0)
        { 
            cartItems.remove(index);
            numItems--;
        }
    }
    
    public void update(Part part, int quantity)
    {
        int index = partInList(part);
        if(index >=0 )
            cartItems.get(index).quantity = quantity;
        
    }
    public void sub(Part part, int quantity)
    {
        int index = partInList(part);
        if(index >=0 )
        {
            if(cartItems.get(index).quantity>1)
                cartItems.get(index).quantity -= quantity;
        }
       
       
    }
    
    public ArrayList<CartItem> getList()
    {
        return cartItems;
    }
    public ArrayList<String> getPartList()
    {
        ArrayList<String> partList = new ArrayList<String>();
        for(int i = 0; i < cartItems.size(); i++)
            partList.add(cartItems.get(i).part.getPartId());
        return partList;        
    }
    public ArrayList<Integer> getQuantityList()
    {
        ArrayList<Integer> partList = new ArrayList<Integer>();
        for(int i = 0; i < cartItems.size(); i++)
            partList.add(cartItems.get(i).quantity);
        return partList;        
    }
    
    private int partInList(Part part)
    {
        for(int i = 0; i < cartItems.size(); i++)
        {
            if(part.getPartId().equals(cartItems.get(i).part.getPartId()))
                return i;
        }
        return -1;
    }
    
    public double getTotalPrice()
    {
        double total = 0;
        for(CartItem c : cartItems)
        {
            total += c.quantity * c.part.getPartPrice();
        }
        return total;
    }
    
   
}
