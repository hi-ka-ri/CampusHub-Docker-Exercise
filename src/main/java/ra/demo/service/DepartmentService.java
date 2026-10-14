package ra.demo.service;

import ra.demo.model.entity.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    List<Department> getDepartments();
    Department insertDepartment(Department department);
    Department getDepartmentById(String departmentId);
}
