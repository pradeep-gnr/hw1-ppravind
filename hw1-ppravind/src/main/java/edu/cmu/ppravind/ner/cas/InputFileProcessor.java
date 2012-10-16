package edu.cmu.ppravind.ner.cas;

import java.io.File;
import java.io.IOException;

import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.collection.CollectionException;
import org.apache.uima.collection.CollectionReader_ImplBase;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.util.FileUtils;
import org.apache.uima.util.Progress;

public class InputFileProcessor extends CollectionReader_ImplBase {

	
	public String inputFile;	
	// Checks if the Input File has been read for the hasNext Method
	boolean file_read= false;
	
	public void initialize() throws ResourceInitializationException {
		// Initialize the Input Directory
		// Initialize File Path
		System.out.println("Input String Initialized");
		inputFile = (String) getConfigParameterValue("InputFile");	
		
	}
	
	@Override
	public void getNext(CAS aCAS) throws IOException, CollectionException {
		// TODO Auto-generated method stub
		JCas jcas;
	    try {
	      jcas = aCAS.getJCas();
	    } catch (CASException e) {
	      throw new CollectionException(e);
	    }
	    
	    // Check if input File has been read ! 
	    if (file_read ==false)
	    {
	    	// Read File and Keep in CAS !	    	
	    	
	    	File file = new File(inputFile);
	    	String text = FileUtils.file2String(file);
	         // put document in CAS
	        jcas.setDocumentText(text);
	        file_read = true;
	    }

	}
	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public Progress[] getProgress() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasNext() throws IOException, CollectionException {
		// TODO Auto-generated method stub
		return file_read==false;
	}

}
