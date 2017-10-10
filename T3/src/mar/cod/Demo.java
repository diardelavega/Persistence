package mar.cod;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import mar.cod.entity.Employee;

public class Demo {

	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
			.createEntityManagerFactory("IndiEzamp");

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
		EntityTransaction et = null;
		try {
			et = em.getTransaction();
			et.begin();
			Employee emp = new Employee(1, "Mario", "Rista", 3);
			em.persist(emp);
			et.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (et != null)
				et.rollback();
		} finally {
			em.close();
		}

	}

}
