package com.example.AUI_2;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.example.AUI_2.DTO.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class MenuSectionService {

    private final MenuSectionRepository menuSectionRepository;

    public MenuSectionService(MenuSectionRepository menuSectionRepository) {
        this.menuSectionRepository = menuSectionRepository;
    }

    public List<MenuSection> findAll() {
        return menuSectionRepository.findAll();
    }

    public void save(MenuSection section) {
        menuSectionRepository.save(section);
    }

    public MenuSection findById(UUID id)
    {
        return menuSectionRepository.findById(id).orElse(null);
    }

    //Lab3 HTTP
    public List<MenuSectionReadDTO> findAllDto() {
        List<MenuSection> sections = menuSectionRepository.findAll();

        return sections.stream()
                .map(this::convertToReadDTO)
                .collect(Collectors.toList());
    }

    public MenuSectionReadDTO findDtoById(UUID id)
    {
        return convertToReadDTO(menuSectionRepository.findById(id).orElse(null));
    }

    public MenuSectionReadDTO create(MenuSectionCreateDTO createDTO) {
        MenuSection section = new MenuSection();
        section.setName(createDTO.getName());
        section.setDescription(createDTO.getDescription());
        menuSectionRepository.save(section);

        return convertToReadDTO(section);
    }

    public MenuSectionReadDTO update(UUID id, MenuSectionUpdateDTO updateDTO) {
        MenuSection section = menuSectionRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Section not found"));

        if (updateDTO.getName() != null) {
            section.setName(updateDTO.getName());
        }
        if (updateDTO.getDescription() != null) {
            section.setDescription(updateDTO.getDescription());
        }

        menuSectionRepository.save(section);

        return convertToReadDTO(section);
    }

    public void delete(UUID id) {
        MenuSection section = menuSectionRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Section not found"));

        menuSectionRepository.deleteById(id);
    }

    private MenuSectionReadDTO convertToReadDTO(MenuSection section) {

        if(section == null)
            return null;

        MenuSectionReadDTO dto = new MenuSectionReadDTO();
        dto.setId(section.getId());
        dto.setName(section.getName());
        dto.setDescription(section.getDescription());
        return dto;
    }

}
