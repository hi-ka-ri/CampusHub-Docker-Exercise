package ra.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ra.demo.model.dto.response.ApiDataResponse;
import ra.demo.model.entity.Employee;
import ra.demo.service.EmployeeService;

@RestController
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @Value("${page_employee_size}")
    private Integer pageSize;

    @GetMapping
    public ResponseEntity<ApiDataResponse<Page<Employee>>> getEmployee(@RequestParam(name = "page", defaultValue = "1") Integer page) {
        return new ResponseEntity<>(new ApiDataResponse<>(
                true,
                "Lấy danh sách nhân viên trang " + page + " thành công",
                employeeService.getEmployees(page - 1, pageSize),
                HttpStatus.OK
        ), HttpStatus.OK);
    }

    @GetMapping("/employees-sorting")
    public ResponseEntity<ApiDataResponse<Page<Employee>>> getEmployeeSorting(@RequestParam(name = "page", defaultValue = "1") Integer page,
                                                                              @RequestParam(name = "sortBy", defaultValue = "empId") String sortBy,
                                                                              @RequestParam(name = "orderBy", defaultValue = "asc") String orderBy) {
        return new ResponseEntity<>(new ApiDataResponse<>(
                true,
                "Lấy danh sách nhân viên trang " + page + " thành công",
                employeeService.getEmployeesWithSorting(page - 1, pageSize, sortBy, orderBy),
                HttpStatus.OK
        ), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApiDataResponse<Employee>> insertEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(new ApiDataResponse<>(
                true,
                "Thêm mới nhân viên thành công",
                employeeService.insertEmployee(employee),
                HttpStatus.CREATED
        ), HttpStatus.CREATED);
    }
}
