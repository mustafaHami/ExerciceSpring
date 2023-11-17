package tn.spring.springboot.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import tn.spring.springboot.classe.Personne;

@Entity
@Getter
@Setter
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Long etudiantId;

    private int moyenne;

    @Embedded
    private Personne personne;

    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name = "classe_id", nullable = true)
    private Classe classe;
    public Etudiant(){}

}
