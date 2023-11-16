package tn.spring.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.spring.springboot.entity.Classe;
import tn.spring.springboot.entity.Etudiant;
import tn.spring.springboot.entity.Professeur;
import tn.spring.springboot.service.ClasseService;

import java.util.List;

@RestController
public class ClasseController {
    @Autowired
    private ClasseService classeService;

    @PostMapping("/classe")
    public Classe saveClasse(@RequestBody Classe classe) {
        return classeService.saveClasse(classe);
    }

    @GetMapping("/classe")
    public List<Classe> getAllClasses() {
        return classeService.fetchAllClasse();
    }

    @GetMapping("/classe/{id}")
    public Classe getClasseById(@PathVariable("id") Long id) {
        return classeService.getClasseById(id);
    }

    @PutMapping("/classe/{id}")
    public Classe updateClasse(@PathVariable("id") Long id, Classe classe) {
        return classeService.updateClasseById(id, classe);
    }

    @DeleteMapping("/classe/{id}")
    public String deleteClasse(@PathVariable("id") Long id) {
        return classeService.deleteClasseById(id);
    }

    @GetMapping("/classe/etudiants")
    public List<Etudiant> getAllEtudiantInClasse(@PathVariable("id") Long id) {
        return classeService.getClasseEtudiants(id);
    }
    @GetMapping("/classe/prof")
    public Professeur getProfInClasse(@PathVariable("id") Long id) {
        return classeService.getClasseProf(id);
    }
}
