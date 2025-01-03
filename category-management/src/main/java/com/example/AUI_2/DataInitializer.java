package com.example.AUI_2;

import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;

import java.util.UUID;

@Component
public class DataInitializer {

    private final MenuSectionRepository menuSectionRepository;

    public DataInitializer(MenuSectionRepository menuSectionRepository) {
        this.menuSectionRepository = menuSectionRepository;
    }
    /*
    @PostConstruct
    public void init() {

        menuSectionRepository.save(new MenuSection(UUID.randomUUID(), "Przystawki", "Idealne na początek posiłku – lekkie i smaczne przekąski."));
        menuSectionRepository.save(new MenuSection(UUID.randomUUID(), "Dania główne", "Pełne smaku i różnorodności dania główne, które zaspokoją każdy apetyt."));
        menuSectionRepository.save(new MenuSection(UUID.randomUUID(), "Desery", "Słodkie zakończenie posiłku – wybierz coś wyjątkowego."));
        menuSectionRepository.save(new MenuSection(UUID.randomUUID(), "Napoje", "Odświeżające napoje, które uzupełnią każdy posiłek."));
        menuSectionRepository.save(new MenuSection(UUID.randomUUID(), "Zupy", "Rozgrzewające i aromatyczne zupy na każdą okazję."));
        menuSectionRepository.save(new MenuSection(UUID.randomUUID(), "Sałatki", "Świeże i zdrowe sałatki z najwyższej jakości składników."));
        menuSectionRepository.save(new MenuSection(UUID.randomUUID(), "Dania wegetariańskie", "Bogate w smaki dania bez mięsa dla miłośników roślinnych przysmaków."));
        menuSectionRepository.save(new MenuSection(UUID.randomUUID(), "Dania sezonowe", "Potrawy inspirowane aktualną porą roku i świeżymi składnikami."));
        System.out.println("Data initialized");
    }
     */
}