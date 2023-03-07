package com.example.taller3_aplicaciones_mobiles;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class FormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        TextInputLayout ti_code = findViewById(R.id.ti_code);
        TextInputLayout ti_email = findViewById(R.id.ti_email);

        Button btn_note = findViewById(R.id.btn_note);

        btn_note.setOnClickListener(v -> {

            String input_code = ti_code.getEditText().getText().toString().trim();
            String input_email = ti_email.getEditText().getText().toString().trim();

            ti_code.setHelperText("");
            ti_email.setHelperText("");

            if (input_code.isEmpty() && input_email.isEmpty()) {
                ti_code.setHelperText("Introduce tu código de estudiante *");
                ti_email.setHelperText("Introduce tu email institucional *");
            } else if (input_code.isEmpty()) {
                ti_code.setHelperText("Introduce tu código de estudiante *");
            } else if (input_email.isEmpty()) {
                ti_email.setHelperText("Introduce tu email institucional *");
            } else if (!Patterns.EMAIL_ADDRESS.matcher(input_email).matches()) {
                ti_email.setHelperText("Correo no válido");
            } else {
                Student student = new Student(input_code, input_email);

                Intent intent = new Intent(FormActivity.this, DataActivity.class);
                intent.putExtra("student", student);

                ti_code.getEditText().setText("");
                ti_email.getEditText().setText("");

                startActivity(intent);
            }
        });
    }
}