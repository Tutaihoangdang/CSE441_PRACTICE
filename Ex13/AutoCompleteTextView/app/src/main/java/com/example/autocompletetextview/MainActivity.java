package com.example.autocompletetextview;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView selection;
    // Khai báo 2 CompleteTextView
    AutoCompleteTextView singleComplete;
    MultiAutoCompleteTextView multiComplete;

    // Khởi tạo mảng để Test
    String arr[] = {"hà nội", "Huế", "Sài gòn", "hà giang", "Bội an", "Kiên giang", "Lâm đồng", "Long khánh"};

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        selection = (TextView) findViewById(R.id.selection);

        // Khai báo AutoCompleteTextView
        singleComplete = (AutoCompleteTextView) findViewById(R.id.editauto);

        ArrayAdapter<String> myadapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                arr
        );

        // Thiết lập ArrayAdapter
        singleComplete.setAdapter(myadapter);

        // Thay đổi tương tự cho MultiAutoCompleteTextView ra
        multiComplete = (MultiAutoCompleteTextView) findViewById(R.id.multiAutoCompleteTextView);

        // Thiết lập ArrayAdapter
        multiComplete.setAdapter(new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                arr
        ));

        // Với mỗi MultiAutoCompleteTextView bắt buộc phải gọi đối tượng Tokenizer
        multiComplete.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

        // Thiết lập sự kiện thay đổi văn bản cho AutoCompleteTextView
        singleComplete.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                selection.setText(singleComplete.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }
}
