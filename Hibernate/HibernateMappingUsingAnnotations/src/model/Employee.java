package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EmployeeDataTable") // table name
public class Employee {

	// All annotations to be imported from javax persistence class.
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "empID")
	private int id;

	@Column(name = "empName")
	private String name;

	@Column(name = "empDepartment")
	private String dept;

	@Column(name = "empDesignation")
	private String desig;

	@Column(name = "empSalary")
	private int salary;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getDesig() {
		return desig;
	}

	public void setDesig(String desig) {
		this.desig = desig;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", salary=" + salary + ", name=" + name + ", dept=" + dept + ", desig=" + desig
				+ "]";
	}

	public Employee(String name, String dept, String desig, int salary) {
		super();
		this.name = name;
		this.dept = dept;
		this.desig = desig;
		this.salary = salary;
	}

}
