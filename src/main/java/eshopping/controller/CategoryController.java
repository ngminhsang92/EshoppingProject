package eshopping.controller;

import eshopping.domain.Category;
import eshopping.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import java.util.List;

@ControllerAdvice
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;
    @ModelAttribute("categories")
    public List<Category> getCategoryList(){
        return categoryService.getCategoryList();
    }
}
