package gmail.vuthanhvt.dictionary.data;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import gmail.vuthanhvt.dictionary.data.model.Consonant;
import gmail.vuthanhvt.dictionary.data.model.MongViet;
import gmail.vuthanhvt.dictionary.data.model.Rhyme;
import gmail.vuthanhvt.dictionary.data.model.Tone;
import gmail.vuthanhvt.dictionary.data.model.Vowel;

/**
 * Create by FRAMGIA\vu.anh.thanh on 24/10/2018.
 * Phone: 096.320.8650
 * Email: vuthanhvt@gmail.com
 * <p>
 * Class DataBaseHelper.
 */
public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String TAG = "DataBaseHelper";
    private SQLiteDatabase myDataBase;
    private final Context myContext;
    public static String DATABASE_NAME = "databaseMongViet.sqlite";
    public String DATABASE_PATH;
    public static final int DATABASE_VERSION = 1;

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.myContext = context;
        DATABASE_PATH = "/data/data/" + myContext.getPackageName() + "/databases/";
    }

    public void createDatabase() throws IOException {
        Log.d(TAG, "createDatabase: ");
        boolean dbExist = checkDataBase();
        Log.d(TAG, "createDatabase: dbExist = " + dbExist);
        if (!dbExist) {
            this.getReadableDatabase();
            try {
                this.close();
                copyDataBase();
            } catch (IOException e) {
                throw new Error("Error copying database");
            }
        }
    }

    private boolean checkDataBase() {
        boolean checkDB = false;
        try {
            String myPath = DATABASE_PATH + DATABASE_NAME;
            File dbfile = new File(myPath);
            checkDB = dbfile.exists();
        } catch (SQLiteException e) {
        }
        return checkDB;
    }

    private void copyDataBase() throws IOException {
        Log.d(TAG, "copyDataBase: ");
        String outFileName = DATABASE_PATH + DATABASE_NAME;
        OutputStream myOutput = new FileOutputStream(outFileName);
        InputStream myInput = myContext.getAssets().open(DATABASE_NAME);

        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);
        }
        myInput.close();
        myOutput.flush();
        myOutput.close();
    }

    public void db_delete() {
        File file = new File(DATABASE_PATH + DATABASE_NAME);
        if (file.exists()) {
            file.delete();
            System.out.println("delete database file.");
        }
    }

    public void openDatabase() throws SQLException {
        String myPath = DATABASE_PATH + DATABASE_NAME;
        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
    }

    public synchronized void closeDataBase() throws SQLException {
        if (myDataBase != null)
            Log.d(TAG, "closeDataBase: 11111111111");
            myDataBase.close();
        super.close();
    }

    public void onCreate(SQLiteDatabase db) {
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion > oldVersion) {
            Log.v("Database Upgrade", "Database version higher than old.");
            db_delete();
        }
    }

    //get all data in MongViet table.
    public void getAllTableMongViet(List<MongViet> mList, String condition, String strCompare) {
        Log.d(TAG, "getAllTableMongViet: ");
        String myPath = DATABASE_PATH + DATABASE_NAME;
        String query =  "SELECT * " +
                        "FROM MONGVIET " +
                        "WHERE " + strCompare + " LIKE '%" + condition + "%' " +
                        "ORDER BY " + strCompare;
        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
        if (myDataBase == null) {
            return;
        }
        Cursor cursor = myDataBase.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                String mHMongWord = cursor.getString(cursor.getColumnIndex("TuMong"));
                String mVietNameWord = cursor.getString(cursor.getColumnIndex("NghiaViet"));
                String mReading = cursor.getString(cursor.getColumnIndex("Cachdoc"));

                mList.add(new MongViet(mVietNameWord, mHMongWord, mReading));
                cursor.moveToNext();
            }
        }
        closeDataBase();
    }

    /*//get all data in Tone table (bảng thanh điệu)
    public void getAllTableTone(List<Tone> mList) {
        Log.d(TAG, "getAllTableBangthanhdieu: ");
        String myPath = DATABASE_PATH + DATABASE_NAME;
        String query =  "SELECT * " +
                        "FROM BANGTHANHDIEU";
        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
        if (myDataBase == null) {
            return;
        }
        Cursor cursor = myDataBase.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                String mIntonation = cursor.getString(cursor.getColumnIndex("Thanhdieu"));
                String mReading = cursor.getString(cursor.getColumnIndex("Cachdoc"));

                mList.add(new Tone(mIntonation, mReading));
                cursor.moveToNext();
            }
        }
        closeDataBase();
    }

    //get all data in Consonant table (phụ âm).
    public void getAllTableConsonant(List<Consonant> mList) {
        Log.d(TAG, "getAllTableBangthanhdieu: ");
        String myPath = DATABASE_PATH + DATABASE_NAME;
        String query =  "SELECT * " +
                "FROM BANGPHUAM";
        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
        if (myDataBase == null) {
            return;
        }
        Cursor cursor = myDataBase.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                String mConsonant = cursor.getString(cursor.getColumnIndex("Phuam"));
                String mReading = cursor.getString(cursor.getColumnIndex("Cachdoc"));

                mList.add(new Consonant(mConsonant, mReading));
                cursor.moveToNext();
            }
        }
        closeDataBase();
    }

    //get all data in Rhyme table (bảng vần).
    public void getAllTableRhyme(List<Rhyme> mList) {
        Log.d(TAG, "getAllTableBangthanhdieu: ");
        String myPath = DATABASE_PATH + DATABASE_NAME;
        String query =  "SELECT * " +
                "FROM BANGVAN";
        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
        if (myDataBase == null) {
            return;
        }
        Cursor cursor = myDataBase.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                String mRhyme = cursor.getString(cursor.getColumnIndex("Van"));
                String mReading = cursor.getString(cursor.getColumnIndex("Cachdoc"));

                mList.add(new Rhyme(mRhyme, mReading));
                cursor.moveToNext();
            }
        }
        closeDataBase();
    }

    //get all data in Vowel table (nguyên âm).
    public void getAllTableVowel(List<Vowel> mList) {
        Log.d(TAG, "getAllTableBangthanhdieu: ");
        String myPath = DATABASE_PATH + DATABASE_NAME;
        String query =  "SELECT * " +
                "FROM BANGNGUYENAM";
        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
        if (myDataBase == null) {
            return;
        }
        Cursor cursor = myDataBase.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                String mRhyme = cursor.getString(cursor.getColumnIndex("Nguyenam"));
                String mReading = cursor.getString(cursor.getColumnIndex("Cachdoc"));

                mList.add(new Vowel(mRhyme, mReading));
                cursor.moveToNext();
            }
        }
        closeDataBase();
    }*/

    public void getAllTableCharacter(List<Object> mList, String mTable) {
        Log.d(TAG, "getAllTableCharacter: ");
        String myPath = DATABASE_PATH + DATABASE_NAME;
        String query = "SELECT * " +
                "FROM " + mTable;
        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
        if (myDataBase == null) {
            return;
        }
        Cursor cursor = myDataBase.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                if ("BANGNGUYENAM".equals(mTable.toUpperCase())) {
                    String mVowel = cursor.getString(cursor.getColumnIndex("Nguyenam"));
                    String mReading = cursor.getString(cursor.getColumnIndex("Cachdoc"));
                    mList.add(new Vowel(mVowel, mReading));
                } else if ("BANGPHUAM".equals(mTable.toUpperCase())) {
                    String mConsonant = cursor.getString(cursor.getColumnIndex("Phuam"));
                    String mReading = cursor.getString(cursor.getColumnIndex("Cachdoc"));
                    mList.add(new Consonant(mConsonant, mReading));
                } else if ("BANGVAN".equals(mTable.toUpperCase())) {
                    String mRhyme = cursor.getString(cursor.getColumnIndex("Van"));
                    String mReading = cursor.getString(cursor.getColumnIndex("Cachdoc"));
                    mList.add(new Rhyme(mRhyme, mReading));
                } else if ("BANGTHANHDIEU".equals(mTable.toUpperCase())) {
                    String mTone = cursor.getString(cursor.getColumnIndex("Thanhdieu"));
                    String mReading = cursor.getString(cursor.getColumnIndex("Cachdoc"));
                    mList.add(new Tone(mTone, mReading));
                }
                cursor.moveToNext();
            }
        }
        closeDataBase();
    }

    public void updateRowDictionary(String mVietNamWord, String mHMongWord, String mReading,
                                    boolean isMongViet) {
        Log.d(TAG, "updateRowDictionary: ");
        String myPath = DATABASE_PATH + DATABASE_NAME;
        String query =  "UPDATE MONGVIET " +
                        "SET TuMong = '" + mHMongWord + "', " +
                        "NghiaViet = '" + mVietNamWord + "', " +
                        "CachDoc = '" + mReading + "' ";
        if (isMongViet) {
            query = query + "WHERE TuMong = '" + mHMongWord + "'";
        } else {
            query = query + "WHERE NghiaViet = '" + mVietNamWord + "'";
        }
        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
        if (myDataBase == null) {
            return;
        }
        myDataBase.execSQL(query);
        closeDataBase();
    }
}
