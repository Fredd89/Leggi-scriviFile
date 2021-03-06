package itts.volta.scritturafile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText fileName, fileText;
    Button readBtn, writeBtn, rawRead, assetsRead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fileName = findViewById(R.id.editTxt);
        fileText = findViewById(R.id.editTxt2);
        readBtn = findViewById(R.id.readBtn);
        writeBtn = findViewById(R.id.writeBtn);
        rawRead = findViewById(R.id.rawRead);
        assetsRead = findViewById(R.id.assetsRead);
        ManageFile manageFile = new ManageFile();
        Context context = getApplicationContext();

        readBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fileText = manageFile.readFile(fileName.getText().toString(), getApplicationContext());
                Intent intent = new Intent(MainActivity.this, ReadFile_activity.class);
                intent.putExtra("fileText", fileText);
                intent.putExtra("fileName", fileName.getText().toString());
                startActivity(intent);
            }
        });

        writeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = manageFile.writeFile(fileName.getText().toString(), fileText.getText().toString(), getApplicationContext());
                Toast.makeText(context, str, Toast.LENGTH_SHORT).show();
            }
        });

        rawRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = manageFile.readRawFile(context);
                Toast.makeText(context, str, Toast.LENGTH_LONG).show();
            }
        });

        assetsRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = manageFile.readAssetsFile(context);
                Toast.makeText(context, str, Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        fileName = findViewById(R.id.editTxt);
        fileText = findViewById(R.id.editTxt2);
        fileName.getText().clear();
        fileText.getText().clear();
    }
}