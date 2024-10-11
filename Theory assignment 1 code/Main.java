import java.util.Scanner;

public class Main {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
Messageapp msgapp = new Messageapp();
while (true)
{
    System.out.println("WELCOME  TO THE MESSAGING APP\nEnter your choice to use the following features:");
System.out.println(" 1. Add contact\n 2.Dislay contact\n 3.Delete contact\n 4.Send message\n 5.Search chats\n 6.Display chats\n 7.Delete chat\n 8.Exit");
int choice = sc.nextInt();
sc.nextLine();
switch (choice){
    case 1:
        System.out.println("Enter name of contact to be added:");
        String name = sc.nextLine();
        System.out.println("Enter phone no of contact to be added:");
        String phoneNo = sc.nextLine();
        msgapp.addcontact(name, phoneNo);
      break;

    case 2:
        msgapp.Displaycontact();
        break;

    case 3:
        System.out.println("Enter name of contact to be deleted:");
        name = sc.nextLine();
        msgapp.deleteContact(name);
        break;

    case 4:
        System.out.println("Enter name of contact to send message to");
        name = sc.nextLine();
        msgapp.sendmsg(name);
        break;
    case 5:
        System.out.println("Enter name of contact to  search message:");
        name = sc.nextLine();
        msgapp.searchchats(name);
        break;

    case 6:
        msgapp.Dispaychats();
        break;

    case 7:
        System.out.println("Enter name of contact to delete message");
        name = sc.nextLine();
        System.out.println("Enter message id to be deleted:");
        String msgid = sc.nextLine();
        msgapp.deletemessage(name,msgid);
        break;

    case 8:
        System.exit(0);
}


}

}


}