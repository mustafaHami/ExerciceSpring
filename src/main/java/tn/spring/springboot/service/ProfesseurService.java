package tn.spring.springboot.service;

import tn.spring.springboot.entity.Etudiant;
import tn.spring.springboot.entity.Professeur;

import java.util.List;

public interface ProfesseurService {
    Professeur saveProfesseur(Professeur professeur);

    List<Professeur> fetchAllProfesseur();

    Professeur getProfesseurById(Long id);

    Professeur updateProfesseurById(Long id, Professeur newProfesseur);
    String deleteProfesseurById(Long id);
}
