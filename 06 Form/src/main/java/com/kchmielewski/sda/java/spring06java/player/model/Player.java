package com.kchmielewski.sda.java.spring06java.player.model;

import java.util.Objects;

public class Player {
    private String name;
    private String surname;

    public Player() {
    }

    public Player(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name) &&
                Objects.equals(surname, player.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }
}
