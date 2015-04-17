package com.epam.Vadym_Vlasenko.eShop.entity;

import java.io.Serializable;

/**
 * Created by Вадим on 22.03.2015.
 */
public class Insert implements Serializable {

    private int id;
    private String title;

    public Insert() {
    }

    public Insert(String title) {
        this.title = title;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Insert)) return false;

        Insert insert = (Insert) o;

        if (id != insert.id) return false;
        if (title != null ? !title.equals(insert.title) : insert.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Insert{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}

