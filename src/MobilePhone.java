import java.util.Scanner;

public class MobilePhone implements  Telephone{

    private boolean isPowerOn;
    private boolean isRinging;
    private boolean foundPerson;
    private String[] persons;

    private String enterPhoneNumber;
    int position = -1;
    private String callAgain;

    @Override
    public void powerOn() {
        isPowerOn = true;
        System.out.println("Your mobile phone is turning on");
        System.out.println("...");
        System.out.println("..");
        System.out.println(".");
        System.out.println("Your mobile is on");
    }

    @Override
    public void listOfPhoneNumbers() {
        System.out.println("Your list of phone numbers: ");
        this.persons = new String[3];
        this.persons[0] = "0900000000";
        this.persons[1] = "0900111111";
        this.persons[2] = "0900222222";

        for(int i = 0; i < this.persons.length; i++) {
            System.out.println("Person" + (i + 1) + ": " + this.persons[i]);
        }
    }

    @Override
    public boolean callPhone() {
        System.out.println("Please enter a phone number");
        Scanner scanner = new Scanner(System.in);
        enterPhoneNumber = scanner.nextLine();

        for (int i = 0; i < this.persons.length; i++) {
            if (this.persons[i].equals(enterPhoneNumber)) {
                foundPerson = true;
                isRinging = true;
                position = i;
            }
        }
        if (position != -1) {
            System.out.println("You call " + enterPhoneNumber + " Person" + position);
            System.out.println("brnn!!! ..... brnn!!!");
            answer();
        } else {
            System.out.println("Phone number " + enterPhoneNumber + " does not exist");
            System.out.println("Do you want to call again? ... yes or no?");
            callAgain = scanner.nextLine();
            if(callAgain.equalsIgnoreCase( "yes")) {
                callPhone();
            } else {
                return false;
            }
        }
        return isRinging;
    }

    @Override
    public boolean isRinging() {
        return isRinging();
    }

    @Override
    public void answer() {
        if(isRinging && isPowerOn) {
            System.out.println("Answering the phone");
            isRinging = false;
        }
    }
}



