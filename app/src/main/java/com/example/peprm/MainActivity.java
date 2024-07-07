package com.example.peprm;// MainActivity.java
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TableLayout employeeTable;
    private List<Employee> employeeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        employeeTable = findViewById(R.id.employeeTable);

        // Sample data
        employeeList = new ArrayList<>();
        employeeList.add(new Employee(1, "Ramesh Fadatare", "2022-01-01", 50000));
        employeeList.add(new Employee(2, "John Cena", "2022-01-02", 60000));
        employeeList.add(new Employee(3, "Tony Stark", "2022-01-03", 70000));
        employeeList.add(new Employee(4, "Tom Cruise", "2022-01-04", 80000));
        employeeList.add(new Employee(5, "Amir Khan", "2022-01-05", 90000));

        addTableRows();
    }

    private void addTableRows() {
        for (Employee employee : employeeList) {
            TableRow tableRow = new TableRow(this);

            TextView id = new TextView(this);
            id.setText(String.valueOf(employee.getId()));
            id.setGravity(Gravity.CENTER);

            TextView fullName = new TextView(this);
            fullName.setText(employee.getFullName());
            fullName.setGravity(Gravity.CENTER);

            TextView date = new TextView(this);
            date.setText(employee.getDate());
            date.setGravity(Gravity.CENTER);

            TextView salary = new TextView(this);
            salary.setText(String.valueOf(employee.getSalary()));
            salary.setGravity(Gravity.CENTER);

            // Action Buttons
            Button updateButton = new Button(this);
            updateButton.setText("Update");
            updateButton.setOnClickListener(v -> {
                // Handle update action
            });

            Button deleteButton = new Button(this);
            deleteButton.setText("Delete");
            deleteButton.setTextColor(getResources().getColor(android.R.color.white));
            deleteButton.setBackgroundColor(getResources().getColor(android.R.color.holo_red_dark));
            deleteButton.setOnClickListener(v -> {
                // Handle delete action
            });

            Button addButton = new Button(this);
            addButton.setText("Add");
            addButton.setOnClickListener(v -> {
                // Handle add action
            });

            TableRow actionRow = new TableRow(this);
            actionRow.addView(updateButton);
            actionRow.addView(deleteButton);
            actionRow.addView(addButton);

            tableRow.addView(id);
            tableRow.addView(fullName);
            tableRow.addView(date);
            tableRow.addView(salary);

            // Wrap action buttons in a horizontal layout to fit in the "Actions" column
            TableRow actionRowWrapper = new TableRow(this);
            actionRowWrapper.addView(actionRow);

            tableRow.addView(actionRowWrapper);

            employeeTable.addView(tableRow);
        }
    }
}
