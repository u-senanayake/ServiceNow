package skysoft.udayanga.com.servicenow.model;

public class UnitF {
    private int fid;
    private String code;
    private String description;

    public UnitF() {
    }

    public UnitF(int fid, String code, String description) {

        this.fid = fid;
        this.code = code;
        this.description = description;
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
        return "UnitF{" +
                "fid=" + fid +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
