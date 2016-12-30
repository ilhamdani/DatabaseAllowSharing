package com.lab.ilham.databaseallowsharing;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends Activity {

    private SqlLiteManger _sqlLiteManger;
    private List<String> _listFromDB;
    private ArrayAdapter<String> _adapter;
    private ListView listView;

    private String[] _versionName = { "Eclair", "Froyo", "Gingerbread", "Honeycomb", "Ice-cream Sandwich"};
    private String[] _versionNo = {"2.0 - 2.1", "2.2 - 2.2.3", "2.3 - 2.3.7", "3.0 - 3.2.6", "4.0 - 4.0.4"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.listView1);

        _sqlLiteManger = new SqlLiteManger(this);
        _sqlLiteManger.open();

        for (int i = 1; i < _versionName.length; i++) {
            _sqlLiteManger.insert(_versionName[i], _versionNo[i]);
        }

        _listFromDB = _sqlLiteManger.fetch();
        _adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, _listFromDB);
        listView.setAdapter(_adapter);
    }
}
