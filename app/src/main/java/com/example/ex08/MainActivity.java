package com.example.ex08;

import static java.lang.System.exit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    private final String FILENAME = "internal.txt";
    TextView tV;
    EditText eT;
    String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tV = findViewById(R.id.tV);
        eT = findViewById(R.id.eT);

        read(null);
    }

    public void onSave(View view) {
        text = eT.getText().toString();
        try {
            FileOutputStream fOS = openFileOutput(FILENAME, MODE_PRIVATE);
            OutputStreamWriter oSW = new OutputStreamWriter(fOS);
            BufferedWriter bW = new BufferedWriter(oSW);
            bW.write(text);
            bW.close();
            oSW.close();
            fOS.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onReset(View view) {
        try {
            FileOutputStream fOS = openFileOutput(FILENAME, MODE_PRIVATE);
            OutputStreamWriter oSW = new OutputStreamWriter(fOS);
            BufferedWriter bW = new BufferedWriter(oSW);
            bW.write("");
            bW.close();
            oSW.close();
            fOS.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onExit(View view) {
        text = eT.getText().toString();
        try {
            FileOutputStream fOS = openFileOutput(FILENAME, MODE_PRIVATE);
            OutputStreamWriter oSW = new OutputStreamWriter(fOS);
            BufferedWriter bW = new BufferedWriter(oSW);
            bW.write(text);
            bW.close();
            oSW.close();
            fOS.close();
            exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void read(View view) {
        try {
            FileInputStream fIS = openFileInput(FILENAME);
            InputStreamReader iSR = new InputStreamReader(fIS);
            BufferedReader bR = new BufferedReader(iSR);
            StringBuilder sB = new StringBuilder();
            String line = bR.readLine();
            while (line != null) {
                sB.append(line + '\n');
                line = bR.readLine();
            }
            bR.close();
            iSR.close();
            fIS.close();
            tV.setText(sB.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}