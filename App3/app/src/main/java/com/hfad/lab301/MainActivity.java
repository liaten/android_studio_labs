package com.hfad.lab301;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

class Student{
    private String Full_Name,Gender,Programming_Languages,IDE;
    public Student(String Full_Name_Add, String Gender_Add, String Programming_Languages_Add, String IDE_Add){
        this.Full_Name = Full_Name_Add;
        this.Gender = Gender_Add;
        this.Programming_Languages = Programming_Languages_Add;
        this.IDE = IDE_Add;
    }
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
}
public class MainActivity extends AppCompatActivity {

    ImageButton add_button;
    ListView  mainLV;
    List list = new ArrayList();
    ArrayList<Student> studlist = new ArrayList<>();
    ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add_button = (ImageButton) findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent addIntent = new Intent("android.intent.action.add_student_activity");
                startActivityForResult(addIntent,1);
            }
        });
        mainLV = (ListView) findViewById(R.id.main_list_view);
        Student Vlad = new Student("Пестерев Владислав Олегович","Мужской","C#, Kotlin, Java","Android Studio, Visual Studio");
        Student Sanya = new Student("Ватаманов Александр Александрович","Мужской","Java, C#, Delphi","Visual Studio");
        Student Artem = new Student("Гарматко Артем Сергеевич","Мужский","C#, Java","Visual Studio");
        Student Andrey = new Student("Черняев Андрей Григорьевич","Мужской","Java","IntelliJ Idea");
        studlist.add(Vlad);
        studlist.add(Sanya);
        studlist.add(Artem);
        studlist.add(Andrey);
        list.add("Группа 131-ПИо, Прикладная информатика, Сыктывкарский государственный университет им. Питиима Сорокина");
        for(int i=0;i<studlist.size();i++){
            list.add(studlist.get(i).Get_Full_Name() + "\n" + studlist.get(i).Get_IDE() + " | " + studlist.get(i).Get_Gender() + " | " + studlist.get(i).Get_Programming_Languages() );
        }
        adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,list);
        mainLV.setAdapter(adapter);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            if(resultCode == RESULT_OK){
                PStudent PS = data.getParcelableExtra("student");
                adapter.add(PS.Get_Full_Name() + "\n" + PS.Get_IDE() + " | " + PS.Get_Gender() + " | " + PS.Get_Programming_Languages());
            }
        }
    }
}
