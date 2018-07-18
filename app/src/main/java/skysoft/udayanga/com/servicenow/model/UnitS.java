package skysoft.udayanga.com.servicenow.model;

public class UnitS {
    private int sid, bid, fid;
    private String code, description;

    public UnitS() {
    }

    public UnitS(int sid, int bid, int fid, String code, String description) {

        this.sid = sid;
        this.bid = bid;
        this.fid = fid;
        this.code = code;
        this.description = description;
    }

    public int getSid() {

        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
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

    @Override
    public String toString() {
        return "UnitS{" +
                "sid=" + sid +
                ", bid=" + bid +
                ", fid=" + fid +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
