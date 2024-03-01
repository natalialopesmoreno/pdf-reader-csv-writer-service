package com.example.pdf_reader_csv_writer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.junit.Test;

public class PdfReaderTest {
	
	@Test
	public void givenSamplePdf_whenUsingApachePdfBox_thenCompareOutput() throws IOException {
	    
	    String expectedText = "Hello World!\n";
	    File file = new File("sample.pdf");
	    PDDocument document = PDDocument.load(file);
	    PDFTextStripper stripper = new PDFTextStripper();
	    String text = stripper.getText(document);
	    document.close();
	    
	    assertEquals(expectedText, text);
	}

}
