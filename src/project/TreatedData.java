package project;

/**
 * Created by Лера on 17.01.2017.
 */
public class TreatedData {
    public InitialData inData;
    public String incorrectLine;

    public TreatedData(){
        inData = null;
        incorrectLine = "";
    }

    public TreatedData(InitialData InData, String IncorrectLine){
        inData = InData;
        incorrectLine = IncorrectLine;
    }

    public String getIncorrect(){
        return incorrectLine;
    }
}
