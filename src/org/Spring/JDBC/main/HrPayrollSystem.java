package org.Spring.JDBC.main;

import org.Spring.JDBC.dao.EmployeeDao;
import org.Spring.JDBC.model.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HrPayrollSystem {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"Spring.xml");
		EmployeeDao employeeDao = context.getBean("employeeDaoImp",
				EmployeeDao.class);

		// create employee table
		employeeDao.createEmployee();

		System.out.println(employeeDao.getEmployeeCount());

		Employee emp = new Employee(1, "James", 28);
		employeeDao.insertEmployee(emp);

		Employee employee = employeeDao.getEmployeeById(1);
		System.out.println(employee.getEmpId() + " - " + employee.getName());

		System.out.println(employeeDao.deleteEmployeeById(1));

	}

}
