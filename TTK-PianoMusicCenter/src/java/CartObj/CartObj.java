/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CartObj;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author XinWei
 */
public class CartObj implements Serializable {

    public static int count=0;
    private HashMap<String, Integer> items;
    public CartObj() {
        items = new HashMap<>();
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        CartObj.count = count;
    }




    public HashMap<String, Integer> getItems() {
        return items;
    }

    public void setItems(HashMap<String, Integer> items) {
        this.items = items;
        
    }


    public HashMap<String, Integer> getItem() {
        
        return items;
    }

    public void setItem(HashMap<String, Integer> item) {
        this.items = item;
    }
    public void change(String key , int value) {
        items.put(key, value);
    }
    public void addItemToCart(String title) {
        if (items == null) {
            items = new HashMap<>();
        }
        int quantity = 1;
        if (items.containsKey(title)) {
            quantity = items.get(title) + 1;
            
        }
        items.put(title, quantity);
    }
    public void removeItemFromCart(String title){
        if(items == null){
            return;
        }
        if(items.containsKey(title)){
            items.remove(title);
            if(items.isEmpty()){
                items = null;
                
            }
        }
    }
}
