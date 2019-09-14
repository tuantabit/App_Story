package com.tuantadev.apptruyen.UI;

public class Store {
    private String name;
    private int id;
    private int idStore;
    private String title;

    public Store(String name, int id, int idStore) {
        this.name = name;
        this.id = id;
        this.idStore = idStore;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdStore() {
        return idStore;
    }

    public void setIdStore(int idStore) {
        this.idStore = idStore;
    }
}
