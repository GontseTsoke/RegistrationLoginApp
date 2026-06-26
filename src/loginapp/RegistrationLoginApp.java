import java.util.Scanner;
import java.util.ArrayList;

public class RegistrationLoginApp {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println("        WELCOME TO QUICKCHAT");
        System.out.println("=================================");

        // Ask user for number of messages
        System.out.print("How many messages would you like to send? ");
        int totalMessages = input.nextInt();
        input.nextLine();

        int sentMessages = 0;

        // Message collections
        ArrayList<Message> sentList = new ArrayList<>();
        ArrayList<Message> storedList = new ArrayList<>();
        ArrayList<Message> discardedList = new ArrayList<>();

        while (true) {

            System.out.println("1) Send Messages");
            System.out.println("2) Show Sent Messages");
            System.out.println("3) Stored Messages");
            System.out.println("4) Quit");

            System.out.print("Enter choice: ");
            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {

                // SEND MESSAGE
                case 1:

                    if (sentMessages >= totalMessages) {

                        System.out.println("Message limit reached.");
                        break;
                    }

                    // Enter recipient
                    System.out.print("Enter recipient number (+27...): ");
                    String recipient = input.nextLine();

                    // Enter message
                    System.out.print("Enter your message: ");
                    String text = input.nextLine();

                    // Create message object
                    Message msg = new Message(sentMessages, recipient, text);

                    // Validate recipient
                    if (!msg.checkRecipientCell(recipient)) {

                        System.out.println("Cell phone number incorrectly formatted or does not contain international code.");
                        break;
                    }

                    // Validate message length
                    if (!msg.checkMessageLength(text)) {

                        System.out.println("Message exceeds 250 characters by "
                                + (text.length() - 250)
                                + " characters, please reduce size.");

                        break;
                    }

                    // Message options
                    System.out.println("\nChoose an option:");
                    System.out.println("1) Send Message");
                    System.out.println("2) Disregard Message");
                    System.out.println("3) Store Message to send later");

                    System.out.print("Enter option: ");
                    int option = input.nextInt();
                    input.nextLine();

                    // SEND MESSAGE
                    if (option == 1) {

                    msg.setStatus("Sent");
                    sentList.add(msg);

                    System.out.println("\nMessage successfully sent.");
                    System.out.println("---------------------------------");
                    System.out.println(msg.printMessage());
                    System.out.println("---------------------------------");

                    sentMessages++;

                    }
                    // DISCARD MESSAGE
                    else if (option == 2) {

                    msg.setStatus("Discarded");
                    discardedList.add(msg);

                    System.out.println("Message discarded.");

                    }
                    // STORE MESSAGE
                    else if (option == 3) {

                    msg.setStatus("Stored");
                    storedList.add(msg);

                    System.out.println("Message successfully stored.");

                    } else {

                    System.out.println("Invalid option.");
                    }

                    break;

                    // SHOW SENT MESSAGES
                    case 2:

            if (storedList.isEmpty()) {

                System.out.println("No stored messages.");

            } else {

                Message longest = storedList.get(0);

                for (Message m : storedList) {

                    if (m.getMessageText().length() > longest.getMessageText().length()) {
                        longest = m;
                    }

                }

                System.out.println("\nLongest Stored Message:");
                System.out.println(longest.printMessage());

            }

            break;

                    // STORED MESSAGES
                    case 3:

            System.out.print("Enter Message ID: ");
            String id = input.nextLine();

            boolean found = false;

            for (Message m : storedList) {

                if (m.getMessageID().equals(id)) {

                    System.out.println(m.printMessage());
                    found = true;

                }

            }

            if (!found) {
                System.out.println("Message not found.");
            }

            break;

                    // QUIT
                    case 4:

            System.out.print("Enter recipient number: ");
           String searchRecipient = input.nextLine();

            boolean recipientFound = false;

            for (Message m : storedList) {

                if (m.getRecipient().equals(searchRecipient)) {

                    System.out.println(m.printMessage());
                    recipientFound = true;

                }

            }

            if (!recipientFound) {

                System.out.println("No messages found.");

            }

            break;
            
            //
            case 5:

            System.out.print("Enter Message Hash: ");
            String hash = input.nextLine();

            boolean deleted = false;

            for (int i = 0; i < storedList.size(); i++) {

                if (storedList.get(i).getMessageHash().equals(hash)) {

                    storedList.remove(i);
                    deleted = true;
                    break;

                }

            }

            if (deleted) {

                System.out.println("Message deleted.");

            } else {

                System.out.println("Hash not found.");

            }

            break;
            
            //Report
            case 6:

            System.out.println("\n===== MESSAGE REPORT =====");

            for (Message m : sentList) {

                System.out.println(m.printMessage());
                System.out.println("----------------------------");

            }

            break;

        default:

            System.out.println("Invalid option.");

    }

    break;
                     }
                       }
                         }
       
