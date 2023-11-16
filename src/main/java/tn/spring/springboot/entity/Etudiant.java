package tn.spring.springboot.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import tn.spring.springboot.classe.Personne;

@Entity
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long etudiantId;

    @Getter
    @Setter
    private int moyenne;

    @Setter
    @Getter
    @Embedded
    private Personne personne;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "classe_id", nullable = false)
    private Classe classe;
    public Etudiant(){}

}
