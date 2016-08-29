package eshopping.serviceImpl;

import eshopping.dao.ICategoryDao;
import eshopping.domain.Category;
import eshopping.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements ICategoryService{

    @Autowired
    private ICategoryDao categoryDao;

    public List<Category> getCategoryList() {
        return categoryDao.getList();
    }

    public Category getCategoryById(Integer id) {
        return categoryDao.getOneById(id);
    }

    public void addCategory(Category category) {
        categoryDao.add(category);
    }

    public void editCategory(Category category) {
        categoryDao.edit(category);
    }

    public void deleteCategory(Category category) {
        categoryDao.delete(category);
    }

}
