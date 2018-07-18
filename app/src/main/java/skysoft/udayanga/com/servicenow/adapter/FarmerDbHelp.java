package skysoft.udayanga.com.servicenow.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

import skysoft.udayanga.com.servicenow.model.Certification;
import skysoft.udayanga.com.servicenow.model.City;
import skysoft.udayanga.com.servicenow.model.Farmer;
import skysoft.udayanga.com.servicenow.model.UnitB;
import skysoft.udayanga.com.servicenow.model.UnitF;
import skysoft.udayanga.com.servicenow.model.UnitS;

public class FarmerDbHelp extends SQLiteOpenHelper {
    String TAG = "Farmer Db Help";
    private static final int databaseVersion = 1;
    private static final String databaseName = "sky_ics_mob";
    private static String tableNameFarmer = "farmer",
            tabelNameCertification = "certifications",
            tableNameCities = "citys",
            tableUnitB = "unit_b",
            tableUnitF = "unit_f",
            tableUnitS = "unit_c";


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

    private static final String keyCetId = "cer_id",
            keyCerName = "cert_name",
            keySysDate = "sys_dat_time";
    private static final String keyCountry = "country",
            keyCity = "city";

    private static final String
            keyCode = "code",
            keyDescription = "description";


    public FarmerDbHelp(Context context) {
        super(context, databaseName, null, databaseVersion);
    }

    private void addData() {

        Log.d(TAG, "Adding data to table");

        addCertificate(new Certification(1, "Bio Suisse", "2018-07-12 17:55:46", "System", 1));
        addCertificate(new Certification(2, "Conventional", "2018-07-12 17:55:46", "System", 1));
        addCertificate(new Certification(3, "Demeter", "2018-07-12 17:55:46", "System", 1));
        addCertificate(new Certification(4, "Ecological", "2018-07-12 17:55:46", "System", 1));
        addCertificate(new Certification(5, "FAIRTRADE", "2018-07-12 17:55:46", "System", 1));
        addCertificate(new Certification(6, "Inconversion", "2018-07-12 17:55:46", "System", 1));
        addCertificate(new Certification(7, "JAS", "2018-07-12 17:55:46", "System", 1));
        addCertificate(new Certification(9, "Naturland", "2018-07-12 17:55:46", "System", 1));
        addCertificate(new Certification(10, "Organic", "2018-07-12 17:55:46", "System", 1));
        addCertificate(new Certification(11, "USDA-NOP", "2018-07-12 17:55:46", "System", 1));
        addCertificate(new Certification(12, "UTZ", "2018-07-12 17:55:46", "System", 1));
        addCertificate(new Certification(20, "ESR", "2018-07-12 17:55:46", "System", 1));
        addCertificate(new Certification(20, "ESR", "2018-07-12 17:55:46", "System", 1));
        addCertificate(new Certification(21, "BSCI", "2018-07-12 17:55:46", "System", 1));
        addCertificate(new Certification(22, "GLOBALG.A.P", "2018-07-12 17:55:46", "System", 1));
        addCertificate(new Certification(23, "Organic - NEW", "2018-07-12 17:55:46", "System", 1));
        addCertificate(new Certification(24, "Organic - IC1", "2018-07-12 17:55:46", "System", 1));
        addCertificate(new Certification(25, "Organic - IC2", "2018-07-12 17:55:46", "System", 1));
        addCertificate(new Certification(26, "Organic - IC3", "2018-07-12 17:55:46", "System", 1));
        addCertificate(new Certification(27, "Bio Suisse - BS1", "2018-07-12 17:55:46", "System", 1));
        addCertificate(new Certification(28, "Bio Suisse - BS2", "2018-07-12 17:55:46", "System", 1));

        addCity(new City(1, "Sri Lanka", "Kandy"));
        addCity(new City(2, "Sri Lanka", "Colombo"));
        addCity(new City(3, "Sri Lanka", "Galle"));

        addUnitF(new UnitF(0, "Undefined", "Undefined"));
        addUnitF(new UnitF(2, "F2", "Central"));
        addUnitF(new UnitF(0, "F3", "Downsouth"));

        addUnitB(new UnitB(0, 0, "0", "0"));
        addUnitB(new UnitB(1, 1, "B1", "sesdfe"));
        addUnitB(new UnitB(0, 0, "B2", "SEE"));

        addUnitS(new UnitS(0, 0, 0, "0", "0"));
        addUnitS(new UnitS(1, 1, 1, "S1", "SSDFSES"));
        addUnitS(new UnitS(2, 1, 1, "S2", "SDF"));
        addUnitS(new UnitS(3, 2, 2, "S3", "SER"));
    }

