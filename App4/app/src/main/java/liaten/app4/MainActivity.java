package liaten.app4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button open_button = (Button) findViewById(R.id.open_button);
        open_button.setOnClickListener(open_button_listener);

    }
    private View.OnClickListener open_button_listener = view -> {
        Intent addIntent = new Intent("android.intent.action.OpenActivity");
        startActivity(addIntent);
    };
}