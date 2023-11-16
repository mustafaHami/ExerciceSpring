package tn.spring.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.spring.springboot.entity.Classe;

public interface ClasseRepository extends JpaRepository<Classe, Long> {
}
