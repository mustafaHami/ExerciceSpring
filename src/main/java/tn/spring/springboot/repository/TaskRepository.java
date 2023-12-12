package tn.spring.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.spring.springboot.entity.Tasks;

public interface TaskRepository extends JpaRepository<Tasks, Long> {
}

