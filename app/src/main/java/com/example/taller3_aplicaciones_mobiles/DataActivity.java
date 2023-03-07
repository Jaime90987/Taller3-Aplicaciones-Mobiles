package com.example.taller3_aplicaciones_mobiles;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.widget.Button;
import android.widget.TextView;

public class DataActivity extends AppCompatActivity {
    private static final float NOTA = 4.5f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        TextView tv_data = findViewById(R.id.tv_data);
        Button btn_back = findViewById(R.id.btn_back);

        btn_back.setOnClickListener(v -> finish());

        Intent intent = getIntent();
        Student student = (Student) intent.getSerializableExtra("student");

        String title = "Consulta de Nota";
        String code = "Código de estudiante";
        String email = "Correo Institucional";
        String note = "Nota Definitiva";

        SpannableString spannableString1 = new SpannableString(title);
        spannableString1.setSpan(new StyleSpan(Typeface.BOLD), 0, title.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString1.setSpan(new AbsoluteSizeSpan(28, true), 0, title.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString1.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this, R.color.dark_blue)), 0, title.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        SpannableString spannableString2 = new SpannableString(code);
        spannableString2.setSpan(new StyleSpan(Typeface.BOLD), 0, code.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString2.setSpan(new AbsoluteSizeSpan(20, true), 0, code.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString2.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this, R.color.black)), 0, code.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        SpannableString spannableString3 = new SpannableString(student.getStudent_code());
        spannableString3.setSpan(new AbsoluteSizeSpan(17, true), 0, student.getStudent_code().length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        SpannableString spannableString4 = new SpannableString(email);
        spannableString4.setSpan(new StyleSpan(Typeface.BOLD), 0, email.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString4.setSpan(new AbsoluteSizeSpan(20, true), 0, email.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString4.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this, R.color.black)), 0, email.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        SpannableString spannableString5 = new SpannableString(student.getEmail());
        spannableString5.setSpan(new AbsoluteSizeSpan(17, true), 0, student.getEmail().length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        SpannableString spannableString6 = new SpannableString(note);
        spannableString6.setSpan(new StyleSpan(Typeface.BOLD), 0, note.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString6.setSpan(new AbsoluteSizeSpan(20, true), 0, note.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString6.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this, R.color.black)), 0, note.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        SpannableString spannableString7 = new SpannableString(Float.toString(NOTA));
        spannableString7.setSpan(new AbsoluteSizeSpan(17, true), 0, Float.toString(NOTA).length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        SpannableStringBuilder builder = new SpannableStringBuilder();
        builder.append("\n")
                .append(spannableString1)
                .append("\n\n\n")
                .append(spannableString2)
                .append("\n")
                .append(spannableString3)
                .append("\n\n\n")
                .append(spannableString4)
                .append("\n")
                .append(spannableString5)
                .append("\n\n\n")
                .append(spannableString6)
                .append("\n")
                .append(spannableString7);

        tv_data.setText(builder);
    }
}