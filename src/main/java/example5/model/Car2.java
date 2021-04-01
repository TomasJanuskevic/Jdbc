package example5.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Mycars")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String car;
    private String model;
    private String engine;

}
