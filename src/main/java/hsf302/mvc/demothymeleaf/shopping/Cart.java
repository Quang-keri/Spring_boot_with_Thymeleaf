package hsf302.mvc.demothymeleaf.shopping;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Long,Product> cart;

    public Cart() {
    }

    public Cart(Map<Long, Product> cart) {
        this.cart = cart;
    }

    public Map<Long, Product> getCart() {
        return cart;
    }

    public void setCart(Map<Long, Product> cart) {
        this.cart = cart;
    }

    public boolean add(Product product) {
        boolean check = false;
        try {
            if (this.cart == null) {
                this.cart = new HashMap<>();
            }
            if (this.cart.containsKey(product.getProductId())) {
                int currentQuantity = this.cart.get(product.getProductId()).getQuantity();
                product.setQuantity(currentQuantity + product.getQuantity());
            }
            this.cart.put(product.getProductId(), product);
            check = true;
        } catch (Exception e) {

        }
        return check;
    }

    public boolean edit(Long id,int quantity){
        boolean check =false;
        try{
            if(this.cart != null){
                if(this.cart.containsKey(id)){
                    this.cart.get(id).setQuantity(quantity);
                    check =true;
                }
            }
        }catch(Exception e){

        }
        return check;
    }

    public boolean remove(Long  id){
        boolean check =false;

        try{
            if(this.cart != null){
                if(this.cart.containsKey(id)){
                    this.cart.remove(id);
                    check=true;
                }

            }

        }catch(Exception e){

        }

        return  check;
    }
}
