package br.unfior.quintaapp.model;

/**
 * Created by bruno on 26/11/16.
 */

public class Category {

    private Long id;
    private String name;
    private String description;

    public Category(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Category(String name, String description) {
        this(null, name, description);
    }

    public Category() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
