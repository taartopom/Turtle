package com.sandra.turtle;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Presentation extends AppCompatActivity {
    Dialog myDialog;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        myDialog = new Dialog(this);
    }


        public void ShowPopUp(View view){
            TextView txtClose;
            Button btnStart;

            myDialog.setContentView(R.layout.activity_presentation);

            txtClose = (TextView) myDialog.findViewById(R.id.txtClose);
            btnStart =  (Button)myDialog.findViewById(R.id.btnStart);

            txtClose.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    myDialog.dismiss();
                }
            });
            myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            myDialog.show();
    }
}
