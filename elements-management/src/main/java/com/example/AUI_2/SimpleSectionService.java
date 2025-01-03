package com.example.AUI_2;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SimpleSectionService {

    private final SimpleSectionRepository simpleSectionRepository;

    public SimpleSectionService(SimpleSectionRepository simpleSectionRepository) {
        this.simpleSectionRepository = simpleSectionRepository;
    }

    public SimpleSection findById(UUID id) {
        return simpleSectionRepository.findById(id).orElse(null);
    }
    public SimpleSection findByName(String name) {
        return simpleSectionRepository.findByName(name);
    }

    public void save(SimpleSection category) {
        simpleSectionRepository.save(category);
    }

    public void deleteById(UUID id) {
        if (!simpleSectionRepository.existsById(id)) {
            throw new EntityNotFoundException("Sekcja o podanym ID nie istnieje: " + id);
        }
        simpleSectionRepository.deleteById(id);
    }

    public SimpleSection update(UUID id, SimpleSection updatedSection) {
        SimpleSection section = simpleSectionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Section not found"));

        section.setName(updatedSection.getName());
        return simpleSectionRepository.save(section);
    }

    public List<SimpleSection> findAll() {
        return simpleSectionRepository.findAll();
    }
}
