package ca.gc.aafc.employee.api.employee;

import java.util.List;

import org.springframework.data.domain.Page;

public record EmployeeResponse(Long id, String name, Long salary, String departmentName) {
	
//	public static EmployeeResponse from(Employee employee) {
//		return new EmployeeResponse(
//			employee.getId(),
//			employee.getName(),
//			employee.getSalary(),
//			employee.getDepartment().getName()
//		);
//	}
//	
//	public static List<EmployeeResponse> from(List<Employee> employees) {
//		return employees.stream().map(EmployeeResponse::from).toList();
//	}
//	
//	public static Page<EmployeeResponse> from(Page<Employee> employees) {
//		return employees.map(EmployeeResponse::from);
//	}
}
