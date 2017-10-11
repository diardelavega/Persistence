package mar.cod;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

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
			
			 List<Employee> emps = em.createQuery("Select s from Employee s Where empid >3",Employee.class).getResultList();
			
			
//			Employee emp = new Employee(4, "Mario", "Rista", 14);
//			Employee emp2 = new Employee(2, "Mario", "Rista", 13);
//			Employee emp3 = new Employee(3, "Mario", "Rista", 23);
//			List<Employee> empList =new ArrayList<Employee>();
//			empList.add(emp);
//			empList.add(emp2);
//			empList.add(emp3);
//
			for(int i=0;i<emps.size();i++)
				System.out.println(emps.get(i).toString());
				
//				em.persist(empList.get(i));
//			
//			et.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (et != null)
				et.rollback();
		} finally {
			em.close();
		}

	}

}
