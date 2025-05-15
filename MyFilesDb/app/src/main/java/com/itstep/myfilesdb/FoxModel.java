package com.itstep.myfilesdb;

import androidx.annotation.NonNull;

import java.util.UUID;

public class FoxModel {

    private UUID id;

    public FoxModel(){
        this.id = UUID.randomUUID();
    }

    private String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    private String link;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @NonNull
    @Override
    public String toString() {
        return this.link;
    }
}
