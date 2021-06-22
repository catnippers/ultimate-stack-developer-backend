package pl.tomaszbuga.ultimatestackdeveloper.article;

import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Long> {
}
