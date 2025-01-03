package com.example.AUI_2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SimpleSectionRepository extends JpaRepository<SimpleSection, UUID> {

    public SimpleSection findByName(String name);
}
