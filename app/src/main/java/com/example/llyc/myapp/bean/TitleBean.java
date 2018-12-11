package com.example.llyc.myapp.bean;

import java.io.Serializable;

/**
 * Created by Bright on 2018/10/29.
 *
 * @Describe ContentFragment->RecycleView条目
 * @Called
 */
public class TitleBean implements Serializable {
    private int id;
    private String title;
    private String description;

    public TitleBean(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    @Override
    public String toString() {
        return "TitleBean{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
