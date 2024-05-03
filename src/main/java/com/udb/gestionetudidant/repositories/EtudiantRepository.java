package com.udb.gestionetudidant.repositories;

import com.udb.gestionetudidant.entities.Etudiant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
    Etudiant findByEmail(String email);
    @Query("SELECT etd FROM Etudiant etd WHERE etd.prenom LIKE :mc1 OR etd.nom LIKE :mc2")
    Page<Etudiant> findBySearch(@Param("mc1")String mc1, @Param("mc2")String mc2, Pageable pageable);
}
