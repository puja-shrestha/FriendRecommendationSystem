package com.example.puza.friendrecommendation;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class RegisterActivity extends AppCompatActivity {

    private EditText first_name;
    private EditText last_name;
    private EditText email;
    private EditText password;
    private EditText confirm_password;
    private EditText mobile;
    private EditText address;
    private EditText location;
    private EditText terms_conditions;

    private Button registerBtn;

    private TextView selectDate;
    Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);
//        registerManager = RegisterClient.getInstance();

        first_name = (EditText)findViewById(R.id.first_name);
        last_name = (EditText)findViewById(R.id.last_name);
        email = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);
        confirm_password = (EditText)findViewById(R.id.confirm_password);
        mobile = (EditText)findViewById(R.id.mobile);
        address = (EditText)findViewById(R.id.address);


        selectDate = findViewById(R.id.btnDate);
        // final TextView date = view.findViewById(R.id.tvSelectedDate);

        selectDate.setOnClickListener(new View.OnClickListener() {

            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

            @Override
            public void onClick(View view) {

                DatePickerDialog datePickerDialog = new DatePickerDialog(RegisterActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                                selectDate.setText(day + "/" + month + "/" + year);

                            }
                        }, year, month, dayOfMonth);

                datePickerDialog.show();
            }
        });


//        registerBtn = (Button) findViewById(R.id.registerBtn);
//
//        registerBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                postUserData();
//            }
//        });

    }
}
