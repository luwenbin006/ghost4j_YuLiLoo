package ghost4j;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.ghost4j.converter.ConverterException;
import org.ghost4j.converter.PDFConverter;
import org.ghost4j.document.DocumentException;
import org.ghost4j.document.PSDocument;

public class TestJ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//load PostScript document
	    PSDocument document = new PSDocument();
	    try {
			document.load(new File("testx.ps"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
	    //create OutputStream
	    FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(new File("xrendition.pdf"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
	    //create converter
	    PDFConverter converter = new PDFConverter();
	 
	    //set options
	    converter.setPDFSettings(PDFConverter.OPTION_PDFSETTINGS_PREPRESS);
	 
	    //convert
	    try {
			converter.convert(document, fos);
		} catch (IOException | ConverterException | DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
}
