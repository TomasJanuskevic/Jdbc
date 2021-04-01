package onetoone;

import javax.persistence.*;

@Entity
//@Table papildomoms konfiguracijoms lenteles
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Column anotacija skirta konfiguruoti stulpeli
    private String name;

    private String country;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id", unique = true) // veikia kaip foreign key kuriant lentele
    private Book book;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
