package tn.spring.springboot.controller;

import org.springframework.stereotype.Controller;
import tn.spring.springboot.entity.Classe;
import tn.spring.springboot.entity.Etudiant;
import tn.spring.springboot.service.ClasseService;
import tn.spring.springboot.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EtudiantController {

    @Autowired
    private EtudiantService etudiantService;

    @Autowired
    private ClasseService classeService;

    @PostMapping("/etudiant/ajouter")
    public String ajouterEtudiant(@ModelAttribute Etudiant etudiant, @RequestParam("classeId") Long classeId) {
        Classe classe = classeService.getClasseById(classeId);
        if (classe != null) {
            etudiant.setClasse(classe);
        }
        etudiantService.saveEtudiant(etudiant);
        return "redirect:/";
    }

    @PostMapping("/etudiant/supprimer/{etudiantId}")
    public String deleteEtudiant(@PathVariable("etudiantId") Long etudiantId) {
        etudiantService.deleteEtudiantById(etudiantId);
        return "redirect:/";
    }

    @PostMapping("/etudiant")
    public Etudiant saveEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantService.saveEtudiant(etudiant);
    }

    @GetMapping("/etudiant")
    public List<Etudiant> getAllEtudiants() {
        return etudiantService.fetchAllEtudiant();
    }

    @GetMapping("/etudiant/{id}")
    public Etudiant getEtudiantById(@PathVariable("id") Long id) {
        return etudiantService.getEtudiantById(id);
    }

    @PutMapping("/etudiant/{id}")
    public Etudiant updateEtudiant(@PathVariable("id") Long id, Etudiant newEtudiant) {
        return etudiantService.updateEtudiantById(id, newEtudiant);
    }
}
