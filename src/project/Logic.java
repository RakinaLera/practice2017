package project;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;
import java.nio.file.Paths;

/**
 * Created by Лера on 16.01.2017.
 */
public class Logic {
    //Чтение данных
    public static List<String> getString() throws IOException {
        return Files.readAllLines(Paths.get("data.csv"), Charset.forName("windows-1251"));
    }

    //Обработка данных
    public TreatedData partition(String initialDataString) {
        InitialData inData = null;
        String incorrectLine = null;
        if (correct(initialDataString))
            inData = partitionString(initialDataString);
        else incorrectLine = initialDataString;
        TreatedData q = new TreatedData(inData, incorrectLine);
        return q;
    }

    private InitialData partitionString(String initialDataString) {
        String[] s = initialDataString.split("\\|", 14);
        InitialData obj = new InitialData(s[0], s[1], s[2], s[3], s[4], s[5], s[6], s[7], s[8], s[9],
                s[10], s[11], s[12], s[13].substring(0, s[13].length() - 1));
        return obj;
    }

    //проверка корректности строки
    private boolean correct(String str) {
        boolean f = false;
        if (str.charAt(0) != '#' && str != null) {
            int k = 0;
            for (char element : str.toCharArray())
                if (element == '|')
                    k++;
            if (k == 14)
                f = true;
        }
        return f;
    }
}


