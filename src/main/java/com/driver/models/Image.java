package com.driver.models;

import javax.persistence.*;

@Entity
@Table(name = "image")
public
class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String description;

    String dimensions;

    @ManyToOne
    @JoinColumn
    Blog blog;

    public Image() {
    }

    public Image(String description, String dimensions) {
        this.description = description;
        this.dimensions = dimensions;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getDimensions() {
        return dimensions;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }
}