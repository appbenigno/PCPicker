package Pcpicker_webserviceForDesktop;

import java.util.List;
import javax.xml.bind.annotation.*;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Inventory")
public class Inventory 
{
    @XmlElement(name ="items")
    private List<InventoryItem> items;

    /**
     * @return the items
     */
    public List<InventoryItem> getItems() {
        return items;
    }

    /**
     * @param items the items to set
     */
    public void setItems(List<InventoryItem> items) {
        this.items = items;
    }
}