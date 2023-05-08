package com.xadmin.usermanagement.web;

import static java.time.temporal.TemporalAdjusters.lastDayOfYear;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Servlet implementation class GeneratePdf
 */
@WebServlet("/GeneratePdf")
public class GeneratePdf extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GeneratePdf() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			LocalDate now = LocalDate.now();
			LocalDate lastDay = now.with(lastDayOfYear());
			long diff = ChronoUnit.DAYS.between(now, lastDay);
			System.out.println("Nombre de jours restant : " + diff);
			long nbHeure = (diff * 4) / 7;
			System.out.println("Nombre d heure restant autorise pour cette annee: " + nbHeure);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			String file_name = "E:\\Desktop\\JEE\\generatePdf\\fer";
			Document doc = new Document();
			PdfWriter.getInstance(doc, new FileOutputStream(file_name));
			doc.open();
			Paragraph p = new Paragraph("hello ferdaws taktak!");
			doc.add(p);
			doc.close();
			System.out.println("finish process generate pdf");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
