package shop;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class BuyItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long buyItemId;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    public BuyItem(int quantity, Product product, Cart cart) {
        this.quantity = quantity;
        this.product = product;
        this.cart = cart;
    }

    @Override
    public String toString() {
        return product.getProductId() + ". " + product.getItem() + ": quantity " + quantity + " price " + buyItemPrice();
    }

    public int buyItemPrice(){
        return product.getPrice() * quantity;
    }
}
