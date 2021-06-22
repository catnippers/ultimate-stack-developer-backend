package pl.tomaszbuga.ultimatestackdeveloper.category.graphql.mutator;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;
import pl.tomaszbuga.ultimatestackdeveloper.category.CategoryRepository;
import pl.tomaszbuga.ultimatestackdeveloper.category.Category;
import pl.tomaszbuga.ultimatestackdeveloper.category.graphql.exception.CategoryNotFoundException;

import java.util.Optional;

@Component
public class CategoryMutation implements GraphQLMutationResolver {
    private CategoryRepository categoryRepository;

    public CategoryMutation(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category newCategory(String title, String tag) {
        Category category = new Category(title, tag);
        categoryRepository.save(category);
        return category;
    }

    public boolean deleteCategory(Long id) {
        categoryRepository.deleteById(id);
        return true;
    }

    public Category updateCategoryTitleById(String newTitle, Long id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);

        if (optionalCategory.isPresent()) {
            Category category = optionalCategory.get();
            category.setTitle(newTitle);
            categoryRepository.save(category);
            return category;
        } else {
            throw new CategoryNotFoundException("Category not found", id);
        }
    }

    public Category updateCategoryTagById(String newTag, Long id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);

        if (optionalCategory.isPresent()) {
            Category category = optionalCategory.get();
            category.setTag(newTag);
            categoryRepository.save(category);
            return category;
        } else {
            throw new CategoryNotFoundException("Category not found", id);
        }
    }
}
