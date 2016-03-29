package ru.list.victor_90.study.myapplication.logic;

import android.os.Environment;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class JSONFromFile {

    private static final String FILE_PATH = "myDir";
    private static final String FILE_NAME = "test.json";

    public static String path = "";

    private JSONObject jsonObject;

    // Вызов с фалом по умолчанию
    public JSONFromFile() throws IOException, JSONException {
        this(FILE_PATH,FILE_NAME);
    }

    // В конструкторе считываются данные с json файла и создается объект JSONEobject
    public JSONFromFile(String filePath, String fileName) throws IOException, JSONException {

        // Получаем путь к файлу
        File sdPath = Environment.getExternalStorageDirectory();
        path = sdPath.getAbsolutePath() + "/" + filePath;
        sdPath = new File(path);

        File file = new File(sdPath,fileName);
        StringBuffer buffer = new StringBuffer();
        BufferedReader reader = new BufferedReader(new FileReader(file));

        // Пробегаем по файлу и считываем его
        String line;
            while ((line = reader.readLine()) != null){
                buffer.append(line);
            }

        jsonObject = new JSONObject(String.valueOf(buffer));
    }

    public JSONObject getJsonObject() {

        return jsonObject;
    }
}
