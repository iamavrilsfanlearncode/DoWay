package nullteam.com.doway.model;

import java.io.Serializable;

public class ActivityPicInfo implements Serializable {

    private String imageUrl;

    public ActivityPicInfo(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
