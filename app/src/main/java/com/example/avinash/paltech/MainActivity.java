package com.example.avinash.paltech;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText filterText;
    private ListView itemList;

    private ArrayAdapter<String> listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        filterText = (EditText)findViewById(R.id.editText);

        itemList = (ListView)findViewById(R.id.listView);

        final String [] listViewAdapterContent = {"Rohit - 11442431", "Muralikrishnan - 114116024", "Ranganathan - 11413132", "Murugan - 114112233", "Rohit - 1124234", "Swathi - 114116024", "Riddhi - 114116024", "Vaikuntakrishnan - 114116024"};

        listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, listViewAdapterContent);

        itemList.setAdapter(listAdapter);

        itemList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
// make Toast when click
                //Toast.makeText(getApplicationContext(), "Position " + position, Toast.LENGTH_LONG).show();

                filterText.setText(listAdapter.getItem(position));
                itemList.setVisibility(View.GONE);

                Intent i = new Intent(MainActivity.this, Main2Activity.class).putExtra("patient", listAdapter.getItem(position));
                startActivity(i);

            }
        });
        filterText.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                itemList.setVisibility(View.VISIBLE);
                MainActivity.this.listAdapter.getFilter().filter(s);

            }

            @Override
            public void afterTextChanged(Editable s) {
                itemList.setVisibility(View.VISIBLE);
            }
        });
    }

}