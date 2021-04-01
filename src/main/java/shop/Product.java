package shop;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    private String item;
    private int price;

    public Product(String item, int price) {
        this.item = item;
        this.price = price;
    }

    @Override
    public String toString() {
        return productId + ". " + item + " " + price + " eur";
    }
}
