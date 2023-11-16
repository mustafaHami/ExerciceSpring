package tn.spring.springboot.service;

import tn.spring.springboot.entity.Classe;
import tn.spring.springboot.entity.Etudiant;
import tn.spring.springboot.entity.Professeur;

import java.util.List;

public interface ClasseService {
    Classe saveClasse(Classe classe);

    List<Classe> fetchAllClasse();

    Classe getClasseById(Long id);

    Classe updateClasseById(Long id, Classe newClasse);

    String deleteClasseById(Long id);

    List<Etudiant> getClasseEtudiants(Long id);
    Professeur getClasseProf(Long id);
}
