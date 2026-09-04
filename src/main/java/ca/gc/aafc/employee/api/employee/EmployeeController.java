package ca.gc.aafc.employee.api.employee;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import com.example.employee.api.common.dto.CountResponse;
//import com.example.employee.api.exception.InvalidRequestException;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@GetMapping
	public ResponseEntity<List<EmployeeResponse>> getEmployees() {
		List<EmployeeResponse> employees = List.of(new EmployeeResponse(1L, "Lei Liu", 80000L, "IT"));
		
		return ResponseEntity.ok(employees);
	}
	
//	private static final Set<String> ALLOWED_SORT_FIELDS = Set.of(
//	        "name",
//	        "salary",
//	        "department.name"
//	);
//
//	private final EmployeeService employeeService;
//
//	public EmployeeController(EmployeeService employeeService) {
//		this.employeeService = employeeService;
//	}
//
//	@GetMapping(params = "filter")
//	public ResponseEntity<List<EmployeeResponse>> getEmployeesAboveDepartmentAverage(@RequestParam String filter) {
//		if (!Objects.equals(filter, "aboveDepartmentAverage")) {
//			throw new InvalidRequestException("Missing request parameter: filter=aboveDepartmentAverage");
//		}
//		
//    	List<EmployeeResponse> employees = employeeService.getEmployeesAboveDepartmentAverage();
//    	return ResponseEntity.ok(employees);
//	}
//	
//    @GetMapping("/{id}")
//    public ResponseEntity<EmployeeResponse> getEmployeeById(@PathVariable Long id) {
//    	EmployeeResponse employee = employeeService.getEmployeeById(id);
//        return ResponseEntity.ok(employee);
//    }
//    
//    @GetMapping(path = "/{id}", params = "include")
//    public ResponseEntity<EmployeeResponse> getEmployeeByIdWithDepartment(
//    		@PathVariable Long id, @RequestParam String include) {
//    	if (!Objects.equals(include, "department")) {
//			throw new InvalidRequestException("Missing request parameter: include=department");
//    	}
//    	
//    	EmployeeResponse employee = employeeService.getEmployeeByIdWithDepartment(id);
//        return ResponseEntity.ok(employee);
//    }
//
//    @GetMapping(params = "departmentId")
//    public ResponseEntity<Page<EmployeeResponse>> getEmployeesByDepartmentId(
//	    	@RequestParam Long departmentId,
//	        @PageableDefault Pageable pageable) {
//    	for (Sort.Order order : pageable.getSort()) {
//    	    if (!ALLOWED_SORT_FIELDS.contains(order.getProperty())) {
//    	        throw new InvalidRequestException("Invalid sort field: " + order.getProperty());
//    	    }
//    	}
//    	
//    	Page<EmployeeResponse> employees = employeeService.getEmployeesByDepartmentId(departmentId, pageable);
//    	return ResponseEntity.ok(employees);
//    }
//    
////    @GetMapping
////    public ResponseEntity<List<EmployeeResponse>> search(EmployeeSearchCriteria criteria) {
////    	List<EmployeeResponse> employees = employeeService.search(criteria);
////    	return ResponseEntity.ok(employees);
////    }
//    
//    @GetMapping
//    public ResponseEntity<Page<EmployeeResponse>> getEmployees(@PageableDefault Pageable pageable) {
//    	for (Sort.Order order : pageable.getSort()) {
//    	    if (!ALLOWED_SORT_FIELDS.contains(order.getProperty())) {
//    	        throw new InvalidRequestException("Invalid sort field: " + order.getProperty());
//    	    }
//    	}
//    	
//    	Page<EmployeeResponse> employees = employeeService.getEmployees(pageable);
//    	return ResponseEntity.ok(employees);
//    }
//    
//    @GetMapping("/count")
//    public CountResponse getEmployeeCount() {
//    	return new CountResponse(employeeService.count());
//    }
//    
//    @PostMapping
//    public ResponseEntity<EmployeeResponse> createEmployee(@Valid @RequestBody EmployeeCreateRequest request) {
//    	EmployeeResponse createdEmployee = employeeService.createEmployee(request);
//        return ResponseEntity.status(HttpStatus.CREATED).body(createdEmployee);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<EmployeeResponse> updateEmployee(
//    		@PathVariable Long id, 
//    		@Valid @RequestBody EmployeeUpdateRequest request) {
//    	EmployeeResponse employee = employeeService.updateEmployee(id, request);
//    	return ResponseEntity.ok(employee);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
//    	employeeService.deleteEmployee(id);
//
//        return ResponseEntity.noContent().build();
//    }
}
