import java.util.Scanner;
import java.util.Arrays;
public class Messageapp {
    private String contact[][]=new String [200][3];
    private Sms chats[][]=new Sms[200][200];
private final String sendername="Maham";
private final String sendernumber="03008812484";
private static int contactcount=0;
private int chatcount[]=new int[200];

    {
        addedcontact("Komal","03221836653");
        addedcontact("Laiba","03239884711");
        addedcontact("Abeera","03219348471");
        addedcontact("Iqra","03218384692");
        addedcontact("Alishba","03008162665");

    }

public void addedcontact(String name, String number) {
    contact[contactcount][0] =Integer.toString(contactcount+1);
            contact[contactcount][1] =name;
                    contact[contactcount][2] =number;
contactcount++;
}

    public void addcontact(String name, String number) {
        contact[contactcount][0] =Integer.toString(contactcount+1);
        contact[contactcount][1] =name;
        contact[contactcount][2] =number;
contactcount++;
System.out.println(contactcount);
System.out.println("Contact Added");
    }

private int findname(String name) {
        for(int i=0;i<contactcount;i++){
            if(contact[i][1].equalsIgnoreCase(name))
            return i;
        }
       return -1;
}
public void Displaycontact() {
        if(contactcount==0) {
            System.out.println("No Contact Found");
            return;
        }
       System.out.println("Contact List:");
for(int i=0;i<contactcount;i++) {
    System.out.println("Contact id:"+contact[i][0]+" \nName:"+contact[i][1]+" \nNumber:"+contact[i][2]);
}

}

    public void deleteContact(String name) {
        int Index = findname(name);
        if (Index != -1) {
            for (int i =Index; i < contactcount - 1; i++) {
                contact[i][0] = contact[i + 1][0];
                contact[i][1] = contact[i + 1][1];
                contact[i][2] = contact[i + 1][2];
            }
            contactcount--;
            System.out.println("Contact deleted.");
        } else {
            System.out.println("Contact not found.");
        }
    }

public void sendmsg(String name){
 int index=findname(name);
 if(index!=-1){
    int id=Integer.parseInt(contact[index][0])-1;
    System.out.println("Send text to"+contact[index][1]);
     System.out.println("Enter 0 if you want to stop chatting otherwise type message");
     System.out.println("Sender: "+sendername+"\nReceiver: "+contact[index][1]);
     Scanner sc=new Scanner(System.in);
while(true){
    String message=sc.nextLine();
if(message.equals("0"))
    break;
Sms text=new Sms(message);
chats[id][chatcount[id]++]=text;
System.out.println("Message sent");
}
 }
else{
     System.out.println("Contact not found.");
 }
}
    public void searchchats(String name) {
        int Index = findname(name);
        if (Index != -1) {
            int contactId = Integer.parseInt(contact[Index][0]) - 1;
            System.out.println("\nChats with " + contact[Index][1] + ":");
            System.out.println("Sender: " + sendername + " | Receiver: " + contact[Index][1]);
            Sms[] messages = Arrays.copyOf(chats[Index], chatcount[Index]);
            bubbleSortMessagesByTime(messages);

            for (Sms message : messages) {
                System.out.println(message.toString());
                message.status();
            }
        } else {
            System.out.println("No chats found with this contact.");
        }
    }

    private void bubbleSortMessagesByTime(Sms[] messages) {
        int n = messages.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (messages[j].getDatetime().isBefore(messages[j + 1].getDatetime())) {
                    Sms temp = messages[j];
                    messages[j] = messages[j + 1];
                    messages[j + 1] = temp;
                }
            }
        }
    }

    public void Dispaychats() {

        for(int i=0;i<contactcount;i++){
            int contactId = Integer.parseInt(contact[i][0]) - 1;
            System.out.println("\nChats with " + contact[i][1] + ":");
            System.out.println("Sender: " + sendername + " | Receiver: " + contact[i][1]);
            Sms[] messages = Arrays.copyOf(chats[i], chatcount[i]);
            bubbleSortMessagesByTime(messages);

            for (Sms message : messages) {
                System.out.println(message.toString());
                message.status();
            }

    }  }

public void deletemessage(String name,String messageid){
int index=findname(name);
if(index!=-1){
    int id=Integer.parseInt(contact[index][0])-1;
    for(int i=0;i<chatcount[id];i++){
        if(chats[id][i].getMessageid().equals(messageid))
{
for(int j=i;j<(chatcount[id])-1;j++){

    chats[id][j]=chats[id][j+1];
}
                chats[id][chatcount[id] - 1] = null;

chatcount[id]--;
System.out.println("Message deleted.");
return;
        }
    }

}

System.out.println("Message Id not found.");
}







    }
