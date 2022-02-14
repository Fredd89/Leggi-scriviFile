package itts.volta.scritturafile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class ReadFile_activity extends AppCompatActivity {

    EditText fileTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_file);

        fileTxt = findViewById(R.id.fileTxt);

        Intent intent = new Intent();

        String str = intent.getStringExtra("str");
        fileTxt.setText(str);
    }
}