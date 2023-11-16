package tn.spring.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import tn.spring.springboot.entity.Classe;
import tn.spring.springboot.entity.Etudiant;
import tn.spring.springboot.entity.Professeur;
import tn.spring.springboot.service.ClasseService;
import tn.spring.springboot.service.EtudiantService;
import tn.spring.springboot.service.ProfesseurService;

import java.util.List;


@Controller
public class HomeController {

    @Autowired
    private ClasseService classeService;

    @Autowired
    private EtudiantService etudiantService;

    @Autowired
    private ProfesseurService professeurService;

    @GetMapping("/")
    public String home(Model model) {
        List<Classe> listeClasses = classeService.fetchAllClasse();
        List<Etudiant> listeEtudiants = etudiantService.fetchAllEtudiant();
        List<Professeur> listeProfesseurs = professeurService.fetchAllProfesseur();

        model.addAttribute("classes", listeClasses);
        model.addAttribute("etudiants", listeEtudiants);
        model.addAttribute("professeurs", listeProfesseurs);

        return "gestion-crud";
    }

}
