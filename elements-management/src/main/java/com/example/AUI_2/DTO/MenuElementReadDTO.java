package com.example.AUI_2.DTO;

import java.util.UUID;

public class MenuElementReadDTO {
    private UUID id;
    private String name;
    private int price;
    private String sectionName;

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getSectionName() {
        return sectionName;
    }
}