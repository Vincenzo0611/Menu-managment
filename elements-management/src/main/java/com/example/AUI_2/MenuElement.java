package com.example.AUI_2;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Builder
@Entity
@Table(name = "menu_elements")
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class MenuElement implements Comparable<MenuElement>, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private int price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_section_id")
    private SimpleSection menuSection;

    @Override
    public int compareTo(MenuElement o) {
        return this.name.compareTo(o.name);
    }

    public boolean compareToHash(MenuElement o)
    {
        return this.hashCode() == o.hashCode();
    }

    @Override
    public String toString()
    {
        return "ID: " + this.id + " name: " + this.name + " cost " + this.price;
    }

    public String getName() {
        return name;
    }

    public UUID getId() {
        return id;
    }

    public SimpleSection getSection() {
        return menuSection;
    }

    public int getPrice() {
        return price;
    }
}
