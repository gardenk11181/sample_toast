package com.gardenlab.sampletoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editText1;
    private EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
    }

    public void onButton1Clicked(View v) {
        try {
            Toast toastView = Toast.makeText(this, "Position Changed", Toast.LENGTH_SHORT);

            int xOffset = Integer.parseInt(editText1.getText().toString());
            int yOffset = Integer.parseInt(editText2.getText().toString());

            toastView.setGravity(Gravity.TOP|Gravity.TOP, xOffset,yOffset);
            toastView.show();
        } catch(NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public void onButton2Clicked(View v) {
        LayoutInflater inflater = getLayoutInflater();

        View layout = inflater.inflate(
                R.layout.toastborder,
                (ViewGroup) findViewById(R.id.toast_layout_root));
        TextView text = layout.findViewById(R.id.text);

        Toast toast = new Toast(this);
        text.setText("모양 바꾼 토스트");
        toast.setGravity(Gravity.CENTER, 0,-100);
        toast.setDuration(Toast.LENGTH_SHORT);

        toast.setView(layout);
        toast.show();
    }
}
