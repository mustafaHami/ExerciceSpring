package tn.spring.springboot.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import tn.spring.springboot.classe.Personne;
@Entity
public class Professeur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long profId;

    @Getter
    @Setter
    private String matiere;

    @Setter
    @Getter
    @Embedded
    private Personne personne;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "classe_id", nullable = false)
    private Classe classe;
    public Professeur(){}
}
