package com.example.project_7_3_toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button bt1;
    EditText tvName, tvEmail, dlgEdtName, dlgEdtEmail, a, b;
    TextView toastText;
    View dialogView, toastView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("사용자 정보 입력");

        tvName = (EditText) findViewById(R.id.tvName);
        tvEmail = (EditText) findViewById(R.id.tvEmail);
        bt1 = (Button) findViewById(R.id.bt1);

        bt1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dialogView = (View) View.inflate(MainActivity.this, R.layout.dialog1, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder (MainActivity.this);

                a = (EditText) dialogView.findViewById(R.id.dlgEdt1);
                a.setText(tvName.getText().toString());
                b = (EditText) dialogView.findViewById(R.id.dlgEdt2);
                b.setText(tvEmail.getText().toString());

                dlg.setTitle("사용자 정보 입력");
                dlg.setIcon(R.drawable.ic_launcher_background);
                dlg.setView(dialogView);

                dlg.setPositiveButton("확인",
                        new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dlgEdtName = (EditText) dialogView.findViewById(R.id.dlgEdt1);
                        dlgEdtEmail = (EditText) dialogView.findViewById(R.id.dlgEdt2);

                        tvName.setText(dlgEdtName.getText().toString());
                        tvEmail.setText(dlgEdtEmail.getText().toString());
                    }
                        });
                dlg.setNegativeButton("취소",
                        new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast toast = new Toast(MainActivity.this);
                        toastView = (View) View.inflate(MainActivity.this, R.layout.toast1, null);
                        toastText = (TextView) toastView.findViewById(R.id.toastT1);
                        toastText.setText("취소했습니다");
                        toast.setView(toastView);

                        Display dis = ((WindowManager) getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
                        int xO = (int) (Math.random() * dis.getWidth());
                        int yO = (int) (Math.random() * dis.getHeight());
                        toast.setGravity(Gravity.TOP | Gravity.LEFT, xO, yO);

                        toast.show();
                    }
                        });
                dlg.show();
            }
        });

    }
}