package com.example.k234111eapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CalculatorActivity extends AppCompatActivity {

    Button btnCalculate;
    TextView txtMC, txtMR, txtMPlus, txtMMinus, txtMS, txtM;
    View.OnClickListener click_m_listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculator);

        addViews();
        addEvents();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void addEvents() {
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processFormular();
            }
        });

        click_m_listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.equals(txtM)) {

                } else if (view.equals(txtMC)) {

                } else if (view.equals(txtMR)) {

                } else if (view.equals(txtMPlus)) {

                } else if (view.equals(txtMMinus)) {

                } else if (view.equals(txtMS)) {

                }
            }
        };

        txtM.setOnClickListener(click_m_listener);
        txtMC.setOnClickListener(click_m_listener);
        txtMMinus.setOnClickListener(click_m_listener);
        txtMR.setOnClickListener(click_m_listener);
        txtMPlus.setOnClickListener(click_m_listener);
        txtMS.setOnClickListener(click_m_listener);
    }

    private void processFormular() {
        EditText edtFormular = findViewById(R.id.edtFormular);
        String formular = edtFormular.getText().toString();

        // Tạm thời giữ nguyên công thức để không bị xóa trắng màn hình
        String result = formular;

        edtFormular.setText(result);
    }

    private void addViews() {
        btnCalculate = findViewById(R.id.btnCalculate);
        txtMC = findViewById(R.id.txtMC);
        txtMR = findViewById(R.id.txtMR);
        txtMPlus = findViewById(R.id.txtMPlus);
        txtMMinus = findViewById(R.id.txtMMinus);
        txtMS = findViewById(R.id.txtMS);
        txtM = findViewById(R.id.txtM);
    }

    public void processChooseValue(View view) {
        Button btn = (Button) view;

        EditText edtFormular = findViewById(R.id.edtFormular);
        String old_value = edtFormular.getText().toString();
        String new_value = btn.getText().toString();

        if (old_value.equals("0")) {
            edtFormular.setText(new_value);
        } else {
            edtFormular.setText(old_value + new_value);
        }
    }

    public void processBackspace(View view) {
        EditText edtFormular = findViewById(R.id.edtFormular);
        String old_value = edtFormular.getText().toString();
        String new_value;

        if (old_value.length() > 1) {
            new_value = old_value.substring(0, old_value.length() - 1);
        } else {
            new_value = "0";
        }

        edtFormular.setText(new_value);
    }
}