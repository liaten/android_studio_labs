package liaten.app4;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TxtEditActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.txt_edit_activity);

        // выгрузить текст из файла
        EditText et = (EditText) findViewById(R.id.editTextTxt);
        FileInputStream f = null;
        try{
            f = openFileInput("1.txt");
            byte[] bytes = new byte[f.available()];
            f.read(bytes);
            String text = new String(bytes);
            et.setText(text);
        }
        catch (IOException ex)
        {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }

        // добавить текст в файл
        Button push_txt = (Button) findViewById(R.id.push_button);
        push_txt.setOnClickListener(txt_export_listener);
    }
    private View.OnClickListener txt_export_listener = new View.OnClickListener()
    {
        @Override
        public void onClick(View view)
        {
            FileOutputStream f = null;
            try
            {
                EditText et = (EditText) findViewById(R.id.editTextTxt);
                String text = et.getText().toString();
                f = openFileOutput("1.txt", MODE_PRIVATE);
                f.write(text.getBytes());
                Toast.makeText(TxtEditActivity.this,"Файл сохранен", Toast.LENGTH_SHORT).show();
            }
            catch (IOException ex)
            {
                Toast.makeText(TxtEditActivity.this, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    };
}
