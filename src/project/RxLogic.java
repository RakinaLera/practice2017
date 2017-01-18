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
            }
        }
        else System.out.println("Некорректная строка: " + str);
    }
}
