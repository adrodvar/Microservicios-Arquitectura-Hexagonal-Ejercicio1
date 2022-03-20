package com.example.demo.core.domain.model;

public class Pokemon {

    private Id id;

    private Name name;

    private Weight weight;

    private Height height;

    public Pokemon(int id, String name, int weight, int height) {
        this.id = new Id(id);
        this.name = new Name(name);
        this.weight = new Weight(weight);
        this.height = new Height(height);
    }

    public Id getId() {
        return id;
    }

    public Name getName() {
        return name;
    }

    public Weight getWeight() {
        return weight;
    }

    public Height getHeight() {
        return height;
    }
}
