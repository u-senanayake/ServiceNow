package skysoft.udayanga.com.servicenow.Dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import skysoft.udayanga.com.servicenow.model.UnitF;

public class UnitFDbHelp extends SQLiteOpenHelper {
    private static final int databaseVersion = 1;
    private static final String databaseName = "sky_ics_mob";
    private static String tableUnitF = "unit_f";
    private static String keyFid = "fid", keyCode = "code",
            keyDescription = "description";


    public UnitFDbHelp(Context context) {
        super(context, databaseName, null, databaseVersion);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public ArrayList<UnitF> getAllUnitF() {
        ArrayList<UnitF> unitFS = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + tableUnitF;
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                UnitF unitF = new UnitF();
                unitF.setFid(cursor.getInt(0));
                unitF.setCode(cursor.getString(1));
                unitF.setDescription(cursor.getString(2));

            } while (cursor.moveToNext());
        }
        return unitFS;
    }

    public List<String> getUnitFIds(){

        String selectQuery = "SELECT  * FROM " + tableUnitF ;
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        List<String> ids= new ArrayList<String>();
        int i = 0;
        while (cursor.moveToNext()) {
            ids.add(cursor.getString(cursor.getColumnIndex(keyFid)));
            i++;
        }
        return ids;
    }
    public List<String> getUnitFCodes(){

        String selectQuery = "SELECT  * FROM " + tableUnitF ;
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        List<String> codes= new ArrayList<String>();
        int i = 0;
        while (cursor.moveToNext()) {
            codes.add(cursor.getString(cursor.getColumnIndex(keyCode)));
            i++;
        }
        return codes;
    }

}
