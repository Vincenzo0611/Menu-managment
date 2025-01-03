package com.example.AUI_2;

import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;

import java.util.UUID;

@Component
public class DataInitializer {

    private final MenuElementRepository menuElementRepository;
    private final SimpleSectionRepository simpleSectionRepository;

    public DataInitializer(MenuElementRepository menuElementRepository, SimpleSectionRepository simpleSectionRepository) {
        this.menuElementRepository = menuElementRepository;
        this.simpleSectionRepository = simpleSectionRepository;
    }
    /*
    @PostConstruct
    public void init() {
        SimpleSection starters = simpleSectionRepository.save(new SimpleSection(UUID.randomUUID(), "Przystawki"));
        SimpleSection soups = simpleSectionRepository.save(new SimpleSection(UUID.randomUUID(), "Zupy"));
        SimpleSection mainCourses = simpleSectionRepository.save(new SimpleSection(UUID.randomUUID(), "Dania Główne"));

        menuElementRepository.save(new MenuElement(null, "Sałatka", 10, starters));
        menuElementRepository.save(new MenuElement(null, "Tatar wołowy", 10, starters));
        menuElementRepository.save(new MenuElement(null, "Rosół", 12, soups));
        menuElementRepository.save(new MenuElement(null, "Żurek", 12, soups));
        menuElementRepository.save(new MenuElement(null, "Stek", 25, mainCourses));
        menuElementRepository.save(new MenuElement(null, "Makaron Carbonara", 20, mainCourses));
        menuElementRepository.save(new MenuElement(null, "Pizza", 20, mainCourses));

        System.out.println("Data initialized");
    }

     */
}