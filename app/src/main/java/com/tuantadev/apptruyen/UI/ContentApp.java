package com.tuantadev.apptruyen.UI;

public class ContentApp {
    private String name;
    private String contentApp;

    public ContentApp(String name, String contentApp) {
        this.name = name;
        this.contentApp = contentApp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContentApp() {
        return contentApp;
    }

    public void setContentApp(String contentApp) {
        this.contentApp = contentApp;
    }
}
