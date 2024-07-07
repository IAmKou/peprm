package com.example.peprm;// MainActivity.java
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    ImageButton ivAddNew;
    ListView lv;
    ArrayAdapter adapter;
    ArrayList<Employee> dsEmployee = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ivAddNew = findViewById(R.id.ivAdd);
        lv = findViewById(R.id.lvEmployee);
        dsEmployee = EmployeeDao.getAll(MainActivity.this);
        adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, dsEmployee);
        lv.setAdapter(adapter);

        ivAddNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogAdd();
            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "pos: " + position, Toast.LENGTH_SHORT).show();
                showDialogEdit(position);
            }
        });
    }

    private void showDialogEdit(int pos){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.activity_edit_delete, null);
        builder.setView(view);
        Dialog dialog = builder.create();
        dialog.show();

        EditText edName = view.findViewById(R.id.editNameCN);
        EditText edHireDate = view.findViewById(R.id.editHireDateCN);
        EditText edSalary = view.findViewById(R.id.editSalaryCN);
        Button btnEdit = view.findViewById(R.id.btnSaveEdit);
        Button btnDelete = view.findViewById(R.id.btnDelete);
        Employee em = dsEmployee.get(pos);
        edName.setText(em.getFullName());
        edHireDate.setText(em.getHiredate());
        edSalary.setText(em.getSalary());

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                em.setFullName(edName.getText().toString());
                em.setHiredate(edHireDate.getText().toString());
                em.setSalary(edSalary.getText().toString());
                if(EmployeeDao.update(MainActivity.this, em)){
                    Toast.makeText(MainActivity.this, "Edit Successful", Toast.LENGTH_SHORT).show();
                    dsEmployee.clear();
                    dsEmployee.addAll(EmployeeDao.getAll(MainActivity.this));
                    adapter.notifyDataSetChanged();
                    dialog.dismiss();
                }else{
                    Toast.makeText(MainActivity.this, "Edit Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(EmployeeDao.delete(MainActivity.this, em.getId())){
                    Toast.makeText(MainActivity.this, "Delete Successful", Toast.LENGTH_SHORT).show();
                    dsEmployee.clear();
                    dsEmployee.addAll(EmployeeDao.getAll(MainActivity.this));
                    adapter.notifyDataSetChanged();
                    dialog.dismiss();
                }else{
                    Toast.makeText(MainActivity.this, "Delete Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void showDialogAdd(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.activity_add, null);
        builder.setView(view);
        Dialog dialog = builder.create();
        dialog.show();

        EditText edName = view.findViewById(R.id.editName);
        EditText edHireDate = view.findViewById(R.id.editHireDate);
        EditText edSalary = view.findViewById(R.id.editSalary);
        Button btnSave = view.findViewById(R.id.btnSaveAdd);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edName.getText().toString();
                String hireDate = edHireDate.getText().toString();
                String salary = edSalary.getText().toString();
                if(EmployeeDao.insert(MainActivity.this, name, hireDate, salary)){
                    Toast.makeText(MainActivity.this, "Add Successful", Toast.LENGTH_SHORT).show();
                    dsEmployee.clear();
                    dsEmployee.addAll(EmployeeDao.getAll(MainActivity.this));
                    adapter.notifyDataSetChanged();
                    dialog.dismiss();
                }else{
                    Toast.makeText(MainActivity.this, "Add Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}
