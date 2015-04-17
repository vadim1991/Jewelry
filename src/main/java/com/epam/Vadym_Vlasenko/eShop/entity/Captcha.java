package com.epam.Vadym_Vlasenko.eShop.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * Created by swift-seeker-89717 on 17.04.2015.
 */
public class Captcha implements Serializable {

    private String content;
    private UUID uuid;
    private Date dateCreated;

    public Captcha() {
    }

    public Captcha(String content, UUID uuid, Date dateCreated) {
        this.content = content;
        this.uuid = uuid;
        this.dateCreated = dateCreated;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Captcha captcha = (Captcha) o;

        if (content != null ? !content.equals(captcha.content) : captcha.content != null) return false;
        if (uuid != null ? !uuid.equals(captcha.uuid) : captcha.uuid != null) return false;
        return !(dateCreated != null ? !dateCreated.equals(captcha.dateCreated) : captcha.dateCreated != null);

    }

    @Override
    public int hashCode() {
        int result = content != null ? content.hashCode() : 0;
        result = 31 * result + (uuid != null ? uuid.hashCode() : 0);
        result = 31 * result + (dateCreated != null ? dateCreated.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Captcha{" +
                "content='" + content + '\'' +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
