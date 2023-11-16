package tn.spring.springboot.controller;

import tn.spring.springboot.entity.Etudiant;
import tn.spring.springboot.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EtudiantController {

    @Autowired
    private EtudiantService etudiantService;

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

    @DeleteMapping("/etudiant/{id}")
    public String deleteEtudiant(@PathVariable("id") Long id) {
        return etudiantService.deleteEtudiantById(id);
    }
}
