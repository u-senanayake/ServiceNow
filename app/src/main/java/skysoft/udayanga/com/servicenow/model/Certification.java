package skysoft.udayanga.com.servicenow.model;

public class Certification {
    private int cerId;
    private String cerName;
    private String sysDateTime;
    private String user;
    private int active;

    public Certification() {
    }

    public Certification(int cerId, String cerName, String sysDateTime, String user, int active) {
        this.cerId = cerId;
        this.cerName = cerName;
        this.sysDateTime = sysDateTime;
        this.user = user;
        this.active = active;
    }

    public int getCerId() {
        return cerId;
    }

    public void setCerId(int cerId) {
        this.cerId = cerId;
    }

    public String getCerName() {
        return cerName;
    }

    public void setCerName(String cerName) {
        this.cerName = cerName;
    }

    public String getSysDateTime() {
        return sysDateTime;
    }

    public void setSysDateTime(String sysDateTime) {
        this.sysDateTime = sysDateTime;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int  isActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Certification{" +
                "cerId=" + cerId +
                ", cerName='" + cerName + '\'' +
                ", sysDateTime='" + sysDateTime + '\'' +
                ", user='" + user + '\'' +
                ", active=" + active +
                '}';
    }
}