    private String createTableCertification() {
        Log.d(TAG, "Creating Certification table");

        return "CREATE TABLE " + tabelNameCertification + " ( " +
                keyCetId + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                keyCerName + " TEXT DEFAULT NULL  ," +
                keySysDate + " DATETIME DEFAULT CURRENT_TIMESTAMP  , " +
                keyUser + " TEXT, " +
                keyActive + " INTEGER NOT NULL DEFAULT 1 ) ";
    }

    private void addCertificate(Certification certification) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(keyCetId, certification.getCerId());
        values.put(keyCerName, certification.getCerName());
        values.put(keySysDate, certification.getSysDateTime());
        values.put(keyUser, certification.getUser());
        values.put(keyActive, certification.isActive());
        database.insert(tabelNameCertification, null, values);
        database.close();
    }

    private String createTableCities() {
        Log.d(TAG, "Creating City table");

        return "CREATE TABLE " + tableNameCities + " ( " +
                keyCityId + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                keyCountry + " TEXT NOT NULL," +
                keyCity + " TEXT NOT NULL )";
    }

    private void addCity(City city) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(keyCityId, city.getCityID());
        values.put(keyCountry, city.getCountry());
        values.put(keyCity, city.getCity());
        database.insert(tableNameCities, null, values);
        database.close();
    }

    public ArrayList<City> getAllCities() {
        ArrayList<City> cities = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + tableNameCities;
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                City city = new City();
                city.setCityID(cursor.getInt(0));
                city.setCountry(cursor.getString(1));
                city.setCity(cursor.getString(2));

            } while (cursor.moveToNext());
        }
        return cities;
    }


    private String createTableUnitF() {
        //        sqLiteDatabase.execSQL(createTable);
        Log.d(TAG, "Creating Unit F table");

        return "CREATE TABLE " + tableUnitF + " ( " +
                keyFid + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT ," +
                keyCode + " TEXT NOT NULL," +
                keyDescription + " TEXT DEFAULT NULL )";
    }

    private void addUnitF(UnitF unitF) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(keyFid, unitF.getFid());
        values.put(keyCode, unitF.getCode());
        values.put(keyDescription, unitF.getDescription());
        database.insert(tableNameCities, null, values);
        database.close();
    }

    private String createTableUnitB() {
        Log.d(TAG, "Creating Unit B table");

        //        sqLiteDatabase.execSQL(createTable);
        return "CREATE TABLE " + tableUnitB + " ( " +
                keyBid + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                keyFid + " INTEGER NOT NULL," +
                keyCode + " TEXT NOT NULL," +
                keyDescription + " TEXT DEFAULT NULL ," +
                " FOREIGN KEY ( " + keyFid + " ) REFERENCES " + tableUnitF + " ( " + keyFid + "))";
    }

    private void addUnitB(UnitB unitB) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(keyBid, unitB.getBid());
        values.put(keyFid, unitB.getFid());
        values.put(keyCode, unitB.getCode());
        database.insert(tableNameCities, null, values);
        database.close();
    }


    private String createTableUnitS() {
        Log.d(TAG, "Creating Unit S table");

//        sqLiteDatabase.execSQL(createTable);
        return "CREATE TABLE " + tableUnitS + " ( " +
                keySid + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                keyBid + " INTEGER NOT NULL, " +
                keyFid + " INTEGER NOT NULL , " +
                keyCode + " TEXT NOT NULL , " +
                keyDescription + " TEXT DEFAULT NULL, " +
                " FOREIGN KEY ( " + keyFid + " ) REFERENCES " + tableUnitF + " ( " + keyFid + ")," +
                " FOREIGN KEY ( " + keyBid + " ) REFERENCES " + tableUnitB + " ( " + keyBid + "))";

    }

    private void addUnitS(UnitS unitS) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(keySid, unitS.getSid());
        values.put(keyBid, unitS.getBid());
        values.put(keyFid, unitS.getFid());
        values.put(keyCode, unitS.getCode());
        values.put(keyDescription, unitS.getDescription());

        database.insert(tableNameCities, null, values);
        database.close();
    }

    private String createTableFarmer() {

        Log.d(TAG, "Creating Farmer table");

        String createTable = "CREATE TABLE " + tableNameFarmer + " ( " +
                keyFarmerId + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT , " +
                keyFarmerCode + " TEXT NOT NULL, " +
                keyNameWithIni + " TEXT NOT NULL, " +
                keyFullName + " TEXT NOT NULL, " +
                keyFullNameLan1 + " TEXT DEFAULT NULL," +
                keyAddress + " TEXT DEFAULT NULL ," +
                keyAddressLan1 + " TEXT DEFAULT NULL," +
                keyCityId + " INTEGER NOT NULL," +
                keyGender + " TEXT NOT NULL," +
                keyEnrolledDate + " TEXT NOT NULL," +
                keyNicOrPassport + " TEXT DEFAULT NULL," +
                keyPhoneHome + " TEXT DEFAULT NULL," +
                keyPhoneMobile + " TEXT DEFAULT NULL," +
                keyRiskStatus + " TEXT DEFAULT 'Normal'," +
                keyActive + " INTEGER NOT NULL DEFAULT 1," +
                keyPerchaseActive + " INTEGER NOT NULL DEFAULT 0 ," +
                keyUser + " TEXT NOT NULL," +
                keyImage + " TEXT ," +
                keyFid + " INTEGER NOT NULL DEFAULT 0," +
                keyBid + " INTEGER NOT NULL DEFAULT 0," +
                keySid + " INTEGER NOT NULL DEFAULT 0," +
                keyFairtradeStatus + " INTEGER DEFAULT NULL," +
                keyRemark + " TEXT DEFAULT NULL," +
                keySanctioned + " INTEGER NOT NULL DEFAULT 0 ," +
                keySanctionedType + " INTEGER DEFAULT NULL," +
                keySanctionedRemarks + " TEXT DEFAULT NULL," +
                keySanctionedDate + " TEXT DEFAULT NULL," +
                keySanctionedBy + " TEXT DEFAULT NULL," +
                keySanctionedAudit + " TEXT DEFAULT NULL," +
                keyLock + " INTEGER DEFAULT 0 ," +
                " FOREIGN KEY ( " + keyBid + " ) REFERENCES " + tableUnitB + " ( " + keyBid + " ), " +
                " FOREIGN KEY ( " + keyFid + " ) REFERENCES " + tableUnitF + " ( " + keyFid + " ), " +
                " FOREIGN KEY ( " + keySid + " ) REFERENCES " + tableUnitS + " ( " + keySid + " )) ";


        return createTable;
    }

    private String setIncrementValueFarmer() {
        return "BEGIN TRANSACTION; " +
                " UPDATE sqlite_sequence SET seq = 500000 WHERE name = 'farmer';" +
                " INSERT INTO sqlite_sequence (name,seq) SELECT 'farmer', 500000 WHERE NOT EXISTS (SELECT changes() AS change FROM sqlite_sequence WHERE change <> 0);" +
                " COMMIT;";

    }

    private void addFaermer(Farmer farmer) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();


        database.insert(tableNameCities, null, values);
        database.close();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(createTableCertification());
        sqLiteDatabase.execSQL(createTableCities());
        sqLiteDatabase.execSQL(createTableUnitF());
        sqLiteDatabase.execSQL(createTableUnitB());
        sqLiteDatabase.execSQL(createTableUnitS());
        sqLiteDatabase.execSQL(createTableFarmer());
        sqLiteDatabase.execSQL(setIncrementValueFarmer());
        addData();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
