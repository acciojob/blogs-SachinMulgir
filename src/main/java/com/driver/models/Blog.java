package com.driver.models;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Generated;
import org.springframework.boot.test.autoconfigure.data.cassandra.DataCassandraTest;

import javax.persistence.*;
import java.util.*;
import java.util.Date;

@Entity
@Table(name = "Blog")
public
class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String title;

    String content;

    @CreationTimestamp
    Date pubDate;

    @ManyToOne
    @JoinColumn
    User user;

    @OneToMany(mappedBy = "blog", cascade = CascadeType.ALL)
    List<Image> imageList = new ArrayList<>();

    public Blog() {
    }

    public Blog(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public User getUser() {
        return user;
    }

    public List<Image> getImageList() {
        return imageList;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setImageList(List<Image> imageList) {
        this.imageList = imageList;
    }
}