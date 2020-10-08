package com.example.fifteengame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    //region UI componenets

    Button[] buttons;
    Button swap;
    //endregion
    //region vars


    //endregion
    //region overrides
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        swap = findViewById(R.id.swap);

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


        buttons[15].setVisibility(View.INVISIBLE);

        for (int i = 0; i < 15; i++) {
            buttons[i].setText(String.valueOf(i + 1));
        }


        swap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                randomize();
            }
        });

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveButtons((Button) v);
            }
        };
        for (int i = 0; i < 16; i++) {
            buttons[i].setOnClickListener(listener);
        }

    }

    //endregion
    //region randomize
    private void randomize() {
        Toast.makeText(this, "empty yet", Toast.LENGTH_SHORT).show();
    }

    //endregion
    //region move buttons
    private void moveButtons(Button view) {
        int index = Integer.parseInt(view.getTag().toString()) - 1;
        int right = index + 1;
        int left = index - 1;

        int top = index - 4;
        int down = index + 4;


        Log.d("Tags", "moveButtons: " + view.getTag());

        if (right<=15 && buttons[right].getVisibility() == View.INVISIBLE) {

                view.setVisibility(View.INVISIBLE);
                buttons[right].setText(view.getText());
                view.setText(null);
                buttons[right].setVisibility(View.VISIBLE);

        } else if (left>=0 && buttons[left].getVisibility() == View.INVISIBLE) {
            view.setVisibility(View.INVISIBLE);
            buttons[left].setText(view.getText());
            view.setText(null);
            buttons[left].setVisibility(View.VISIBLE);
        } else if (top>=0 && buttons[top].getVisibility() == View.INVISIBLE) {
            view.setVisibility(View.INVISIBLE);
            buttons[top].setText(view.getText());
            view.setText(null);
            buttons[top].setVisibility(View.VISIBLE);
        } else if (down<=15 && buttons[down].getVisibility() == View.INVISIBLE) {
            view.setVisibility(View.INVISIBLE);
            buttons[down].setText(view.getText());
            view.setText(null);
            buttons[down].setVisibility(View.VISIBLE);
        }
    }
    //endregion
}




