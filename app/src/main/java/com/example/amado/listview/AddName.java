package com.example.amado.listview;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class AddName extends ActionBarActivity {
    private ArrayList<String> mNewNames;

    private final String EXTRA ="EXTRA";
    private EditText mEditName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_name);
        mNewNames= new ArrayList<String>();
        mEditName = (EditText)findViewById(R.id.get_name);
        Button addButton = (Button)findViewById(R.id.add_button);
        Button doneButton = (Button)findViewById(R.id.done_button);

        final ListView addedList = (ListView)findViewById(R.id.added_names_list);
        final Adapter adapter = new Adapter(mNewNames);
        addedList.setAdapter(adapter);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               mNewNames.add(mEditName.getText().toString());
                mEditName.setText("");
                Toast toast = Toast.makeText(AddName.this, "Name Added", Toast.LENGTH_SHORT);
                toast.show();
                adapter.notifyDataSetChanged();
            }
        });
        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putStringArrayListExtra(EXTRA, mNewNames);
                setResult(0,intent);
                finish();
            }
        });



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_name, menu);


        return true;
    }

    private class Adapter extends ArrayAdapter{
        Adapter(ArrayList<String> added){
            super(AddName.this, android.R.layout.simple_list_item_1, added);
        }


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
