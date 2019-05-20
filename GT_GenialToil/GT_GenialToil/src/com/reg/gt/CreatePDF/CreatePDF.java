package com.reg.gt.CreatePDF;

import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.Request;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.reg.gt.entity.Purchase_Requisition;

public class CreatePDF {
	public static void generatePDF(){
		String FILE_NAME="E:\\details\\materialsdetails_db.pdf";

		Document document = new Document();

		try {
		PdfWriter.getInstance(document, new FileOutputStream(FILE_NAME));

		document.open();




		Paragraph p = new Paragraph();
		p.add("SRA Limited");
		p.setAlignment(Element.ALIGN_CENTER);
		document.add(p);

		Paragraph p1 = new Paragraph();
		p1.add("PURCHASE REQUISITION");
		p1.setAlignment(Element.ALIGN_CENTER);
		document.add(p1);


		PdfPTable table = new PdfPTable(2);
		table.setWidthPercentage(100);
		table.setSpacingBefore(11f);
		table.setSpacingAfter(11f);

		float[] colsWidth={0.7f,2f};
		table.setWidths(colsWidth);


		PdfPCell c = new PdfPCell(new Paragraph("Site Name"));
		table.addCell(c);
		PdfPCell b = new PdfPCell(new Paragraph(" "));
		table.addCell(b);

		PdfPCell d = new PdfPCell(new Paragraph("PR No"));
		table.addCell(d);
		PdfPCell e = new PdfPCell(new Paragraph(" "));
		table.addCell(e);
		        
		PdfPCell f = new PdfPCell(new Paragraph("PR Date"));
		table.addCell(f);
		PdfPCell g = new PdfPCell(new Paragraph(" "));
		table.addCell(g);

		PdfPCell h = new PdfPCell(new Paragraph("PR Description"));
		table.addCell(h);
		PdfPCell i = new PdfPCell(new Paragraph(" "));
		table.addCell(i);

		PdfPCell j = new PdfPCell(new Paragraph("Remarks(if any"));
		table.addCell(j);
		// PdfPCell k = new PdfPCell(new Paragraph(" "));
		// table.addCell(k);
//		         
		        
		        
		        
		document.add(table);


		PdfPTable table1 = new PdfPTable(8);
		table1.setWidthPercentage(100);
		table1.setSpacingBefore(11f);
		table1.setSpacingAfter(11f);

		float[] colWidth={0.6f,1.5f,1f,1f,1f,1f,1f,1f};
		table1.setWidths(colWidth);

		PdfPCell c1 = new PdfPCell(new Paragraph("S.No"));

		table1.addCell(c1);

		c1 = new PdfPCell(new   Paragraph("Material Name"));
		table1.addCell(c1);

		c1 = new PdfPCell(new Paragraph("Material Type"));
		table1.addCell(c1);

		c1 = new PdfPCell(new   Paragraph("Material Grade"));
		table1.addCell(c1);

		c1 = new PdfPCell(new   Paragraph("Req Qty"));
		table1.addCell(c1);

		c1 = new PdfPCell(new   Paragraph("Units"));
		table1.addCell(c1);

		c1 = new PdfPCell(new   Paragraph("Est cost"));
		table1.addCell(c1);

		c1 = new PdfPCell(new   Paragraph("Req date"));
		table1.addCell(c1);
//		
//		ArrayList<Purchase_Requisition> prList = CRUD.getData();
//		for(int x = 0; x<prList.size(); x++) {
//		PdfPCell c2 = new PdfPCell(new Paragraph(Integer.toString(x+1)));
//		table1.addCell(c2);
//
//		c2 = new PdfPCell(new   Paragraph(prList.get(x).mName));
//		table1.addCell(c2);
//
//		c2 = new PdfPCell(new Paragraph(prList.get(x).mtype));
//		table1.addCell(c2);
//
//		c2 = new PdfPCell(new   Paragraph(prList.get(x).mGrade));
//		table1.addCell(c2);
//
//		c2 = new PdfPCell(new   Paragraph(Integer.toString(prList.get(x).req_qty)));
//		table1.addCell(c2);
//
//		c2 = new PdfPCell(new   Paragraph(prList.get(x).uom));
//		table1.addCell(c2);
//
//		c2 = new PdfPCell(new   Paragraph(Double.toString(prList.get(x).est_cost)));
//		table1.addCell(c2);
//
//		c2 = new PdfPCell(new   Paragraph(prList.get(x).reqDate));
//		table1.addCell(c2);
//
//		}document.add(table1);

		System.out.println("Finished");
		document.close();

		}
		catch(Exception e) {
		e.printStackTrace();
		}
	}
}
