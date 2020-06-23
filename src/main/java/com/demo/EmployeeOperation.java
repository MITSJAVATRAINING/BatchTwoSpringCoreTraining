package com.demo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;

@Component
public class EmployeeOperation {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	NamedParameterJdbcTemplate namedJdbcTemplate;

	public void addEmployee() {
		String query = "insert into employee values(:employeeId, :firstName, :lastName, :deptId, :salary)";

		HashMap<String, String> params = new HashMap<String, String>();

		params.put("employeeId", "11");
		params.put("firstName", "Sheshan");
		params.put("lastName", "B");
		params.put("deptId", "1");
		params.put("salary", "1000");
		namedJdbcTemplate.update(query, params);
	}

	public void readCountOfEmployee() {
		String query = "select count(*) from employee";
		int rows = jdbcTemplate.queryForObject(query, Integer.class);
		System.out.println("No of rows in Employee " + rows);
	}

	public void readEmployee() {
		String query = "select * from employee";
		List<Employee> employeeList = jdbcTemplate.query(query, new EmployeeRowMapper());
		System.out.println("List of Employee's are ");
		for (Employee emp: employeeList) {
			printEmployee(emp);
		}
	}

	public void printEmployee(Employee emp) {
		System.out.println("Employee Id " + emp.getEmployeeId());
		System.out.println("First Name " + emp.getFirstName());
		System.out.println("Last Name " + emp.getLastName());
		System.out.println("Department Id " + emp.getDeptId());
		System.out.println("Salary " + emp.getSalary());
	}
	
	public void insertEmployees() {
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		
		Employee emp1 = new Employee();
		emp1.setEmployeeId(12);
		emp1.setFirstName("Dennis");
		emp1.setLastName("D");
		emp1.setDeptId(4);
		emp1.setSalary(100);
		
		employeeList.add(emp1);
		
		Employee emp2 = new Employee();
		emp2.setEmployeeId(13);
		emp2.setFirstName("Joanna");
		emp2.setLastName("J");
		emp2.setDeptId(5);
		emp2.setSalary(200);
		
		employeeList.add(emp2);
		
		SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(employeeList);
		
		String query = "insert into employee values(:employeeId, :firstName, :lastName, :deptId, :salary)";
		
		namedJdbcTemplate.batchUpdate(query, params);
		
	}

	public void modify() {
		System.out.println("In Modify method");
		//addEmployee();
		//readCountOfEmployee();
		insertEmployees();
		readEmployee();
	}
}

class EmployeeRowMapper implements RowMapper<Employee> {

	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee emp = new Employee();
		emp.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
		emp.setFirstName(rs.getString("FIRST_NAME"));
		emp.setLastName(rs.getString("LAST_NAME"));
		emp.setDeptId(rs.getInt("DEPT_ID"));
		emp.setSalary(rs.getInt("SALARY"));
		return emp;
	}

}
