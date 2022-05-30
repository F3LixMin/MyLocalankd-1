package com.example.mylocalbankd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.net.URL;

public class MainActivity extends AppCompatActivity {
    Button DBS;
    Button OCBC;
    Button UOB;
    String bank = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBS = findViewById(R.id.button);
        OCBC = findViewById(R.id.button2);
        UOB = findViewById(R.id.button3);
        registerForContextMenu(DBS);
        registerForContextMenu(OCBC);
        registerForContextMenu(UOB);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0, 0, 0, "Website");
        menu.add(0, 1, 1, "Contact Us");

        if (v == DBS) {
            bank = "DBS";
        } else if (v == OCBC) {
            bank = "OCBC";
        } else if (v == UOB) {
            bank = "UOB";
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (bank.equalsIgnoreCase("DBS")) {
            if (item.getItemId() == 0) {
                String url = "https://www.dbs.com.sg/index/default.page";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            } else if (item.getItemId() == 1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 1801111111));
                startActivity(intentCall);
            }
        } else if (bank.equalsIgnoreCase("OCBC")) {
            if (item.getItemId() == 0) {
                String url = "https://www.ocbc.com/personal-banking/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            } else if (item.getItemId() == 1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 1801111111));
                startActivity(intentCall);
            }
        } else if (bank.equalsIgnoreCase("UOB")) {
            if (item.getItemId() == 0) {
                String url = "https://www.uobgroup.com/uobgroup/default.page";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            } else if (item.getItemId() == 1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 1801111111));
                startActivity(intentCall);
            }


        }
        return super.onContextItemSelected(item);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            DBS.setText("DBS");
            OCBC.setText("OCBC");
            UOB.setText("UOB");
        } else if (id == R.id.ChineseSelection) {
            DBS.setText("星展银行");
            OCBC.setText("华侨银行");
            UOB.setText("大华银行");
        }
    return super.onOptionsItemSelected(item);
    }
}