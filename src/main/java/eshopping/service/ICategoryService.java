package eshopping.service;

import eshopping.domain.Category;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ICategoryService {
    List<Category> getCategoryList();

    Category getCategoryById (Integer id);

    void addCategory(Category category);

    void editCategory(Category category);

    void deleteCategory(Category category);

    void deleteAllCategory();

}
