package com.homefit.android.homefit.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.homefit.android.homefit.database.HomeFitDbSchema.CustomerTable;
import com.homefit.android.homefit.database.HomeFitDbSchema.SessionTable;

public class HomeFitBaseOpenHelper extends SQLiteOpenHelper {

	private static final int VERSION = 1;
	private static final String DATABSE_NAME = "homeFitBase.db";

	public HomeFitBaseOpenHelper(Context context) {
		super(context, DATABSE_NAME, null, VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("create table " + CustomerTable.TABLE_NAME + "(" +
			" _id integer primary key autoincrement, " +
			CustomerTable.Cols.UUID + ", " +
			CustomerTable.Cols.NAME + ", " +
			CustomerTable.Cols.ADDRESS_ONE + ", " +
			CustomerTable.Cols.ADDRESS_TWO + ", " +
			CustomerTable.Cols.CITY + ", " +
			CustomerTable.Cols.STATE + ", " +
			CustomerTable.Cols.ZIP + ", " +
			CustomerTable.Cols.PHONE + ", " +
			CustomerTable.Cols.EMAIL + ")"
		);
		db.execSQL("create table " + SessionTable.TABLE_NAME + "(" +
			" _id integer primary key autoincrement, " +
			SessionTable.Cols.UUID + ", " +
			SessionTable.Cols.CUSTOMER_ID + ", " +
			SessionTable.Cols.SESSION_PLAN + ", " +
			SessionTable.Cols.DATE + ", " +
			SessionTable.Cols.COST + ", " +
			SessionTable.Cols.IS_PAID + ", " +
			SessionTable.Cols.IS_COMPLETE + ")"
		);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}
}
