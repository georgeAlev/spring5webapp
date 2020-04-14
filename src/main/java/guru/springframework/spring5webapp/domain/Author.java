package guru.springframework.spring5webapp.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
public class Author{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;

    @ManyToMany(mappedBy = "authors")
    private Set<Book> books = new HashSet<>();

    /* required by JPA */
    public Author() {
    }

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /* getters */
    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Set<Book> getBooks() {
        return books;
    }

    /* setters */
    public void setId(Long id) {
        this.id = id;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Author{");
        sb.append("id=").append(id);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", books=").append(books);
        sb.append('}');
        return sb.toString();
    }

    /**
     * @return  {@code true} if this object is the same as the obj
     *                       argument OR  have the same id
     *          {@code false} otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        return id != null ? id.equals(author.id) : author.id == null;
    }

    /**
     * Override to maintain the general contract
     * that equal objects must have equal hash codes.
     */
    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
