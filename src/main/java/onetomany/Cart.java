package onetomany;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "CART")
@Data
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Long cartId;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private Set<Item> items;
}
