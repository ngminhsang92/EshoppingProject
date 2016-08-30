package eshopping.dao.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import eshopping.dao.CustomerOrderDao;



@Repository
@Transactional
public class CustomerOrderDaoImpl implements CustomerOrderDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void addCustomerOrder(CustomerOrder customerOrder) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(customerOrder);
		session.flush();
	}

	public List<CustomerOrder> getAllOrders() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM CustomerOrder ORDER BY customerOrderId DESC ";
		Query query = session.createQuery(hql);
		query.setFirstResult(0);
		query.setMaxResults(5);

		List<CustomerOrder> listResult = query.list();
		System.out.println("CustomerOrder.. size is = " + listResult.size());
		if (listResult != null)
			for (CustomerOrder aRow : listResult) {
				System.out.println(aRow);
			}
		return listResult;// listResult;
	}

	public CustomerOrder loadById(int id) {
		Session session = sessionFactory.getCurrentSession();
		CustomerOrder customerOrder = (CustomerOrder)session.load(CustomerOrder.class, id);
		session.flush();
		return customerOrder;
	}

}