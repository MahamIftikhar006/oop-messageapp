import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Sms {

    private String messagecontent;
    private boolean status;
    private String messageid;
    private LocalDateTime datetime;
    private static int idcounter;

    public Sms( String messagecontent) {
        this.messageid=String.format("%d",++idcounter);
        this.messagecontent = messagecontent;
        this.status = false;
        this.datetime= LocalDateTime.now();

    }

    public String getMessageid() {
        return messageid;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

//Functions
   public void status(){

        this.status = true;
   }
public String meassagestatus(){
if(status){
    return "Read";
}
else {
    return"unread";
}

}

    @Override
    public String toString() {
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
      String formattedDate = datetime.format(formatter);
      return "Message"+messagecontent+"\nStatus: "+meassagestatus()+"\nMessageid: "+messageid+"\nDate and Time: "+formattedDate;
    }
}
