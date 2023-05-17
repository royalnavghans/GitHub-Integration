package com.main.Gtihub_Integration.entity;

public class RepositoryRequest {
    private String name;
    private String description;
    private boolean isPrivate;

    // Constructors, getters, and setters

    public RepositoryRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(boolean aPrivate) {
        isPrivate = aPrivate;
    }

}
