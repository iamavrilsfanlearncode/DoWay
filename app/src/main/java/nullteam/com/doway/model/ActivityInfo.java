package nullteam.com.doway.model;

import java.io.Serializable;
import java.util.List;

public class ActivityInfo implements Serializable {


    /**
     * apiurl : https://data.tycg.gov.tw/api/v1/rest/datastore/3983e8e8-7a67-4bbd-b976-bb0cdb97e2f7?format=json
     * postdate : 2019-11-12
     * liaisonemail :
     * file : null
     * activitytime : 2019-12-29~2019-12-29 09:30~21:30
     * closedate : 2019-12-29
     * id : 201911120003
     * subject : 2019YAMAHA聯合音樂發表會--中華教室
     * topdate : null
     * hostunit : 豫章實業有限公司
     * img : [{"imgcontent":"<br>小<br>提<br>琴<br>","imgname":"122802.jpg","imgurl":"http://www.tycg.gov.tw/uploaddowndoc?file=activityhot/201911121542190.jpg&filedisplay=201911121542190.jpg&flag=pic"},{"imgcontent":"<br>單<br>簧<br>管<br>","imgname":"122801.jpg","imgurl":"http://www.tycg.gov.tw/uploaddowndoc?file=activityhot/201911121542340.jpg&filedisplay=201911121542340.jpg&flag=pic"},{"imgcontent":"<br>1<br>2<br>2<br>9<br>Y<br>A<br>M<br>A<br>H<br>A<br>音<br>樂<br>教<br>室<br>-<br>烏<br>克<br>麗<br>麗<br>","imgname":"1228.jpg","imgurl":"http://www.tycg.gov.tw/uploaddowndoc?file=activityhot/201911121542000.jpg&filedisplay=201911121542000.jpg&flag=pic"}]
     * liaisonfax :
     * istop : N
     * liaisonper :
     * activityplace : 文化局演藝廳
     * activityaddress : 330　桃園市桃園區縣府21號
     * liaisontel :
     * fsort : 2
     * link : null
     * datasourceunit : 文化局
     * studyhour : 0
     * joinunit :
     * _id : 1
     * postunit : 文化局
     * detailcontent : 2019YAMAHA聯合音樂發表會&lt;br /&gt;時間:108年12月29日(日)上午0930、下午1330、晚上1800&lt;br /&gt;地點:文化局演藝廳&lt;br /&gt;入場方式:自由入場&lt;br /&gt;&amp;nbsp;&lt;br /&gt;演出團體&lt;br /&gt;豫章實業及豫章音樂教室、聲坊音樂教室，為推廣桃園地區之音樂教育，增加音樂學習人口，透過音樂發表會活動，不但能展現平日練習的成果，更能培養音樂欣賞興趣及內涵。期能用音樂豐富生活，提升桃園地區之人文藝術素養。&lt;br /&gt;&amp;nbsp;&lt;br /&gt;活動內容介紹&lt;br /&gt;以獨奏或合奏方式呈現古典鋼琴、流行爵士鋼琴、電子琴、小提琴、長笛、豎笛、吉他、烏克麗麗、爵士鼓&amp;hellip;等不同樂器之演出，各種室內樂團型態或流行熱門樂團的合奏帶給音樂更豐富的呈現。&lt;br /&gt;&amp;nbsp;&lt;br /&gt;主要演出人員&lt;br /&gt;山葉聲坊音樂教室全體成員&lt;br /&gt;&amp;nbsp;
     */

    private String postdate;
    private String liaisonemail;
    private Object file;
    private String activitytime;
    private String closedate;
    private String subject;
    private Object topdate;
    private String hostunit;
    private String liaisonfax;
    private String istop;
    private String liaisonper;
    private String activityplace;
    private String activityaddress;
    private String liaisontel;
    private int fsort;
    private Object link;
    private String datasourceunit;
    private int studyhour;
    private String joinunit;
    private String postunit;
    private String detailcontent;
    //private List<ImgBean> img;

