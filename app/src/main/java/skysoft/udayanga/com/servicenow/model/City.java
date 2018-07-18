package skysoft.udayanga.com.servicenow.model;

public class City {
    private int cityID;
    private String country;
    private String city;

    public City() {
    }

    public City(int cityID, String country, String city) {
        this.cityID = cityID;
        this.country = country;
        this.city = city;
    }

    public int getCityID() {
        return cityID;
    }

    public void setCityID(int cityID) {
        this.cityID = cityID;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "City{" +
                "cityID=" + cityID +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
