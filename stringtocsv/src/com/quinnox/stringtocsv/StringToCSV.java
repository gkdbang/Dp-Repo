package com.quinnox.stringtocsv;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

public class StringToCSV {

	public static void main(String[] args) throws IOException {
		
		   String data ="//Order[1]/@CustomerFirstName"+"\n"+
				 "//Order[1]/@CustomerEMailID"+"\n"+
				 "//Order[1]/@CustomerLastName"+"\n"+
				 "//Order[1]/@DocumentType"+"\n"+
				 "//Order[1]/@EmailType"+"\n"+
				 "//Order[1]/@EnterpriseCode"+"\n"+
				 "//Order[1]/@OrderNo"+"\n"+
				 "//Order[1]/@ReturnType"+"\n"+
				 "//Order[1]/@ShippinglabelURL"+"\n"+
				 "//Order[1]/@Status"+"\n"+
				 "//Order[1]/@StatusDesc"+"\n"+
				 "//Order[1]/@TemplateName"+"\n"+
				 "//Order[1]/@TotalPrepaidLabelCharge"+"\n"+
				 "//Order[1]/@TrackingNo"+"\n"+
				 "//Order[1]/@xmlns:datetime"+"\n"+
				 "//Order[1]/@xmlns:java"+"\n"+
				 "//Order[1]/@xmlns:xs"+"\n"+
				 "//Order[1]/PersonInfoShipTo[1]/@AddressLine1"+"\n"+
				 "//Order[1]/PersonInfoShipTo[1]/@AddressLine2"+"\n"+
				 "//Order[1]/PersonInfoShipTo[1]/@AlternateEmailID"+"\n"+
				 "//Order[1]/PersonInfoShipTo[1]/@City"+"\n"+
				 "//Order[1]/PersonInfoShipTo[1]/@Country"+"\n"+
				 "//Order[1]/PersonInfoShipTo[1]/@DayPhone"+"\n"+
				 "//Order[1]/PersonInfoShipTo[1]/@EMailID"+"\n"+
				 "//Order[1]/PersonInfoShipTo[1]/@FirstName"+"\n"+
				 "//Order[1]/PersonInfoShipTo[1]/@LastName"+"\n"+
				 "//Order[1]/PersonInfoShipTo[1]/@State"+"\n"+
				 "//Order[1]/PersonInfoShipTo[1]/@ZipCode"+"\n"+
				 "//Order[1]/OrderLines[1]/OrderLine[1]/@OrderedQty"+"\n"+
				 "//Order[1]/OrderLines[1]/OrderLine[1]/@PrimeLineNo"+"\n"+
				 "//Order[1]/OrderLines[1]/OrderLine[1]/@ReturnReason"+"\n"+
				 "//Order[1]/OrderLines[1]/OrderLine[1]/Extn[1]/@ReturnReasonComments"+"\n"+
				 "//Order[1]/OrderLines[1]/OrderLine[1]/Item[1]/@ItemDesc"+"\n"+
				 "//Order[1]/OrderLines[1]/OrderLine[1]/Item[1]/@ItemID"+"\n"+
				 "//Order[1]/OrderLines[1]/OrderLine[1]/DerivedFrom[1]/@OrderNo"+"\n"+
				 "//Order[1]/OrderLines[1]/OrderLine[1]/ItemDetails[1]/PrimaryInformation[1]/@ImageID"+"\n"+
				 "//Order[1]/OrderLines[1]/OrderLine[1]/ItemDetails[1]/PrimaryInformation[1]/@ImageLocation"+"\n"+
				 "//Order[1]/OrderLines[1]/OrderLine[1]/LinePriceInfo[1]/@UnitPrice"+"\n"+
				 "//Order[1]/OrderLines[1]/OrderLine[1]/LineOverallTotals[1]/@LineTotal"+"\n"+
				 "//Order[1]/OrderLines[1]/OrderLine[1]/LineCharges[1]/LineCharge[1]/@ChargeAmount"+"\n"+
				 "//Order[1]/OrderLines[1]/OrderLine[1]/LineCharges[1]/LineCharge[1]/@ChargeCategory"+"\n"+
				 "//Order[1]/OrderLines[1]/OrderLine[1]/LineCharges[1]/LineCharge[1]/@ChargeName"+"\n"+
				 "//Order[1]/OrderLines[1]/OrderLine[1]/LineCharges[1]/LineCharge[1]/@ChargePerLine"+"\n"+
				 "//Order[1]/OrderLines[1]/OrderLine[1]/LineCharges[1]/LineCharge[1]/@ChargePerUnit"+"\n"+
				 "//Order[1]/OrderLines[1]/OrderLine[1]/LineCharges[1]/LineCharge[1]/@IsDiscount"+"\n"+
				 "//Order[1]/OrderLines[1]/OrderLine[1]/LineCharges[1]/LineCharge[2]/@ChargeAmount"+"\n"+
				 "//Order[1]/OrderLines[1]/OrderLine[1]/LineCharges[1]/LineCharge[2]/@ChargeCategory"+"\n"+
				 "//Order[1]/OrderLines[1]/OrderLine[1]/LineCharges[1]/LineCharge[2]/@ChargeName"+"\n"+
				 "//Order[1]/OrderLines[1]/OrderLine[1]/LineCharges[1]/LineCharge[2]/@ChargePerLine"+"\n"+
				 "//Order[1]/OrderLines[1]/OrderLine[1]/LineCharges[1]/LineCharge[2]/@ChargePerUnit"+"\n"+
				 "//Order[1]/OrderLines[1]/OrderLine[1]/LineCharges[1]/LineCharge[2]/@IsDiscount"+"\n"+
				 "//Order[1]/OrderLines[1]/OrderLine[1]/LineCharges[1]/LineCharge[3]/@ChargeAmount"+"\n"+
				 "//Order[1]/OrderLines[1]/OrderLine[1]/LineCharges[1]/LineCharge[3]/@ChargeCategory"+"\n"+
				 "//Order[1]/OrderLines[1]/OrderLine[1]/LineCharges[1]/LineCharge[3]/@ChargeName"+"\n"+
				 "//Order[1]/OrderLines[1]/OrderLine[1]/LineCharges[1]/LineCharge[3]/@ChargePerLine"+"\n"+
				 "//Order[1]/OrderLines[1]/OrderLine[1]/LineCharges[1]/LineCharge[3]/@ChargePerUnit"+"\n"+
				 "//Order[1]/OrderLines[1]/OrderLine[1]/LineCharges[1]/LineCharge[3]/@IsDiscount"+"\n"+
				 "//Order[1]/OrderLines[1]/OrderLine[2]/@OrderedQty"+"\n"+
				 "//Order[1]/OrderLines[1]/OrderLine[2]/@PrimeLineNo"+"\n"+
				 "//Order[1]/OrderLines[1]/OrderLine[2]/@ReturnReason"+"\n"+
				 "//Order[1]/OrderLines[1]/OrderLine[2]/Extn[1]/@ReturnReasonComments"+"\n"+
				 "//Order[1]/OrderLines[1]/OrderLine[2]/Item[1]/@ItemDesc"+"\n"+
				 "//Order[1]/OrderLines[1]/OrderLine[2]/Item[1]/@ItemID"+"\n"+
				 "//Order[1]/OrderLines[1]/OrderLine[2]/DerivedFrom[1]/@OrderNo"+"\n"+
				 "//Order[1]/OrderLines[1]/OrderLine[2]/ItemDetails[1]/PrimaryInformation[1]/@ImageID"+"\n"+
				 "//Order[1]/OrderLines[1]/OrderLine[2]/ItemDetails[1]/PrimaryInformation[1]/@ImageLocation"+"\n"+
				 "//Order[1]/OrderLines[1]/OrderLine[2]/LinePriceInfo[1]/@UnitPrice"+"\n"+
				 "//Order[1]/OrderLines[1]/OrderLine[2]/LineOverallTotals[1]/@LineTotal"+"\n"+
				 "//Order[1]/OrderLines[1]/OrderLine[2]/LineCharges[1]/LineCharge[1]/@ChargeAmount"+"\n"+
				 "//Order[1]/OrderLines[1]/OrderLine[2]/LineCharges[1]/LineCharge[1]/@ChargeCategory"+"\n"+
				 "//Order[1]/OrderLines[1]/OrderLine[2]/LineCharges[1]/LineCharge[1]/@ChargeName"+"\n"+
				 "//Order[1]/OrderLines[1]/OrderLine[2]/LineCharges[1]/LineCharge[1]/@ChargePerLine"+"\n"+
				 "//Order[1]/OrderLines[1]/OrderLine[2]/LineCharges[1]/LineCharge[1]/@ChargePerUnit"+"\n"+
				 "//Order[1]/OrderLines[1]/OrderLine[2]/LineCharges[1]/LineCharge[1]/@IsDiscount"+"\n"+
				 "//Order[1]/OrderLines[1]/OrderLine[2]/LineCharges[1]/LineCharge[2]/@ChargeAmount"+"\n"+
				 "//Order[1]/OrderLines[1]/OrderLine[2]/LineCharges[1]/LineCharge[2]/@ChargeCategory"+"\n"+
				 "//Order[1]/OrderLines[1]/OrderLine[2]/LineCharges[1]/LineCharge[2]/@ChargeName"+"\n"+
				 "//Order[1]/OrderLines[1]/OrderLine[2]/LineCharges[1]/LineCharge[2]/@ChargePerLine"+"\n"+
				 "//Order[1]/OrderLines[1]/OrderLine[2]/LineCharges[1]/LineCharge[2]/@ChargePerUnit"+"\n"+
				 "//Order[1]/OrderLines[1]/OrderLine[2]/LineCharges[1]/LineCharge[2]/@IsDiscount"+"\n"+
				 "//Order[1]/OrderLines[1]/OrderLine[2]/LineCharges[1]/LineCharge[3]/@ChargeAmount"+"\n"+
				 "//Order[1]/OrderLines[1]/OrderLine[2]/LineCharges[1]/LineCharge[3]/@ChargeCategory"+"\n"+
				 "//Order[1]/OrderLines[1]/OrderLine[2]/LineCharges[1]/LineCharge[3]/@ChargeName"+"\n"+
				 "//Order[1]/OrderLines[1]/OrderLine[2]/LineCharges[1]/LineCharge[3]/@ChargePerLine"+"\n"+
				 "//Order[1]/OrderLines[1]/OrderLine[2]/LineCharges[1]/LineCharge[3]/@ChargePerUnit"+"\n"+
				 "//Order[1]/OrderLines[1]/OrderLine[2]/LineCharges[1]/LineCharge[3]/@IsDiscount"+"\n"+
				 "//Order[1]/OverallTotals[1]/@GrandTotal";

		   //Use a BufferedReader to read from actual Text file
		    String csv = data.replace("|", ",");
		    String[] csvAsArray=csv.split("\n");
		    
		    List<String> csvAsList= Arrays.asList(csvAsArray);
		    
		    for (String string : csvAsList) {
				System.out.println(string);
			}
		    
		    // Write data to canonical excel
		    WriteXpathToCanonical.writeXpathToCanonical(csvAsList);
		    
		    //System.out.println(csv);

		    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("C:\\Gaurav2\\CustomerDatA.csv")));
		    out.println(csv);
		    out.close();

	}

}
