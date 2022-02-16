package itts.volta.scritturafile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class ReadFile_activity extends AppCompatActivity {

    EditText fileTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_file);

        fileTxt = findViewById(R.id.fileTxt);

        Intent intent = getIntent();
        String str = intent.getStringExtra("str");
        fileTxt.setText(str);
    }
}