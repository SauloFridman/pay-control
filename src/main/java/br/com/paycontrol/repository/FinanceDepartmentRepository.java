package br.com.paycontrol.repository;

import br.com.paycontrol.model.FinanceDepartment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinanceDepartmentRepository extends JpaRepository<FinanceDepartment,Long> {

}
