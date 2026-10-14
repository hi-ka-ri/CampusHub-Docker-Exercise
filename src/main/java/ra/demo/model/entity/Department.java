package ra.demo.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "departments")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Department {
    @Id
    @Column(name = "department_id", nullable = false, unique = true)
    private String departId;
    @Column(name = "department_name", length = 100, nullable = false, unique = true)
    private String departName;
    private Boolean status;

    @OneToMany(mappedBy = "department")
    @JsonIgnore
    private List<Employee> employees;
}
