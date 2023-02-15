package com.example.mcqs_dbapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    ImageButton whatsapp, github, result;
    TextView wapp, hub, res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        DBHandler hand = new DBHandler(this);

        whatsapp = (ImageButton) findViewById(R.id.whatappButton);
        whatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ArrayList<String> arrayList = hand.selectAllStudents();
                String text = "";
                for (int i = 0; i < arrayList.size(); i++) text += arrayList.get(i) + "\n";
                PackageManager pm = MainActivity2.this.getPackageManager();
                try {
                    Intent sendIntent = new Intent("android.intent.action.MAIN");
                    //sendIntent.setComponent(new ComponentName("com.whatsapp", "com.whatsapp.Conversation"));
                    sendIntent.setAction(Intent.ACTION_SEND);
                    sendIntent.setType("text/plain");
                    sendIntent.putExtra(Intent.EXTRA_TEXT, text);
                    //sendIntent.putExtra("jid","03244910193@s.whatsapp.net"); //phone number without "+" prefix
                    sendIntent.setPackage("com.whatsapp");
                    startActivity(sendIntent);
                } catch(Exception e) {
                    Toast.makeText(MainActivity2.this, "WhatsApp not Installed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        github = (ImageButton) findViewById(R.id.githubButton);
        github.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Uri webpage = Uri.parse("https://github.com/ZunairaAhmad/MCQS_DBApp.git");
                Intent intent1 = new Intent(Intent.ACTION_VIEW, webpage);
                startActivity(intent1);
            }
        });

        result = (ImageButton) findViewById(R.id.resultButton);
        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent2 = new Intent(MainActivity2.this,Result.class);
                startActivity(intent2);
            }
        });
    }
}