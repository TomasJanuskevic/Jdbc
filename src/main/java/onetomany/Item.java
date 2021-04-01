package onetomany;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "ITEM")
@Data
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    //gali buti ir quantity

    @ManyToOne
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart;


}
