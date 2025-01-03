package com.example.AUI_2.controllers;

import com.example.AUI_2.*;
import com.example.AUI_2.DTO.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/sections")
public class MenuSectionController {

    private final MenuSectionService menuSectionService;

    private final RestTemplate restTemplate;

    @Value("${API_ELEMENTS_URL}")
    private String elementsUri;

    public MenuSectionController(MenuSectionService menuSectionService, RestTemplate restTemplate) {
        this.menuSectionService = menuSectionService;
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public List<MenuSectionReadDTO> getAllSections() {
        return menuSectionService.findAllDto();
    }

    @GetMapping("/{id}")
    public MenuSectionReadDTO getSectionById(@PathVariable UUID id) {
        return menuSectionService.findDtoById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MenuSectionReadDTO createSection(@RequestBody MenuSectionCreateDTO createDTO) {
        MenuSectionReadDTO tmp = menuSectionService.create(createDTO);

        ResponseEntity<MenuSectionReadDTO> response = restTemplate.postForEntity(elementsUri + "/api/internal/sections", tmp, MenuSectionReadDTO.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            System.out.println("Sekcja została poprawnie przesłana do elements-management.");
        } else {
            System.err.println("Błąd podczas przesyłania sekcji do elements-management: " + response.getStatusCode());
        }

        return tmp;
    }

    @PutMapping("/{id}")
    public MenuSectionReadDTO updateSection(@PathVariable UUID id, @RequestBody MenuSectionUpdateDTO updateDTO) {
        restTemplate.put(elementsUri + "/api/internal/sections/" + id, updateDTO);
        return menuSectionService.update(id, updateDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSection(@PathVariable UUID id) {
        menuSectionService.delete(id);
        restTemplate.delete(elementsUri + "/api/internal/sections/" + id);
    }
}
