package com.example.AUI_2.controllers;


import com.example.AUI_2.*;
import com.example.AUI_2.DTO.MenuElementUpdateDTO;
import com.example.AUI_2.DTO.MenuSectionCreateDTO;
import com.example.AUI_2.DTO.MenuSectionReadDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/internal/sections")
public class SimpleSectionConntroller {

    private final SimpleSectionService simpleSectionService;
    private final MenuElementService menuElementService;

    public SimpleSectionConntroller(SimpleSectionService simpleSectionService, MenuElementService menuElementService) {
        this.simpleSectionService = simpleSectionService;
        this.menuElementService = menuElementService;
    }

    @PostMapping
    public void addSection(@RequestBody MenuSectionReadDTO createDTO) {
        SimpleSection section = new SimpleSection(createDTO.getId(),createDTO.getName());
        simpleSectionService.save(section);
    }

    @PutMapping("/{id}")
    public SimpleSection updateSection(@PathVariable UUID id, @RequestBody MenuElementUpdateDTO updatedSection) {
        SimpleSection section = simpleSectionService.findById(id);
        section.setName(updatedSection.getName());
        return simpleSectionService.update(id, section);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSection(@PathVariable UUID id) {
        List<MenuElement> elements =  menuElementService.findElementsBySection(simpleSectionService.findById(id));
        for(MenuElement element : elements)
        {
            menuElementService.delete(element.getId());
        }
        simpleSectionService.deleteById(id);
    }

}
