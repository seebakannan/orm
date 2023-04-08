package ormap;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import orbean.StudentBean;

public class StudentDao {
	private SessionFactory sesionFactory = null;

	public void initSession()
	{
		try {
			Configuration config = new Configuration()
					.setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect")
					.setProperty(Environment.DRIVER, "com.mysql.cj.jdbc.Driver")
					.setProperty(Environment.URL, "jdbc:mysql://localhost:3306/ormap")
					.setProperty(Environment.USER, "root")
					.setProperty(Environment.PASS, "novalnet")
					.setProperty(Environment.SHOW_SQL, "true")
					.setProperty(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread")
					.setProperty(Environment.HBM2DDL_AUTO, "update")
					.addAnnotatedClass(StudentBean.class);
			//					.addPackage("orbean");
			//.addAnnotatedClass(getClass());


			ServiceRegistry service = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
			this.sesionFactory = config.buildSessionFactory(service);
		} catch (HibernateException e) {
			e.printStackTrace();
			System.out.println(e.getLocalizedMessage());
		}
	}

	public void addRecord(StudentBean student)
	{
		Transaction transaction = null;
		Session session = null;
		try {
			if (this.sesionFactory == null) {
				this.initSession();
			}

			session = this.sesionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(student);
			transaction.commit();
			System.out.println("data added");
		} catch (HibernateException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			System.out.println(e.getLocalizedMessage());
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void deleteRecord(Integer id)
	{
		Transaction transaction = null;
		Session session = null;
		try {
			if (this.sesionFactory == null) {
				this.initSession();
			}

			session = this.sesionFactory.openSession();
			transaction = session.beginTransaction();
			StudentBean student = session.get(StudentBean.class, id);
			session.delete(student);
			transaction.commit();
			System.out.println("data deleted");
		} catch (HibernateException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			System.out.println(e.getLocalizedMessage());
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void updateRecord(StudentBean student)
	{
		Transaction transaction = null;
		Session session = null;
		try {
			if (this.sesionFactory == null) {
				this.initSession();
			}

			session = this.sesionFactory.openSession();
			transaction = session.beginTransaction();
			session.update(student);
			transaction.commit();
			System.out.println("data updated");
		} catch (HibernateException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			System.out.println(e.getLocalizedMessage());
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void getRecord()
	{

	}

	public List< StudentBean > getCollections()
	{
		List < StudentBean > collection = null;

		Transaction transaction = null;
		Session session = null;
		try {
			if (this.sesionFactory == null) {
				this.initSession();
			}

			session = this.sesionFactory.openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("FROM StudentBean");
			//query.setParameter("student_id", 110);

			//query.setFirstResult(110);

			query.setMaxResults(1);

			collection = query.getResultList();
			transaction.commit();
			System.out.println("data updated");
		} catch (HibernateException e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			System.out.println(e.getLocalizedMessage());
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return collection;
	}
}
