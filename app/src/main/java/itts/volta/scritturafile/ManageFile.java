package itts.volta.scritturafile;

import android.content.Context;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ManageFile {

    public String writeFile(String fileName, Context c) {

        String result = "";
        FileOutputStream file;
        String str = "Text to write into the file";

        try {
            file = c.openFileOutput(fileName, Context.MODE_PRIVATE);
            file.write(str.getBytes());
        }

        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

}
