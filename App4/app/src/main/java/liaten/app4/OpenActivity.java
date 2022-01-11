package liaten.app4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OpenActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.open_activity);
        Button txt_button = (Button) findViewById(R.id.txt);
        Button csv_button = (Button) findViewById(R.id.csv);
        Button xml_button = (Button) findViewById(R.id.xml);
        Button json_button = (Button) findViewById(R.id.json);
        txt_button.setOnClickListener(txt_listener);
        csv_button.setOnClickListener(csv_listener);
        xml_button.setOnClickListener(xml_listener);
        json_button.setOnClickListener(json_listener);

    }
    private View.OnClickListener txt_listener = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            Intent addIntent = new Intent("android.intent.action.TxtEditActivity");
            startActivity(addIntent);
        }
    };
    private View.OnClickListener csv_listener = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            Intent addIntent = new Intent("android.intent.action.CsvEditActivity");
            startActivity(addIntent);
        }
    };
    private View.OnClickListener xml_listener = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            Intent addIntent = new Intent("android.intent.action.XmlEditActivity");
            startActivity(addIntent);
        }
    };
    private View.OnClickListener json_listener = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            Intent addIntent = new Intent("android.intent.action.JsonEditActivity");
            startActivity(addIntent);
        }
    };
}
