package utils;

import java.io.*;

public class FileUtils {

    public static String readMessageFromFile(File file) {
        StringBuilder sb = new StringBuilder();
        String result = "";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF8"))) {

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                sb.append(sCurrentLine);
            }

            String s = sb.toString();
            String[] messageArray = s.split("/n");
            for (String message : messageArray) {
                result = result + "\n" + message;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
