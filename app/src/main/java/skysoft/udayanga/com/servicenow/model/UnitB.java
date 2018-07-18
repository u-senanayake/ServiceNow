package skysoft.udayanga.com.servicenow.model;

public class UnitB {
    private int bid;
    private int fid;
    private String code;
    private String description;

    @Override
    public String toString() {
        return "UnitB{" +
                "bid=" + bid +
                ", fid=" + fid +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UnitB(int bid, int fid, String code, String description) {

        this.bid = bid;
        this.fid = fid;
        this.code = code;
        this.description = description;
    }

    public UnitB() {

    }
}
