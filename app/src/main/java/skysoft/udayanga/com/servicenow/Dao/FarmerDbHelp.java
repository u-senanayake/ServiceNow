package skysoft.udayanga.com.servicenow.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import skysoft.udayanga.com.servicenow.model.Farmer;

public class FarmerDbHelp extends SQLiteOpenHelper {
    private static final int databaseVersion = 1;
    private static final String databaseName = "sky_ics_mob";
    private static String tableNameFarmer = "farmer";
    private static final String keyFarmerId = "farmer_ID",
            keyFarmerCode = "famer_code",
            keyNameWithIni = "name_wt_initials",
            keyFullName = "full_name",
            keyFullNameLan1 = "full_name_lan1",
            keyAddress = "address",
            keyAddressLan1 = "address_lan1",
            keyCityId = "cityID",
            keyGender = "gender",
            keyEnrolledDate = "enrolled_date",
            keyNicOrPassport = "nic_or_passport_no",
            keyPhoneHome = "phone_home",
            keyPhoneMobile = "phone_mobile",
            keyRiskStatus = "risk_status",
            keyActive = "active",
            keyPerchaseActive = "perchaseActive",
            keyUser = "user",
            keyImage = "image",
            keyFid = "fid",
            keyBid = "bid",
            keySid = "sid",
            keyFairtradeStatus = "fairtrade_status",
            keyRemark = "Remrks",
            keySanctioned = "sanctioned",
            keySanctionedType = "sanctioned_type",
            keySanctionedRemarks = "sanctioned_remarks",
            keySanctionedDate = "sanctioned_date",
            keySanctionedBy = "sanctioned_by",
            keySanctionedAudit = "sanctioned_Audit",
            keyLock = "lock";

