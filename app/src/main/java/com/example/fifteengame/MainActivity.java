package com.example.fifteengame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MainActivity";
    //region UI componenets
    TableLayout group;
    TableRow row;
    Button button;
    //endregion

    //region vars
    int index;

    //endregion
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        group = findViewById(R.id.table_layout);
        button = findViewById(R.id.button12);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row = (TableRow) v.getParent();
                row.removeViewAt(3);

                row = (TableRow) group.getChildAt(3);
                row.addView(button, 3);

                Log.d(TAG, "onClick: ");
            }
        });


    }


}