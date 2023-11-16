package tn.spring.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.spring.springboot.entity.Professeur;

public interface ProfesseursRepository extends JpaRepository<Professeur, Long> {
}
