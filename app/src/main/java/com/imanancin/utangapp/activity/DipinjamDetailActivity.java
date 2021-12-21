package com.imanancin.utangapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.imanancin.utangapp.R;
import com.imanancin.utangapp.model.DataModel;

public class DipinjamDetailActivity extends AppCompatActivity {

    private String TAG = "DipinjamDetailAct";
    TextView customer_name, date, total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dipinjam_detail);

        // ambil data dari intent parcelable
        DataModel dm = getIntent().getParcelableExtra("DATA");
        Log.d(TAG, dm.getCustomer_name());
        customer_name = (TextView) findViewById(R.id.tv_customer_name);
        customer_name.setText(dm.getCustomer_name());

        date = (TextView) findViewById(R.id.tv_date);
        date.setText(dm.getDate());

        total = (TextView) findViewById(R.id.tv_total);
        total.setText(dm.getTotal().toString());


    }
}