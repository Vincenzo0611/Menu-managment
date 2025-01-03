package com.example.AUI_2.DTO;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.*;

public class SimpleSection implements Serializable {


    String name;

    public SimpleSection(String name) {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return " name: " + this.name;
    }

}

