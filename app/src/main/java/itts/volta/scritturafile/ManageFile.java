package itts.volta.scritturafile;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

    public class ManageFile {

        public String readFile(String fileName, Context c) {

            BufferedReader fileIn = null;
            String outputFile;
            StringBuilder strB = new StringBuilder();

            try{
                fileIn= new BufferedReader(new InputStreamReader(c.openFileInput(fileName)));
                while((outputFile = fileIn.readLine()) != null) {
                    strB.append(outputFile + "\n");
                }
            }
            catch(FileNotFoundException e){
                Log.e("!ifFileExists", "File does not exists");

            } catch (IOException e) {
                e.printStackTrace();
            }

            return strB.toString();

        }

        public String writeFile(String fileName, String str, Context c) {

            String result = "";
            FileOutputStream file;

            try
            {
                file = c.openFileOutput(fileName, Context.MODE_PRIVATE);
                file.write(str.getBytes());
                file.close();
                result = "File correctly written";
            }

            catch (FileNotFoundException e) {
                Log.e("ManageFile", "FNF error intercepted");
                e.printStackTrace();
                result = "File not found Exception";
            }

            catch (IOException e) {
                Log.e("ManageFile", "IO error intercepted");
                e.printStackTrace();
                result = "Input Output Exception";
            }
            return result;
        }

        public String readFileRow(Context c) {
            String str = "";
            Resources res = c.getResources();
            InputStream is = res.openRawResource(R.raw.song);

            return str;
        }

        public String readFileAssets(Context c) {
            String str = "";
            AssetManager am = c.getAssets();

            try {
                InputStream is = am.open("song.txt");
            }
            catch (IOException e) {
                e.printStackTrace();
            }

            return str;
        }

}
