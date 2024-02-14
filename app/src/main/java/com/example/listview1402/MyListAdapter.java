package com.example.listview1402;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;



    /**
     * Application ListView
     * Created by EvILeg on 21.07.2015.
     */
    public class MyListAdapter extends BaseAdapter {

        /*
         * Создаем объекты для отображения внешнего вида элемента
         * и объекта списка, с которым будет производиться работа
         */
        private LayoutInflater LInflater;
        private ArrayList<DataFlags> list;

        /*
         * Конструктор класса. В данном случае лишь транслируется лист с данными
         * в лист адаптера, с которым будет производиться непосредственная работа
         */
        public MyListAdapter(Context context, ArrayList<DataFlags> data){

            list = data;
            LInflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        /*
         * Далее идут стандартные методы родительского класса BaseAdapter.
         * Внимательно ознакомьтесь с отличиями методов в уроке и методов,
         * которые автоматически создает Android Studio.
         * Данные методы должны работать непосредственно с используемым нами ArrayList
         * и структурой данных, формируемой классом DataFlags
         */
        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public DataFlags getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        /*
         * Метод, в котором формируется внешний вид элементов с его наполнением
         */
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder holder;
            View v = convertView;

            /*
             * В том случае, если вид элемента не создан, производится его создание
             * с помощью ViewHolder и тегирование данного элемента конкретным holder объектом
             */
            if ( v == null){
                holder = new ViewHolder();
                v = LInflater.inflate(R.layout.listview, parent, false);
                holder.flag = (ImageView) v.findViewById(R.id.flagImage);
                holder.name = (TextView) v.findViewById(R.id.name);
                holder.abbreviation = ((TextView) v.findViewById(R.id.abbreviation));
                v.setTag(holder);
            }

            /*
             * После того, как все элементы определены, производится соотнесение
             * внешнего вида, данных и конкретной позиции в ListView.
             * После чего из ArrayList забираются данные для элемента ListView и
             * передаются во внешний вид элемента
             */
            holder = (ViewHolder) v.getTag();
            DataFlags dataFlags = getData(position);

            holder.flag.setImageResource(dataFlags.getFlagID());
            holder.name.setText(v.getResources().getString(dataFlags.getNameID()));
            holder.abbreviation.setText(v.getResources().getString(dataFlags.getAbbreviationID()));

            return v;
        }

        /*
         * Метод, который забирает объект из ArrayList для дальнейшей работы с ним
         * и передачи его данных в элемент ListView
         */
        DataFlags getData(int position){
            return (getItem(position));
        }

        /*
         * Данная структура данных необходима для того, чтобы при пролистывании
         * большого списка не возникало артефактов и перескакивания данных с одной позиции ListView
         * на другую, что достигается тегированием каждого элемента ListView
         */
        private static class ViewHolder {
            private ImageView flag;
            private TextView name;
            private TextView abbreviation;
        }
    }

