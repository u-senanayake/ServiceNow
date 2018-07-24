package skysoft.udayanga.com.servicenow.model;

public class Farmer {
    private int farmerId;//above 500000
    private String farmerCode;//not generate in app
    private String nameInitial;
    private String fullName;
    private String fullNameLan1;
    private String address;
    private String addressLan1;
    private int city;
    private String gender;
    private String enrolledDate;
    private String nicOrPassportNo;
    private String phoneHome;
    private String phoneMobile;
    private String riskStatus;
    private int  active;
    private int perchaseActive;
    private String user;
    private String imgUrl;
    private int fid;
    private int bid;
    private int sid;
    private String fairtradeStatus;
    private String remark;
    private int sectioned;
    private int sectionedType;
    private String sectionedRemark;
    private String sectionedDate;
    private String sectionedBy;
    private String sectionedAudit;
    private int locked;

    public Farmer() {
    }

    public Farmer(int farmerId, String farmerCode, String nameInitial, String fullName, String fullNameLan1,
                  String address, String addressLan1, int city, String gender, String enrolledDate,
                  String nicOrPassportNo, String phoneHome, String phoneMobile, String riskStatus, int active,
                  int perchaseActive, String user, String imgUrl, int fid, int bid, int sid,
                  String fairtradeStatus, String remark, int sectioned, int sectionedType, String sectionedRemark,
                  String sectionedDate, String sectionedBy, String sectionedAudit, int locked) {
        this.farmerId = farmerId;
        this.farmerCode = farmerCode;
        this.nameInitial = nameInitial;
        this.fullName = fullName;
        this.fullNameLan1 = fullNameLan1;
        this.address = address;
        this.addressLan1 = addressLan1;
        this.city = city;
        this.gender = gender;
        this.enrolledDate = enrolledDate;
        this.nicOrPassportNo = nicOrPassportNo;
        this.phoneHome = phoneHome;
        this.phoneMobile = phoneMobile;
        this.riskStatus = riskStatus;
        this.active = active;
        this.perchaseActive = perchaseActive;
        this.user = user;
        this.imgUrl = imgUrl;
        this.fid = fid;
        this.bid = bid;
        this.sid = sid;
        this.fairtradeStatus = fairtradeStatus;
        this.remark = remark;
        this.sectioned = sectioned;
        this.sectionedType = sectionedType;
        this.sectionedRemark = sectionedRemark;
        this.sectionedDate = sectionedDate;
        this.sectionedBy = sectionedBy;
        this.sectionedAudit = sectionedAudit;
        this.locked = locked;
    }

    public Farmer(String nameInitial, String fullName, String fullNameLan1, String address,
                  String addressLan1, int city, String gender, String enrolledDate, String nicOrPassportNo,
                  String phoneHome, String phoneMobile, String riskStatus,
                  String user, String imgUrl, int fid, int bid, int sid, String fairtradeStatus, String remark) {
        this.nameInitial = nameInitial;
        this.fullName = fullName;
        this.fullNameLan1 = fullNameLan1;
        this.address = address;
        this.addressLan1 = addressLan1;
        this.city = city;
        this.gender = gender;
        this.enrolledDate = enrolledDate;
        this.nicOrPassportNo = nicOrPassportNo;
        this.phoneHome = phoneHome;
        this.phoneMobile = phoneMobile;
        this.riskStatus = riskStatus;
        this.user = user;
        this.imgUrl = imgUrl;
        this.fid = fid;
        this.bid = bid;
        this.sid = sid;
        this.fairtradeStatus = fairtradeStatus;
        this.remark = remark;
    }

    public int getFarmerId() {
        return farmerId;
    }

    public void setFarmerId(int farmerId) {
        this.farmerId = farmerId;
    }

    public String getFarmerCode() {
        return farmerCode;
    }

    public void setFarmerCode(String farmerCode) {
        this.farmerCode = farmerCode;
    }

    public String getNameInitial() {
        return nameInitial;
    }

