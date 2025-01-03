package com.example.AUI_2.controllers;

import com.example.AUI_2.*;
import com.example.AUI_2.DTO.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/elements")
public class MenuElementController {

    private final MenuElementService menuElementService;
    private final SimpleSectionService simpleSectionService;

    public MenuElementController(MenuElementService menuElementService, SimpleSectionService simpleSectionService) {
        this.menuElementService = menuElementService;
        this.simpleSectionService = simpleSectionService;
    }

    @GetMapping
    public List<MenuElementReadDTO> getAllElements() {
        return menuElementService.findAllDto();
    }

    @GetMapping("section/{sectionId}")
    public List<MenuElementReadDTO> getAllElementsForSection(@PathVariable UUID sectionId) {
        return menuElementService.findAllDtoSectionId(sectionId);
    }

    @GetMapping("/showSections")
    public List<SimpleSection> getAllSections() {
        return simpleSectionService.findAll();
    }

    @GetMapping("/{id}")
    public MenuElementReadDTO getElementById(@PathVariable UUID id) {
        return menuElementService.findDtoById(id);
    }

    @PostMapping("/section/addId/{sectionId}")
    @ResponseStatus(HttpStatus.CREATED)
    public MenuElementReadDTO createElement(@PathVariable UUID sectionId, @RequestBody MenuElementCreateDTO createDTO) {
        return menuElementService.create(sectionId, createDTO);
    }

    @PostMapping("/section/addName/{sectionName}")
    @ResponseStatus(HttpStatus.CREATED)
    public MenuElementReadDTO createElement(@PathVariable String sectionName, @RequestBody MenuElementCreateDTO createDTO) {
        return menuElementService.create(sectionName, createDTO);
    }

    @PutMapping("/{id}")
    public MenuElementReadDTO updateElement(@PathVariable UUID id, @RequestBody MenuElementUpdateDTO updateDTO) {
        return menuElementService.update(id, updateDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteElement(@PathVariable UUID id) {
        menuElementService.delete(id);
    }
}
