package com.kowalik.dominik.model;

import java.util.Set;

/**
 * Created by dominik on 2017-03-24.
 */

public class PageContent implements Comparable<PageContent> {

    private Long id;

    private String header;

    private String title;

    private String text;

    private Set<String> photos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Set<String> getPhotos() {
        return photos;
    }

    public void setPhotos(Set<String> photos) {
        this.photos = photos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PageContent that = (PageContent) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getHeader() != null ? !getHeader().equals(that.getHeader()) : that.getHeader() != null) return false;
        if (getTitle() != null ? !getTitle().equals(that.getTitle()) : that.getTitle() != null) return false;
        if (getText() != null ? !getText().equals(that.getText()) : that.getText() != null) return false;
        return getPhotos() != null ? getPhotos().equals(that.getPhotos()) : that.getPhotos() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getHeader() != null ? getHeader().hashCode() : 0);
        result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
        result = 31 * result + (getText() != null ? getText().hashCode() : 0);
        result = 31 * result + (getPhotos() != null ? getPhotos().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PageContent{" +
                "id=" + id +
                ", header='" + header + '\'' +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", photos=" + photos +
                '}';
    }


    @Override
    public int compareTo(PageContent o) {
        if (this.equals(o)) return 0;
        return this.getId().compareTo(o.getId());
    }
}


