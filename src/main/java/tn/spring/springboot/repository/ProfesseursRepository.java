package tn.spring.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.spring.springboot.entity.Professeur;
@Repository
public interface ProfesseursRepository extends JpaRepository<Professeur, Long> {
}
