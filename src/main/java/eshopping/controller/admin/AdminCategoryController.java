package eshopping.controller.admin;

import eshopping.domain.Category;
import eshopping.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminCategoryController {
    @Autowired
    private ICategoryService categoryService;

    private Path path;

    @RequestMapping("/category/addCategory")
    public String addCategory(Model model) {
        Category category = new Category();
        model.addAttribute("category", category);
        return "adminaddCategory";
    }

    @RequestMapping("/categoryList/all")
    public String getCategories(Model model) {
        List<Category> categories = categoryService.getCategoryList();
        model.addAttribute("categories", categories);

        return "admincategoryList";
    }

    @RequestMapping(value = "/category/addCategory", method = RequestMethod.POST)
    public String addCategoryPost(@Valid Category category, BindingResult result,
                                 HttpServletRequest request) {
        if (result.hasErrors()) {
            return "adminaddCategory";
        }

        MultipartFile coverImage = category.getCoverImage();

        if (coverImage != null && !coverImage.isEmpty()) {
            String rootDirectory = request.getSession().getServletContext().getRealPath("/");

            try {
                category.setImagebytes(new javax.sql.rowset.serial.SerialBlob(coverImage.getBytes()));
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            categoryService.addCategory(category);
            path = Paths.get(rootDirectory + "/WEB-INF/resources/images/category_" + category.getCategoryId() + ".png");

            try {
                File img = new File(path.toString());
                coverImage.transferTo(img);
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new RuntimeException("Category image saving failed", ex);
            }
        }

        return "redirect:/admin/categoryList/all";
    }

    @RequestMapping("/category/editCategory/{id}")
    public String editCategory(@PathVariable("id") int id, Model model){
        Category category = categoryService.getCategoryById(id);
        model.addAttribute("category", category);
        return "admineditCategory";
    }

    @RequestMapping(value = "/category/editCategory", method = RequestMethod.POST)
    public String editCategoryPost(@Valid @ModelAttribute("category") Category category, BindingResult result,
                                  HttpServletRequest request) {

        if (result.hasErrors()) {
            return "editCategory";
        }

        MultipartFile coverImage = category.getCoverImage();

        if (coverImage != null && !coverImage.isEmpty()) {
            String rootDirectory = request.getSession().getServletContext().getRealPath("/");

            try {
                category.setImagebytes(new javax.sql.rowset.serial.SerialBlob(coverImage.getBytes()));
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            path = Paths.get(rootDirectory + "/WEB-INF/resources/images/category" + category.getCategoryId() + ".png");

            try {
                File img = new File(path.toString());
                coverImage.transferTo(img);
            } catch (Exception ex) {
                ex.printStackTrace();
                throw new RuntimeException("Category image saving failed", ex);
            }
        }

        categoryService.editCategory(category);

        return "redirect:/admin/CategoryList/all";
    }

    @RequestMapping("/category/deleteCategory/{id}")
    public String deleteCategory(@PathVariable int id, Model model, HttpServletRequest request) {
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "/WEB-INF/resources/images/category" + id + ".png");

        if (Files.exists(path)) {
            try {
                Files.delete(path);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        Category category = categoryService.getCategoryById(id);
        categoryService.deleteCategory(category);

        return "redirect:/admin/categoryList/all";
    }
}
