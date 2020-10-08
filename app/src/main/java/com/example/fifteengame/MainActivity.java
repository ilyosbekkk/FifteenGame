package com.example.fifteengame;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    //region onCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String username;
        timer = findViewById(R.id.timer);
        if (getIntent().hasExtra("username")) {
            username = getIntent().getStringExtra("username");
            Toast.makeText(this, "HI " + username + "!", Toast.LENGTH_SHORT).show();

        }


        // initialize buttons array
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
                findViewById(R.id.button16)
        };
        dimension = (int) Math.sqrt(buttons.length);

        // set texts 1~16 to the buttons
        for (int n = 0; n < buttons.length; n++) {
            buttons[n].setText(String.valueOf(n + 1));
            buttons[n].setTag(n);
        }

        // hide button #16
        buttons[buttons.length - 1].setVisibility(View.INVISIBLE);

        // shuffle the buttons
        shuffleButtons();

        thread = new Timer();
        thread.start();


    }
    //endregion

    // region Variables
    TextView timer;
    Timer thread;
    private static final int SHUFFLE_TIMES = 500;
    private static final String TAG = "MyFifteenGame";
    private Button[] buttons;
    private int dimension;
    // endregion


    //region  onButtonClick
    public void onButtonClick(View view) {
        // find which direction the clicked button should move to

        int clickedIndex = (int) view.getTag();
        int emptyIndex = -1;
        for (int n = 0; n < buttons.length; n++)
            if (buttons[n].getVisibility() == View.INVISIBLE) {
                emptyIndex = n;
                break;
            }

        if (emptyIndex % dimension != dimension - 1 && clickedIndex == emptyIndex + 1) {
            // left case
            switchButtons(buttons[clickedIndex], buttons[emptyIndex]);
        } else if (emptyIndex % dimension != 0 && clickedIndex == emptyIndex - 1) {
            // right case
            switchButtons(buttons[clickedIndex], buttons[emptyIndex]);
        } else if (emptyIndex < buttons.length - dimension && clickedIndex == emptyIndex + dimension) {
            // up case
            switchButtons(buttons[clickedIndex], buttons[emptyIndex]);
        } else if (emptyIndex >= dimension && clickedIndex == emptyIndex - dimension) {
            // down case
            switchButtons(buttons[clickedIndex], buttons[emptyIndex]);
        } else {
            Log.e(TAG, "onButtonClick: " + clickedIndex + ", " + emptyIndex);
            return;
        }

        // check if empty index has the correct value
        validateButtonCorrectness(emptyIndex);
        buttons[clickedIndex].setSelected(false);

        if (areAllButtonsCorrect()) {
            Toast.makeText(this, "Congratulations! You did it!", Toast.LENGTH_SHORT).show();
            thread.interrupt();
            shuffleButtons();
        }

        // buttons[emptyIndex].startAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_button_appear));
        // buttons[clickedIndex].startAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_button_disappear));
    }
    //endregion


    //region validateButtonCorrectness
    private void validateButtonCorrectness(int index) {
        boolean correct = String.valueOf(((int) buttons[index].getTag()) + 1).equals(buttons[index].getText().toString());
        buttons[index].setSelected(correct);
    }
    //endregion

    //region switchButtons
    private void switchButtons(Button a, Button b) {
        CharSequence tempStr = a.getText();
        a.setText(b.getText());
        b.setText(tempStr);

        int tempVis = a.getVisibility();
        a.setVisibility(b.getVisibility());
        b.setVisibility(tempVis);
    }
    //endregion

    //region shuffleButtons
    private void shuffleButtons() {
        Random random = new Random();

        // find the empty button
        int emptyIndex = -1;
        for (int n = 0; n < buttons.length; n++)
            if (buttons[n].getVisibility() == View.INVISIBLE) {
                emptyIndex = n;
                break;
            }

        for (int n = 0; n < SHUFFLE_TIMES; n++) {
            // find neighbor buttons to the empty button
            ArrayList<Button> neighbors = new ArrayList<>();
            if (emptyIndex % dimension != 0) {
                // left neighbor
                neighbors.add(buttons[emptyIndex - 1]);
            }
            if (emptyIndex % dimension != dimension - 1) {
                // right neighbor
                neighbors.add(buttons[emptyIndex + 1]);
            }
            if (emptyIndex >= dimension) {
                // above neighbor
                neighbors.add(buttons[emptyIndex - dimension]);
            }
            if (emptyIndex < buttons.length - dimension) {
                // below neighbor
                neighbors.add(buttons[emptyIndex + dimension]);
            }

            // pick one neighbor for switching
            int randomNeighborIndex = random.nextInt(neighbors.size());

            // switch
            switchButtons(buttons[emptyIndex], neighbors.get(randomNeighborIndex));
            emptyIndex = (int) neighbors.get(randomNeighborIndex).getTag();
        }

        // validate correctness of the shuffled buttons
        for (int n = 0; n < buttons.length; n++)
            validateButtonCorrectness(n);
    }
    //endregion

    //region areAllButtonsCorrect
    private boolean areAllButtonsCorrect() {
        boolean result = true;
        for (int n = 0; result && n < buttons.length - 1; n++)
            result = buttons[n].isSelected();
        return result;
    }
    //endregion

    //region timer
    class Timer extends Thread {
        @Override
        public void run() {
            try {
                runTime();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void runTime() throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            Thread.sleep(1000);
            int finalI = i;
            timer.post(() -> timer.setText(String.valueOf(finalI)));

        }
    }
    //endregion

}


