package com.example.vince.customlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView list;
    CustomAdapter adapter;
    ArrayList people;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = findViewById(R.id.listwatu);
        people = new ArrayList<Item>();
        Item mtu1 = new Item("Vincent Kimani","0795189789",R.drawable.kenya);
        Item mtu2 = new Item("Mugia Vincent","0709109789",R.drawable.kenya);
        Item mtu3 = new Item("Raphael Wanjala","0710180089",R.drawable.kenya);
        Item mtu4 = new Item("Mandy Wachuka","0723457809",R.drawable.kenya);
        Item mtu5 = new Item("Zj Heno","0723457809",R.drawable.kenya);
        Item mtu6 = new Item("Vincent Kimani","0795189789",R.drawable.kenya);
        Item mtu7 = new Item("Mugia Vincent","0709109789",R.drawable.kenya);
        Item mtu8 = new Item("Raphael Wanjala","0710180089",R.drawable.kenya);
        Item mtu9 = new Item("Mandy Wachuka","0723457809",R.drawable.kenya);
        Item mtu10 = new Item("Zj Heno","0723457809",R.drawable.kenya);
        Item mtu11 = new Item("Vincent Kimani","0795189789",R.drawable.kenya);
        Item mtu12 = new Item("Mugia Vincent","0709109789",R.drawable.kenya);
        Item mtu13 = new Item("Raphael Wanjala","0710180089",R.drawable.kenya);
        Item mtu14 = new Item("Mandy Wachuka","0723457809",R.drawable.kenya);
        Item mtu15 = new Item("Zj Heno","0723457809",R.drawable.kenya);
        Item mtu16 = new Item("Vincent Kimani","0795189789",R.drawable.kenya);
        Item mtu17 = new Item("Mugia Vincent","0709109789",R.drawable.kenya);
        Item mtu18 = new Item("Raphael Wanjala","0710180089",R.drawable.kenya);
        Item mtu19 = new Item("Mandy Wachuka","0723457809",R.drawable.kenya);
        Item mtu20 = new Item("Zj Heno","0723457809",R.drawable.kenya);

        people.add(mtu1);
        people.add(mtu2);
        people.add(mtu3);
        people.add(mtu4);
        people.add(mtu5);
        people.add(mtu6);
        people.add(mtu7);
        people.add(mtu8);
        people.add(mtu9);
        people.add(mtu10);
        people.add(mtu11);
        people.add(mtu12);
        people.add(mtu13);
        people.add(mtu14);
        people.add(mtu15);
        people.add(mtu16);
        people.add(mtu17);
        people.add(mtu18);
        people.add(mtu19);
        people.add(mtu20);

        adapter = new CustomAdapter(this,people);
        list.setAdapter(adapter);
    }
}
