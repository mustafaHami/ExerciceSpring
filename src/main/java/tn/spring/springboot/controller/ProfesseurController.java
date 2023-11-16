package tn.spring.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.spring.springboot.entity.Etudiant;

import tn.spring.springboot.entity.Professeur;
import tn.spring.springboot.service.ProfesseurService;

import java.util.List;

@RestController
public class ProfesseurController {
    @Autowired
    private ProfesseurService professeurService;

    @PostMapping("/prof")
    public Professeur saveProf(@RequestBody Professeur prof) {
        return professeurService.saveProfesseur(prof);
    }

    @GetMapping("/prof")
    public List<Professeur> getAllProfesseurs() {
        return professeurService.fetchAllProfesseur();
    }

    @GetMapping("/prof/{id}")
    public Professeur getProfesseurById(@PathVariable("id") Long id) {
        return professeurService.getProfesseurById(id);
    }

    @PutMapping("/prof/{id}")
    public Professeur updateProfesseur(@PathVariable("id") Long id, Professeur newProfesseur) {
        return professeurService.updateProfesseurById(id, newProfesseur);
    }

    @DeleteMapping("/prof/{id}")
    public String deleteProfesseur(@PathVariable("id") Long id) {
        return professeurService.deleteProfesseurById(id);
    }
}
