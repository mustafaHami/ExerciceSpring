package tn.spring.springboot.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import tn.spring.springboot.classe.Personne;
@Entity
@Getter
@Setter
public class Professeur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long profId;

    private String matiere;

    @Embedded
    private Personne personne;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "classe_id", nullable = false)
    private Classe classe;

    public Professeur(){}
}
