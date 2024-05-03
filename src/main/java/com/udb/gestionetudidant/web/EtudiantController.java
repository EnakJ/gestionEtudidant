package com.udb.gestionetudidant.web;

import com.udb.gestionetudidant.entities.Etudiant;
import com.udb.gestionetudidant.repositories.EtudiantRepository;
import com.udb.gestionetudidant.services.EtudiantImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.ssl.SslProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


@Controller
@RequestMapping(value = "/Etudiant")
public class EtudiantController {
    @Autowired
    private EtudiantRepository etudiantRepository;
    @Value("${imgDir}")
    private String imgPath;
    @RequestMapping(value = "/index")
    public String Index(Model model, @RequestParam(name = "page", defaultValue = "0") int p,
                        @RequestParam(name = "moCle", defaultValue = "") String mc){

        Page<Etudiant> etds = etudiantRepository.findBySearch("%"+mc+"%", "%"+mc+"%", PageRequest.of(p, 10)
        );
        model.addAttribute("pageEtudiants", etds);
        int pageCount = etds.getTotalPages();
        int[] page = new int[pageCount];
        for (int i = 0; i < pageCount; i++){page[i] = i;}
        model.addAttribute("page", page);
        model.addAttribute("pageCourant", p);
        model.addAttribute("moCle", mc);
        return "etudiants";
    }

    @RequestMapping(value = "/formEtudiant")
    public String formEtudiant(Model model){
        model.addAttribute("etudiant", new Etudiant());
        return "formulaire";
    }

    @RequestMapping(value = "/saveEtudiant", method = RequestMethod.POST)
    public String save(@Valid Etudiant etudiant, BindingResult bindingResult,
                       @RequestParam(name = "picture") MultipartFile file) throws IOException {
        if(!(file.isEmpty())){
            etudiant.setPhoto(file.getOriginalFilename());
            etudiantRepository.save(etudiant);
            //Premiere methode de stockage du photo
//            file.transferTo(new File(System.getProperty("user.home")+"/Tools/projects/images/"+
//            file.getOriginalFilename()));

            //Deuxieme methode de stockage du photo
            file.transferTo(new File(imgPath+etudiant.getIdEtudiant()));
        }
        if (bindingResult.hasErrors()){
            return "formulaire";
        }

        return "redirect:index";
    }

    @RequestMapping(value = "/getPhoto", produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public byte[] getPhoto(Long id, Model model) throws IOException {
        Etudiant etudiant = etudiantRepository.getOne(id);
        File f = new File(imgPath+id);
        model.addAttribute("etudiant", etudiant);
        return IOUtils.toByteArray(new FileInputStream(f));
    }

    @RequestMapping(value = "/delete")
    public String delete(Long id){
        etudiantRepository.deleteById(id);
        return "redirect:index";
    }

    @RequestMapping(value = "/edit")
    public String edit(Long id, Model model){
        Etudiant etudiant = etudiantRepository.getOne(id);
        model.addAttribute("etudiant", etudiant);
        return "editForm";
    }
}
