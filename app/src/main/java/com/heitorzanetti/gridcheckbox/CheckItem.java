package com.heitorzanetti.gridcheckbox;

/**
 * Created by heitorzc on 14/01/2017.
 */

public class CheckItem {

    private String   image;
    private String   description;
    private boolean  selected = false;


    public CheckItem(String image, String description) {
        this.image = image;
        this.description = description;
    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
