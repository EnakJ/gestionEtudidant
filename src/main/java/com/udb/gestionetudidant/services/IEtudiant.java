package com.udb.gestionetudidant.services;

import com.udb.gestionetudidant.entities.Etudiant;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IEtudiant {
    Etudiant addNewEtudiant(Etudiant etudiant);
    List<Etudiant> findAll();
    Etudiant findByEmail(String email);
}
