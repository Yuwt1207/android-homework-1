package com.example.helloworld;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button culbtn=findViewById(R.id.culculatebutton);
        Button btn1=findViewById(R.id.button1);
        final TextView tv1=findViewById(R.id.tv1);
        final CheckBox cb1=findViewById(R.id.checkBox2);
        final Switch switch1=findViewById(R.id.switch2);
        SeekBar sb=findViewById(R.id.seekBar);

        culbtn.setEnabled(false);
        sb.setMax(20);
        sb.setProgress(0);
        tv1.setTextSize(10);
        tv1.setGravity(Gravity.CENTER);
        tv1.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);//下划线
        tv1.getPaint().setAntiAlias(true);//去除锯齿

        btn1.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                tv1.setText("我红了");
                tv1.setTextColor(Color.rgb(0,255,0));

                Log.d("MainActivity", "button");
            }
        });

        culbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,culculateActivity.class);
                startActivity(intent);
                Log.d("MainActivity", "culculate");
            }
        });

        cb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                culbtn.setEnabled(isChecked);
                Log.d("MainActivity", "checkbox");
            }
        });

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    tv1.setText(tv1.getText());
                    tv1.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);//中划线
                    tv1.getPaint().setAntiAlias(true);//去除锯齿
                }
                else
                {
                    tv1.setText(tv1.getText());
                    tv1.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);//加下划线
                    tv1.getPaint().setAntiAlias(true);//去除锯齿
                }
                Log.d("MainActivity", "switch");
            }
        });

        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {//滑动时
                tv1.setTextSize(progress+10);
                Log.d("MainActivity", "seekbar");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {//开始滑动

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {//停止滑动

            }
        });


    }
}
