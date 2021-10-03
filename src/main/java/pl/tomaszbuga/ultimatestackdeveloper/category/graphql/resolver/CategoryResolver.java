package pl.tomaszbuga.ultimatestackdeveloper.category.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;
import pl.tomaszbuga.ultimatestackdeveloper.category.Category;
import pl.tomaszbuga.ultimatestackdeveloper.category.CategoryRepository;
import pl.tomaszbuga.ultimatestackdeveloper.category.graphql.exception.CategoryNotFoundException;

import java.util.Optional;

@Component
public class CategoryResolver implements GraphQLQueryResolver {
    private final CategoryRepository categoryRepository;

    public CategoryResolver(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Iterable<Category> findAllCategories() {
        return categoryRepository.findAll();
    }

    public Category findCategoryById(Long id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);

        if (optionalCategory.isPresent()) {
            return optionalCategory.get();
        } else {
            throw new CategoryNotFoundException("Category not found", id);
        }
    }

    public float countCategories() {
        return categoryRepository.count();
    }
}
