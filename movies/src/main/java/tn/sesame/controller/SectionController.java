package tn.sesame.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import tn.sesame.model.Section;
import tn.sesame.repository.SectionRepository;

import java.util.List;

@RestController
@CrossOrigin(origins = "*" )
@RequestMapping("/sections")
public class SectionController {
    @Autowired
    SectionRepository sectionRepository;
    @GetMapping
    public List<Section>getSectionWithProducts(){
        return sectionRepository.findAll();
    }

}
