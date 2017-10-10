package mar.cod.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table (name="employee")
public class Employee implements Serializable {

	@Id
	int empId;
	String fname;
	String lname;
	int depCode;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int empId, String fname, String lname, int depCode) {
		super();
		this.empId = empId;
		this.fname = fname;
		this.lname = lname;
		this.depCode = depCode;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public int getDepCode() {
		return depCode;
	}

	public void setDepCode(int depCode) {
		this.depCode = depCode;
	}

}
