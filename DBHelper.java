package com.weebly.noctiseastern.androidstudioproject7;

import java.util.ArrayList;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "MyDBName.db";
    public static final String PLAYER_TABLE_NAME = "player";
    public static final String PLAYER_COLUMN_ID = "id";
    public static final String PLAYER_COLUMN_NAME = "name";
    public static final String PLAYER_COLUMN_PLAYER_ICON_ID = "player_icon_id";
    public static final String PLAYER_COLUMN_MONEY = "money";
    public DBHelper(Context context)
	   {
	      super(context, DATABASE_NAME , null, 1);
	   }
    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL("CREATE TABLE player " +
                        "(id integer primary key, name text, player_icon_id int, money int)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS player");
        onCreate(db);
    }

    public boolean insertPlayer (String name, int player_icon_id, int money)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("player_icon_id", player_icon_id);
        contentValues.put("money", money);
        db.insert("player", null, contentValues);
        return true;
    }

    public Cursor getData(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "SELECT * from player where id=" + id + "", null );
        return res;
    }

    public int numberOfRows() {
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, PLAYER_TABLE_NAME);
        return numRows;
    }

    public boolean updatePlayer (Integer id, String name, int player_icon_id, int money)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("player_icon_id", player_icon_id);
        contentValues.put("money", money);
        db.update("player", contentValues, "id = ? ", new String[] { Integer.toString(id) } );
        return true;
    }

    public Integer deletePlayer (Integer id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("player",
                "id = ? ",
                new String[] { Integer.toString(id) });
    }
    public ArrayList<String> getAllPlayer()
    {
        ArrayList<String> array_list = new ArrayList<String>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from player", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            String t=res.getString(res.getColumnIndex(PLAYER_COLUMN_ID))+". "+res.getString(res.getColumnIndex(PLAYER_COLUMN_NAME));
            array_list.add(t);
            res.moveToNext();
        }
        return array_list;
    }
}
