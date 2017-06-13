package Tools;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * --------- Convertir esta clase a estatica para ------------ --------- usar
 * los metodos sin instanciarla ------------
 */
public class FileManager {


	public String readText(File Archivo){
        String res ="";

        try {
            BufferedReader b = new BufferedReader(new FileReader(Archivo));
            String readLine = "";
            while ((readLine = b.readLine()) != null) {
            	res+=readLine;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
		return res;

    }




}

