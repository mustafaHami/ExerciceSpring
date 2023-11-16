package tn.spring.springboot.service;

import tn.spring.springboot.entity.Etudiant;
import tn.spring.springboot.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EtudiantServiceImpl implements EtudiantService {

    @Autowired
    private EtudiantRepository etudiantRepository;

    @Override
    public Etudiant saveEtudiant(Etudiant etudiant){
        return etudiantRepository.save(etudiant);
    }
    @Override
    public List<Etudiant> fetchAllEtudiant(){
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant getEtudiantById(Long id) {
        Optional<Etudiant> employee = etudiantRepository.findById(id);
        return employee.orElse(null);
    }

    @Override
    public Etudiant updateEtudiantById(Long id, Etudiant newEtudiant) {
        Optional<Etudiant> etudiant = etudiantRepository.findById(id);

        if (etudiant.isPresent()) {
            Etudiant originalEtudiant = etudiant.get();

            if (Objects.nonNull(newEtudiant.getPersonne().getNom()) && !"".equalsIgnoreCase(newEtudiant.getPersonne().getNom())) {
                originalEtudiant.getPersonne().setNom(newEtudiant.getPersonne().getNom());
            }
            if (Objects.nonNull(newEtudiant.getPersonne().getPrenom()) && !"".equalsIgnoreCase(newEtudiant.getPersonne().getPrenom())) {
                originalEtudiant.getPersonne().setPrenom(newEtudiant.getPersonne().getPrenom());
            }
            if (Objects.nonNull(newEtudiant.getPersonne().getDateNaissance()) && !"".equalsIgnoreCase(newEtudiant.getPersonne().getDateNaissance())) {
                originalEtudiant.getPersonne().setDateNaissance(newEtudiant.getPersonne().getDateNaissance());
            }
            if (newEtudiant.getMoyenne() != 0) {
                originalEtudiant.setMoyenne(newEtudiant.getMoyenne());
            }
            return etudiantRepository.save(originalEtudiant);
        }
        return null;
    }

    @Override
    public String deleteEtudiantById(Long id) {
        if (etudiantRepository.findById(id).isPresent()) {
            etudiantRepository.deleteById(id);
            return "Etudiant deleted successfully";
        }
        return "No such employee in the database";
    }

}
