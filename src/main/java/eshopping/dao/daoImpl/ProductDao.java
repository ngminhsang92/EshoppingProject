package eshopping.dao.daoImpl;

import eshopping.dao.IProductDao;
import eshopping.domain.Product;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ProductDao implements IProductDao {
    @Autowired
    private SessionFactory sessionFactory;

    public List<Product> getList() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Product");
        List<Product> productList = query.list();
        session.flush();
        return productList;
    }

    public Product getOneById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Product product = (Product) session.get(Product.class, id);
        //HibernateStatisticUtil.printStatistics(sessionFactory);
        session.flush();
        return product;
    }

    public void add(Product domain) {
        Session session = sessionFactory.getCurrentSession();
        //domain.getCategory().addProduct(domain);
        session.saveOrUpdate(domain);
        session.flush();
    }

    public void edit(Product domain) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(domain);
        session.flush();
    }

    public void delete(Product domain) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(domain);
        session.flush();
    }

    public List<Product> getRecentProducts() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Product p order by p.productId DESC");
        query.setMaxResults(3);
        List<Product> productList = query.list();
        session.flush();

        return productList;
    }

    public List<Product> getProductByCategoryId(Integer categoryId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Product p where p.category.categoryId = :category_id");
        query.setParameter("category_id",categoryId);
        List<Product> productList = query.list();
        session.flush();
        return productList;
    }

    public void deleteAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from Product");
        query.executeUpdate();
        session.flush();
    }
}
