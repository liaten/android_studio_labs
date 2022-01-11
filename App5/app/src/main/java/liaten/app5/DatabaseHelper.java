package liaten.app5;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DatabaseHelper extends SQLiteOpenHelper {

    public Context context;
    private static final String DATABASE_NAME = "Corporations.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME_CORP = "Corporations";
    private static final String COLUMN_ID_CORP = "CId";
    private static final String COLUMN_NAME_CORP = "CName";
    private static final String COLUMN_FOUNDERS_CORP = "CFounders";
    private static final String COLUMN_PRODUCTS_CORP = "CProducts";
    private static final String COLUMN_PRICE_CORP = "CPrice";
    private static final String COLUMN_CATEGORY_CORP = "CCategory";

    private static final String TABLE_NAME_USER = "User";
    private static final String COLUMN_ID_USER = "UId";
    private static final String COLUMN_LOGIN_USER = "ULogin";
    private static final String COLUMN_PASSWORD_USER = "UPassword";
    private static final String COLUMN_MAIL_USER = "UMail";

    DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // Создание таблицы "CorpTable"

        db.execSQL(
                "CREATE TABLE " + TABLE_NAME_CORP + " (" + COLUMN_ID_CORP + " INTEGER UNIQUE PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_NAME_CORP + " TEXT, " + COLUMN_FOUNDERS_CORP + " TEXT, " + COLUMN_PRODUCTS_CORP + " TEXT, " +
                        COLUMN_PRICE_CORP + " INTEGER, " + COLUMN_CATEGORY_CORP +" TEXT);"
        );

        // Создание таблицы "UserTable"

        db.execSQL(
                "CREATE TABLE " + TABLE_NAME_USER + " (" + COLUMN_ID_USER + " INTEGER UNIQUE PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_LOGIN_USER + " TEXT UNIQUE, " + COLUMN_PASSWORD_USER + " TEXT, " + COLUMN_MAIL_USER + " TEXT UNIQUE);"
        );

        // Заполнение таблицы первичными значениями

        // 1.1 Microsoft -> Visual Studio

        ContentValues cv = new ContentValues();
        cv.put(COLUMN_NAME_CORP, "Microsoft Inc.");
        cv.put(COLUMN_FOUNDERS_CORP, "Билл Гейтс, Пол Аллен");
        cv.put(COLUMN_PRODUCTS_CORP, "MS Visual Studio");
        cv.put(COLUMN_PRICE_CORP,"0");
        cv.put(COLUMN_CATEGORY_CORP,"IDE");
        db.insert(TABLE_NAME_CORP, null, cv);

        // 1.2 Microsoft -> MS SQL Server

        cv.put(COLUMN_NAME_CORP, "Microsoft Inc.");
        cv.put(COLUMN_FOUNDERS_CORP, "Билл Гейтс, Пол Аллен");
        cv.put(COLUMN_PRODUCTS_CORP, "MS SQL Server"); // + MS Windows
        cv.put(COLUMN_PRICE_CORP,"0");
        cv.put(COLUMN_CATEGORY_CORP,"БД");
        db.insert(TABLE_NAME_CORP, null, cv);

        // 1.3 Microsoft -> MS Windows

        cv.put(COLUMN_NAME_CORP, "Microsoft Inc.");
        cv.put(COLUMN_FOUNDERS_CORP, "Билл Гейтс, Пол Аллен");
        cv.put(COLUMN_PRODUCTS_CORP, "MS Windows"); // +
        cv.put(COLUMN_PRICE_CORP,"21400");
        cv.put(COLUMN_CATEGORY_CORP,"OS");
        db.insert(TABLE_NAME_CORP, null, cv);

        // 2.1 Apple -> iOS

        cv = new ContentValues();
        cv.put(COLUMN_NAME_CORP, "Apple Inc.");
        cv.put(COLUMN_FOUNDERS_CORP, "Стив Джобс, Стив Возняк, Рональд Уэйн");
        cv.put(COLUMN_PRODUCTS_CORP, "iOS");
        cv.put(COLUMN_PRICE_CORP,"0");
        cv.put(COLUMN_CATEGORY_CORP,"OS");
        db.insert(TABLE_NAME_CORP, null, cv);

        // 2.2 Apple -> iPhone

        cv = new ContentValues();
        cv.put(COLUMN_NAME_CORP, "Apple Inc.");
        cv.put(COLUMN_FOUNDERS_CORP, "Стив Джобс, Стив Возняк, Рональд Уэйн");
        cv.put(COLUMN_PRODUCTS_CORP, "iPhone");
        cv.put(COLUMN_PRICE_CORP,"80000");
        cv.put(COLUMN_CATEGORY_CORP,"Устройство");
        db.insert(TABLE_NAME_CORP, null, cv);

        // 2.3 Apple -> iPad

        cv = new ContentValues();
        cv.put(COLUMN_NAME_CORP, "Apple Inc.");
        cv.put(COLUMN_FOUNDERS_CORP, "Стив Джобс, Стив Возняк, Рональд Уэйн");
        cv.put(COLUMN_PRODUCTS_CORP, "iPad");
        cv.put(COLUMN_PRICE_CORP,"100000");
        cv.put(COLUMN_CATEGORY_CORP,"Устройство");
        db.insert(TABLE_NAME_CORP, null, cv);

        // 2.4 Apple -> iPod

        cv = new ContentValues();
        cv.put(COLUMN_NAME_CORP, "Apple Inc.");
        cv.put(COLUMN_FOUNDERS_CORP, "Стив Джобс, Стив Возняк, Рональд Уэйн");
        cv.put(COLUMN_PRODUCTS_CORP, "iPod");
        cv.put(COLUMN_PRICE_CORP,"30000");
        cv.put(COLUMN_CATEGORY_CORP,"Устройство");
        db.insert(TABLE_NAME_CORP, null, cv);

        // 2.5 Apple -> MacOS

        cv = new ContentValues();
        cv.put(COLUMN_NAME_CORP, "Apple Inc.");
        cv.put(COLUMN_FOUNDERS_CORP, "Стив Джобс, Стив Возняк, Рональд Уэйн");
        cv.put(COLUMN_PRODUCTS_CORP, "MacOS/OSX");
        cv.put(COLUMN_PRICE_CORP,"0");
        cv.put(COLUMN_CATEGORY_CORP,"OS");
        db.insert(TABLE_NAME_CORP, null, cv);

        // 2.6 Apple -> MacBook

        cv = new ContentValues();
        cv.put(COLUMN_NAME_CORP, "Apple Inc.");
        cv.put(COLUMN_FOUNDERS_CORP, "Стив Джобс, Стив Возняк, Рональд Уэйн");
        cv.put(COLUMN_PRODUCTS_CORP, "MacBook");
        cv.put(COLUMN_PRICE_CORP,"120000");
        cv.put(COLUMN_CATEGORY_CORP,"Устройство");
        db.insert(TABLE_NAME_CORP, null, cv);

        // 2.7 Apple -> iMac

        cv = new ContentValues();
        cv.put(COLUMN_NAME_CORP, "Apple Inc.");
        cv.put(COLUMN_FOUNDERS_CORP, "Стив Джобс, Стив Возняк, Рональд Уэйн");
        cv.put(COLUMN_PRODUCTS_CORP, "iMac");
        cv.put(COLUMN_PRICE_CORP,"200000");
        cv.put(COLUMN_CATEGORY_CORP,"Устройство");
        db.insert(TABLE_NAME_CORP, null, cv);

        // 3.1 Linux Foundation -> OS Linux

        cv = new ContentValues();
        cv.put(COLUMN_NAME_CORP, "Сообщество независимых разработчиков");
        cv.put(COLUMN_FOUNDERS_CORP, "Линус Торвальдс");
        cv.put(COLUMN_PRODUCTS_CORP, "ОС Linux, Git");
        cv.put(COLUMN_PRICE_CORP,"0");
        cv.put(COLUMN_CATEGORY_CORP,"OS");
        db.insert(TABLE_NAME_CORP, null, cv);

        // 3.2 Linux Foundation -> OS Linux

        cv = new ContentValues();
        cv.put(COLUMN_NAME_CORP, "Сообщество независимых разработчиков");
        cv.put(COLUMN_FOUNDERS_CORP, "Линус Торвальдс");
        cv.put(COLUMN_PRODUCTS_CORP, "Git");
        cv.put(COLUMN_PRICE_CORP,"0");
        cv.put(COLUMN_CATEGORY_CORP,"Система контроля версий");
        db.insert(TABLE_NAME_CORP, null, cv);

        // 4.1 VK -> VK

        cv = new ContentValues();
        cv.put(COLUMN_NAME_CORP, "Компания ООО \"ВКонтакте\"");
        cv.put(COLUMN_FOUNDERS_CORP, "Павел Дуров");
        cv.put(COLUMN_PRODUCTS_CORP, "ВКонтакте");
        cv.put(COLUMN_PRICE_CORP,"0");
        cv.put(COLUMN_CATEGORY_CORP,"Соцсеть, мессенджер");
        db.insert(TABLE_NAME_CORP, null, cv);

        // 4.2 VK -> Telegram

        cv = new ContentValues();
        cv.put(COLUMN_NAME_CORP, "Компания ООО \"ВКонтакте\"");
        cv.put(COLUMN_FOUNDERS_CORP, "Павел Дуров");
        cv.put(COLUMN_PRODUCTS_CORP, "Telegram");
        cv.put(COLUMN_PRICE_CORP,"0");
        cv.put(COLUMN_CATEGORY_CORP,"Мессенджер");
        db.insert(TABLE_NAME_CORP, null, cv);

        // 5.1 Meta -> Facebook

        cv = new ContentValues();
        cv.put(COLUMN_NAME_CORP, "Meta");
        cv.put(COLUMN_FOUNDERS_CORP, "Марк Цукерберг, Эдуардо Саверин, Дастин Московиц, Крис Хьюз");
        cv.put(COLUMN_PRODUCTS_CORP, "Facebook");
        cv.put(COLUMN_PRICE_CORP,"0");
        cv.put(COLUMN_CATEGORY_CORP,"Соцсеть, мессенджер");
        db.insert(TABLE_NAME_CORP, null, cv);

        // 5.2 Meta -> Instagram

        cv = new ContentValues();
        cv.put(COLUMN_NAME_CORP, "Meta");
        cv.put(COLUMN_FOUNDERS_CORP, "Марк Цукерберг, Эдуардо Саверин, Дастин Московиц, Крис Хьюз");
        cv.put(COLUMN_PRODUCTS_CORP, "Instagram");
        cv.put(COLUMN_PRICE_CORP,"0");
        cv.put(COLUMN_CATEGORY_CORP,"Соцсеть");
        db.insert(TABLE_NAME_CORP, null, cv);

        // 5.3 Meta -> Spark AR

        cv = new ContentValues();
        cv.put(COLUMN_NAME_CORP, "Meta");
        cv.put(COLUMN_FOUNDERS_CORP, "Марк Цукерберг, Эдуардо Саверин, Дастин Московиц, Крис Хьюз");
        cv.put(COLUMN_PRODUCTS_CORP, "Spark AR");
        cv.put(COLUMN_PRICE_CORP,"0");
        cv.put(COLUMN_CATEGORY_CORP,"IDE, AR");
        db.insert(TABLE_NAME_CORP, null, cv);

        // 5.4 Meta -> Spark AR

        cv = new ContentValues();
        cv.put(COLUMN_NAME_CORP, "Meta");
        cv.put(COLUMN_FOUNDERS_CORP, "Марк Цукерберг, Эдуардо Саверин, Дастин Московиц, Крис Хьюз");
        cv.put(COLUMN_PRODUCTS_CORP, "Messenger");
        cv.put(COLUMN_PRICE_CORP,"0");
        cv.put(COLUMN_CATEGORY_CORP,"Мессенджер");
        db.insert(TABLE_NAME_CORP, null, cv);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_CORP);
    }

    public void addCorp(String corp, String founders, String products, String price, String category){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_NAME_CORP, corp);
        cv.put(COLUMN_FOUNDERS_CORP, founders);
        cv.put(COLUMN_PRODUCTS_CORP, products);
        cv.put(COLUMN_PRICE_CORP, price);
        cv.put(COLUMN_CATEGORY_CORP, category);


        long result = db.insert(TABLE_NAME_CORP, null, cv);
        if (result == -1){
            Toast.makeText(context, "Ошибка.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Успешно добавлено.", Toast.LENGTH_SHORT).show();
        }
    }

    public void addUser(String login, String password, String email){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_LOGIN_USER, login);
        cv.put(COLUMN_PASSWORD_USER, password);
        cv.put(COLUMN_MAIL_USER, email);

        long result = db.insert(TABLE_NAME_USER, null, cv);
        if (result == -1){
            Toast.makeText(context, "Ошибка.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Успешно добавлено.", Toast.LENGTH_SHORT).show();
        }
    }

    Cursor searchUser(String data){
        String query = "SELECT " + COLUMN_LOGIN_USER + " FROM " + TABLE_NAME_USER
                + " WHERE ("
                + COLUMN_LOGIN_USER + " LIKE '" + data + "')";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    Cursor searchPassword(String data){
        String query = "SELECT " + COLUMN_PASSWORD_USER + " FROM " + TABLE_NAME_USER
                + " WHERE ("
                + COLUMN_LOGIN_USER + " LIKE '" + data + "')";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    Cursor readAllData(){
        String query = "SELECT * FROM " + TABLE_NAME_CORP;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    Cursor readAllLogins(){
        String query = "SELECT * FROM " + TABLE_NAME_USER;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    Cursor searchData(String data){
        String query = "SELECT * FROM " + TABLE_NAME_CORP
                + " WHERE ("
                + COLUMN_NAME_CORP + " LIKE '%" + data + "%'"
                + " OR " + COLUMN_FOUNDERS_CORP + " LIKE '%" + data + "%'"
                + " OR " + COLUMN_PRODUCTS_CORP + " LIKE '%" + data + "%')";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }



    Cursor sortData(String column){
        if (column.equals("product")){
            column = COLUMN_PRODUCTS_CORP;
        }
        else if(column.equals("category")){
            column = COLUMN_CATEGORY_CORP;
        }
        String query = "SELECT * FROM " + TABLE_NAME_CORP +
                " ORDER BY " + column;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    Cursor getSumOfProducts(){
        String query = "SELECT " +
                "SUM("+ COLUMN_PRICE_CORP +")" + " FROM " + TABLE_NAME_CORP;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    Cursor getAvgOfProducts(){
        String query = "SELECT " +
                "AVG("+ COLUMN_PRICE_CORP +")" + " FROM " + TABLE_NAME_CORP;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    public void updateData(String id, String name, String founders, String products, String price, String category) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_NAME_CORP, name);
        cv.put(COLUMN_FOUNDERS_CORP, founders);
        cv.put(COLUMN_PRODUCTS_CORP, products);
        cv.put(COLUMN_PRICE_CORP, price);
        cv.put(COLUMN_CATEGORY_CORP, category);

        long result = db.update(TABLE_NAME_CORP, cv, "id=?", new String[]{id});
        if(result == -1){
            Toast.makeText(context, "Ошибка", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Успешно добавлено!", Toast.LENGTH_SHORT).show();
        }
    }

    void deleteOneRow(String row_id){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME_CORP, "id=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Ошибка при удалении.", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Успешно удалено.", Toast.LENGTH_SHORT).show();
        }
    }
}
