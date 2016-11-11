package com.example.ashwin.sharedpreferencessaveobjects;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mEmployeeIdEditText, mEmployeeNameEditText;
    private SharedPreferencesManager mSharedPreferencesManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSharedPreferencesManager = new SharedPreferencesManager(this);

        initViews();
    }

    private void initViews()
    {
        mEmployeeIdEditText = (EditText) findViewById(R.id.employeeIdEditText);
        mEmployeeNameEditText = (EditText) findViewById(R.id.employeeNameEditText);
    }

    public void save(View view)
    {
        Employee employee = new Employee( mEmployeeIdEditText.getText().toString(), mEmployeeNameEditText.getText().toString() );
        mSharedPreferencesManager.setEmployee(employee);
        Toast.makeText(this, "Saved", Toast.LENGTH_LONG).show();
    }

    public void check(View view)
    {
        Intent intent = new Intent(MainActivity.this, EmployeeActivity.class);
        startActivity(intent);
    }
}
