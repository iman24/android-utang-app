package com.imanancin.utangapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.ArrayMap;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.imanancin.utangapp.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class TambahActivity extends AppCompatActivity {

    EditText et_customer, et_total, et_date;
    Button tambah;
    RadioGroup pilih;
    RadioButton rb_dipinjam, rb_meminjam;
    Calendar calendar = Calendar.getInstance();

    ArrayMap<String, String> data = new ArrayMap<String, String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);

        et_customer = (EditText) findViewById(R.id.et_customer);
        et_total = (EditText) findViewById(R.id.et_total);
        et_date = (EditText) findViewById(R.id.et_date);
        rb_dipinjam = (RadioButton) findViewById(R.id.rb_dipinjam);
        rb_meminjam = (RadioButton) findViewById(R.id.rb_meminjam);
        pilih = (RadioGroup) findViewById(R.id.pilih);


        updateDateLabel();


        tambah = (Button) findViewById(R.id.tambah);
        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int p = pilih.getCheckedRadioButtonId();
                switch (p) {
                    case R.id.rb_dipinjam:
                        data.put("dipinjam", "ya");
                        break;
                    case R.id.meminjam:
                        data.put("meminjam", "ya");
                        break;
                }
                data.put("customer", et_customer.getText().toString());
                data.put("total", et_total.getText().toString());
                data.put("date", et_date.getText().toString());
                Toast.makeText(TambahActivity.this, data.toString(), Toast.LENGTH_SHORT).show();
            }
        });



        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                calendar.set(Calendar.YEAR, i);
                calendar.set(Calendar.MONTH, i1);
                calendar.set(Calendar.DAY_OF_MONTH, i2);
                updateDateLabel();
            }
        };

        et_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(TambahActivity.this, date, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
                Toast.makeText(TambahActivity.this, "HALOO", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void updateDateLabel(){
        String format = "dd/MM/yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(format, Locale.US);
        et_date.setText(dateFormat.format(calendar.getTime()));
    }
}