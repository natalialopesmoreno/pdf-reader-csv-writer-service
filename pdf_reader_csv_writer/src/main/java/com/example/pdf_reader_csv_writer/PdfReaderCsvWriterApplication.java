package com.example.pdf_reader_csv_writer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PdfReaderCsvWriterApplication {

	public static void main(String[] args) {
		
		 try {

			 String outputFilePath = "dados2.csv";

			 File file = new File(System.getProperty("user.dir").concat("/src/main/java/com/example/pdf_reader_csv_writer/file.pdf"));

	            if (!file.exists()) {
	                System.err.println("File not found.");
	                return;
	            }


			 	writeTextInCsv(outputFilePath, getStringFromFile(file));


			 System.out.println("Dados convertidos com sucesso para o arquivo CSV!");

	        } catch (IOException e) {
	            e.printStackTrace();
	        }

		
		SpringApplication.run(PdfReaderCsvWriterApplication.class, args);

		
		 
	}

	private static void writeTextInCsv(String outputFilePath, String text) throws IOException {
		FileWriter writer = new FileWriter(outputFilePath);

		// Dividir a string em linhas
		String[] lines = text.split("\n");

		for (String line : lines) {
			// Dividir cada linha em colunas
			String[] columns = line.split(";");

			// Escrever as colunas no arquivo CSV
			for (int i = 0; i < columns.length; i++) {
				writer.append(columns[i]);
				if (i != columns.length - 1) {
					writer.append(',');
				}
			}
			writer.append('\n');
		}

		writer.close();
	}

	private static String getStringFromFile(File file) throws IOException {
		// Instantiate PDFTextStripper class
		PDFTextStripper pdfStripper = new PDFTextStripper();
		// Load the PDF document
		PDDocument document = PDDocument.load(file);
		String text = pdfStripper.getText(document);
		// Close the document
		document.close();
		return text;
	}

}
