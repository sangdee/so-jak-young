package com.cbnu.sjy_.core.model.entity;

/**
 * @author : Sangji Lee
 * @when : 2019-11-27 오후 1:37
 * @homepage : https://github.com/sangji11
 */
public class Item {
    String name;
    String image;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Item(String name, String image) {
        super();
        this.name = name;
        this.image = image;
    }


}
