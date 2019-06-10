package com.perfusionpro.perfusiondo2calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity {

    public void updateTextViews(){

        //arrays to keep values inside of
        Double[] nums = new Double[9];
        Double[] newNums = new Double[8];

        //editText and textView arrays
        EditText[] editTexts = new EditText[9];
        TextView[] textViews = new TextView[8];

        //The EditTexts that can be edited
        editTexts[0] = (EditText)findViewById(R.id.editText001);
        editTexts[1] = (EditText)findViewById(R.id.editText002);
        editTexts[2] = (EditText)findViewById(R.id.editText003);
        editTexts[3] = (EditText)findViewById(R.id.editText004);
        editTexts[4] = (EditText)findViewById(R.id.editText005);
        editTexts[5] = (EditText)findViewById(R.id.editText006);
        editTexts[6] = (EditText)findViewById(R.id.editText007);
        editTexts[7] = (EditText)findViewById(R.id.editText008);
        editTexts[8] = (EditText)findViewById(R.id.editText009);

        //The TextViews that are calculated based upon what was entered
        textViews[0] = findViewById(R.id.textView010);
        textViews[1] = findViewById(R.id.textView011);
        textViews[2] = findViewById(R.id.textView012);
        textViews[3] = findViewById(R.id.textView013);
        textViews[4] = findViewById(R.id.textView014);
        textViews[5] = findViewById(R.id.textView015);
        textViews[6] = findViewById(R.id.textView016);
        textViews[7] = findViewById(R.id.textView017);

        //pull data from user's input
        for (int i = 0;i<editTexts.length-1;i++) {
            nums[i] = Double.parseDouble(editTexts[i].getText().toString());
        }

        //perform calculations
        newNums[0] = nums[6] / nums[0];
        newNums[1] = nums[1] * (1.34) * (nums[2] / 100) + (0.003 * nums[4]);
        newNums[2] = nums[1] * (1.34) * 75 / 100 + 0.003 * nums[5];
        newNums[3] = (newNums[1] * nums[6]) * 10;
        newNums[4] = (newNums[1] * newNums[0]) * 10;
        newNums[5] = nums[6] * (newNums[1] - newNums[2]) * 10;
        newNums[6] = newNums[0] * (newNums[1] - newNums[2]) * 10;
        newNums[7] = 80 * (nums[8] - nums[7]) / nums[6];

        //plug data into textviews
        for (int i = 0;i<textViews.length-1;i++) {
            textViews[i].setText(String.valueOf(newNums[i]));
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //make button do something
        Button calcButton = findViewById(R.id.calculateButton);
        calcButton.setOnClickListener( new OnClickListener() {
            @Override
            public void onClick(View v) {

                //call function that updates values
                updateTextViews();

            }
        });

    }
}
