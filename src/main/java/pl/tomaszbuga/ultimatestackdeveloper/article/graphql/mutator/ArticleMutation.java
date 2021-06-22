package pl.tomaszbuga.ultimatestackdeveloper.article.graphql.mutator;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;
import pl.tomaszbuga.ultimatestackdeveloper.article.Article;
import pl.tomaszbuga.ultimatestackdeveloper.article.ArticleRepository;
import pl.tomaszbuga.ultimatestackdeveloper.article.graphql.exception.ArticleNotFoundException;
import pl.tomaszbuga.ultimatestackdeveloper.category.Category;
import pl.tomaszbuga.ultimatestackdeveloper.category.CategoryRepository;
import pl.tomaszbuga.ultimatestackdeveloper.category.graphql.exception.CategoryNotFoundException;

import java.util.Optional;
import java.util.Set;

@Component
public class ArticleMutation implements GraphQLMutationResolver {
    private final ArticleRepository articleRepository;
    private final CategoryRepository categoryRepository;

    public ArticleMutation(ArticleRepository articleRepository,
                           CategoryRepository categoryRepository) {
        this.articleRepository = articleRepository;
        this.categoryRepository = categoryRepository;
    }

    public Article newArticle(
            String title,
            String authorFirstName,
            String authorLastName) {
        Article article = new Article(title, authorFirstName, authorLastName);
        articleRepository.save(article);
        return article;
    }

    public Article editArticleById(
            String newTitle,
            String newSummary,
            String newContent,
            Long id) {
        Optional<Article> optionalArticle = articleRepository.findById(id);

        if (optionalArticle.isPresent()) {
            Article article = optionalArticle.get();
            article.setTitle(newTitle);
            article.setSummary(newSummary);
            article.setContent(newContent);
            articleRepository.save(article);

            return article;
        } else {
            throw new ArticleNotFoundException("Article not found", id);
        }
    }

    public boolean deleteArticle(Long id) {
        articleRepository.deleteById(id);
        return true;
    }

    public Article updateArticleTitle(String newTitle, Long id) {
        Optional<Article> optionalArticle = articleRepository.findById(id);

        if (optionalArticle.isPresent()) {
            Article article = optionalArticle.get();
            article.setTitle(newTitle);
            articleRepository.save(article);
            return article;
        } else {
            throw new ArticleNotFoundException("Article not found", id);
        }
    }

    public Boolean assignCategoryToArticle(Long articleId, Long categoryId) {
        Optional<Article> optionalArticle = articleRepository.findById(articleId);
        Optional<Category> optionalCategory = categoryRepository.findById(categoryId);

        if (!optionalArticle.isPresent()) {
            throw new ArticleNotFoundException("Article not found", articleId);
        }
        if (!optionalCategory.isPresent()) {
            throw new CategoryNotFoundException("Category not found", categoryId);
        }

        articleRepository
                .save(optionalArticle
                        .get()
                        .addCategory(optionalCategory.get()));

        return true;
    }

    public Boolean removeCategoryFromArticle(Long articleId, Long categoryId) {
        Optional<Article> optionalArticle = articleRepository.findById(articleId);
        Optional<Category> optionalCategory = categoryRepository.findById(categoryId);

        if (!optionalArticle.isPresent()) {
            throw new ArticleNotFoundException("Article not found", articleId);
        }
        if (!optionalCategory.isPresent()) {
            throw new CategoryNotFoundException("Category not found", categoryId);
        }

        articleRepository
                .save(optionalArticle
                        .get()
                        .removeCategory(optionalCategory.get()));

        return true;
    }
}
