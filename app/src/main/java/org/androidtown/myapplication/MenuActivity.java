package org.androidtown.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import org.androidtown.myapplication.QuizActivity;

public class MenuActivity extends AppCompatActivity {
    SharedPreferences pref;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void onBtn1Clicked(View v){
        Intent intent = new Intent(getApplicationContext(), QuizActivity.class);
        startActivity(intent);
    }

    public void onDataBtnClicked(View v){
        pref = getSharedPreferences("Choices", Context.MODE_PRIVATE);
        editor = pref.edit();
        editor.clear();
        editor.commit();
        Toast.makeText(getApplicationContext(), "Deleted", Toast.LENGTH_SHORT).show();
    }

}
