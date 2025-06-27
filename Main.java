import javax.swing.JOptionPane;
import java.util.Scanner;
import java.io.*;

import java.util.StringTokenizer;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
public class Main
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        File file = new File("ParcelInfo.txt");
        Scanner scanFile = new Scanner(file);

        Parcel p = new Parcel();
        Parcel A = new Parcel();
        Parcel B = new Parcel();
        Parcel C = new Parcel();
        Queue q = new Queue();
        Queue qTemp = new Queue();
        Stack sA = new Stack();
        Stack sB = new Stack();
        Stack sC = new Stack();
        Stack sTemp = new Stack();
        LinkedList removedList = new LinkedList();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yy");
        LocalDateTime now = LocalDateTime.now();
        String todayDate = dtf.format(now);

        boolean run = true;
        while(run)
        {
            System.out.print("\f");
            header();
            System.out.println(todayDate);
            System.out.println(" | 1. Display all parcels\n | 2. Display parcel by ID\n | 3. Insert new parcels from file\n | 4. Insert a parcel\n | 5. Remove today's due parcels\n | 6. Display today's removed parcels\n | 9. Exit");
            System.out.print("\nEnter number: ");
            System.out.print("\n--------------------------------------------------------------------");
            int action = sc.nextInt();
            if(action == 1)
            {
                System.out.print("\f");
                header();

                while(!sA.isEmpty())
                {
                    p = sA.pop();
                    p.DisplayInfo();
                    sTemp.push(p);
                }
                while(!sTemp.isEmpty())
                    sA.push(sTemp.pop());

                while(!sB.isEmpty())
                {
                    p = sB.pop();
                    p.DisplayInfo();
                    sTemp.push(p);
                }
                while(!sTemp.isEmpty())
                    sB.push(sTemp.pop());

                while(!sC.isEmpty())
                {
                    p = sC.pop();
                    p.DisplayInfo();
                    sTemp.push(p);
                }
                while(!sTemp.isEmpty())
                    sC.push(sTemp.pop());

                System.out.print("\nEnter any key to go back: ");
                sc.next();
            }
            else if(action == 2)
            {
                System.out.print("\f");
                header();
                boolean found = false;
                String searchID = JOptionPane.showInputDialog("Enter parcel ID to search: ");
                while(!found)
                {
                    while(!sA.isEmpty())
                    {
                        p = sA.pop();

                        if(p.getParcelID().equalsIgnoreCase(searchID))
                        {
                            p.DisplayInfo();
                            found = true;
                        }
                            
                        sTemp.push(p);
                    }
                    while(!sTemp.isEmpty())
                        sA.push(sTemp.pop());
                    
                    while(!sB.isEmpty())
                    {
                        p = sB.pop();

                        if(p.getParcelID().equalsIgnoreCase(searchID))
                        {
                            p.DisplayInfo();
                            found = true;
                        }

                        sTemp.push(p);
                    }
                    while(!sTemp.isEmpty())
                        sB.push(sTemp.pop());
                    
                    while(!sC.isEmpty())
                    {
                        p = sC.pop();

                        if(p.getParcelID().equalsIgnoreCase(searchID))
                        {
                            p.DisplayInfo();
                            found = true;
                        }
                        
                        sTemp.push(p);
                    }
                    while(!sTemp.isEmpty())
                        sC.push(sTemp.pop());
                    
                    break;
                }
                
                if(!found)
                    System.out.println("Parcel not found!");
                
                System.out.print("\nEnter any key to go back: ");
                sc.next();
            }
            else if(action == 3)
            {
                System.out.print("\f");
                header();
                while (scanFile.hasNext())
                {
                    String indata = scanFile.nextLine();
                    StringTokenizer st = new StringTokenizer(indata,";");

                    String parcelID = st.nextToken();
                    String senderName = st.nextToken();
                    String senderAddress = st.nextToken();
                    String senderContactNo = st.nextToken();
                    String receiverName = st.nextToken();
                    String receiverAddress = st.nextToken();
                    String receiverContactNo = st.nextToken();
                    double parcelWeight = Double.parseDouble(st.nextToken());
                    int parcelAddress = Integer.parseInt(st.nextToken());
                    boolean fragile = Boolean.parseBoolean(st.nextToken());
                    String dateIn = st.nextToken();
                    String dateOut = st.nextToken();

                    p = new Parcel(parcelID, senderName, senderAddress,senderContactNo,receiverName,receiverAddress,receiverContactNo,parcelWeight, parcelAddress, fragile, dateOut, dateIn);
                    q.enqueue(p);
                }

                while(!q.isEmpty())
                {
                    p = q.dequeue();

                    if(p.getParcelWeight() <= 10)
                        sA.push(p);
                    else if(p.getParcelWeight() > 10 && p.getParcelWeight() <= 20)
                        sB.push(p);
                    else if(p.getParcelWeight() > 20 && p.getParcelWeight() <= 50)
                        sC.push(p);

                    qTemp.enqueue(p);
                }
                while(!qTemp.isEmpty())
                {
                    q.enqueue(qTemp.dequeue());
                }

                while(!sA.isEmpty())
                {
                    p =(Parcel) sA.pop();
                    int a = 0000;

                    if(a==A.getParcelAddress()){
                        if(p.getParcelWeight() <= 10)
                            a =1111;
                        else if(p.getParcelWeight() > 10 && p.getParcelWeight() <= 20)
                            a = 2111;
                        else if(p.getParcelWeight() > 20 && p.getParcelWeight() <= 50)
                            a = 3111;
                    }
                    else
                        a=A.getParcelAddress();

                    String b = Integer.toString(a);

                    while(a == A.getParcelAddress())
                    {
                        a=a+1;
                        b = Integer.toString(a);
                        if(b.substring(3,4).equals("6"))
                        {
                            a=a+4;
                        }
                        if(b.substring(2,3).equals("7"))
                        {
                            a=a+30;
                        }
                    }

                    p.setParcelAddress(a);
                    A = p;
                    qTemp.enqueue(p);
                }
                while(!qTemp.isEmpty())
                {
                    sA.push(qTemp.dequeue());
                }

                while(!sB.isEmpty())
                {
                    p =(Parcel) sB.pop();
                    int a = 0000;

                    if(a==B.getParcelAddress()){
                        if(p.getParcelWeight() <= 10)
                            a =1111;
                        else if(p.getParcelWeight() > 10 && p.getParcelWeight() <= 20)
                            a = 2111;
                        else if(p.getParcelWeight() > 20 && p.getParcelWeight() <= 50)
                            a = 3111;
                    }
                    else
                        a=B.getParcelAddress();

                    String b = Integer.toString(a);

                    while(a == B.getParcelAddress())
                    {
                        a=a+1;
                        b = Integer.toString(a);
                        if(b.substring(3,4).equals("6"))
                        {
                            a=a+4;
                        }
                        if(b.substring(2,3).equals("7"))
                        {
                            a=a+30;
                        }
                    }

                    p.setParcelAddress(a);
                    B = p;
                    qTemp.enqueue(p);
                }
                while(!qTemp.isEmpty())
                {
                    sB.push(qTemp.dequeue());
                }

                while(!sC.isEmpty())
                {
                    p =(Parcel) sC.pop();
                    int a = 0000;

                    if(a==C.getParcelAddress()){
                        if(p.getParcelWeight() <= 10)
                            a =1111;
                        else if(p.getParcelWeight() > 10 && p.getParcelWeight() <= 20)
                            a = 2111;
                        else if(p.getParcelWeight() > 20 && p.getParcelWeight() <= 50)
                            a = 3111;
                    }
                    else
                        a=C.getParcelAddress();

                    String b = Integer.toString(a);
                    while(a == C.getParcelAddress())
                    {
                        a=a+1;
                        b = Integer.toString(a);
                        if(b.substring(3,4).equals("6"))
                        {
                            a=a+4;
                        }
                        if(b.substring(2,3).equals("7"))
                        {
                            a=a+30;
                        }
                    }

                    p.setParcelAddress(a);
                    C = p;
                    qTemp.enqueue(p);
                }
                while(!qTemp.isEmpty())
                {
                    sC.push(qTemp.dequeue());
                }

                System.out.println("Data from files inserted successfully.");
                System.out.print("\nEnter any key to go back: ");
                sc.next();
            }
            else if(action == 4)
            {
                System.out.print("\f");
                int loop =  Integer.parseInt(JOptionPane.showInputDialog("How many parcel need to be inserted :"));
                for(int i =0 ; i<loop;i++)
                {
                    String parcelID = JOptionPane.showInputDialog("Enter Parcel Id :");
                    String senderName = JOptionPane.showInputDialog("Enter Sender Name :");
                    String senderAddress = JOptionPane.showInputDialog("Enter Sender Address :");
                    String senderContactNo = JOptionPane.showInputDialog("Enter Contact Number :");
                    String receiverName = JOptionPane.showInputDialog("Enter Receiver Name :");
                    String receiverAddress = JOptionPane.showInputDialog("Enter Receiver Address :");
                    String receiverContactNo = JOptionPane.showInputDialog("Enter Receiver Contact Number :");
                    double parcelWeight = Double.parseDouble(JOptionPane.showInputDialog("Enter Parcel Weight(kg) :"));
                    int parcelAddress = 0;
                    boolean fragile = Boolean.parseBoolean(JOptionPane.showInputDialog("Parcel Fragile (True/False) :"));
                    String dateIn = JOptionPane.showInputDialog("Enter Parcel Date In :");
                    String dateOut = JOptionPane.showInputDialog("Enter Parcel Date Out :");

                    p = new Parcel(parcelID, senderName, senderAddress,senderContactNo,receiverName,receiverAddress,receiverContactNo,parcelWeight, parcelAddress, fragile, dateOut, dateIn);
                    q.enqueue(p);
                }

                while(!q.isEmpty())
                {
                    p = q.dequeue();

                    if(p.getParcelWeight() <= 10)
                        sA.push(p);
                    else if(p.getParcelWeight() > 10 && p.getParcelWeight() <= 20)
                        sB.push(p);
                    else if(p.getParcelWeight() > 20 && p.getParcelWeight() <= 50)
                        sC.push(p);

                    qTemp.enqueue(p);
                }
                while(!qTemp.isEmpty())
                    q.enqueue(qTemp.dequeue());

                System.out.println("Data  inserted successfully.");
                System.out.print("\nEnter any key to go back: ");
                sc.next();
            }
            else if(action == 5)//dida
            {
                System.out.print("\f");
                header();
                System.out.print("Are you sure you want to remove today's due parcels?(Y/N):");
                String removeConfirmation = sc.next();
                if(removeConfirmation.equalsIgnoreCase("Y"))
                {
                    while(!sA.isEmpty())
                    {
                        p = sA.pop();
                        
                        if(p.getDateOut().equalsIgnoreCase(todayDate))
                        {
                            p.DisplayInfo();
                            removedList.insertAtFront(p);
                        }
                        else
                            sTemp.push(p);
                    }
                    while(!sTemp.isEmpty())
                        sA.push(sTemp.pop());

                    while(!sB.isEmpty())
                    {
                        p = sB.pop();
                        
                        if(p.getDateOut().equalsIgnoreCase(todayDate))
                        {
                            p.DisplayInfo();
                            removedList.insertAtFront(p);
                        }
                        else
                            sTemp.push(p);
                    }
                    while(!sTemp.isEmpty())
                        sB.push(sTemp.pop());

                    while(!sC.isEmpty())
                    {
                        p = sC.pop();
                        
                        if(p.getDateOut().equalsIgnoreCase(todayDate))
                        {
                            p.DisplayInfo();
                            removedList.insertAtFront(p);
                        }
                        else
                            sTemp.push(p);
                    }
                    while(!sTemp.isEmpty())
                        sC.push(sTemp.pop());
                        
                    System.out.println("Today's due parcels successfully removed.\nEnter any key to continue.");
                    sc.next();
                }else{
                    System.out.println("Today's due parcels not removed.\nEnter any key to continue.");
                    sc.next();
                }
            }
            else if(action == 6)
            {
                System.out.print("\f");
                header();
                
                Object data = removedList.getFirst();
                while(data != null)
                {
                    p =(Parcel) data;
                    p.DisplayInfo();
                    data = removedList.getNext();
                }

                System.out.print("\nEnter any key to continue: ");
                sc.next();
            }
            else if(action == 9)
            {
                System.out.print("\f");
                header();
                System.out.println("Are you sure you want to exit?(Y/N)");
                String exitConfirmation = sc.next();
                if(exitConfirmation.equalsIgnoreCase("Y"))
                {
                    try
                    {
                        System.out.print("\f");
                        header();
                        System.out.println("Program exited successfully!");

                        FileWriter myWriter = new FileWriter("OutputFile.txt");
                        Object data = removedList.getFirst();
                        while(data != null)
                        {
                            p =(Parcel) data;
                            myWriter.write(p.printInfo());
                            myWriter.write("\n");
                            data = removedList.getNext();
                        }
                        myWriter.close();
                    }
                    catch (FileNotFoundException e){System.out.println("Input file does not exist");}
                    catch (EOFException eof){System.out.println("Problem :"+eof.getMessage());}
                    catch (IOException ioe){System.out.println("Problem :"+ioe.getMessage());}

                    run = false;
                    break;
                }else
                    break;
            }
            else
            {
                System.out.print("\f");
                header();
                System.out.println("Invalid choice!");
                System.out.println("Enter any key to continue: ");
                sc.next();
            }
        }
    }

    public static void header()
    {
        System.out.println("----------------- MHolding Logistic Facility------------------------");
    }
}