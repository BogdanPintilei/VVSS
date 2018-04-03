package ui;

import controller.ClientController;
import model.Client;

import java.util.Scanner;

;

public class ElectricaUI
{
    private ClientController ctrl;
    private Scanner in;

    public ElectricaUI(ClientController ctrl)
    {
        this.ctrl = ctrl;
        this.in = new Scanner(System.in);
    }

    public ClientController getCtrl()
    {
        return this.ctrl;
    }

    public Scanner getIn()
    {
        return this.in;
    }

    public void setCtrl(ClientController newCtrl)
    {
        this.ctrl = newCtrl;
    }

    public void setIn(Scanner newIn)
    {
        this.in = newIn;
    }

    private void printMenu()
    {
        String menu;
        menu = "Electrica Admin Menu: \n";
        menu += "\t 1 - to add a new client; \n";
        menu += "\t 2 - to add a new index; \n";
        menu += "\t 3 - to list the current invoices (and possible penalties or pending payment) of the subscribers; \n";
        menu += "\t 4 - list the clients \n";
        menu += "\t 0 - exit \n";

        System.out.println(menu);
    }


    public void Run()
    {
        printMenu();


        int cmd = in.nextInt();
        in.nextLine();

        while (cmd != 0)
        {
            if (cmd == 1)
            {
                System.out.println("Enter name:");
                String name = in.nextLine();

                System.out.println("Enter address:");
                String address = in.nextLine();

                System.out.println("Enter id:");
                String id = in.nextLine();

                ctrl.AddClient(name, address, id);
            }
            else if (cmd == 2)
            {
                System.out.println("Enter name:");
                String name = in.nextLine();

                System.out.println("Enter address:");
                String address = in.nextLine();

                System.out.println("Enter id:");
                String id = in.nextLine();

                Client c = new Client(name, address, id);


                System.out.println("Enter the YEAR:");
                String yearS = in.nextLine();
                int year = Integer.parseInt(yearS);

                System.out.println("Enter the MONTH:");
                String monthS = in.nextLine();
                int month = Integer.parseInt(monthS);

                System.out.println("Enter toPay:");
                String sumToPayS = in.nextLine();
                float sumToPay = Float.parseFloat(sumToPayS);

                ctrl.AddClientIndex(c, year, month, sumToPay);

            }
            else if (cmd == 3)
            {
                System.out.println("list the current invoices :");

                System.out.println("Enter name:");
                String name = in.nextLine();
                System.out.println("Enter address:");
                String address = in.nextLine();
                System.out.println("Enter id:");
                String id = in.nextLine();
                Client c = new Client(name, address, id);


                ctrl.ListIssue(c);

            }
            else if (cmd == 4)
            {
                System.out.println("The list of clients is: ");

                for (int i = 0; i < ctrl.getClients().size(); i++)
                    System.out.println(ctrl.getClients().get(i));
            }

            printMenu();
            cmd = in.nextInt();
            in.nextLine();
        }
    }
}

