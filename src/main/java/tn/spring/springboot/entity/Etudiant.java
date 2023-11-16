package tn.spring.springboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long etudiantId;

    @Getter
    private String etudiantName;

    private float etudiantSalary;

    public Etudiant(){}

    public Etudiant(long etudiantId, String etudiantName, float etudiantSalary){
        this.etudiantId = etudiantId;
        this.etudiantName = etudiantName;
        this.etudiantSalary = etudiantSalary;
    }
}
