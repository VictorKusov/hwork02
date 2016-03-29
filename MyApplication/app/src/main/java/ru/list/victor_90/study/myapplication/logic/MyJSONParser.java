package ru.list.victor_90.study.myapplication.logic;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class MyJSONParser {

    private JSONObject jsonObject;

    // Тут хранятся данные с json'a
    private String name;
    private ArrayList<People> people;

    public MyJSONParser(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }

    public String getName() {
        return name;
    }

    public ArrayList<People> getPeople() {
        return people;
    }

    // Парсим JSONobject
    public void parse() throws JSONException {

        people = new ArrayList<People>();
        name = jsonObject.getString("name");

        JSONArray array = jsonObject.getJSONArray("people");

        for (int i = 0; i < array.length(); i++) {
            People man = new People();

            man.setId(array.getJSONObject(i).getInt("id"));
            man.setName(array.getJSONObject(i).getString("name"));
            man.setSurname(array.getJSONObject(i).getString("surname"));
            man.setAge(array.getJSONObject(i).getInt("age"));
            man.setIsDegree(array.getJSONObject(i).getBoolean("isDegree"));

            people.add(man);
        }
    }
}
