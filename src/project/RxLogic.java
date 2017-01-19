package project;

import rx.Observable;

import java.io.*;

/**
 * Created by Лера on 17.01.2017.
 */
public class RxLogic {

    public Observable<String> getObservable(String fileName) throws IOException{
        return Observable.create(subscribe -> {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(fileName));
                String line = null;
                while ((line = reader.readLine()) != null) {
                    subscribe.onNext(line);
                }
                if(line == null)
                {
                    subscribe.onCompleted();
                }
            } catch (IOException e) {
                subscribe.onError(e);
            }
        });
    }

    public void processData(String fileName) throws IOException{
        getObservable(fileName)
                .subscribe(x -> correct(x));
    }


    private void correct(String str) {
        if (str.charAt(0) != '#' && str != null) {
            int k = 0;
            for (char element : str.toCharArray())
                if (element == '|')
                    k++;
            if (k == 14) {
                System.out.println(str);
                InitialData ob = partitionString(str);
            }
        }
        else System.out.println("Некорректная строка: " + str);
    }

    private InitialData partitionString(String initialDataString) {
        String[] s = initialDataString.split("\\|", 14);
        InitialData obj = new InitialData(s[0], s[1], s[2], s[3], s[4], s[5], s[6], s[7], s[8], s[9],
                s[10], s[11], s[12], s[13].substring(0, s[13].length() - 1));
        return obj;
    }
}
