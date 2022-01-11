package liaten.app4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ChangeAddActivity extends AppCompatActivity
{
    Button save_st_button;
    EditText
            FullNameEditText,
            IDEEditText,
            PLEditText,
            GenderEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_add_activity);
        save_st_button = findViewById(R.id.save_student_button);
        FullNameEditText = findViewById(R.id.full_name_edit_text);
        IDEEditText = findViewById(R.id.ide_edit_text);
        PLEditText = findViewById(R.id.programming_lang_edit_text);
        GenderEditText = findViewById(R.id.gender_edit_text);
        PStudent PS = null;
        int id = 0;
        Bundle arguments = getIntent().getExtras();
        int head = (int)arguments.get("head");
        if(arguments.get("student")!=null){
            PS = (PStudent) arguments.get("student");
            id = (int) arguments.get("id");
        }
        TextView tv = findViewById(R.id.change_add_head);
        if(head==0)
        {
            tv.setText(getString(R.string.add_student_head));
        }
        else {
            tv.setText(getString(R.string.change_student_head));
            FullNameEditText.setText(PS.Get_Full_Name());
            IDEEditText.setText(PS.Get_IDE());
            PLEditText.setText(PS.Get_Programming_Languages());
            GenderEditText.setText(PS.Get_Gender());
        }
        int finalId = id;
        save_st_button.setOnClickListener(view -> {
            if(     FullNameEditText.getText().toString().equals("")
                    || IDEEditText.getText().toString().equals("")
                    || PLEditText.getText().toString().equals("")
                    || GenderEditText.getText().toString().equals("")){
                Toast.makeText(ChangeAddActivity.this,"Не все поля заполнены",Toast.LENGTH_SHORT).show();
            }
            else{
                String FullName = FullNameEditText.getText().toString();
                String IDE = IDEEditText.getText().toString();
                String PL = PLEditText.getText().toString();
                String Gender = GenderEditText.getText().toString();
                PStudent PS2 = new PStudent(FullName,Gender,PL,IDE);
                Intent resultIntent = new Intent(ChangeAddActivity.this,XmlEditActivity.class);
                resultIntent.putExtra("student",PS2);
                resultIntent.putExtra("id", finalId);
                setResult(Activity.RESULT_OK,resultIntent);
                finish();
            }
        });
    }

}
