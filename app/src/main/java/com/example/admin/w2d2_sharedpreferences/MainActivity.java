package com.example.admin.w2d2_sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String PREFS_NAME="MyAppSettings";
    EditText et_name_values,et_lastname_values;
    SharedPreferences settingsValues;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_name_values=(EditText)findViewById(R.id.et_name);
        et_lastname_values=(EditText)findViewById(R.id.et_latname);

    }

    public void updateEditViews(View view) {
        et_name_values.setText(settingsValues.getString("name",""));
        et_lastname_values.setText(settingsValues.getString("lastname",""));
    }

    public void popupLastName(View view) {
        Toast.makeText(this,settingsValues.getString("lastname","DEFAULT LAST NAME VALUE"),Toast.LENGTH_SHORT).show();
    }

    public void popupName(View view) {
        Toast.makeText(this,settingsValues.getString("name","DEFAULT NAME VALUE"),Toast.LENGTH_SHORT).show();
    }

    public void saveValues(View view) {
        /*SharedPreferences settings = getSharedPreferences(PREFS_NAME,MODE_PRIVATE);//create the sharedpref
        SharedPreferences.Editor editor= settings.edit();
        editor.putString("key","somevalue");
        editor.commit();

        String value= settings.getString("key","");
        Toast.makeText(this,value,Toast.LENGTH_SHORT).show();*/
        settingsValues=getSharedPreferences(PREFS_NAME,MODE_PRIVATE);

        SharedPreferences.Editor editor= settingsValues.edit();



        editor.putString("name",et_name_values.getText().toString());
        editor.putString("lastname",et_lastname_values.getText().toString());
        editor.commit();

        et_name_values.setText("");
        et_lastname_values.setText("");
        Toast.makeText(this,"VALUES SAVED",Toast.LENGTH_SHORT).show();
    }
}
