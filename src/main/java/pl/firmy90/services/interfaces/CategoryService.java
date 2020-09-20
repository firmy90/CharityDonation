package pl.firmy90.services.interfaces;

import pl.firmy90.model.domain.entity.Category;

import java.util.List;

public interface CategoryService {
    Long countCategories();

    List<Category> showCategories();
}
