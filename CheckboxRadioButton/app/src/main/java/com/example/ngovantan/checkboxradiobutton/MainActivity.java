package com.example.ngovantan.checkboxradiobutton;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class MainActivity extends Activity {

    EditText editname,editcmnd,editbosung;
    RadioGroup rg1;
    RadioButton rbtrungcap,rbcaodang,rbdaihoc;
    CheckBox ckdocsach,ckdoccode,ckdocbao;
    Button btnsend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editname = (EditText)findViewById(R.id.editname);
        editcmnd = (EditText)findViewById(R.id.editcmnd);
        editbosung = (EditText)findViewById(R.id.editbosung);
        rg1 = (RadioGroup)findViewById(R.id.radioGroup1);
        ckdocsach = (CheckBox)findViewById(R.id.docsach);
        ckdocbao = (CheckBox)findViewById(R.id.docbao);
        ckdoccode = (CheckBox)findViewById(R.id.doccode);
        btnsend = (Button)findViewById(R.id.btnsend);

        btnsend.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0){
                doShowMoreInformation();
            }
        });
    }
    public void doShowMoreInformation(){
        String name = editname.getText().toString();
        if (name.length()<3){
            editname.requestFocus();
            editname.selectAll();
            Toast.makeText(this,"Tên phải >= 3 kí tự", Toast.LENGTH_LONG).show();
            return;
        }
        String cmnd = editcmnd.getText().toString();
        if (cmnd.length()!=9)
        {
            editcmnd.requestFocus();
            editcmnd.selectAll();
            Toast.makeText(this,"CMND phải đúng 9 kí tự",Toast.LENGTH_LONG).show();
            return;
        }
        String bang = "";
        int id=rg1.getCheckedRadioButtonId();
        if (id==-1)
        {
            Toast.makeText(this,"Phải chọn bằng cấp",Toast.LENGTH_LONG).show();
            return;
        }
        String sothich ="";
        if (ckdocbao.isChecked())
            sothich += "Đọc báo\n";
        if (ckdocsach.isChecked())
            sothich += "Đọc sách\n";
        if (ckdoccode.isChecked())
            sothich +="Đọc code\n";
        String bosung = editbosung.getText().toString();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Thông tin cá nhân");
        builder.setPositiveButton("Đóng", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        String msg = name + "\n";
        msg +=cmnd + "\n";
        msg +=bang + "\n";
        msg +=sothich;
        msg+="___________________\n";
        msg +="Thông tin bổ sung:\n";
        msg+=bosung+"\n";
        msg+="___________________";
        builder.setMessage(msg);
        builder.create().show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
