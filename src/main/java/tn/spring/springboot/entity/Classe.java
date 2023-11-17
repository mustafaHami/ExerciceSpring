package tn.spring.springboot.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
public class Classe {
    @Id
    @GeneratedValue
    @Getter
    @Setter
    private Long classeId;

    @Getter
    @Setter
    private String nom;

    @Getter
    @Setter
    @OneToMany(mappedBy = "classe",cascade = CascadeType.ALL)
    private List<Etudiant> etudiants;

    @OneToOne(mappedBy = "classe",cascade = CascadeType.ALL)
    @Getter
    @Setter
    private Professeur professeur;



}
