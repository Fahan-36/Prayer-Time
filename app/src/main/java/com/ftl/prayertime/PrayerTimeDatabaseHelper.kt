package com.ftl.prayertime

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.ContactsContract.CommonDataKinds.Note

class PrayerTimeDatabaseHelper(context: Context): SQLiteOpenHelper (context, DATABASE_NAME,null,
    DATABASE_VERSION){


    companion object{
        private const val DATABASE_VERSION = 1
        private const val TABLE_NAME = "allprayertime"
        private const val DATABASE_NAME = "prayertimeapp.db"
        private const val COLUMN_ID = "id"
        private const val COLUMN_TITLE = "name"
        private const val COLUMN_CONTENT = "time"
    }

    override fun onCreate(db: SQLiteDatabase?) {
       val createTableQuery = "CREATE TABLE $TABLE_NAME ($COLUMN_ID INTEGER PRIMARY KEY,$COLUMN_TITLE TEXT , $COLUMN_CONTENT TEXT)"
       db?.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val dropTableQuery = "DROP TABLE IF EXISTS $TABLE_NAME"
        db?.execSQL(dropTableQuery)
        onCreate(db)
    }

    fun insertPrayerTime(prayerTime: PrayerTime){
        val db = writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_TITLE
                ,prayerTime.name)
            put(COLUMN_CONTENT
                ,prayerTime.time)
        }
        db.insert(TABLE_NAME,null,values)
        db.close()
    }
    fun getAllPrayerTime():List<PrayerTime>
    {
        val prayerTimesList = mutableListOf<PrayerTime>()
        val db= readableDatabase
        val query = "SELECT * FROM $TABLE_NAME"
        val cursor= db.rawQuery(query,null)

        while (cursor.moveToNext()){
            val id = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID))
            val name=cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TITLE))
            val time=cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CONTENT))

            val prayerTime = PrayerTime(id,name,time)
            prayerTimesList.add(prayerTime)
        }
        cursor.close()
        db.close()
        return prayerTimesList

    }
    fun updatePrayerTime(prayerTime: PrayerTime){
        val db = writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_TITLE,prayerTime.name)
            put(COLUMN_CONTENT,prayerTime.time)
        }
        val whereClause ="$COLUMN_ID= ?"
        val whereArgs = arrayOf(prayerTime.id.toString())
        db.update(TABLE_NAME,values,whereClause,whereArgs)
        db.close()
    }
    fun getPrayerTimeByID(prayerTimeID : Int):PrayerTime{
        val db = readableDatabase
        val query = "SELECT * FROM $TABLE_NAME WHERE $COLUMN_ID = $prayerTimeID"
        val cursor = db.rawQuery(query, null)

        val id = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID))
        val name = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TITLE))
        val time = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CONTENT))

        cursor.close()
        db.close()
        return  PrayerTime(id,name,time)
    }

    fun deletePrayerTime(prayerTimeID: Int){
        val db= writableDatabase
        val whereClause = "$COLUMN_ID = ?"
        val whereArgs = arrayOf(prayerTimeID.toString())
        db.delete(TABLE_NAME,whereClause,whereArgs)
        db.close()
    }
}