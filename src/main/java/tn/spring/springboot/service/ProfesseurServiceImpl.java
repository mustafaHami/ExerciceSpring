package tn.spring.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.spring.springboot.entity.Etudiant;
import tn.spring.springboot.entity.Professeur;
import tn.spring.springboot.repository.EtudiantRepository;
import tn.spring.springboot.repository.ProfesseursRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProfesseurServiceImpl implements ProfesseurService {

    @Autowired
    private ProfesseursRepository professeursRepository;
    @Override
    public Professeur saveProfesseur(Professeur professeur) {
        return professeursRepository.save(professeur);
    }

    @Override
    public List<Professeur> fetchAllProfesseur() {
        return professeursRepository.findAll();
    }

    @Override
    public Professeur getProfesseurById(Long id) {
        Optional<Professeur> prof = professeursRepository.findById(id);
        return prof.orElse(null);
    }

    @Override
    public Professeur updateProfesseurById(Long id, Professeur newProfesseur) {
        Optional<Professeur> prof = professeursRepository.findById(id);

        if (prof.isPresent()) {
            Professeur originalProfesseur = prof.get();

            if (Objects.nonNull(newProfesseur.getPersonne().getNom()) && !"".equalsIgnoreCase(newProfesseur.getPersonne().getNom())) {
                originalProfesseur.getPersonne().setNom(newProfesseur.getPersonne().getNom());
            }
            if (Objects.nonNull(newProfesseur.getPersonne().getPrenom()) && !"".equalsIgnoreCase(newProfesseur.getPersonne().getPrenom())) {
                originalProfesseur.getPersonne().setPrenom(newProfesseur.getPersonne().getPrenom());
            }
            if (Objects.nonNull(newProfesseur.getPersonne().getDateNaissance()) && !"".equalsIgnoreCase(newProfesseur.getPersonne().getDateNaissance())) {
                originalProfesseur.getPersonne().setDateNaissance(newProfesseur.getPersonne().getDateNaissance());
            }
            if (Objects.nonNull(newProfesseur.getMatiere()) && !"".equalsIgnoreCase(newProfesseur.getMatiere())) {
                originalProfesseur.setMatiere(newProfesseur.getMatiere());
            }
            return professeursRepository.save(originalProfesseur);
        }
        return null;
    }

    @Override
    public String deleteProfesseurById(Long id) {
        if(professeursRepository.findById(id).isPresent()) {
            professeursRepository.deleteById(id);
            return "Professeur deleted successfully";
        }
        return "No such employee in the database";
    }
}
