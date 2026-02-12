package com.example.miprimeraapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView tempVal;
    Button btn;
    RadioButton opt;
    EditText txtNum1, txtNum2;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btnCalcular);
        txtNum1 = findViewById(R.id.txtNum1);
        txtNum2 = findViewById(R.id.txtNum2);
        radioGroup = findViewById(R.id.optOpciones);

        // 🔹 Escuchar cambios en el grupo de opciones
        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.optFactorial) {
                // Deshabilitar NUM 2 cuando se selecciona Factorial
                txtNum2.setEnabled(false);
                txtNum2.setText(""); // opcional: limpiar el campo
            } else {
                // Habilitar NUM 2 para las demás operaciones
                txtNum2.setEnabled(true);
            }
        });

        btn.setOnClickListener(v -> calcular());
    }

    private void calcular() {
        tempVal = findViewById(R.id.txtNum1);
        Double num1 = Double.parseDouble(tempVal.getText().toString());

        // Solo leer num2 si está habilitado
        Double num2 = 0.0;
        if (txtNum2.isEnabled() && !txtNum2.getText().toString().isEmpty()) {
            num2 = Double.parseDouble(txtNum2.getText().toString());
        }

        double respuesta = 0;

        opt = findViewById(R.id.optSuma);
        if(opt.isChecked()) {
            radioGroup = findViewById(R.id.optOpciones);
            if(radioGroup.getCheckedRadioButtonId()==R.id.optSuma) {
                respuesta = num1 + num2;
            }
            opt = findViewById(R.id.optResta);
            if(opt.isChecked()){
                if(radioGroup.getCheckedRadioButtonId()==R.id.optResta) {
                    respuesta = num1 - num2;
                }
                opt = findViewById(R.id.optMultiplicacion);
                if(opt.isChecked()){
                    if(radioGroup.getCheckedRadioButtonId()==R.id.optMultiplicacion) {
                        respuesta = num1 * num2;
                    }
                    opt = findViewById(R.id.optDivision);
                    if(opt.isChecked()){
                        if(radioGroup.getCheckedRadioButtonId()==R.id.optDivision) {
                            respuesta = num1 / num2;
                        }
                        tempVal = findViewById(R.id.lblRespuesta);
                        tempVal.setText("Respuesta: "+ respuesta);
                    }