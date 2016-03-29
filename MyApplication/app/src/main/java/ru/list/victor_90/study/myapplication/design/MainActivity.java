package ru.list.victor_90.study.myapplication.design;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

import ru.list.victor_90.study.myapplication.R;
import ru.list.victor_90.study.myapplication.logic.*;

public class MainActivity extends Activity implements View.OnClickListener {

    MyJSONParser parser;
    EditText Id;
    TextView txtField;
    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBox = (CheckBox) findViewById(R.id.checkBox);
        Id = (EditText) findViewById(R.id.edit_id);
        txtField = (TextView) findViewById(R.id.txt_main);

        findViewById(R.id.button).setOnClickListener(this);

        // listener for checkbox
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Id.setEnabled(true);
                } else {
                    Id.setEnabled(false);
                }
            }
        });

        parseFromFile();
    }

    private void parseFromFile() {
        try {
            parser = new MyJSONParser(new JSONFromFile().getJsonObject());
            parser.parse();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {

        if(parser == null){
            Toast.makeText(MainActivity.this,"Не найден файл " + JSONFromFile.path, Toast.LENGTH_SHORT).show();
            return;
        }

        int id = 0;
        txtField.setText("");
        // берем данные из парселя
        String name = parser.getName();
        ArrayList<People> people= parser.getPeople();

        // если показывать одну запись, то и выводим одну запись
        if(checkBox.isChecked()) {

            id = Integer.parseInt(Id.getText().toString());
            try {
                txtField.append(name + "\n");
                txtField.append(people.get(id).toString());
            } catch (IndexOutOfBoundsException e) {
                txtField.setText("Запись не найдена");
                return;
            }
        } else {
            // иначе выводим все записи
            txtField.append(name + "\n");

            for (People man : people){
                txtField.append(man.toString());
                txtField.append("--------------\n");
            }
        }



    }
}
