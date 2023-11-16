package tn.spring.springboot.service;

import tn.spring.springboot.entity.Etudiant;
import tn.spring.springboot.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EtudiantServiceImpl implements EtudiantService {

    @Autowired
    private EtudiantRepository etudiantRepository;

    @Override
    public Etudiant saveEtudiant(Etudiant etudiant){
        return etudiantRepository.save(etudiant);
    }
    @Override
    public List<Etudiant> fetchAllEtudiant(){
        List<Etudiant> allEtudiants = etudiantRepository.findAll();
        return allEtudiants;
    }

    @Override
    public Etudiant getEtudiantById(Long id) {
        Optional<Etudiant> employee = etudiantRepository.findById(id);
        if (employee.isPresent()) {
            return employee.get();
        }
        return null;
    }

    @Override
    public Etudiant updateEtudiantById(Long id, Etudiant etudiant) {
        Optional<Etudiant> employee1 = etudiantRepository.findById(id);

        if (employee1.isPresent()) {
            Etudiant originalEtudiant = employee1.get();

            if (Objects.nonNull(etudiant.getEtudiantName()) && !"".equalsIgnoreCase(etudiant.getEtudiantName())) {
                originalEtudiant.setEtudiantName(etudiant.getEtudiantName());
            }
            if (Objects.nonNull(etudiant.getEtudiantSalary()) && etudiant.getEtudiantSalary() != 0) {
                originalEtudiant.setEtudiantSalary(etudiant.getEtudiantSalary());
            }
            return etudiantRepository.save(originalEtudiant);
        }
        return null;
    }

    @Override
    public String deleteDepartmentById(Long id) {
        if (etudiantRepository.findById(id).isPresent()) {
            etudiantRepository.deleteById(id);
            return "Employee deleted successfully";
        }
        return "No such employee in the database";
    }

}
