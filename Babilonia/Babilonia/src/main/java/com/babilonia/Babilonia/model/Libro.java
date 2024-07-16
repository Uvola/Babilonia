package com.babilonia.Babilonia.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Libro {
    @JsonAlias("title")
    private String title;

    @JsonAlias("authors")
    private List<Autor> authors;

    @JsonAlias("translators")
    private List<Person> translators;

    @JsonAlias("subjects")
    private List<String> subjects;

    @JsonAlias("bookshelves")
    private List<String> bookshelves;

    @JsonAlias("languages")
    private List<String> languages;

    private Boolean copyright;

    @JsonAlias("media_type")
    private String mediaType;

    private Format formats;

    @JsonAlias("download_count")
    private int downloadCount;

    //Setters

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthors(List<Autor> authors) {
        this.authors = authors;
    }

    public void setTranslators(List<Person> translators) {
        this.translators = translators;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    public void setBookshelves(List<String> bookshelves) {
        this.bookshelves = bookshelves;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public void setCopyright(Boolean copyright) {
        this.copyright = copyright;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public void setFormats(Format formats) {
        this.formats = formats;
    }

    public void setDownloadCount(int downloadCount) {
        this.downloadCount = downloadCount;
    }

    //Getters

    public String getTitle() {
        return title;
    }

    public List<Autor> getAuthors() {
        return authors;
    }

    public List<Person> getTranslators() {
        return translators;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public List<String> getBookshelves() {
        return bookshelves;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public Boolean getCopyright() {
        return copyright;
    }

    public String getMediaType() {
        return mediaType;
    }

    public Format getFormats() {
        return formats;
    }

    public int getDownloadCount() {
        return downloadCount;
    }
}
