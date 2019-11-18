package nullteam.com.doway.model;

import java.io.Serializable;

public class Restaurant implements Serializable {
    /**
     * OPEN API :  https://data.gov.tw/dataset/7778
     * ID : 01_100
     * Name : 湖莓宴餐坊
     * Address : 苗栗縣大湖鄉富興村八寮彎2-7號4樓
     * Tel : 037-995677
     * HostWords : 湖苺宴開在大湖酒莊的4樓，是大湖地區農會經營的田媽媽餐坊，但是不同於一般田園風格的田媽媽主題餐廳，主打草莓創意料理的湖苺宴，裝潢、菜色都充滿年輕想法，一群六年級中段班的田媽媽，把她們對草莓的奇思異想，充份發揮在料理上。
     餐廳所供的菜色會依季節不同做更換，皆以套餐為主，在草莓產季菜單有德國烤豬腳酌草莓醋酸菜、草莓魚排酌草莓酸辣醬等，另外，這裡的意大利麵可是別處吃不到的哦！因為田媽媽們在麵條中加入了草莓，遊客吃了會有驚豔之感哦！
     若是水梨產季，則推出水梨風味套餐，其中「水梨磨菇里肌肉餐」餐點以新鮮的水梨加上鮮嫩多汁的里肌肉以燴飯的方式呈現，讓您吃到水果的鮮甜及富有彈性的里肌肉，多層次的口感保證讓您回味無窮。
     * Price :
     * OpenHours :
     * CreditCard : True
     * TravelCard : True
     * TrafficGuidelines :
     * ParkingLot :
     * Url :
     * Email :
     * BlogUrl :
     * PetNotice :
     * Reminder :
     * FoodMonths :
     * FoodCapacity :
     * FoodFeature : 湖苺宴開在大湖酒莊的4樓，是大湖地區農會經營的田媽媽餐坊，但是不同於一般田園風格的田媽媽主題餐廳，主打草莓創意料理的湖苺宴，裝潢、菜色都充滿年輕想法，一群六年級中段班的田媽媽，把她們對草莓的奇思異想，充份發揮在料理上。
     餐廳所供的菜色會依季節不同做更換，皆以套餐為主，在草莓產季菜單有德國烤豬腳酌草莓醋酸菜、草莓魚排酌草莓酸辣醬等，另外，這裡的意大利麵可是別處吃不到的哦！因為田媽媽們在麵條中加入了草莓，遊客吃了會有驚豔之感哦！
     若是水梨產季，則推出水梨風味套餐，其中「水梨磨菇里肌肉餐」餐點以新鮮的水梨加上鮮嫩多汁的里肌肉以燴飯的方式呈現，讓您吃到水果的鮮甜及富有彈性的里肌肉，多層次的口感保證讓您回味無窮。
     * City : 苗栗縣
     * Town : 大湖鄉
     * Coordinate : 24.4402288,120.876103
     * PicURL : https://ezgo.coa.gov.tw/Uploads/opendata/TainmaMain01/APPLY_D/20151007173924.jpg
     */

    private String ID;
    private String Name;
    private String Address;
    private String Tel;
    private String HostWords;
    private String Price;
    private String OpenHours;
    private String CreditCard;
    private String TravelCard;
    private String TrafficGuidelines;
    private String ParkingLot;
    private String Url;
    private String Email;
    private String BlogUrl;
    private String PetNotice;
    private String Reminder;
    private String FoodMonths;
    private String FoodCapacity;
    private String FoodFeature;
    private String City;
    private String Town;
    private String Coordinate;
    private String PicURL;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String Tel) {
        this.Tel = Tel;
    }

    public String getHostWords() {
        return HostWords;
    }

    public void setHostWords(String HostWords) {
        this.HostWords = HostWords;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String Price) {
        this.Price = Price;
    }

    public String getOpenHours() {
        return OpenHours;
    }

    public void setOpenHours(String OpenHours) {
        this.OpenHours = OpenHours;
    }

    public String getCreditCard() {
        return CreditCard;
    }

    public void setCreditCard(String CreditCard) {
        this.CreditCard = CreditCard;
    }

    public String getTravelCard() {
        return TravelCard;
    }

    public void setTravelCard(String TravelCard) {
        this.TravelCard = TravelCard;
    }

    public String getTrafficGuidelines() {
        return TrafficGuidelines;
    }

    public void setTrafficGuidelines(String TrafficGuidelines) {
        this.TrafficGuidelines = TrafficGuidelines;
    }

    public String getParkingLot() {
        return ParkingLot;
    }

    public void setParkingLot(String ParkingLot) {
        this.ParkingLot = ParkingLot;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String Url) {
        this.Url = Url;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getBlogUrl() {
        return BlogUrl;
    }

    public void setBlogUrl(String BlogUrl) {
        this.BlogUrl = BlogUrl;
    }

    public String getPetNotice() {
        return PetNotice;
    }

    public void setPetNotice(String PetNotice) {
        this.PetNotice = PetNotice;
    }

    public String getReminder() {
        return Reminder;
    }

    public void setReminder(String Reminder) {
        this.Reminder = Reminder;
    }

    public String getFoodMonths() {
        return FoodMonths;
    }

    public void setFoodMonths(String FoodMonths) {
        this.FoodMonths = FoodMonths;
    }

    public String getFoodCapacity() {
        return FoodCapacity;
    }

    public void setFoodCapacity(String FoodCapacity) {
        this.FoodCapacity = FoodCapacity;
    }

    public String getFoodFeature() {
        return FoodFeature;
    }

    public void setFoodFeature(String FoodFeature) {
        this.FoodFeature = FoodFeature;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getTown() {
        return Town;
    }

    public void setTown(String Town) {
        this.Town = Town;
    }

    public String getCoordinate() {
        return Coordinate;
    }

    public void setCoordinate(String Coordinate) {
        this.Coordinate = Coordinate;
    }

    public String getPicURL() {
        return PicURL;
    }

    public void setPicURL(String PicURL) {
        this.PicURL = PicURL;
    }
}
