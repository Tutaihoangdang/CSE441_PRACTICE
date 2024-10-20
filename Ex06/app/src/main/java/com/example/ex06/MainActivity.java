package com.example.ex06;

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
    EditText edtten,editCMND,editBosung;
    CheckBox chkdocbao,chkdocsach,chkdoccode;
    Button btnsend;
    RadioGroup group;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtten = findViewById(R.id.edtten);
        editCMND = findViewById(R.id.edtcmnd);
        editBosung = findViewById(R.id.edtbosung);
        chkdocbao = findViewById(R.id.chkdocbao);
        chkdoccode = findViewById(R.id.chkcode);
        chkdocsach = findViewById(R.id.chkdocsach);
        btnsend = findViewById(R.id.btnsend);
        btnsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
// TODO Auto-generated method stub
                doShowInformation();
            }
        });
    }
    public void doShowInformation()
    {
//Kiểm tra tên hợp lệ
        String ten=edtten.getText().toString();
        ten=ten.trim();
        if(ten.length()<3)
        {
            edtten.requestFocus();
            edtten.selectAll();
            Toast.makeText(this, "Tên phải >= 3 ký tự",
                    Toast.LENGTH_LONG).show();
            return;
        }
//kiểm tra CMND hợp lệ
        String cmnd=editCMND.getText().toString();
        cmnd=cmnd.trim();
        if(cmnd.length()!=9)
        {
            editCMND.requestFocus();
            editCMND.selectAll();
            Toast.makeText(this, "CMND phải đúng 9 ký tự",
                    Toast.LENGTH_LONG).show();
            return;
        }
//Kiểm tra bằng cấp
        String bang="";
        group = findViewById(R.id.idgruop);
        int id=group.getCheckedRadioButtonId();// Trả về Id
        if(id==-1)
        {
            Toast.makeText(this, "Phải chọn bằng cấp",

                    Toast.LENGTH_LONG).show();
            return;
        }
        RadioButton rad= findViewById(id);
        bang=rad.getText()+"";
//Kiểm tra sở thích
        String sothich="";
        if(chkdocbao.isChecked())
            sothich+=chkdocbao.getText()+"\n";
        if(chkdocsach.isChecked())
            sothich+=chkdocsach.getText()+"\n";
        if(chkdoccode.isChecked())
            sothich+=chkdoccode.getText()+"\n";
        String bosung=editBosung.getText()+"";
//Tạo Dialpg
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Thông tin cá nhân");
        builder.setPositiveButton("Đóng", new
                DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub
                        dialog.cancel();
                    }
                });
        //tạo nội dung
        String msg=ten+"\n";
        msg+= cmnd+"\n";
        msg+=bang+"\n";
        msg+=sothich;
        msg+="—————————–\n";
        msg+="Thông tin bổ sung:\n";
        msg+=bosung+ "\n";
        msg+="—————————–";
        builder.setMessage(msg);//thiết lập nội dung
        builder.create().show();//hiển thị Dialog
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        AlertDialog.Builder b =new
                AlertDialog.Builder(MainActivity.this);
        b.setTitle("Question");
        b.setMessage("Are you sure you want to exit?");
        b.setIcon(R.drawable.ic_launcher_background);
        b.setPositiveButton("Yes", new DialogInterface.
                OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                finish();
            }});
        b.setNegativeButton("No", new
                DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which)

                    {
                        dialog.cancel();
                    }
                });
        b.create().show();
    }
}
