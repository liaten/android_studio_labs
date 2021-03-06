package liaten.app5;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class UpdateActivity extends AppCompatActivity {

    EditText etCorpName, etCorpFounders, etCorpProducts, etCorpPrice, etCorpCategory;
    Button clearButton, updateButton, deleteButton;

    String id, name, founders, products, price, category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        etCorpName = findViewById(R.id.editTextCorpName);
        etCorpFounders = findViewById(R.id.editTextCorpFounders);
        etCorpProducts = findViewById(R.id.editTextCorpProducts);
        etCorpPrice = findViewById(R.id.editTextCorpPrice);
        etCorpCategory = findViewById(R.id.editTextCorpCategory);

        clearButton = findViewById(R.id.clear_button);
        updateButton = findViewById(R.id.update_button);
        deleteButton = findViewById(R.id.delete_button);

        //First we call this

        getAndSetIntentData();

        //Set actionbar title after getAndSetIntentData method

        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle(name);
        }

        // обработчик кнопки обновления

        updateButton.setOnClickListener(view -> {
            //And only then we call this
            DatabaseHelper myDB = new DatabaseHelper(UpdateActivity.this);
            name = etCorpName.getText().toString().trim();
            founders = etCorpFounders.getText().toString().trim();
            products = etCorpProducts.getText().toString().trim();
            price = etCorpPrice.getText().toString().trim();
            category = etCorpCategory.getText().toString().trim();

            myDB.updateData(id, name, founders, products, price, category);
            finish();
        });

        // обработчик кнопки удаления

        deleteButton.setOnClickListener(view -> confirmDialog());

        // Запрет на ввод цифр
        for (EditText et : new EditText[]{etCorpFounders, etCorpCategory})
            et.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if (Pattern.compile("[0-9]").matcher(et.getText().toString()).find()) {
                        et.setText(et.getText().toString().substring(0,
                                et.getText().toString().length() - 1));
                        et.setSelection(et.getText().toString().length());
                    }
                }

                @Override
                public void afterTextChanged(Editable s) {
                }
            });
    }

    void getAndSetIntentData(){
        if(getIntent().hasExtra("id") && getIntent().hasExtra("corp_name") &&
                getIntent().hasExtra("corp_founders") && getIntent().hasExtra("corp_products")){
            //Getting Data from Intent
            id = getIntent().getStringExtra("id");
            name = getIntent().getStringExtra("corp_name");
            founders = getIntent().getStringExtra("corp_founders");
            products = getIntent().getStringExtra("corp_products");
            price = getIntent().getStringExtra("corp_price");
            category = getIntent().getStringExtra("corp_category");

            //Setting Intent Data
            etCorpName.setText(name);
            etCorpFounders.setText(founders);
            etCorpProducts.setText(products);
            etCorpPrice.setText(price);
            etCorpCategory.setText(category);

            Log.d("stev", name
                    + " " + founders
                    + " " + products
                    + " " + price
                    + " " + category);
        }else{
            Toast.makeText(this, "Нет данных.", Toast.LENGTH_SHORT).show();
        }
    }

    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Удалить " + products + " ?");
        builder.setMessage("Вы уверены?");
        builder.setPositiveButton("Да", (dialogInterface, i) -> {
            DatabaseHelper myDB = new DatabaseHelper(UpdateActivity.this);
            myDB.deleteOneRow(id);
            finish();
        });
        builder.setNegativeButton("Не совсем", (dialogInterface, i) -> {
        });
        builder.create().show();
    }

    public void onClickClear(View view) {
        etCorpName.setText("");
        etCorpFounders.setText("");
        etCorpProducts.setText("");
        etCorpPrice.setText("");
        etCorpCategory.setText("");
    }
}