package com.example.peprm;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class EmployeeDao {
    public static ArrayList<Employee> getAll(Context context){
        ArrayList<Employee> ds = new ArrayList<>();
        DbHelper helper = new DbHelper(context);
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cs = db.rawQuery("Select * from Employee", null);
        cs.moveToFirst();
        while(!cs.isAfterLast()){
            int id = cs.getInt(0);
            String name = cs.getString(1);
            String hireDate = cs.getString(2);
            String salary = cs.getString(3);
            Employee em = new Employee(id, name, hireDate, salary);
            ds.add(em);
            cs.moveToNext();
        }
        db.close();
        cs.close();
        return ds;
    }

    public static boolean insert(Context context, String name, String hireDate, String salary){
        DbHelper helper = new DbHelper(context);
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("FullName", name);
        values.put("HireDate", hireDate);
        values.put("Salary", salary);
        long row =db.insert("Employee", null, values);
        return (row > 0);
    }
    public static boolean update (Context context, Employee em){
        DbHelper helper = new DbHelper(context);
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("FullName", em.getFullName());
        values.put("HireDate", em.getHiredate());
        values.put("Salary", em.getSalary());
        int row =db.update("Employee", values, "Id=?", new String[]{em.getId()+ ""});
        return (row>0);
    }

    public static boolean delete(Context context, int id){
        DbHelper helper = new DbHelper(context);
        SQLiteDatabase db = helper.getWritableDatabase();
        int row = db.delete("Employee","Id=?", new String[]{id+ ""});
        return (row>0);
    }
}
