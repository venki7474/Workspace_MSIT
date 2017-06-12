package com.example.chotu.secretnotes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Chotu on 2/6/2016.
 */
public class MyNoteDB extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "AllNotes.db";
    public static final String TABLE_NOTES = "Notes";
    public static final String COLUMN_TITLE = "_noteTitle";
    public static final String COLUMN_NOTECONTENT="_noteContent";
    public static final String TABLE_USER = "PasswordTable";
    public static final String USER_PASSWORD = "Password";

    public MyNoteDB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE "+ TABLE_NOTES + "( " +
                COLUMN_TITLE + " TEXT ," +
                COLUMN_NOTECONTENT + " TEXT " +
                ");";
        db.execSQL(query);

        String query2 = "CREATE TABLE " + TABLE_USER + "( " +
                USER_PASSWORD + " NUMBER" +
                ");";
        db.execSQL(query2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NOTES);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        onCreate(db);
    }

    //// adding into the database
    public void createNote(Note note){
        ContentValues values = new ContentValues();
        values.put(COLUMN_TITLE, note.getNoteTitle());
        values.put(COLUMN_NOTECONTENT, note.getNoteContent());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_NOTES, null, values);
        System.out.println("venki");

        db.close();
    }

    public void createUser(String pswdStr){
        int input = Integer.parseInt(pswdStr);
        ContentValues values = new ContentValues();
        values.put(USER_PASSWORD, input);
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_USER, null, values);
        db.close();
    }
    public boolean check_for_user() {
        SQLiteDatabase db  = getReadableDatabase();
        String query = "SELECT * FROM PasswordTable;";
        int count = db.rawQuery(query,null).getCount();
        if (count == 0){
            return true;
        } else {
            return false;
        }
    }
    public boolean loginCheck(String pin){
        SQLiteDatabase db  = getReadableDatabase();
        String query = "SELECT * FROM PasswordTable";
        Cursor c = db.rawQuery(query, null);
        if (c.moveToFirst()) {
            do {
                if (c.getString(c.getColumnIndex("Password")) != null) {
                    if (c.getString(c.getColumnIndex("Password")).equals(pin)) {
                        return true;
                    }
                }
            } while (c.moveToFirst());
        }
        return false;
    }

    public ArrayList<String> databaseToString() {
//        String dbString = "";
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM "+ TABLE_NOTES +" WHERE 1 = 1" ;
        // CURSOR POINTS TO THE location in ur result

        Cursor c = db.rawQuery(query, null);
        ArrayList<String> list = new ArrayList<String>();
        if (c.moveToFirst()) {
            do {
                // get the data into array, or class variable
//                System.out.println("its venki output1");
                if(c.getString(c.getColumnIndex("_noteTitle")) != null) {
//                    dbString += c.getString(c.getColumnIndex("_noteContent"));
//                    dbString += "\n";
                    list.add(c.getString(c.getColumnIndex("_noteTitle")));
                }
            } while (c.moveToNext());
        }
        c.close();
        db.close();
//        System.out.println("its venki output2");
        return list;
    }

    public String getDetails(String title){
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM "+TABLE_NOTES+" WHERE _noteTitle = \""+ title + "\";";
        Cursor c = db.rawQuery(query, null);
        String dbStr = "";
        if (c.moveToFirst()){
            do {
                if (c.getString(c.getColumnIndex("_noteContent")) != null) {
                    dbStr = dbStr + c.getString(c.getColumnIndex("_noteContent"));
                }
            } while(c.moveToNext());
        }
        return dbStr;
    }

    public void deleteNote(String title){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NOTES + " WHERE " + COLUMN_TITLE + " = '" +
                title + "';");
    }

}
