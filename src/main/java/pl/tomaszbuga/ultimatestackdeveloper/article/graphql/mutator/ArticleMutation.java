package pl.tomaszbuga.ultimatestackdeveloper.article.graphql.mutator;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.tomaszbuga.ultimatestackdeveloper.article.Article;
import pl.tomaszbuga.ultimatestackdeveloper.article.ArticleRepository;
import pl.tomaszbuga.ultimatestackdeveloper.article.graphql.exception.ArticleNotFoundException;
import pl.tomaszbuga.ultimatestackdeveloper.category.Category;
import pl.tomaszbuga.ultimatestackdeveloper.category.CategoryRepository;
import pl.tomaszbuga.ultimatestackdeveloper.category.graphql.exception.CategoryNotFoundException;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ArticleMutation implements GraphQLMutationResolver {
    private final ArticleRepository articleRepository;
    private final CategoryRepository categoryRepository;

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

    public Article assignCategoryToArticle(Long articleId, Long categoryId) {
        Article article = articleRepository
                .findById(articleId)
                .orElseThrow(() -> new ArticleNotFoundException("Article not found", articleId));

        Category category = categoryRepository
                .findById(categoryId)
                .orElseThrow(() -> new CategoryNotFoundException("Category not found", categoryId));
      
        return articleRepository.save(article.addCategory(category));
    }

    public Article removeCategoryFromArticle(Long articleId, Long categoryId) {
        Article article = articleRepository
                .findById(articleId)
                .orElseThrow(() -> new ArticleNotFoundException("Article not found", articleId));

        Category category = categoryRepository
                .findById(categoryId)
                .orElseThrow(() -> new CategoryNotFoundException("Category not found", categoryId));

        return articleRepository.save(article.removeCategory(category));
    }
}
