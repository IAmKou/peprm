package com.example.peprm;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Update extends AppCompatActivity {

    private EditText editName;
    private EditText editDate;
    private EditText editSalary;
    private Button btnUpdate;
    private Employee employee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        editName = findViewById(R.id.editName);
        editDate = findViewById(R.id.editDate);
        editSalary = findViewById(R.id.editSalary);
        btnUpdate = findViewById(R.id.btn_update);

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("employee")) {
            employee = (Employee) intent.getSerializableExtra("employee");
            if (employee != null) {
                editName.setText(employee.getFullName());
                editDate.setText(employee.getDate());
                editSalary.setText(String.valueOf(employee.getSalary()));
            }
        }

        btnUpdate.setOnClickListener(v -> {
            String name = editName.getText().toString();
            String date = editDate.getText().toString();
            double salary = Double.parseDouble(editSalary.getText().toString());

            employee.setFullName(name);
            employee.setDate(date);
            employee.setSalary(salary);

            Intent resultIntent = new Intent();
            resultIntent.putExtra("updatedEmployee", employee);
            setResult(RESULT_OK, resultIntent);
            finish();
        });
    }
}
