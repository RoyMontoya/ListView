package com.example.amado.listview;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {
private final String EXTRA= "EXTRA";
    private ArrayList<String> mNewNames;
    private ArrayList<String> mFriends;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        makeFriends();
        ListView list = (ListView)findViewById(R.id.list);
        list.setAdapter(new Adapter(mFriends));

        list.setOnScrollListener(new AbsListView.OnScrollListener() {
            int previousFirstItem = 0;
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
            if(previousFirstItem <firstVisibleItem){
                getSupportActionBar().hide();

            }

                if(previousFirstItem >firstVisibleItem){
                    getSupportActionBar().show();
                }
                previousFirstItem =firstVisibleItem;
            }
        });
    }

    private void makeFriends() {
        mFriends= new ArrayList<String>();
        mFriends.add("paul");
        mFriends.add("daniel");
        mFriends.add("L");
        mFriends.add("jaime");
        mFriends.add("fucka");
        mFriends.add("pinky");
        mFriends.add("pedro");
        mFriends.add("paola");
        mFriends.add("armando");
        mFriends.add("marcela");
        mFriends.add("ana");
        mFriends.add("diana");
        mFriends.add("josh");
        mFriends.add("zack");
    }

    private class Adapter extends ArrayAdapter{
        Adapter(ArrayList<String> friends){
            super(MainActivity.this, android.R.layout.simple_list_item_1,friends);
        }


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mNewNames =data.getStringArrayListExtra(EXTRA);
        mFriends.addAll(mNewNames);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.add_name) {
            Intent i = new Intent(MainActivity.this, AddName.class);
            startActivityForResult(i, 0);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
