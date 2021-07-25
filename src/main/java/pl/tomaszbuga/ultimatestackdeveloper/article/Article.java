package pl.tomaszbuga.ultimatestackdeveloper.article;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.tomaszbuga.ultimatestackdeveloper.category.Category;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "article")
@Data
@NoArgsConstructor
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(
            name = "title",
            nullable = false)
    private String title;
    @Column(
            name = "author_first_name",
            nullable = false)
    private String authorFirstName;
    @Column(name = "author_last_name")
    private String authorLastName;
    @Column(name = "summary")
    private String summary;
    @Column(name = "content")
    private String content;
    @Column(name = "create_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate createDate;
    @Column(name = "publish_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate publishDate;

    @ManyToMany(
            cascade = {CascadeType.MERGE, CascadeType.PERSIST},
            fetch = FetchType.EAGER)
    @JoinTable(
            name = "article_category",
            joinColumns = @JoinColumn(name = "article_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();

    public Article(Long id) {
        this.id = id;
    }

    public Article(
            String title,
            String authorFirstName,
            String authorLastName) {
        this.title = title;
        this.authorFirstName = authorFirstName;
        this.authorLastName = authorLastName;
        this.createDate = LocalDate.now();
    }

    public Article addCategory(Category category) {
        this.categories.add(category);
        category.getArticles().add(this);
        return this;
    }

    public Article removeCategory(Category category) {
        this.categories.remove(category);
        category.getArticles().remove(this);
        return this;
    }

    public Article setCategories(Set<Category> categories) {
        this.categories = categories;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return id.equals(article.id) &&
                title.equals(article.title) &&
                Objects.equals(authorFirstName, article.authorFirstName) &&
                Objects.equals(authorLastName, article.authorLastName) &&
                Objects.equals(summary, article.summary) &&
                Objects.equals(content, article.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, authorFirstName, authorLastName, summary, content);
    }
}
