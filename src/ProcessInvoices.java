//***************************************************************
//
//  Developer:    Afaq Ahmad
//
//  Program #:    Four
//
//  File Name:    ProcessInvoices.java
//
//  Course:       ITSE 2317 Intermediate Java Programming
//
//  Due Date:     March 30th 2025
//
//  Instructor:   Fred Kumi
//
//  Chapter:      17
//
//  Description:  Class to process invoice data using streams and lambdas
//
//***************************************************************

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;

public class ProcessInvoices {

    //***************************************************************
    //
    //  Method:       solutionPartA
    // 
    //  Description:  Sorts Invoice objects by partDescription and displays
    //
    //  Parameters:   ArrayList<Invoice> invoiceList
    //
    //  Returns:      N/A 
    //
    //**************************************************************
    public void solutionPartA(ArrayList<Invoice> invoiceList) {
        System.out.println("a - Invoices sorted by part description:");

        // Sort by part description and display
        invoiceList.stream()
                .sorted(Comparator.comparing(Invoice::getPartDescription))
                .forEach(System.out::println);

        System.out.println();
    }

    //***************************************************************
    //
    //  Method:       solutionPartB
    // 
    //  Description:  Sorts Invoice objects by pricePerItem and displays
    //
    //  Parameters:   ArrayList<Invoice> invoiceList
    //
    //  Returns:      N/A 
    //
    //**************************************************************
    public void solutionPartB(ArrayList<Invoice> invoiceList) {
        System.out.println("b - Invoices sorted by price:");

        // Sort by price and display
        invoiceList.stream()
                .sorted(Comparator.comparing(Invoice::getPrice))
                .forEach(System.out::println);

        System.out.println();
    }

    //***************************************************************
    //
    //  Method:       solutionPartC
    // 
    //  Description:  Maps each Invoice to partDescription and quantity,
    //                sorts by quantity, and displays
    //
    //  Parameters:   ArrayList<Invoice> invoiceList
    //
    //  Returns:      N/A 
    //
    //**************************************************************
    public void solutionPartC(ArrayList<Invoice> invoiceList) {
        System.out.println("c - Invoices mapped to description and quantity:");

        // Map to part description and quantity, sort by quantity, and display
        invoiceList.stream()
                .sorted(Comparator.comparing(Invoice::getQuantity))
                .map(invoice -> String.format("Description: %-15s Quantity: %d",
                        invoice.getPartDescription(), invoice.getQuantity()))
                .forEach(System.out::println);

        System.out.println();
    }

    //***************************************************************
    //
    //  Method:       solutionPartD
    // 
    //  Description:  Maps each Invoice to partDescription and value,
    //                sorts by value, and displays
    //
    //  Parameters:   ArrayList<Invoice> invoiceList
    //
    //  Returns:      N/A 
    //
    //**************************************************************
    public void solutionPartD(ArrayList<Invoice> invoiceList) {
        System.out.println("d - Invoices mapped to description and invoice amount:");

        // Map to part description and invoice amount, sort by amount, and display
        invoiceList.stream()
                .sorted(Comparator.comparing(invoice -> invoice.getQuantity() * invoice.getPrice()))
                .map(invoice -> {
                    double amount = invoice.getQuantity() * invoice.getPrice();
                    return String.format("Description: %-15s Invoice amount: %7.2f",
                            invoice.getPartDescription(), amount);
                })
                .forEach(System.out::println);

        System.out.println();
    }

    //***************************************************************
    //
    //  Method:       solutionPartE
    // 
    //  Description:  Maps Invoice to partDescription and value,
    //                filters for values between $200-$500,
    //                sorts by value, and displays
    //
    //  Parameters:   ArrayList<Invoice> invoiceList
    //
    //  Returns:      N/A 
    //
    //**************************************************************
    public void solutionPartE(ArrayList<Invoice> invoiceList) {
        System.out.println("e - Invoices mapped to description and invoice amount for invoices in the range 200-500:");

        // Map to part description and invoice amount, filter for values between $200-$500,
        // sort by amount, and display
        invoiceList.stream()
                .filter(invoice -> {
                    double amount = invoice.getQuantity() * invoice.getPrice();
                    return amount >= 200.00 && amount <= 500.00;
                })
                .sorted(Comparator.comparing(invoice -> invoice.getQuantity() * invoice.getPrice()))
                .map(invoice -> {
                    double amount = invoice.getQuantity() * invoice.getPrice();
                    return String.format("Description: %-15s Invoice amount: %7.2f",
                            invoice.getPartDescription(), amount);
                })
                .forEach(System.out::println);

        System.out.println();
    }

    //***************************************************************
    //
    //  Method:       solutionPartF
    // 
    //  Description:  Finds any one Invoice with "Saw" in partDescription
    //
    //  Parameters:   ArrayList<Invoice> invoiceList
    //
    //  Returns:      N/A 
    //
    //**************************************************************
    public void solutionPartF(ArrayList<Invoice> invoiceList) {
        System.out.println("f - Find any one Invoice in which description contains \"Saw\"");

        // Find first invoice with "Saw" in the description
        Optional<Invoice> sawInvoice = invoiceList.stream()
                .filter(invoice -> invoice.getPartDescription().contains("Saw"))
                .findFirst();

        // Display the invoice if found
        if (sawInvoice.isPresent()) {
            System.out.println(sawInvoice.get());
        } else {
            System.out.println("No invoices found with \"Saw\" in the description.");
        }

        System.out.println();
    }
}