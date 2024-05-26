package HelperMethods;
//TODO finish completing the Note Formatter
public class NoteFormatter {
    private String msid;
    private String date;
    private Object userPendCode;

    public NoteFormatter(String userMsid, String userDate, Object userPendCode){
        this.msid = userMsid;
        this.date = userDate;
        this.userPendCode = userPendCode;

    }
    //TODO Specific formatted note templates will need to be add because certain pend codes have different templates
    public String formattedNote(){
        return this.msid;
    }
}
