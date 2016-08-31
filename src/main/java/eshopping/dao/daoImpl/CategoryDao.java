package eshopping.dao.daoImpl;

import eshopping.dao.ICategoryDao;
import eshopping.domain.Category;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CategoryDao implements ICategoryDao {
    @Autowired
    private SessionFactory sessionFactory;

    public List<Category> getList() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Category");
        List<Category> categoryList = query.list();
        session.flush();
        return categoryList;
    }

    public Category getOneById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Category category = (Category) session.get(Category.class, id);
        session.flush();
        return category;
    }

    public void add(Category domain) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(domain);
        session.flush();
    }

    public void edit(Category domain) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(domain);
        session.flush();
    }

    public void delete(Category domain) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(domain);
        session.flush();
    }

    public void deleteAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from Category");
        query.executeUpdate();
        session.flush();
    }
}
