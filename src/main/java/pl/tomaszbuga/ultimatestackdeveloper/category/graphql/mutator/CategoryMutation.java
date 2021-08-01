package pl.tomaszbuga.ultimatestackdeveloper.category.graphql.mutator;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;
import pl.tomaszbuga.ultimatestackdeveloper.category.Category;
import pl.tomaszbuga.ultimatestackdeveloper.category.CategoryRepository;
import pl.tomaszbuga.ultimatestackdeveloper.category.graphql.exception.CategoryNotFoundException;

@Component
public class CategoryMutation implements GraphQLMutationResolver {
    private CategoryRepository categoryRepository;

    public CategoryMutation(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category newCategory(String title, String tag) {
        return categoryRepository.save(new Category(title, tag));
    }

    public boolean deleteCategory(Long id) {
        categoryRepository.deleteById(id);
        return true;
    }

    public Category updateCategoryTitleById(String newTitle, Long id) {
        Category category = categoryRepository
                .findById(id)
                .orElseThrow(() -> new CategoryNotFoundException("Category not found", id));

        category.setTitle(newTitle);
        return categoryRepository.save(category);
    }

    public Category updateCategoryTagById(String newTag, Long id) {
        Category category = categoryRepository
                .findById(id)
                .orElseThrow(() -> new CategoryNotFoundException("Category not found", id));

        category.setTag(newTag);
        return categoryRepository.save(category);
    }
}
