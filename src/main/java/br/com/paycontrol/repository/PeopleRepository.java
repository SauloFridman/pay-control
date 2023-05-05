package br.com.paycontrol.repository;

import br.com.paycontrol.model.People;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeopleRepository extends JpaRepository<People,Long> {
}
