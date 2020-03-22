package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class culculateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_culculate);

        final int[] num = {1,1};//数字1，数字2
        final int[] op = {1};//操作符 1+ 2- 3* 4/
        RadioGroup rgnum1=findViewById(R.id.RGnum1);
        RadioGroup rgnum2=findViewById(R.id.RGnum2);
        RadioGroup rgop=findViewById(R.id.RGoperator);
        final TextView tvres=findViewById(R.id.textViewresult);
        Button btncul=findViewById(R.id.button1);
        tvres.setTextSize(20);
        tvres.setTextColor(Color.parseColor("#DC143C"));


        rgnum1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rbnum1=group.findViewById(checkedId);
                num[0] =Integer.parseInt(rbnum1.getText().toString());
                Log.d("culculateActivity","rgnum1");
            }
        });

        rgnum2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rbnum2=group.findViewById(checkedId);
                num[1]=Integer.parseInt(rbnum2.getText().toString());
                Log.d("culculateActivity","rgnum2");
            }
        });

        rgop.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.radioButtonadd:
                        op[0] =1;
                        break;
                    case R.id.radioButtonminus:
                        op[0]=2;
                        break;
                    case R.id.radioButtonmul:
                        op[0]=3;
                        break;
                    case R.id.radioButtondiv:
                        op[0]=4;
                        break;
                }
                Log.d("culculateActivity","rgop");
            }
        });

        btncul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float result =0;
                if(op[0]==1)
                {
                    result=num[0]+num[1];
                }
                else if(op[0]==2)
                {
                    result=num[0]-num[1];
                }
                else if(op[0]==3)
                {
                    result=num[0]*num[1];
                }
                else if(op[0]==4)
                {
                    result=(float)num[0]/(float)num[1];
                }
                tvres.setText(String.valueOf(result));
                Log.d("culculateActivity","btncul");
            }
        });


    }
}
