package pl.firmy90.services.implementation;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.firmy90.model.domain.entity.Category;
import pl.firmy90.model.repositories.CategoryRepository;
import pl.firmy90.services.interfaces.CategoryService;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class DefaultCategoryService implements CategoryService {
    private final CategoryRepository categoryRepository;


    @Override
    public Long countCategories() {
        return categoryRepository.count();
    }

    @Override
    public List<Category> showCategories() {
        return categoryRepository.findAll();
    }


}
