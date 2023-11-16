package tn.spring.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tn.spring.springboot.entity.Classe;

import tn.spring.springboot.entity.Professeur;
import tn.spring.springboot.service.ClasseService;
import tn.spring.springboot.service.ProfesseurService;

import java.util.List;

@Controller
public class ProfesseurController {
    @Autowired
    private ProfesseurService professeurService;

    @Autowired
    private ClasseService classeService;

    @PostMapping("/professeur/ajouter")
    public String ajouterProfesseur(@ModelAttribute Professeur professeur, @RequestParam("classeId") Long classeId) {
        Classe classe = classeService.getClasseById(classeId);
        if (classe != null) {
            professeur.setClasse(classe);
        }
        professeurService.saveProfesseur(professeur);
        return "redirect:/";
    }

    @PostMapping("/professeur/supprimer/{profId}")
    public String deleteEtudiant(@PathVariable("profId") Long profId) {
        professeurService.deleteProfesseurById(profId);
        return "redirect:/";
    }

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
