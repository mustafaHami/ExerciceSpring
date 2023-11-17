package tn.spring.springboot.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Classe {
    @Id
    @GeneratedValue
    private Long classeId;

    private String nom;

    @OneToMany(mappedBy = "classe",cascade = CascadeType.ALL)
    private List<Etudiant> etudiants;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Professeur professeur;


}
