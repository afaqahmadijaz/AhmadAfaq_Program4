//***************************************************************
//
//  Developer:    Instructor
//
//  Program #:    Four
//
//  File Name:    Program4Template.java
//
//  Course:       ITSE 2317 Intermediate Java Programming
//
//  Due Date:     March 30th 2025
//
//  Instructor:   Fred Kumi
//
//  Chapter:      17
//
//  Description:  Program4 test class used to demonstrate the use
//                of streams. This class will read data from the
//                invoive file, Program4.txt and perform all
//                requirements in the assignment.
//
//                Do not modifiy the main method of this class. If you
//                do, you will not receive credit for this program. 
//
//***************************************************************

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.ArrayList;

public class Program4
{
   Scanner input = null;
   
   //***************************************************************
   //
   //  Method:       main
   // 
   //  Description:  The main method of the program
   //
   //  Parameters:   String array
   //
   //  Returns:      N/A 
   //
   //**************************************************************
   public static void main(String[] args) 
   {	   
      Program4 program4Obj = new Program4();
      ProcessInvoices invoiceObj = new ProcessInvoices();
      
      ArrayList<Invoice> invoiceList = new ArrayList<>();
      
	  program4Obj.developerInfo();
	  
	  program4Obj.openFile();
	  program4Obj.readRecords(invoiceList);

      invoiceObj.solutionPartA(invoiceList);
      invoiceObj.solutionPartB(invoiceList);
      invoiceObj.solutionPartC(invoiceList);
      invoiceObj.solutionPartD(invoiceList);
      invoiceObj.solutionPartE(invoiceList);
      invoiceObj.solutionPartF(invoiceList);
   }
	
   //***************************************************************
   //
   //  Method:       openFile
   // 
   //  Description:  Opens the invoice file, Program4.txt
   //
   //  Parameters:   None
   //
   //  Returns:      N/A 
   //
   //**************************************************************
   public void openFile()
   {
      try
      {
         input = new Scanner(Paths.get("Program4.txt")); 
      } 
      catch (IOException ioException)
      {
         System.err.println("Error opening file. Terminating.");
         System.exit(1);
      }
   }
 
   //***************************************************************
   //
   //  Method:       readRecords
   // 
   //  Description:  
   //
   //  Parameters:   None
   //
   //  Returns:      N/A 
   //
   //**************************************************************
   public void readRecords(ArrayList<Invoice> invoiceList)
   {

      try
      {
         while (input.hasNext())
         {
            String line = input.nextLine();
            String[] parts = line.split(",");

            int partNumber = Integer.parseInt(parts[0]);
            String partDescription = parts[1];
            int quantity = Integer.parseInt(parts[2]);
            double price = Double.parseDouble(parts[3]);

            Invoice invoice = new Invoice(partNumber, partDescription, quantity, price);
            invoiceList.add(invoice);
         }
      }
      catch (Exception ex)
      {
         System.err.println("Error reading records: " + ex.getMessage());
      }
      finally
      {
         if (input != null)
         {
            input.close();
         }
      }

   }
   
   //***************************************************************
   //
   //  Method:       developerInfo
   // 
   //  Description:  The developer information method of the program
   //
   //  Parameters:   None
   //
   //  Returns:      N/A 
   //
   //**************************************************************
   public void developerInfo()
   {
      System.out.println("Name:     Afaq Ahmad");
      System.out.println("Course:   ITSE 2317 Intermediate Java Programming");
      System.out.println("Program:  Four");
	  System.out.println("Due Date: March 30th 2025\n");
   } // End of developerInfo
}