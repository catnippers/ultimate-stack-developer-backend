package pl.tomaszbuga.ultimatestackdeveloper.category;
import pl.tomaszbuga.ultimatestackdeveloper.article.Article;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(
            name = "title",
            nullable = false)
    private String title;
    @Column(
            name = "tag",
            nullable = false)
    private String tag;
    @ManyToMany(
            mappedBy = "categories",
            fetch = FetchType.EAGER)
    private Set<Article> articles;

    public Category() {
    }

    public Category(Long id) {
        this.id = id;
    }

    public Category(String title, String tag) {
        this.title = title;
        this.tag = tag;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Article> getArticles() {
        return articles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return id.equals(category.id) &&
                title.equals(category.title) &&
                tag.equals(category.tag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, tag);
    }
}
