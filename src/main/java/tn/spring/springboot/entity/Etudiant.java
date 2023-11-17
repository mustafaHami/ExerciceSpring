package tn.spring.springboot.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.spring.springboot.classe.Personne;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long etudiantId;

    private int moyenne;

    @Embedded
    private Personne personne;

    @ManyToOne
    @JoinColumn(name = "classe_id", nullable = true)
    private Classe classe;

}
