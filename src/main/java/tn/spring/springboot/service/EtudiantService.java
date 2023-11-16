package tn.spring.springboot.service;

import tn.spring.springboot.entity.Etudiant;

import java.util.List;

public interface EtudiantService {
    Etudiant saveEtudiant(Etudiant etudiant);

    List<Etudiant> fetchAllEtudiant();

    Etudiant getEtudiantById(Long id);

    Etudiant updateEtudiantById(Long id, Etudiant newEtudiant);

    String deleteEtudiantById(Long id);
}
