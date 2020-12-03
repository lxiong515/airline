package dmacc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

//import javax.swing.text.Document;

import com.itextpdf.io.IOException;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.*;
import com.itextpdf.layout.Document;

public class GeneratePdf {
	
	public static void main(String[] args) throws IOException, FileNotFoundException {

		//this is example is from: https://www.boraji.com/itext7-hello-world-example
		    File file = new File("reservation.pdf");

		    // Open PDF document in write mode
		    PdfWriter pdfWriter = new PdfWriter(file);
		    PdfDocument pdfDocument = new PdfDocument(pdfWriter);

		    // Create document to add new elements
		    Document document = new Document(pdfDocument);

		    // Create Paragraph
		    Paragraph paragraph = new Paragraph("Hello Itext7");
		    paragraph.add("\n");
		    paragraph.add("My first PDF document in iText7.");

		    // Add Paragraph to document
		    document.add(paragraph);

		    // Close document
		    document.close();
		  }
		/* Too many errors in this code from youtube https://www.youtube.com/watch?v=fPr6HUDC37I
		//create document
		Document document = new Document();
		
		PdfWriter.getInstance(document, new FileOutputStream("C:\\temp\\table.pdf"));
		
		//open the document
		document.open();
		
		//create a paragraph
		Paragraph intro=new Paragraph("Customer Reservation");
		Paragraph space=new Paragraph(" ");
		
		//create a table
		PdfTable table = new PdfTable(3);
		
		//create a cell
		PdfCell c1=new PdfPCell(new Paragraph("First Name"));
		PdfCell c2=new PdfPCell(new Paragraph("Last Name"));
		PdfCell c3=new PdfCell(new Paragraph("Depart"));
		PdfCell c4=new PdfCell(new Paragraph("Destination"));
		PdfCell c5=new PdfCell(new Paragraph("Seat"));

		//add cells to the table
		table.addCell(c1);
		table.addCell(c2);
		table.addCell(c3);
		table.addCell(c4);
		table.addCell(c5);
		
		// now add the objects to the document
		document.add(intro);
		document.add(space);
		document.add(table);
		

	    // Close document
	    document.close();
	  }

*/
}
