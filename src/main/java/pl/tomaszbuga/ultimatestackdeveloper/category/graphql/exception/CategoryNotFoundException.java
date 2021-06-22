package pl.tomaszbuga.ultimatestackdeveloper.category.graphql.exception;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoryNotFoundException extends RuntimeException implements GraphQLError {
    private Map<String, Object> extensions = new HashMap<>();

    public CategoryNotFoundException(String message, long invalidCategoryId) {
        super(message);
        extensions.put("invalidCategoryId", invalidCategoryId);
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public ErrorType getErrorType() {
        return null;
    }
}
