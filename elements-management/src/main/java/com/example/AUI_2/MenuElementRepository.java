package com.example.AUI_2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
import java.util.List;

@Repository
public interface MenuElementRepository extends JpaRepository<MenuElement, UUID> {

    List<MenuElement> findByMenuSectionId(UUID sectionId);

    List<MenuElement> findByMenuSection(SimpleSection section);

}