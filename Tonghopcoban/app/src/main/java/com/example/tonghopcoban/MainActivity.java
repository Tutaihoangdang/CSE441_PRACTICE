package com.example.tonghopcoban;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText edtHoten, edtCmnd, edtBosung;
    RadioGroup idgr;
    Button btnGui;
    CheckBox chkDocsach, chkDocbao, chkCode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        //Ánh xạ Id
        edtHoten=findViewById(R.id.edtHoten);
        edtCmnd = findViewById(R.id.edtCmnd);
        edtBosung=findViewById(R.id.edtBosung);
        idgr   = findViewById(R.id.idgr);
        chkDocsach = findViewById(R.id.chkdocsach);
        chkDocbao=findViewById(R.id.chkdocbao);
        chkCode=findViewById(R.id.chkcode);
        btnGui = findViewById(R.id.btnGui);

        //Xử lí logic
        btnGui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Hoten = edtHoten.getText().toString();
                if(Hoten.length()<3){
                    Toast.makeText(MainActivity.this, "Họ tên phải có ít nhất 3 kí tự",
                            Toast.LENGTH_LONG).show();
                    edtHoten.requestFocus();
                    edtHoten.selectAll();
                    return;
                }

                String Cmnd = edtCmnd.getText().toString();
                if(Cmnd.length()!=12){
                    Toast.makeText(MainActivity.this, "CMND phải có đúng 12 số", Toast.LENGTH_SHORT).show();
                    edtCmnd.requestFocus();
                    edtCmnd.selectAll();
                    return;
                }

                //Lấy thông tin bằng cấp
                int idsl = idgr.getCheckedRadioButtonId();
                RadioButton rdsl = findViewById(idsl);
                String Bangcap="" ;
                Bangcap = rdsl.getText().toString();

                //Lấy thông tin sở thích
                String Sothich="";
                if(chkDocsach.isChecked()){
                    Sothich += chkDocsach.getText().toString()+"-";
                }
                if(chkDocbao.isChecked()){
                    Sothich += chkDocbao.getText().toString()+"-";
                }
                if(chkCode.isChecked()){
                    Sothich += chkCode.getText().toString();
                }

                //Lấy thông tin bổ sung
                String bosung = edtBosung.getText().toString();
                String tonghop = Hoten + "\n"+ Cmnd +"\n" + Bangcap + "\n" +Sothich+"\n";
                tonghop += "<-----------------THÔNG TIN BỔ SUNG----------------->";
                tonghop += "\n" + bosung+ "\n";
                tonghop += "-----------------------------------------------------";

                // Tạo hợp thoại
                AlertDialog.Builder myDAL = new AlertDialog.Builder(MainActivity.this);
                myDAL.setTitle("THÔNG TIN CÁ NHÂN!");
                myDAL.setMessage(tonghop);
                myDAL.setPositiveButton("Đóng", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                myDAL.create().show();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}