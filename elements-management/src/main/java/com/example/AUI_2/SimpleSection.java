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
public class SimpleSection implements Comparable<SimpleSection>, Serializable {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "name")
    String name;

    @Override
    public int compareTo(SimpleSection o) {
        return this.name.compareTo(o.name);
    }

    public boolean compareToHash(SimpleSection o)
    {
        return this.hashCode() == o.hashCode();
    }

    @Override
    public String toString()
    {
        return "ID: " + this.id + " name: " + this.name;
    }

}
