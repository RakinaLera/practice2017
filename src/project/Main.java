package project;

import java.io.IOException;

/**
 * Created by Лера on 16.01.2017.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        RxLogic rxLogic = new RxLogic();
        rxLogic.processData("data.csv");
    }
}
