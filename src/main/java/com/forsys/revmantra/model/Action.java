package com.forsys.revmantra.model;

public enum Action {

    INSERTED("INSERTED"),
    UPDATED("UPDATED"),
    DELETED("DELETED"),
    LOADED("LOADED");

    private final String name;

    private Action(String value) {
        this.name = value;
    }

    public String value() {
        return this.name;
    }

    @Override
    public String toString() {
        return name;
    }
}