package nullteam.com.doway.model;

import java.io.Serializable;

public class ActivityPicInfo implements Serializable {

    String imgurl;

    public ActivityPicInfo(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }
}
