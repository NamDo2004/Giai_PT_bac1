package com.example.giai_pt_bac1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private Button btnTinh;
    private EditText edt_A, edt_B, edt_KQ;
    private void findviews(){
        btnTinh = findViewById(R.id.btnTinh);
        edt_A = findViewById(R.id.edt_A);
        edt_B = findViewById(R.id.edt_B);
        edt_KQ = findViewById(R.id.edt_KQ);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        findviews();
        edt_KQ.setEnabled(false);

        btnTinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float a = Float.parseFloat(edt_A.getText().toString());
                float b = Float.parseFloat(edt_B.getText().toString());
                float x;
                DecimalFormat df = new DecimalFormat("#.##");

                if(a == 0){
                    if(b == 0){
                        edt_KQ.setText("Phuong trinh co vo so nghiem");
                    }
                    else{
                        edt_KQ.setText("Phuong trinh vo nghiem");
                    }
                }

                if(a != 0){
                    if(b == 0){
                        x = 0;
                        edt_KQ.setText(String.valueOf(x));
                    }
                    else{
                        x = -b/a;
                        edt_KQ.setText(String.valueOf(df.format(x)));
                    }
                }
            }
        });
    }
}