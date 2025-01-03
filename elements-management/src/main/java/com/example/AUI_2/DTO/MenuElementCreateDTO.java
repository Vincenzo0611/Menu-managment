package com.example.AUI_2.DTO;

import java.util.UUID;

public class MenuElementCreateDTO {
    private String name;
    private int price;
    private UUID sectionId;

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setSectionId(UUID sectionId) {
        this.sectionId = sectionId;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public UUID getSectionId() {
        return sectionId;
    }
}