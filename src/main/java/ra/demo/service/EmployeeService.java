package ra.demo.service;

import org.springframework.data.domain.Page;
import ra.demo.model.entity.Employee;

public interface EmployeeService {
    //Hàm lấy dữ liệu có phân trang
    Page<Employee> getEmployees(Integer page, Integer pageSize);

    //Hàm vừa phân trang vừa sắp xếp
    Page<Employee> getEmployeesWithSorting(Integer page, Integer pageSize, String sortBy, String orderBy);

    Employee insertEmployee(Employee employee);
}
