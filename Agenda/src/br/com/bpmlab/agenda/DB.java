package br.com.bpmlab.agenda;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DB extends SQLiteOpenHelper {

	private static String dbName = "cliente.db";
	private static String sql1 = "DROP TABLE clientes;";
	private static String sql = "CREATE TABLE [clientes] ([id] INTEGER PRIMARY KEY AUTOINCREMENT, [nome] VARCHAR(30), [email] VARCHAR(40), [endereco] VARCHAR(50), [telefone] VARCHAR(15));";
	private static int version = 1;

	public DB(Context context) {
		super(context, dbName, null, version);

	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		
//		db.execSQL(sql1);
		db.execSQL(sql);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		/*
		 * if (oldVersion == 1) { if (newVersion == 2) {
		 * db.execSQL("DROP TABLE LOGS"); db.execSQL("CREATE TABLE ..."); } }
		 */
	}

}
