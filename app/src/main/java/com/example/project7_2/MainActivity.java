package com.example.project7_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout baseLayout;
    Button button1, button2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("배경색 바꾸기(컨텍스트 메뉴)");
        baseLayout = (LinearLayout) findViewById(R.id.baseLayout);
        button1 = (Button) findViewById(R.id.button1);
        registerForContextMenu(button1);

        button2 = (Button) findViewById(R.id.button2);
        registerForContextMenu(button2);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater mInflater = getMenuInflater();
        if(v == button1){
            menu.setHeaderTitle("배경색 변경");

            mInflater.inflate(R.menu.context_menu1, menu);
        }
        if(v == button2){
            mInflater.inflate(R.menu.context_menu2, menu);
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item){

        if(item.getItemId() == R.id.itemRed){
            baseLayout.setBackgroundColor(Color.RED);
            return true;
        } else if(item.getItemId() == R.id.itemGreen){
            baseLayout.setBackgroundColor(Color.GREEN);
            return true;
        } else if(item.getItemId() == R.id.itemBlue) {
            baseLayout.setBackgroundColor(Color.BLUE);
            return true;
        }
        else if(item.getItemId() == R.id.subRotate) {
            button2.setRotation(45);
            return true;
        }
        else if(item.getItemId() == R.id.subSize) {
            button2.setScaleX(2);
            return true;
        }
        return false;
    }
}
