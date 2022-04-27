package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView text;
    //Button



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.textView3);
    }
    public void write(View view)
    {
        Button b = (Button) view;
        String s = b.getText().toString();
        text.append(s);
    }

    public void clearAll(View view)
    {
        text.setText("");

    }
    public void clearOne(View view)
    {
        String display = text.getText().toString();
        display = display.substring(0,display.length()-1);
        text.setText(display);
    }
    public void evaluate(View view)
    {
        String display = text.getText().toString();
        try {
            Double d = Double.parseDouble(display);
            text.setText(d.toString());
        }
        catch (NumberFormatException nfe)
        {

            String[] i = display.split("[+/*-]");
            Double f = Double.parseDouble(i[0]);
            Double s = Double.parseDouble(i[1]);
            text.append(f.toString());
            text.append(s.toString());
            if(display.contains("+"))
            {
                Double result = f + s;
                String a = result.toString();
                text.setText(a);
            }
            else if (display.contains("-"))
            {
                Double result = f - s;
                text.setText(result.toString());
            }
            else if (display.contains("/"))
            {
                Double result = f / s;
                text.setText(result.toString());
            }
            else if (display.contains("*"))
            {
                Double result = f * s;
                text.setText(result.toString());
            }

        }
    }
}