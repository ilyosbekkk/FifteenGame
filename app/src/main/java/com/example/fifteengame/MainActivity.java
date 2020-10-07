package com.example.fifteengame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    //region UI componenets
    TableLayout group;
    TableRow row;
    Button[] buttons;
    //endregion

    //region vars
    int index;
    private static final String TAG = "MainActivity";

    //endregion

    //region overrides
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        group = findViewById(R.id.table_layout);
        buttons = new Button[]{
                findViewById(R.id.button1),
                findViewById(R.id.button2),
                findViewById(R.id.button3),
                findViewById(R.id.button4),
                findViewById(R.id.button5),
                findViewById(R.id.button6),
                findViewById(R.id.button7),
                findViewById(R.id.button8),
                findViewById(R.id.button9),
                findViewById(R.id.button10),
                findViewById(R.id.button11),
                findViewById(R.id.button12),
                findViewById(R.id.button13),
                findViewById(R.id.button14),
                findViewById(R.id.button15),
                findViewById(R.id.button16)};


        setListeners(buttons);
        getCoordinates();


    }
    //endregion

    //region set listeners
    private void setListeners(Button[] buttons) {
        for (Button button : buttons) {
            button.setOnClickListener(this);
        }
    }
    //endregions

    //region randomize
    private void randomize() {
        TableRow row1 = (TableRow) group.getChildAt(0);
        TableRow row2 = (TableRow) group.getChildAt(1);
        TableRow row3 = (TableRow) group.getChildAt(2);
        TableRow row4 = (TableRow) group.getChildAt(3);
        row1.removeAllViews();
        row2.removeAllViews();
        row3.removeAllViews();
        row4.removeAllViews();

        Random rand = new Random();
        ArrayList<Integer> numbers = new ArrayList<>();
        do {
            int number = rand.nextInt(16);
            if (!numbers.contains(number))
                numbers.add(number);

        } while (numbers.size() != 16);
        for (int i = 0; i < 16; i++) {
            Log.d(TAG, "randomize: " + numbers.get(i));
        }
        for (int i = 0; i < 16; i++) {
            if (i < 4)
                row4.addView(buttons[numbers.get(i)]);
            else if (i < 8)
                row3.addView(buttons[numbers.get(i)]);
            else if (i < 12)
                row2.addView(buttons[numbers.get(i)]);
            else
                row1.addView(buttons[numbers.get(i)]);


        }

    }
    //endregion

    //region coordinates
    private void getCoordinates() {
        for (int i = 0; i < buttons.length; i++) {
            if (i < 4) {
                row = (TableRow) group.getChildAt(0);
                Log.d(TAG, "onCreate: " + "x: " + i + " y: " + 0);

            } else if (i < 8) {

                row = (TableRow) group.getChildAt(1);
                Log.d(TAG, "onCreate: " + "x: " + (i - 4) + " y: " + 1);

            } else if (i < 12) {
                row = (TableRow) group.getChildAt(2);
                Log.d(TAG, "onCreate: " + "x: " + (i - 8) + " y: " + 2);


            } else {
                row = (TableRow) group.getChildAt(3);
                Log.d(TAG, "onCreate: " + "x: " + (i - 12) + " y: " + 3);


            }

        }
    }
    //endregion

    //region onClick
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:

                break;
            case R.id.button2:
                randomize();
                break;
            case R.id.button3:
                break;
            case R.id.button4:
                break;
            case R.id.button5:
                break;
            case R.id.button6:
                break;
            case R.id.button7:
                break;
            case R.id.button8:
                break;
            case R.id.button9:
                break;
            case R.id.button10:
                break;
            case R.id.button11:
                break;
            case R.id.button12:
                break;
            case R.id.button13:
                break;
            case R.id.button14:
                break;
            case R.id.button15:
                break;
            case R.id.button16:
                break;
            default:
                break;


        }
    }
    //endregion

    //region move buttons
    private void middle() {

    }

    private void edge(TableRow row1, TableRow row2, int x, int y) {


    }

    private void corner() {

    }
    //endregion
}