    public FarmerDbHelp(Context context) {
        super(context, databaseName, null, databaseVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void addFarmer(Farmer farmer) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();

//        values.put(keyFarmerId, farmer.getFarmerId());
//        values.put(keyFarmerCode, farmer.getFarmerCode());
        values.put(keyNameWithIni, farmer.getNameInitial());
        values.put(keyFullName, farmer.getFullName());
        values.put(keyFullNameLan1, farmer.getFullNameLan1());
        values.put(keyAddress, farmer.getAddress());
        values.put(keyAddressLan1, farmer.getAddressLan1());
        values.put(keyCityId, farmer.getCity());
        values.put(keyGender, farmer.getGender());
        values.put(keyEnrolledDate, farmer.getEnrolledDate());
        values.put(keyNicOrPassport, farmer.getNicOrPassportNo());
        values.put(keyPhoneHome, farmer.getPhoneHome());
        values.put(keyPhoneMobile, farmer.getPhoneMobile());
        values.put(keyRiskStatus, farmer.getRiskStatus());
//        values.put(keyActive, farmer.isActive());
//        values.put(keyPerchaseActive, farmer.isPerchaseActive());
        values.put(keyUser, farmer.getUser());
        values.put(keyImage, farmer.getImgUrl());
        values.put(keyFid, farmer.getFid());
        values.put(keyBid, farmer.getBid());
        values.put(keySid, farmer.getSid());
        values.put(keyFairtradeStatus, farmer.isFairtradeStatus());
        values.put(keyRemark, farmer.getRemark());
//        values.put(keySanctioned, farmer.isSectioned());
//        values.put(keySanctionedType, farmer.getSectionedType());
//        values.put(keySanctionedRemarks, farmer.getSectionedRemark());
//        values.put(keySanctionedDate, farmer.getSectionedDate());
//        values.put(keySanctionedBy, farmer.getSectionedBy());
//        values.put(keySanctionedAudit, farmer.getSectionedAudit());
//        values.put(keyLock, farmer.isLocked());
        database.insert(tableNameFarmer, null, values);
        database.close();
    }

    public List<String> gteFarmerIds() {
        String selectQuery = "SELECT  * FROM " + tableNameFarmer;
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        List<String> ids = new ArrayList<String>();
        int i = 0;
        while (cursor.moveToNext()) {
            ids.add(cursor.getString(cursor.getColumnIndex(keyFarmerId)));
            i++;
        }
        return ids;
    }

    public Farmer getById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(tableNameFarmer, new String[]{
                        keyFarmerId,//0
                        keyFarmerCode,//1
                        keyNameWithIni,//2
                        keyFullName,//3
                        keyFullNameLan1,//4
                        keyAddress,//5
                        keyAddressLan1,//6
                        keyCityId,//7
                        keyGender,//8
                        keyEnrolledDate,//9
                        keyNicOrPassport,//10
                        keyPhoneHome,//11
                        keyPhoneMobile,//12
                        keyRiskStatus,//13
                        keyActive,//14
                        keyPerchaseActive,//15
                        keyUser, //16
                        keyImage,//17
                        keyFid,//18
                        keyBid,//19
                        keySid,//20
                        keyFairtradeStatus,//21
                        keyRemark,//22
                        keySanctioned,//23
                        keySanctionedType,//24
                        keySanctionedRemarks,//25
                        keySanctionedDate,//26
                        keySanctionedBy,//27
                        keySanctionedAudit,//28
                        keyLock//29
                }, keyFarmerId + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        Farmer farmer = new Farmer();
        farmer.setFarmerId(Integer.parseInt(cursor.getString(0)));
        farmer.setFarmerCode(cursor.getString(1));
        farmer.setNameInitial(cursor.getString(2));
        farmer.setFullName(cursor.getString(3));
        farmer.setFullNameLan1(cursor.getString(4));
        farmer.setAddress(cursor.getString(5));
        farmer.setAddressLan1(cursor.getString(6));
        farmer.setCity(Integer.parseInt(cursor.getString(7)));
        farmer.setGender(cursor.getString(8));
        farmer.setEnrolledDate(cursor.getString(9));
        farmer.setNicOrPassportNo(cursor.getString(10));
        farmer.setPhoneHome(cursor.getString(11));
        farmer.setPhoneMobile(cursor.getString(12));
        farmer.setRiskStatus(cursor.getString(13));
        farmer.setActive(Integer.parseInt(cursor.getString(14)));
        farmer.setPerchaseActive(Integer.parseInt(cursor.getString(15)));
        farmer.setUser(cursor.getString(16));
        farmer.setImgUrl(cursor.getString(17));
        if (cursor.getString(18) != null) {
            farmer.setFid(Integer.parseInt(cursor.getString(18)));
        } else {
            farmer.setFid(0);
        }
        if (cursor.getString(19) != null) {
            farmer.setBid(Integer.parseInt(cursor.getString(19)));
        } else {
            farmer.setBid(0);
        }
        if (cursor.getString(20) != null) {
            farmer.setSid(Integer.parseInt(cursor.getString(20)));
        } else {
            farmer.setSid(0);
        }
        farmer.setFairtradeStatus(cursor.getString(21));
        farmer.setRemark(cursor.getString(22));
        if (cursor.getString(23) != null) {
            farmer.setSectioned(Integer.parseInt(cursor.getString(23)));
        } else {
            farmer.setSectioned(0);
        }
        if (cursor.getString(24) != null) {
            farmer.setSectionedType(Integer.parseInt(cursor.getString(24)));
        } else {
            farmer.setSectionedType(0);
        }
        farmer.setSectionedRemark(cursor.getString(25));
        farmer.setSectionedDate(cursor.getString(25));
        farmer.setSectionedBy(cursor.getString(27));
        farmer.setSectionedAudit(cursor.getString(28));
        if (cursor.getString(29) != null) {
            farmer.setActive(Integer.parseInt(cursor.getString(29)));
        } else {
            farmer.setActive(1);
        }

        return farmer;
    }
}
