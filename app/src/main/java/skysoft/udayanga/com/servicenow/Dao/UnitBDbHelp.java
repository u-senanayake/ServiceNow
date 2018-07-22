package skysoft.udayanga.com.servicenow.Dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import skysoft.udayanga.com.servicenow.model.UnitB;
import skysoft.udayanga.com.servicenow.model.UnitF;

public class UnitBDbHelp extends SQLiteOpenHelper {
    private static final int databaseVersion = 1;
    private static final String databaseName = "sky_ics_mob";
    private static String tableUnitB = "unit_b";
    private static String keyBid = "bid", keyCode = "code",
            keyDescription = "description", keyFid = "fid";

    public UnitBDbHelp(Context context) {
        super(context, databaseName, null, databaseVersion);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public ArrayList<UnitF> getAllUnitFByFid(int fid) {
        ArrayList<UnitF> unitBS = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + tableUnitB +" where "+ keyFid + " = " + fid  ;
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                UnitB unitB = new UnitB();
                unitB.setBid(cursor.getInt(0));
                unitB.setFid(cursor.getInt(1));
                unitB.setCode(cursor.getString(2));
                unitB.setDescription(cursor.getString(3));

            } while (cursor.moveToNext());
        }
        return unitBS;
    }

    public List<String> getUnitBIdsByFid(int fid) {

        String selectQuery = "SELECT  * FROM " + tableUnitB +" where "+ keyFid + " = " + fid ;
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        List<String> ids = new ArrayList<String>();
        int i = 0;
        while (cursor.moveToNext()) {
            ids.add(cursor.getString(cursor.getColumnIndex(keyBid)));
            i++;
        }
        return ids;
    }

    public List<String> getUnitFCodesByFid(int fid) {

        String selectQuery = "SELECT  * FROM " + tableUnitB +" where "+ keyFid + " = " + fid ;
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
