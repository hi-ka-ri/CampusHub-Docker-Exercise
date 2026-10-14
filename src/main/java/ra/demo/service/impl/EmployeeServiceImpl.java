package ra.demo.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ra.demo.model.entity.Employee;
import ra.demo.repository.EmployeeRepository;
import ra.demo.service.EmployeeService;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Override
    public Page<Employee> getEmployees(Integer page, Integer pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return employeeRepository.findAll(pageable);
    }

    @Override
    public Page<Employee> getEmployeesWithSorting(Integer page, Integer pageSize, String sortBy, String orderBy) {
        Sort sort = null;
        switch (sortBy){
            case "empId":
                sort = Sort.by("empId");
                break;
            case "fullName":
                sort = Sort.by("fullName");
                break;
            case "gender":
                sort = Sort.by("gender");
                break;
            case "birthday":
                sort = Sort.by("birthday");
                break;
            case "address":
                sort = Sort.by("address");
                break;
        }

        switch (orderBy){
            case "asc":
                sort = sort.ascending();
                break;
            case "desc":
                sort = sort.descending();
                break;
        }

        Pageable pageable = PageRequest.of(page, pageSize, sort);
        return employeeRepository.findAll(pageable);
    }

    @Override
    public Employee insertEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
}
