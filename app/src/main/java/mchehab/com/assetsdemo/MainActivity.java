package mchehab.com.assetsdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listView);
        List<String> listCountries = readCountries();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout
                .simple_list_item_1, listCountries);
        listView.setAdapter(arrayAdapter);
    }

    private List<String> readCountries(){
        //list to store the countries
        List<String> list = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(getAssets().open
                    ("countries.txt")));
            String line;
            while((line = bufferedReader.readLine()) != null){
                list.add(line);
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return list;
    }
}