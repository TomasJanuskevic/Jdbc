package example5.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(
                name = "get_person_by_name",
                query = "from Person where firstName like :name"
        )
})
@Entity//nurodyti, kad is sitos klases kursime duomenu bazes lenteles
@Table(name = "person") //Optional, jei norite pakeisti duomenu bazes lenteles pavadinima
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @Id //pazymi, kad sis stulpelis bus primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //nurodome generavimo strategijos tipa
    @Column()//Optional, reikalinga pakeisti stulpelio pavadinima, ar dydi
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String country;
}
