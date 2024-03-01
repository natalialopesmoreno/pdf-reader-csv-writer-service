package com.example.pdf_reader_csv_writer;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PdfReaderCsvWriterApplication {

	public static void main(String[] args) {
		
		 try {
	            // Replace this with the path to your PDF file
			 
	            System.out.println("Current Directory: " + System.getProperty("user.dir"));

	            File file = new File("C:/Users/natin/Desktop/program/pdf-reader-csv-writer/pdf_reader_csv_writer/src/main/java/com/example/pdf_reader_csv_writer/file.pdf");

	            if (!file.exists()) {
	                System.err.println("File not found.");
	                return;
	            }

	            // Load the PDF document
	            PDDocument document = PDDocument.load(file);
	            
	            // Instantiate PDFTextStripper class
	            PDFTextStripper pdfStripper = new PDFTextStripper();

	            // Get the text from the PDF document
	            String text = pdfStripper.getText(document);

	            // Print the extracted text
	            System.out.println("Text from PDF:\n" + text);

	            // Close the document
	            document.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		
		SpringApplication.run(PdfReaderCsvWriterApplication.class, args);

		
		 
	}

}
