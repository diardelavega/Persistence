package mar.cod;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import mar.cod.entity.Employee;

public class RepFunctions {

	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
			.createEntityManagerFactory("IndiEzamp");

	public int write(Employee e) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et = null;
		int errCod = -1;

		try {
			et = em.getTransaction();
			et.begin();
			em.persist(e);
			et.commit();
			errCod = 1;
		} catch (Exception e1) {
			if (et != null)
				et.rollback();
			e1.printStackTrace();
		} finally {
			em.close();
		}
		return errCod;
	}

	public int writeList(List<Employee> emps) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et = null;
		int errCod = -1;

		try {
			et = em.getTransaction();
			et.begin();

			for (Employee e : emps)
				em.persist(e);
			et.commit();
			errCod = 1;
		} catch (Exception e1) {
			if (et != null)
				et.rollback();
			e1.printStackTrace();
		} finally {
			em.close();
		}
		return errCod;
	}

	public Employee find(int empId) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et = null;
		Employee e = null;
		try {
			et = em.getTransaction();
			et.begin();

			e = em.find(Employee.class, empId);

			et.commit();
		} catch (Exception e1) {
			if (et != null)
				et.rollback();
			e1.printStackTrace();
		} finally {
			em.close();
		}
		return e;
	}

	public List<Employee> findAll() {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et = null;
		List<Employee> el = new ArrayList<>();

		try {
			et = em.getTransaction();
			et.begin();

			el = em.createQuery("Select s From Employee s", Employee.class).getResultList();

			// et.commit();
		} catch (Exception e1) {
			if (et != null)
				et.rollback();
			e1.printStackTrace();
		} finally {
			em.close();
		}
		return el;
	}

	public int updateEmployee(int empId, String nFnam, String nLnam) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et = null;
		int retCode = -1;

		try {
			et = em.getTransaction();
			et.begin();

			Employee e = em.find(Employee.class, empId);
			if (nFnam != null)
				e.setFname(nFnam);
			if (nLnam != null)
				e.setLname(nLnam);
			em.persist(e);
			et.commit();
			retCode = 1;
		} catch (Exception e1) {
			if (et != null)
				et.rollback();
			e1.printStackTrace();
		} finally {
			em.close();
		}
		return retCode;
	}

	public int deleteEmployee(int empId) {
		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et = null;
		int retCode = -1;

		try {
			et = em.getTransaction();
			et.begin();

			Employee e = em.find(Employee.class, empId);
			em.remove(e);
			et.commit();
			retCode = 1;
		} catch (Exception e1) {
			if (et != null)
				et.rollback();
			e1.printStackTrace();
		} finally {
			em.close();
		}
		return retCode;
	}

}
