package nullteam.com.doway.model;

import java.io.Serializable;

public class Hotel implements Serializable {

    /**
     * API URL : https://data.tycg.gov.tw/api/v1/rest/datastore/c3340a19-9219-498a-9a46-21de506ba85b?format=json
     * Website : http://www.monarch-hotels.com.tw/
     * Changetime : 2019/11/01 11:15:23
     * Fax : 886-3-3179000
     * Opentime : 無
     * Tel : 886-3-3169900
     * Name : 尊爵大飯店
     * Px : 121.29780
     * Py : 25.02451
     * Toldescribe : 面對世界的平台，桃園儼然成為台灣邁向世界的起點。身為國家門戶，桃園啟動全力，投入十二重要建設，積極發展交通、觀光文化等產業建設，緊密的結合時代脈動並全面勾勒出桃園一國際大都會格局，在國內多位重量級企業領袖紛紛入主桃園，共同成就這片美麗土地的蓬勃面貌。尊爵大飯店以前瞻性的眼光，立足桃園、在地深耕；以世界的視野來考量自己所扮演的角色，肩負起台灣對外發聲的第一線使命，不斷挑戰無限可能，創造超越國界的人文價值。&nbsp;飯店位置：鄰近桃園國際機場與南崁交流道，座落於桃園市桃園區，為桃園區第一家全功能的國際飯店。來往交通：距離桃園國際機場15公里，車程約20分鐘。距離高鐵(桃園青埔站)，車程約15分鐘。距離桃園區中心3公里，車程約5分鐘。距離南崁交流道，車程約5分鐘。&nbsp;停車資訊: B1-B2附設停車場
     * Charge : 6300 ~ 19000
     * InfoId : 74
     * Zipcode : 330
     * Add : 330 桃園市桃園區莊敬路一段300號
     * Remarks :
     * _id : 1
     * Parkinginfo : 附設停車場
     * TYWebsite : travel.tycg.gov.tw/zh-tw/Accommodation/Detail/74
     */

    private String Website;
    private String Changetime;
    private String Fax;
    private String Opentime;
    private String Tel;
    private String Name;
    private String Px;
    private String Py;
    private String Toldescribe;
    private String Charge;
    private String InfoId;
    private String Zipcode;
    private String Add;
    private String Remarks;
    private int _id;
    private String Parkinginfo;
    private String TYWebsite;

    public String getWebsite() {
        return Website;
    }

    public void setWebsite(String Website) {
        this.Website = Website;
    }

    public String getChangetime() {
        return Changetime;
    }

    public void setChangetime(String Changetime) {
        this.Changetime = Changetime;
    }

    public String getFax() {
        return Fax;
    }

    public void setFax(String Fax) {
        this.Fax = Fax;
    }

    public String getOpentime() {
        return Opentime;
    }

    public void setOpentime(String Opentime) {
        this.Opentime = Opentime;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String Tel) {
        this.Tel = Tel;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getPx() {
        return Px;
    }

    public void setPx(String Px) {
        this.Px = Px;
    }

    public String getPy() {
        return Py;
    }

    public void setPy(String Py) {
        this.Py = Py;
    }

    public String getToldescribe() {
        return Toldescribe;
    }

    public void setToldescribe(String Toldescribe) {
        this.Toldescribe = Toldescribe;
    }

    public String getCharge() {
        return Charge;
    }

    public void setCharge(String Charge) {
        this.Charge = Charge;
    }

    public String getInfoId() {
        return InfoId;
    }

    public void setInfoId(String InfoId) {
        this.InfoId = InfoId;
    }

    public String getZipcode() {
        return Zipcode;
    }

    public void setZipcode(String Zipcode) {
        this.Zipcode = Zipcode;
    }

    public String getAdd() {
        return Add;
    }

    public void setAdd(String Add) {
        this.Add = Add;
    }

    public String getRemarks() {
        return Remarks;
    }

    public void setRemarks(String Remarks) {
        this.Remarks = Remarks;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getParkinginfo() {
        return Parkinginfo;
    }

    public void setParkinginfo(String Parkinginfo) {
        this.Parkinginfo = Parkinginfo;
    }

    public String getTYWebsite() {
        return TYWebsite;
    }

    public void setTYWebsite(String TYWebsite) {
        this.TYWebsite = TYWebsite;
    }
}
