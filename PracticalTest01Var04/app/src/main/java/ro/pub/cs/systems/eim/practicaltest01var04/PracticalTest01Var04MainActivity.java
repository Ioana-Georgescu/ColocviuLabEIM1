package ro.pub.cs.systems.eim.practicaltest01var04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PracticalTest01Var04MainActivity extends AppCompatActivity {
    private String EDIT_TEXT1 = "edit1";
    private String EDIT_TEXT2 = "edit2";
    private CheckBox checkBox1;
    private CheckBox checkBox2;
    private EditText editText1, editText2;
    private TextView displayTextView;
    private Button navigateToSecondaryActivityButton, displayText;
    private boolean check1, check2;
    private String message;

    public void itemClicked1(View v) {
        //code to check if this checkbox is checked!
        CheckBox checkBox = (CheckBox) v;
        if (checkBox.isChecked()) {
            check1 = true;
        }
        else {
            check1 = false;
        }
    }

    public void itemClicked2(View v) {
        //code to check if this checkbox is checked!
        CheckBox checkBox = (CheckBox) v;
        if (checkBox.isChecked()) {
            check2 = true;
        }
        else {
            check2 = false;
        }
    }

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
        }
    }


    private ButtonClickListenerDisplay buttonClickListenerDisplay = new ButtonClickListenerDisplay();
    private class ButtonClickListenerDisplay implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            message = "";
            String text1 = String.valueOf(editText1.getText().toString());
            String text2 = String.valueOf(editText2.getText().toString());
            if (check1) {
                if (!text1.equals("")) {
                    message += text1;
                }
                else {
//                    Toast.makeText(getApplicationContext(),"No input 1", Toast.LENGTH_LONG).show();
                }
            }
            if (check2) {
                if (!text1.equals("")) {
                    message += text2;
                }
                else {
//                    Toast.makeText(this, "No input 2", Toast.LENGTH_LONG).show();
                }
            }
            displayTextView.setText(message);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var04_main);

        checkBox1 = (CheckBox)findViewById(R.id.checkBox1);
        checkBox2 = (CheckBox)findViewById(R.id.checkBox2);
        editText1 = (EditText)findViewById(R.id.editText1);
        editText2 = (EditText)findViewById(R.id.editText2);
        displayTextView = (TextView)findViewById(R.id.textViewFinal);
        navigateToSecondaryActivityButton = (Button)findViewById(R.id.navigate_to_secondary_activity_button);
        navigateToSecondaryActivityButton.setOnClickListener(buttonClickListener);
        displayText = (Button)findViewById(R.id.display_info_button);
        displayText.setOnClickListener(buttonClickListenerDisplay);
        message = "";
        check1 = false;
        check2 = false;

        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey(EDIT_TEXT1)) {
                editText1.setText(savedInstanceState.getString(EDIT_TEXT1));
            } else {
                editText1.setText("");
            }
            if (savedInstanceState.containsKey(EDIT_TEXT2)) {
                editText2.setText(savedInstanceState.getString(EDIT_TEXT2));
            } else {
                editText2.setText("");
            }
        } else {
            editText1.setText("");
            editText2.setText("");
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString(EDIT_TEXT1, editText1.getText().toString());
        savedInstanceState.putString(EDIT_TEXT2, editText2.getText().toString());
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState.containsKey(EDIT_TEXT1)) {
            editText1.setText(savedInstanceState.getString(EDIT_TEXT1));
        } else {
            editText1.setText("");
        }
        if (savedInstanceState.containsKey(EDIT_TEXT2)) {
            editText2.setText(savedInstanceState.getString(EDIT_TEXT2));
        } else {
            editText2.setText("");
        }
    }
}