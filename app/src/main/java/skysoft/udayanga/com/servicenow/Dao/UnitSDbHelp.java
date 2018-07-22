package skysoft.udayanga.com.servicenow.Dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import skysoft.udayanga.com.servicenow.model.UnitS;

public class UnitSDbHelp extends SQLiteOpenHelper {
    private static final int databaseVersion = 1;
    private static final String databaseName = "sky_ics_mob";
    private static String tableUnitS = "unit_c";
    private static String keyBid = "bid", keyCode = "code",
            keyDescription = "description", keyFid = "fid", keySid = "sid";

    public UnitSDbHelp(Context context) {
        super(context, databaseName, null, databaseVersion);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public ArrayList<UnitS> getAllUnitSByFidByBid(int fid, int bid) {
        ArrayList<UnitS> unitSList = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + tableUnitS + " where " + keyFid + " = " + fid + " and " + keySid + " = " + bid;
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                UnitS unitS = new UnitS();
                unitS.setBid(cursor.getInt(0));
                unitS.setFid(cursor.getInt(1));
                unitS.setSid(cursor.getInt(2));
                unitS.setCode(cursor.getString(3));
                unitS.setDescription(cursor.getString(4));

            } while (cursor.moveToNext());
        }
        return unitSList;
    }

    public List<String> getUnitSIdsByFidByBid(int fid, int bid) {

        String selectQuery = "SELECT  * FROM " + tableUnitS + " where " + keyFid + " = " + fid + " and " + keySid + " = " + bid;
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        List<String> ids = new ArrayList<String>();
        int i = 0;
        while (cursor.moveToNext()) {
            ids.add(cursor.getString(cursor.getColumnIndex(keySid)));
            i++;
        }
        return ids;
    }

    public List<String> getUnitSCodesByFidByBid(int fid, int bid) {

        String selectQuery = "SELECT  * FROM " + tableUnitS + " where " + keyFid + " = " + fid + " and " + keySid + " = " + bid;
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        List<String> codes = new ArrayList<String>();
        int i = 0;
        while (cursor.moveToNext()) {
            codes.add(cursor.getString(cursor.getColumnIndex(keyCode)));
            i++;
        }
        return codes;
    }
}
