package tn.spring.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.spring.springboot.entity.Classe;
import tn.spring.springboot.entity.Etudiant;
import tn.spring.springboot.entity.Professeur;
import tn.spring.springboot.repository.ClasseRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ClasseServiceImpl implements ClasseService{

    @Autowired
    private ClasseRepository classeRepository;

    @Override
    public Classe saveClasse(Classe classe) {
        return classeRepository.save(classe);
    }

    @Override
    public List<Classe> fetchAllClasse() {
        return  classeRepository.findAll();
    }

    @Override
    public Classe getClasseById(Long id) {
        Optional<Classe> classe = classeRepository.findById(id);
        return classe.orElse(null);
    }

    @Override
    public Classe updateClasseById(Long id, Classe newClasse) {
        Optional<Classe> classe = classeRepository.findById(id);
        if(classe.isPresent()) {
            Classe originalClasse = classe.get();
            if (Objects.nonNull(newClasse.getNom()) && !"".equalsIgnoreCase(newClasse.getNom())) {
                originalClasse.setNom(newClasse.getNom());
            }
            if(Objects.nonNull(newClasse.getEtudiants())) {
                originalClasse.setEtudiants(newClasse.getEtudiants());
            }
            if(Objects.nonNull(newClasse.getProfesseur())) {
                originalClasse.setProfesseur(newClasse.getProfesseur());
            }
            return classeRepository.save(originalClasse);
        }
        return null;
    }

    @Override
    public String deleteClasseById(Long id) {
        if (classeRepository.findById(id).isPresent()) {
            classeRepository.deleteById(id);
            return "Classe deleted successfully";
        }
        return "No such employee in the database";
    }

    @Override
    public List<Etudiant> getClasseEtudiants(Long id) {
        Optional<Classe> classe = classeRepository.findById(id);
        return classe.map(Classe::getEtudiants).orElse(null);
    }

    @Override
    public Professeur getClasseProf(Long id) {
        Optional<Classe> classe = classeRepository.findById(id);
        return classe.map(Classe::getProfesseur).orElse(null);
    }
}
