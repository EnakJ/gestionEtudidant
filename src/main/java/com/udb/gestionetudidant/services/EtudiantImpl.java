package com.udb.gestionetudidant.services;

import com.udb.gestionetudidant.entities.Etudiant;
import com.udb.gestionetudidant.repositories.EtudiantRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional @AllArgsConstructor
public class EtudiantImpl implements IEtudiant {
    private EtudiantRepository etudiantRepository;
    @Override
    public Etudiant addNewEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public List<Etudiant> findAll() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant findByEmail(String email) {
        return etudiantRepository.findByEmail(email);
    }

}
