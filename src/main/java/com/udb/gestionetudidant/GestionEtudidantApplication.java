package com.udb.gestionetudidant;

import com.udb.gestionetudidant.entities.Etudiant;
import com.udb.gestionetudidant.repositories.EtudiantRepository;
import com.udb.gestionetudidant.services.EtudiantImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class GestionEtudidantApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionEtudidantApplication.class, args);
    }

    @Bean
    CommandLineRunner start(EtudiantImpl etudiantImpl) {
        return args -> {

            /*Stream.of("Youssou", "Mariama", "Penda").forEach(prenom -> {
                Stream.of("Diouf", "Gaye", "Mbaye", "Ba").forEach(nom->{
                    Etudiant etudiant = new Etudiant();
                    etudiant.setPrenom(prenom);
                    etudiant.setNom(nom);
                    etudiant.setEmail(etudiant.getNom()+etudiant.getPrenom()+"@gmail.com");
                    etudiant.setDateNaissance(new Date());
                    etudiantImpl.addNewEtudiant(etudiant);
                });
            });

            Stream.of("Thierno", "Zayna", "Fatoumata").forEach(prenom -> {
                Stream.of("Sonko", "Sakho", "Ngom", "Fall").forEach(nom->{
                    Etudiant etudiant = new Etudiant();
                    etudiant.setPrenom(prenom);
                    etudiant.setNom(nom);
                    etudiant.setEmail(etudiant.getNom()+etudiant.getPrenom()+"@gmail.com");
                    etudiant.setDateNaissance(new Date());
                    etudiantImpl.addNewEtudiant(etudiant);
                });
            });

            Stream.of("Mareme", "Amy", "Oumoul").forEach(prenom -> {
                Stream.of("Dia", "Cissokho", "Sene", "Mbacké").forEach(nom->{
                    Etudiant etudiant = new Etudiant();
                    etudiant.setPrenom(prenom);
                    etudiant.setNom(nom);
                    etudiant.setEmail(etudiant.getNom()+etudiant.getPrenom()+"@gmail.com");
                    etudiant.setDateNaissance(new Date());
                    etudiantImpl.addNewEtudiant(etudiant);
                });
            });*/
        };
    }
}
