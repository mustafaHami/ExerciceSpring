package tn.spring.springboot.classe;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Getter
@Setter
public class Personne {
    private String nom;
    private String prenom;
    private String dateNaissance;

    public Personne(String nom, String prenom, String dateNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
    }

    public Personne() {
    }

    public boolean age20 (String dateString) {
        LocalDate dateNow = LocalDate.now();
        LocalDate dateParse = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        int age = Period.between(dateNow, dateParse).getYears();
        return age > 20;
    }

}
