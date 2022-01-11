package liaten.app5;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PriceActivity extends AppCompatActivity {

    TextView sum_text, avg_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_price);
    }

    @Override
    protected void onStart() {
        super.onStart();
        sum_text = findViewById(R.id.sum);
        avg_text = findViewById(R.id.avg);
        Bundle extras = getIntent().getExtras();
        String avg_s = String.valueOf(extras.getDouble("avg"));
        String sum_s = String.valueOf(extras.getDouble("sum"));
        sum_text.setText(sum_s);
        avg_text.setText(avg_s);
    }
}