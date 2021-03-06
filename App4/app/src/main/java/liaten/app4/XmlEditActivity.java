package liaten.app4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XmlEditActivity extends Activity {
    ListView StudentLV;
    List list = new ArrayList();
    ArrayList<Student> student_list = new ArrayList<>();
    TextView head_text_view;
    EditText StudentETXml;
    Button add_button;
    ArrayAdapter adapter;
    boolean IsText = false;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xml_edit_activity);
        add_button = findViewById(R.id.add_param_button);
        head_text_view = findViewById(R.id.xml_head);
        head_text_view.setOnClickListener(change_on_head_click_listener);
        add_button.setOnClickListener(add_listener);
        StudentETXml = findViewById(R.id.editTextMultiLineXml);
        StudentLV = findViewById(R.id.listview_student);

        Student Vlad = new Student("Пестерев Владислав Олегович","Мужской","C#, Kotlin, Java","Android Studio, Visual Studio");
        Student Alex = new Student("Ватаманов Александр Александрович","Мужской","Java, C#, Delphi, SQL","Visual Studio");
        Student Artem = new Student("Гарматко Артем Сергеевич","Мужской","C#, Java, Delphi","Visual Studio");
        Student Andrey_CH = new Student("Черняев Андрей Григорьевич","Мужской","Java, SQL","IntelliJ Idea");
        Student Igor = new Student("Гончаров Игорь Валерьевич","Мужской","Java, SQL, C#","Android Studio");
        Student Andrey_G = new Student("Жариков Андрей Александрович","Мужской","Delphi","Embarcadero");
        student_list.add(Vlad);
        student_list.add(Alex);
        student_list.add(Artem);
        student_list.add(Andrey_CH);
        student_list.add(Igor);
        student_list.add(Andrey_G);

        StringBuilder to_edit_text = new StringBuilder("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<students>");
        String student;
        for (int i = 0; i < student_list.size(); i++)
        {
            student="\n\t\t<student>\n";
            student+="\t\t\t\t<full_name>";
            student+=student_list.get(i).Get_Full_Name();
            student+="</full_name>\n";
            student+="\t\t\t\t<ide>";
            student+=student_list.get(i).Get_IDE();
            student+="</ide>\n";
            student+="\t\t\t\t<gender>";
            student+=student_list.get(i).Get_Gender();
            student+="</gender>\n";
            student+="\t\t\t\t<pl>";
            student+=student_list.get(i).Get_Programming_Languages();
            student+="</pl>\n";
            list.add
                    (
                            student_list.get(i).Get_Full_Name() +
                            "\n" + student_list.get(i).Get_IDE() +
                            " | " + student_list.get(i).Get_Gender() +
                            " | " + student_list.get(i).Get_Programming_Languages()
                    );
            student+="\t\t</student>";
            to_edit_text.append(student);
        }
        to_edit_text.append("\n</students>");
        StudentETXml.setText(to_edit_text.toString());

        adapter = new ArrayAdapter(XmlEditActivity.this, android.R.layout.simple_list_item_1,list);
        StudentLV.setAdapter(adapter);
        StudentLV.setOnItemClickListener((AdapterView<?> parent, View view, int position, long id) -> {
            Intent editIntent = new Intent("android.intent.action.ChangeAddActivity");
            editIntent.putExtra("head",1);
            PStudent PS = new PStudent(
                    student_list.get((int) id).Get_Full_Name(),
                    student_list.get((int) id).Get_Gender(),
                    student_list.get((int) id).Get_Programming_Languages(),
                    student_list.get((int) id).Get_IDE()
                    );
            editIntent.putExtra("student", PS);
            int idd = (int) id;
            editIntent.putExtra("id",idd);
            startActivityForResult(editIntent,2);
        });
        Button save_button = findViewById(R.id.push_button);
        save_button.setOnClickListener(save_xml_listener);
        Button update_button = findViewById(R.id.update_button);
        update_button.setOnClickListener(update_from_xml_listener);
    }

    private final View.OnClickListener update_from_xml_listener = view -> {
        StudentETXml = findViewById(R.id.editTextMultiLineXml);
        FileInputStream fis;
        try
        {
            fis = openFileInput("1.xml");
            byte[] bytes = new byte[fis.available()];
            fis.read(bytes);
            String text = new String(bytes);
            StudentETXml.setText(text);
            Toast.makeText(this, "Обновлено", Toast.LENGTH_SHORT).show();
        }
        catch (IOException ex)
        {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    };

    private final View.OnClickListener save_xml_listener = view -> {
        StudentETXml = findViewById(R.id.editTextMultiLineXml);
        FileOutputStream fos;
        try
        {
            String text = StudentETXml.getText().toString();
            fos = openFileOutput("1.xml", MODE_PRIVATE);
            fos.write(text.getBytes());
            Toast.makeText(XmlEditActivity.this,"Файл сохранен", Toast.LENGTH_SHORT).show();
        }
        catch (IOException ex)
        {
            Toast.makeText(XmlEditActivity.this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    };

    private final View.OnClickListener change_on_head_click_listener = view -> {
        head_text_view = findViewById(R.id.xml_head);
        StudentETXml = findViewById(R.id.editTextMultiLineXml);
        StudentLV = findViewById(R.id.listview_student);
        if(!IsText){
            // text is now visible
            head_text_view.setText(getString(R.string.xml_head_text));
            StudentLV.setVisibility(View.INVISIBLE);
            StudentETXml.setVisibility(View.VISIBLE);
            IsText = true;
        }
        else {
            // text is now invisible
            head_text_view.setText(getString(R.string.xml_head_visual));
            StudentLV.setVisibility(View.VISIBLE);
            StudentETXml.setVisibility(View.INVISIBLE);
            IsText = false;
        }
    };
    private final View.OnClickListener add_listener = view -> {
        Intent addIntent = new Intent("android.intent.action.ChangeAddActivity");
        addIntent.putExtra("head",0);
        startActivityForResult(addIntent,1);
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            // add item to list
            if(resultCode == RESULT_OK){
                PStudent PS;
                if (data != null) {
                    PS = data.getParcelableExtra("student");
                    student_list.add(new Student(PS.Get_Full_Name(),PS.Get_Gender(),PS.Get_Programming_Languages(),PS.Get_IDE()));
                    int last_student_place = student_list.size()-1;
                    list.add
                            (
                                    student_list.get(last_student_place).Get_Full_Name() +
                                    "\n" + student_list.get(last_student_place).Get_IDE() +
                                    " | " + student_list.get(last_student_place).Get_Gender() +
                                    " | " + student_list.get(last_student_place).Get_Programming_Languages()
                            );
                    adapter = new ArrayAdapter(XmlEditActivity.this, android.R.layout.simple_list_item_1,list);
                    StudentLV.setAdapter(adapter);
                    StudentETXml = findViewById(R.id.editTextMultiLineXml);
                    String from_edit_text = StudentETXml.getText().toString();
                    from_edit_text = from_edit_text.substring(0,from_edit_text.length()-12);
                    String student = "\n\t\t<student>\n";
                    student+="\t\t\t\t<full_name>";
                    student+=student_list.get(last_student_place).Get_Full_Name();
                    student+="</full_name>\n";
                    student+="\t\t\t\t<ide>";
                    student+=student_list.get(last_student_place).Get_IDE();
                    student+="</ide>\n";
                    student+="\t\t\t\t<gender>";
                    student+=student_list.get(last_student_place).Get_Gender();
                    student+="</gender>\n";
                    student+="\t\t\t\t<pl>";
                    student+=student_list.get(last_student_place).Get_Programming_Languages();
                    student+="</pl>\n";
                    student+="\t\t</student>";
                    from_edit_text+=student;
                    from_edit_text+="\n</students>";
                    StudentETXml.setText(from_edit_text);
                }
            }
        }
        else if(requestCode == 2){
            // edit item from list
            if(resultCode == RESULT_OK){
                PStudent PS;
                if (data != null) {
                    PS = data.getParcelableExtra("student");
                    int id = data.getIntExtra("id",0);
                    student_list.get(id).Set_Full_Name(PS.Get_Full_Name());
                    student_list.get(id).Set_Gender(PS.Get_Gender());
                    student_list.get(id).Set_IDE(PS.Get_IDE());
                    student_list.get(id).Set_Programming_Languages(PS.Get_Programming_Languages());
                    list.clear();
                    StringBuilder to_edit_text = new StringBuilder("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<students>");
                    String student;
                    for(int i = 0; i< student_list.size(); i++){
                        student="\n\t\t<student>\n";
                        student+="\t\t\t\t<full_name>";
                        student+=student_list.get(i).Get_Full_Name();
                        student+="</full_name>\n";
                        student+="\t\t\t\t<ide>";
                        student+=student_list.get(i).Get_IDE();
                        student+="</ide>\n";
                        student+="\t\t\t\t<gender>";
                        student+=student_list.get(i).Get_Gender();
                        student+="</gender>\n";
                        student+="\t\t\t\t<pl>";
                        student+=student_list.get(i).Get_Programming_Languages();
                        student+="</pl>\n";
                        list.add
                                (
                                    student_list.get(i).Get_Full_Name() +
                                    "\n" + student_list.get(i).Get_IDE() +
                                    " | " + student_list.get(i).Get_Gender() +
                                    " | " + student_list.get(i).Get_Programming_Languages()
                                );
                        student+="\t\t</student>";
                        to_edit_text.append(student);
                    }
                    to_edit_text.append("\n</students>");
                    StudentETXml.setText(to_edit_text.toString());
                    adapter = new ArrayAdapter(XmlEditActivity.this, android.R.layout.simple_list_item_1,list);
                    StudentLV.setAdapter(adapter);
                }
            }
        }
    }
}