    public String getPostdate() {
        return postdate;
    }

    public void setPostdate(String postdate) {
        this.postdate = postdate;
    }

    public String getLiaisonemail() {
        return liaisonemail;
    }

    public void setLiaisonemail(String liaisonemail) {
        this.liaisonemail = liaisonemail;
    }

    public Object getFile() {
        return file;
    }

    public void setFile(Object file) {
        this.file = file;
    }

    public String getActivitytime() {
        return activitytime;
    }

    public void setActivitytime(String activitytime) {
        this.activitytime = activitytime;
    }

    public String getClosedate() {
        return closedate;
    }

    public void setClosedate(String closedate) {
        this.closedate = closedate;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Object getTopdate() {
        return topdate;
    }

    public void setTopdate(Object topdate) {
        this.topdate = topdate;
    }

    public String getHostunit() {
        return hostunit;
    }

    public void setHostunit(String hostunit) {
        this.hostunit = hostunit;
    }

    public String getLiaisonfax() {
        return liaisonfax;
    }

    public void setLiaisonfax(String liaisonfax) {
        this.liaisonfax = liaisonfax;
    }

    public String getIstop() {
        return istop;
    }

    public void setIstop(String istop) {
        this.istop = istop;
    }

    public String getLiaisonper() {
        return liaisonper;
    }

    public void setLiaisonper(String liaisonper) {
        this.liaisonper = liaisonper;
    }

    public String getActivityplace() {
        return activityplace;
    }

    public void setActivityplace(String activityplace) {
        this.activityplace = activityplace;
    }

    public String getActivityaddress() {
        return activityaddress;
    }

    public void setActivityaddress(String activityaddress) {
        this.activityaddress = activityaddress;
    }

    public String getLiaisontel() {
        return liaisontel;
    }

    public void setLiaisontel(String liaisontel) {
        this.liaisontel = liaisontel;
    }

    public int getFsort() {
        return fsort;
    }

    public void setFsort(int fsort) {
        this.fsort = fsort;
    }

    public Object getLink() {
        return link;
    }

    public void setLink(Object link) {
        this.link = link;
    }

    public String getDatasourceunit() {
        return datasourceunit;
    }

    public void setDatasourceunit(String datasourceunit) {
        this.datasourceunit = datasourceunit;
    }

    public int getStudyhour() {
        return studyhour;
    }

    public void setStudyhour(int studyhour) {
        this.studyhour = studyhour;
    }

    public String getJoinunit() {
        return joinunit;
    }

    public void setJoinunit(String joinunit) {
        this.joinunit = joinunit;
    }

    public String getPostunit() {
        return postunit;
    }

    public void setPostunit(String postunit) {
        this.postunit = postunit;
    }

    public String getDetailcontent() {
        return detailcontent;
    }

    public void setDetailcontent(String detailcontent) {
        this.detailcontent = detailcontent;
    }

    /*public List<ImgBean> getImg() {
        return img;
    }

    public void setImg(List<ImgBean> img) {
        this.img = img;
    }

    /*public static class ImgBean implements Serializable {
        /**
         * imgcontent : <br>小<br>提<br>琴<br>
         * imgname : 122802.jpg
         * imgurl : http://www.tycg.gov.tw/uploaddowndoc?file=activityhot/201911121542190.jpg&filedisplay=201911121542190.jpg&flag=pic
         */

        /*private String imgcontent;
        private String imgname;
        private String imgurl;

        public String getImgcontent() {
            return imgcontent;
        }

        public void setImgcontent(String imgcontent) {
            this.imgcontent = imgcontent;
        }

        public String getImgname() {
            return imgname;
        }

        public void setImgname(String imgname) {
            this.imgname = imgname;
        }

        public String getImgurl() {
            return imgurl;
        }

        public void setImgurl(String imgurl) {
            this.imgurl = imgurl;
        }
    }*/

}