    public void setNameInitial(String nameInitial) {
        this.nameInitial = nameInitial;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFullNameLan1() {
        return fullNameLan1;
    }

    public void setFullNameLan1(String fullNameLan1) {
        this.fullNameLan1 = fullNameLan1;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressLan1() {
        return addressLan1;
    }

    public void setAddressLan1(String addressLan1) {
        this.addressLan1 = addressLan1;
    }

    public int getCity() {
        return city;
    }

    public void setCity(int city) {
        this.city = city;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEnrolledDate() {
        return enrolledDate;
    }

    public void setEnrolledDate(String enrolledDate) {
        this.enrolledDate = enrolledDate;
    }

    public String getNicOrPassportNo() {
        return nicOrPassportNo;
    }

    public void setNicOrPassportNo(String nicOrPassportNo) {
        this.nicOrPassportNo = nicOrPassportNo;
    }

    public String getPhoneHome() {
        return phoneHome;
    }

    public void setPhoneHome(String phoneHome) {
        this.phoneHome = phoneHome;
    }

    public String getPhoneMobile() {
        return phoneMobile;
    }

    public void setPhoneMobile(String phoneMobile) {
        this.phoneMobile = phoneMobile;
    }

    public String getRiskStatus() {
        return riskStatus;
    }

    public void setRiskStatus(String riskStatus) {
        this.riskStatus = riskStatus;
    }

    public int isActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public int isPerchaseActive() {
        return perchaseActive;
    }

    public void setPerchaseActive(int perchaseActive) {
        this.perchaseActive = perchaseActive;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String isFairtradeStatus() {
        return fairtradeStatus;
    }

    public void setFairtradeStatus(String fairtradeStatus) {
        this.fairtradeStatus = fairtradeStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int isSectioned() {
        return sectioned;
    }

    public void setSectioned(int sectioned) {
        this.sectioned = sectioned;
    }

    public int getSectionedType() {
        return sectionedType;
    }

    public void setSectionedType(int sectionedType) {
        this.sectionedType = sectionedType;
    }

    public String getSectionedRemark() {
        return sectionedRemark;
    }

    public void setSectionedRemark(String sectionedRemark) {
        this.sectionedRemark = sectionedRemark;
    }

    public String getSectionedDate() {
        return sectionedDate;
    }

    public void setSectionedDate(String sectionedDate) {
        this.sectionedDate = sectionedDate;
    }

    public String getSectionedBy() {
        return sectionedBy;
    }

    public void setSectionedBy(String sectionedBy) {
        this.sectionedBy = sectionedBy;
    }

    public String getSectionedAudit() {
        return sectionedAudit;
    }

    public void setSectionedAudit(String sectionedAudit) {
        this.sectionedAudit = sectionedAudit;
    }

    public int isLocked() {
        return locked;
    }

    public void setLocked(int locked) {
        this.locked = locked;
    }

    @Override
    public String toString() {
        return "Farmer{" +
                "farmerId=" + farmerId +
                ", farmerCode='" + farmerCode + '\'' +
                ", nameInitial='" + nameInitial + '\'' +
                ", fullName='" + fullName + '\'' +
                ", fullNameLan1='" + fullNameLan1 + '\'' +
                ", address='" + address + '\'' +
                ", addressLan1='" + addressLan1 + '\'' +
                ", city='" + city + '\'' +
                ", gender='" + gender + '\'' +
                ", enrolledDate='" + enrolledDate + '\'' +
                ", nicOrPassportNo='" + nicOrPassportNo + '\'' +
                ", phoneHome='" + phoneHome + '\'' +
                ", phoneMobile='" + phoneMobile + '\'' +
                ", riskStatus='" + riskStatus + '\'' +
                ", active=" + active +
                ", perchaseActive=" + perchaseActive +
                ", user='" + user + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", fid=" + fid +
                ", bid=" + bid +
                ", sid=" + sid +
                ", fairtradeStatus=" + fairtradeStatus +
                ", remark='" + remark + '\'' +
                ", sectioned=" + sectioned +
                ", sectionedType=" + sectionedType +
                ", sectionedRemark='" + sectionedRemark + '\'' +
                ", sectionedDate='" + sectionedDate + '\'' +
                ", sectionedBy='" + sectionedBy + '\'' +
                ", sectionedAudit='" + sectionedAudit + '\'' +
                ", locked=" + locked +
                '}';
    }
}
