package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

// Annotations from 'javax' persistence
@Entity
@Table(name = "EmployeeDataTable") // table name
public class Employee {

	@Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "emp_gen")
    @TableGenerator(name = "emp_gen", table = "id_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", initialValue = 100, allocationSize = 1)
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column
	private int id;

	@Column(name = "empName")
	private String name;

	@Column(name = "empDepartment")
	private String dept;

	@Column(name = "empDesignation")
	private String desig;

	@Column(name = "empSalary")
	private int salary;

	public Employee() {
		super();
	}

	public Employee(String name, String dept, String desig, int salary) {
		super();
		this.name = name;
		this.dept = dept;
		this.desig = desig;
		this.salary = salary;
	}

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

	@Override
	public String toString() {
		return "Employee [id=" + id + ", salary=" + salary + ", name=" + name + ", dept=" + dept + ", desig=" + desig
				+ "]";
	}

}
