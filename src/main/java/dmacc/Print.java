package dmacc;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;

import dmacc.beans.CustomerReservation;

public class Print {
	
	private List<CustomerReservation> listReservations;
	
	public Print(List<CustomerReservation> listReservations) {
        this.listReservations = listReservations;
    }
 
    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);
         
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);
         
        cell.setPhrase(new Phrase("ID", font));
         
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Customer", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Seat", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Flight", font));
        table.addCell(cell);
        
    }
     
    private void writeTableData(PdfPTable table) {
        for (CustomerReservation cr : listReservations) {
            table.addCell(String.valueOf(cr.getId()));
            table.addCell(String.valueOf(cr.getCustomer()));
            table.addCell(cr.getSeatIdentifierText());
            table.addCell(String.valueOf(cr.getFlight()));
            //table.addCell(String.valueOf(cr.isEnabled()));
        }
    }
     
    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
         
        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLUE);
         
        Paragraph p = new Paragraph("List of Reservations", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);
         
        document.add(p);
         
        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {2.0f, 2.0f, 2.0f, 2.0f});//, 3.0f, 1.5f});
        table.setSpacingBefore(10);
         
        writeTableHeader(table);
        writeTableData(table);
         
        document.add(table);
         
        document.close();
         
    }
	
}
