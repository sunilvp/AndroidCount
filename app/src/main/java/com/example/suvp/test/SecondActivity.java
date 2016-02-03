package com.example.suvp.test;

import android.app.ListActivity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by suvp on 1/5/2016.
 */
public class SecondActivity extends ListActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        DbHelper lHelper = new DbHelper(this);
        SQLiteDatabase database = lHelper.getWritableDatabase();
        if(database != null && !database.isReadOnly())
        {
            database.beginTransaction();
            try
            {
                ContentValues lContentValues = new ContentValues();
                lContentValues.put(DbHelper.KEY_NAME, "RS 45/40 SS");
                lContentValues.put(DbHelper.KEY_HP, "5.5");
                lContentValues.put(DbHelper.KEY_TYPE, "Steal");

                String[] allColumns = {DbHelper.KEY_NAME, DbHelper.KEY_HP, DbHelper.KEY_TYPE};

                database.insert(DbHelper.TABLE_PRODUCTS, "", lContentValues);

                List<Product> comments = new ArrayList<Product>();

                Cursor cursor = database.query(DbHelper.TABLE_PRODUCTS,
                        allColumns, null, null, null, null, null);

                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    Product comment = cursorToComment(cursor);
                    comments.add(comment);
                    cursor.moveToNext();
                }
                // make sure to close the cursor
                cursor.close();
                Product[] productArray = new Product[comments.size()];
                int i =0;
                for(Product lProduct : comments)
                {
                    productArray[i] =  lProduct;
                    i++;
                }
                CustomAdapter adapter = new CustomAdapter(this,
                        productArray);
                setListAdapter(adapter);

                database.setTransactionSuccessful();
            }
            catch (Exception e)
            {
                throw e;
            }
            finally
            {
                database.endTransaction();
            }
        }
    }

    private Product cursorToComment(Cursor cursor) {
        Product comment = new Product();
        comment.setName_(cursor.getString(0));
        comment.setHp_(cursor.getFloat(1));
        comment.setType_(cursor.getString(2));
        return comment;
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Toast.makeText(this, "Item Selected", Toast.LENGTH_SHORT).show();
        super.onListItemClick(l, v, position, id);
    }
}
