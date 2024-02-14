package com.example.listview1402;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Находим ListView в разметке активити
        ListView listView = (ListView) this.findViewById(R.id.listViews);

        // Создаём ListView, в котором будут храниться данные для списка
        ArrayList<DataFlags> list = new ArrayList<>();
        list.clear();

        /* Наполняем List данным. В данном случае данные передаются Объектом,
         * в котором хранятся id, указывающие на флаги в ресурсах, а также
         * на Строки, в которых прописаны названия валют стран и аббревиатуры этих валют */
        list.add(new DataFlags(R.drawable.rub, R.string.russian, R.string.russianRUB));
        list.add(new DataFlags(R.drawable.zar, R.string.africa, R.string.africaZAR));
        list.add(new DataFlags(R.drawable.sgd, R.string.singapore, R.string.singaporeSGD));
        list.add(new DataFlags(R.drawable.tur, R.string.turkish, R.string.turkishTRY));
        list.add(new DataFlags(R.drawable.jap, R.string.japan, R.string.japanJPY));
        list.add(new DataFlags(R.drawable.kor, R.string.korea, R.string.koreaKRW));
        list.add(new DataFlags(R.drawable.chi, R.string.china, R.string.chinaCNY));

        /* Создаём адаптер, который будет передавать данные из List`а в
         * элемент ListView и подключаем его непосредственно к ListView`у
         */
        MyListAdapter myListAdaptery = new MyListAdapter(this, list);
        listView.setAdapter(myListAdaptery);
    }
    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
       //getMenuInflater().inflate(R.menu., menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == androidx.core.R.id.action_container) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/
}