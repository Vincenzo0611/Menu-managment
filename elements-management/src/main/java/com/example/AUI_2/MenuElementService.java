package com.example.AUI_2;

import com.example.AUI_2.DTO.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class MenuElementService {

    private final MenuElementRepository menuElementRepository;
    private final SimpleSectionService simpleSectionService;

    public MenuElementService(MenuElementRepository menuElementRepository, SimpleSectionService menuSectionService) {
        this.menuElementRepository = menuElementRepository;
        this.simpleSectionService = menuSectionService;
    }

    public List<MenuElement> findAll() {
        return menuElementRepository.findAll();
    }

    public List<MenuElement> findElementsBySection(SimpleSection menuSection) {
        return menuElementRepository.findByMenuSection(menuSection);
    }

    public void save(MenuElement element) {
        menuElementRepository.save(element);
    }

    public void deleteById(UUID id)
    {
        menuElementRepository.deleteById(id);
    }

    public MenuElement findById(UUID id)
    {
        return menuElementRepository.findById(id).orElse(null);
    }

    //Lab3 HTTP
    public List<MenuElementReadDTO> findAllDto() {
        List<MenuElement> elements = menuElementRepository.findAll();

        return elements.stream()
                .map(this::convertToReadDTO)
                .collect(Collectors.toList());
    }

    public List<MenuElementReadDTO> findAllDtoSectionId(UUID id) {
        List<MenuElement> elements = menuElementRepository.findByMenuSectionId(id);

        return elements.stream()
                .map(this::convertToReadDTO)
                .collect(Collectors.toList());
    }

    public MenuElementReadDTO findDtoById(UUID id)
    {
        return convertToReadDTO(menuElementRepository.findById(id).orElse(null));
    }

    public MenuElementReadDTO create(UUID sectionId, MenuElementCreateDTO createDTO) {
        SimpleSection section = simpleSectionService.findById(sectionId);

        if (section == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Section not found");
        }

        MenuElement element = new MenuElement();
        element.setName(createDTO.getName());
        element.setPrice(createDTO.getPrice());
        element.setMenuSection(section);
        menuElementRepository.save(element);

        return convertToReadDTO(element);
    }

    public MenuElementReadDTO create(String sectionName, MenuElementCreateDTO createDTO) {
        SimpleSection section = simpleSectionService.findByName(sectionName);

        if (section == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Section not found");
        }

        MenuElement element = new MenuElement();
        element.setName(createDTO.getName());
        element.setPrice(createDTO.getPrice());
        element.setMenuSection(section);
        menuElementRepository.save(element);

        return convertToReadDTO(element);
    }

    public MenuElementReadDTO update(UUID id, MenuElementUpdateDTO updateDTO) {
        MenuElement element = menuElementRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Element not found"));

        if (updateDTO.getName() != null) {
            element.setName(updateDTO.getName());
        }
        if (updateDTO.getPrice() != 0) {
            element.setPrice(updateDTO.getPrice());
        }

        menuElementRepository.save(element);

        return convertToReadDTO(element);
    }

    public void delete(UUID id) {
        MenuElement element = menuElementRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Element not found"));

        menuElementRepository.deleteById(id);
    }

    private MenuElementReadDTO convertToReadDTO(MenuElement element) {

        if(element == null)
            return null;

        MenuElementReadDTO dto = new MenuElementReadDTO();
        dto.setId(element.getId());
        dto.setName(element.getName());
        dto.setPrice(element.getPrice());
        dto.setSectionName(element.getSection().getName());
        return dto;
    }

}