package project;

import java.io.IOException;

/**
 * Created by Лера on 16.01.2017.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        /*Logic logic = new Logic();
        ArrayList<String> str = (ArrayList<String>) logic.getString();
        List<TreatedData> dt = str.stream().map(row->logic.partition(row)).collect(Collectors.toList()); */

        RxLogic rxLogic = new RxLogic();
        rxLogic.processData("data.csv");
    }
}
