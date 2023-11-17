package tn.spring.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.spring.springboot.entity.Classe;
@Repository
public interface ClasseRepository extends JpaRepository<Classe, Long> {
}
