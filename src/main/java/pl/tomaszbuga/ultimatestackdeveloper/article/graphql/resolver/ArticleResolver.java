package pl.tomaszbuga.ultimatestackdeveloper.article.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;
import pl.tomaszbuga.ultimatestackdeveloper.article.Article;
import pl.tomaszbuga.ultimatestackdeveloper.article.ArticleRepository;
import pl.tomaszbuga.ultimatestackdeveloper.article.graphql.exception.ArticleNotFoundException;
import pl.tomaszbuga.ultimatestackdeveloper.category.Category;
import pl.tomaszbuga.ultimatestackdeveloper.category.CategoryRepository;
import pl.tomaszbuga.ultimatestackdeveloper.category.graphql.exception.CategoryNotFoundException;

import java.util.List;
import java.util.Optional;

@Component
public class ArticleResolver implements GraphQLQueryResolver {
    private ArticleRepository articleRepository;

    public ArticleResolver(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public Iterable<Article> findAllArticles() {
        return articleRepository.findAll();
    }

    public float countArticles() {
        return articleRepository.count();
    }

    public Article findArticleById(Long articleId) {
        Optional<Article> optionalArticle = articleRepository.findById(articleId);

        if (optionalArticle.isPresent()) {
            return optionalArticle.get();
        } else {
            throw new ArticleNotFoundException("Article not found", articleId);
        }
    }
}
