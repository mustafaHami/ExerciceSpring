package tn.spring.springboot.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
public class Classe {
    @Id
    @GeneratedValue
    private Long classeId;
    @Getter
    @Setter
    private String nom;
    @Getter
    @Setter
    @OneToMany(mappedBy = "classe")
    private List<Etudiant> etudiants;

    @OneToOne(mappedBy = "classe")
    @Getter
    @Setter
    private Professeur professeur;


}
