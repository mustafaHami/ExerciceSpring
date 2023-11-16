package tn.spring.springboot.classe;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

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

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public boolean minimum4Carac(String value) {
        return value.length() < 4;
    }
    public boolean age20 (String dateString) {
        LocalDate dateNow = LocalDate.now();
        LocalDate dateParse = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        int age = Period.between(dateNow, dateParse).getYears();
        return age > 20;
    }

    @Override
    public String toString() {
        return "Personne{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", dateNaissance='" + dateNaissance + '\'' +
                '}';
    }
}
