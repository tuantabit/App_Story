package com.tuantadev.apptruyen.sql;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;

import com.tuantadev.apptruyen.UI.ContentApp;
import com.tuantadev.apptruyen.UI.Store;
import com.tuantadev.apptruyen.UI.Topic;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class ManagerSql {
    private Context context;
    private static final String DB_NAME = "truyencuoi";
    private SQLiteDatabase sqLiteDatabase;

    public ManagerSql(Context context) {
        this.context = context;
        copyExApp();
    }

    private void copyExApp() {
        String path = Environment.getDataDirectory().getPath() + "/data/" +
                context.getPackageName() + "/db";
        if (new File(path + "/" + DB_NAME).exists()) {
            return;
        }

        try {
            InputStream in = context.getAssets().open(DB_NAME);
            new File(path).mkdir();
            OutputStream out = new FileOutputStream(path + "/" + DB_NAME);
            byte[] b = new byte[1024];
            int le = in.read(b);
            while (le > -1) {
                out.write(b, 0, le);
                le = in.read(b);
            }
            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openDB() {
        if (sqLiteDatabase == null || sqLiteDatabase.isOpen() == false) {
            String path = Environment.getDataDirectory().getPath() + "/data/" +
                    context.getPackageName() + "/db";
            sqLiteDatabase = SQLiteDatabase.openDatabase(path + "/" + DB_NAME, null,
                    SQLiteDatabase.OPEN_READWRITE);
        }
    }

    public void closeDB() {
        if (sqLiteDatabase == null || sqLiteDatabase.isOpen() == false) {
            return;
        }
        sqLiteDatabase.close();
        sqLiteDatabase = null;
    }

    public List<Topic> getAllTopic() {
        List<Topic> list = new ArrayList<>();
        openDB();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from categories",
                null);
        cursor.moveToFirst();
        int indexID = cursor.getColumnIndex("id");
        int indexName = cursor.getColumnIndex("name");

        while (!cursor.isAfterLast()) {
            int id = cursor.getInt(indexID);
            String name = cursor.getString(indexName);
            list.add(new Topic(id, name));
            cursor.moveToNext();
        }

        closeDB();
        return list;
    }

    public List<Store> getAllStore(int idCat) {
        List<Store> list = new ArrayList<>();
        openDB();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from stories where cat_id=" + idCat, null);
        cursor.moveToFirst();
        int indexID = cursor.getColumnIndex("cat_id");
        int indexIDStore = cursor.getColumnIndex("id");
        int indexName = cursor.getColumnIndex("name");
        while (!cursor.isAfterLast()) {
            int id = cursor.getInt(indexID);
            int idStore = cursor.getInt(indexIDStore);
            String name = cursor.getString(indexName);
            list.add(new Store(name, id, idStore));
            cursor.moveToNext();
        }
        cursor.close();
        closeDB();
        return list;
    }


    public ContentApp getContent(int id) {
        openDB();
        Cursor cursor = sqLiteDatabase.rawQuery(
                "select * from stories where id = " + id, null);
        cursor.moveToFirst();
        int indexName = cursor.getColumnIndex("name");
        int indexContent = cursor.getColumnIndex("content");

        String name = cursor.getString(indexName);
        String contentA = cursor.getString(indexContent);
        ContentApp store = new ContentApp(name, contentA);

        closeDB();
        return store;
    }
}
