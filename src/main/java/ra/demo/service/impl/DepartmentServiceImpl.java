package ra.demo.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ra.demo.model.entity.Department;
import ra.demo.repository.DepartmetRepository;
import ra.demo.service.DepartmentService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    @Override
    public Department getDepartmentById(String departmentId) {
        return departmetRepository.findByDepartId(departmentId).orElseThrow(()-> new NoSuchElementException("Không tồn tại phòng có id: "+departmentId));
    }

    private final DepartmetRepository departmetRepository;

    @Override
    public List<Department> getDepartments() {
        return departmetRepository.findAll();
    }

    @Override
    public Department insertDepartment(Department department) {
        return departmetRepository.save(department);
    }
}
