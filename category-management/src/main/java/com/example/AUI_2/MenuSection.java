package com.example.AUI_2;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Entity
@Table(name = "menu_sections")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class MenuSection implements Comparable<MenuSection>, Serializable {

    @Id
    @Column(name = "id")
    private UUID id = UUID.randomUUID();

    @Column(name = "name")
    String name;

    @Column(name = "description")
    String description;

    @Override
    public int compareTo(MenuSection o) {
        return this.name.compareTo(o.name);
    }

    public boolean compareToHash(MenuSection o)
    {
        return this.hashCode() == o.hashCode();
    }

    @Override
    public String toString()
    {
        return "ID: " + this.id + " name: " + this.name + " description: " + this.description;
    }

}
