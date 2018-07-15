package skysoft.udayanga.com.servicenow.model;

public class Farmer {
    private int farmerId;
    private double lattitude;
    private double longitude;
    private boolean activated;
    private String password, userName, email, dob, city, address, gender, picUrl, nameWithInitial, fullName;
    private double contactNumber;

    public Farmer() {

    }

    public Farmer(int farmerId, double lattitude, double longitude,
                  boolean activated, String password, String userName, String email,
                  String dob, String city, String address, String gender, String picUrl,
                  String nameWithInitial, String fullName, double contactNumber) {
        this.farmerId = farmerId;
        this.lattitude = lattitude;
        this.longitude = longitude;
        this.activated = activated;
        this.password = password;
        this.userName = userName;
        this.email = email;
        this.dob = dob;
        this.city = city;
        this.address = address;
        this.gender = gender;
        this.picUrl = picUrl;
        this.nameWithInitial = nameWithInitial;
        this.fullName = fullName;
        this.contactNumber = contactNumber;
    }

    public int getFarmerId() {
        return farmerId;
    }

    public void setFarmerId(int farmerId) {
        this.farmerId = farmerId;
    }

    public double getLattitude() {
        return lattitude;
    }

    public void setLattitude(double lattitude) {
        this.lattitude = lattitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getNameWithInitial() {
        return nameWithInitial;
    }

    public void setNameWithInitial(String nameWithInitial) {
        this.nameWithInitial = nameWithInitial;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public double getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(double contactNumber) {
        this.contactNumber = contactNumber;
    }

    @Override
    public String toString() {
        return "Farmer{" +
                "farmerId=" + farmerId +
                ", lattitude=" + lattitude +
                ", longitude=" + longitude +
                ", activated=" + activated +
                ", password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", dob='" + dob + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", gender='" + gender + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", nameWithInitial='" + nameWithInitial + '\'' +
                ", fullName='" + fullName + '\'' +
                ", contactNumber=" + contactNumber +
                '}';
    }
}
