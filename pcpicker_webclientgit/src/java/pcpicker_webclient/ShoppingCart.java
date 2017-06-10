/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pcpicker_webclient;

import java.util.ArrayList;
import java.util.List;
import pcpicker.*;


/**
 *
 * @author admin
 */
public class ShoppingCart {
    private List<Part> parts = new ArrayList<Part>();
    private static ShoppingCart instance;
    private ShoppingCart(){}
    
    public static ShoppingCart GetInstance()
    {
        if(instance == null)
            instance = new ShoppingCart();
        
        return instance;
    }
    public void addItem(Part component)
    {
        parts.add(component);
    }
    public void removeItem(Part component)
    {
        for(int i = 0; i < parts.size();i++)
            if(parts.get(i).getPartId().equals(component.getPartId()))
                parts.remove(i);            
    }
    public List<Part> getList()
    {
        return parts;
    }
    public void delete()
    {
        parts = null;
        instance = null;
    }
}
