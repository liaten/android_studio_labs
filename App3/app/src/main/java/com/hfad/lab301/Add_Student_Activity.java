package com.hfad.lab301;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

class PStudent implements Parcelable{
    private String Full_Name,Gender,Programming_Languages,IDE;
    public PStudent(String Full_Name_Add, String Gender_Add, String Programming_Languages_Add, String IDE_Add){
        this.Full_Name = Full_Name_Add;
        this.Gender = Gender_Add;
        this.Programming_Languages = Programming_Languages_Add;
        this.IDE = IDE_Add;
    }

    protected PStudent(Parcel in) {
        Full_Name = in.readString();
        Gender = in.readString();
        Programming_Languages = in.readString();
        IDE = in.readString();
    }

    public static final Creator<PStudent> CREATOR = new Creator<PStudent>() {
        @Override
        public PStudent createFromParcel(Parcel in) {
            return new PStudent(in);
        }

        @Override
        public PStudent[] newArray(int size) {
            return new PStudent[size];
        }
    };

    public String Get_Full_Name(){
        return this.Full_Name;
    }
    public void Set_Full_Name(String New_Full_Name){
        this.Full_Name = New_Full_Name;
    }
    public String Get_Gender(){
        return this.Gender;
    }
    public void Set_Gender(String New_Gender){
        this.Gender = New_Gender;
    }
    public String Get_Programming_Languages(){
        return this.Programming_Languages;
    }
    public void Set_Programming_Languages(String New_Programming_Languages){
        this.Programming_Languages = New_Programming_Languages;
    }
    public String Get_IDE(){
        return this.IDE;
    }
    public void Set_IDE(String New_IDE){
        this.IDE = New_IDE;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(Full_Name);
        parcel.writeString(Gender);
        parcel.writeString(Programming_Languages);
        parcel.writeString(IDE);
    }
}
public class Add_Student_Activity extends AppCompatActivity {
    Button saveButton;
    EditText
            FullNameEditText,
            IDEEditText,
            PLEditText,
            GenderEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_student_activity);
        saveButton = (Button) findViewById(R.id.SaveButton);
        FullNameEditText = (EditText) findViewById(R.id.FullNameEditText);
        IDEEditText = (EditText) findViewById(R.id.IDEEditText);
        PLEditText = (EditText) findViewById(R.id.PLEditText);
        GenderEditText = (EditText) findViewById(R.id.GenderEditText);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(     FullNameEditText.getText().toString().equals("")
                        || IDEEditText.getText().toString().equals("")
                        || PLEditText.getText().toString().equals("")
                        || GenderEditText.getText().toString().equals("")){
                    Toast.makeText(Add_Student_Activity.this,"Не все поля заполнены",Toast.LENGTH_SHORT).show();
                }
                else{
                    String FullName = FullNameEditText.getText().toString();
                    String IDE = IDEEditText.getText().toString();
                    String PL = PLEditText.getText().toString();
                    String Gender = GenderEditText.getText().toString();
                    PStudent PS = new PStudent(FullName,Gender,PL,IDE);
                    Intent resultIntent = new Intent(Add_Student_Activity.this,MainActivity.class);
                    resultIntent.putExtra("student",PS);
                    setResult(Activity.RESULT_OK,resultIntent);
                    finish();
                }
            }
        });
    }
}
