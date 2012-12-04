package edu.cmu.ppravind.ner.engine;
import com.aliasi.util.AbstractExternalizable;
import com.aliasi.chunk.Chunker;
import com.aliasi.chunk.Chunking;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.UimaContext;
import edu.cmu.ppravind.ner.types.*;
import org.apache.uima.resource.ResourceInitializationException;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.io.InputStream;
import java.io.FileOutputStream;

public class NerGeneExtractor extends JCasAnnotator_ImplBase {
	
	public Chunker chunker;
	private File tempFile;  
	
	private void initFile(InputStream in) throws IOException {  
		   
        tempFile = File.createTempFile("tempFile", ".tmp");  
        tempFile.deleteOnExit();  
        System.out.println("Input File  "+in);
   
        FileOutputStream fout = null;  
   
        try {  
   
            fout = new FileOutputStream(tempFile);  
            int c;  
   
            while ((c = in.read()) != -1) {            	
                fout.write(c);  
            }  
   
        }finally {  
            if (in != null) {  
                in.close();  
            }  
            if (fout != null) {  
                fout.close();  
            }  
        }  
    }  
   
	public File getTempFile() {  
        return tempFile;  
    }  
	
	public void initialize(UimaContext aContext) 
	        throws ResourceInitializationException {
		/*
		 * Initialize with all necessary parameters for NER Extraction
		 */
	  super.initialize(aContext);
	  //File modelFile = new File ("");
	  InputStream in = this.getClass().getClassLoader()
              .getResourceAsStream("ne-en-bio-genetag.HmmChunker");
	 	  
	  try{	  		
		  this.initFile(in);
		 this.chunker = (Chunker) AbstractExternalizable.readObject(this.getTempFile());
	  }  
	 catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	  
	
	}

	public Chunking getNamedEntities(String contents)
	{				
           			
				Chunking chunking = this.chunker.chunk(contents);				
				return chunking;			
			
	}	
	@Override
	public void process(JCas aJCas) throws AnalysisEngineProcessException {
		/* Generate Code for the Named Entity Recognizer
		 * --> Read Document from the CAS
		 * --> Process the Document and set up a Dictionary of all 'ID' and 'contents'
		 * --> Check and identify genes using Named Entity Extraction
		 * --> Update the CAS with the "GeneMention" Annotation for each document ID 
		 *  
		 */
		// TODO Auto-generated method stub		
		
		// get document text from JCas
	    String docText = aJCas.getDocumentText();   
		
		// Search Text for Gene Expressions using Engine		
		
		// Initialize Model File	
		
		// Parse Input File and generate Sentences
		String lines[] = docText.split("\\r?\\n");	
		
		int initialOff = 0;
		int curOff =0;
		int cnt=0;
		// Read Each Line in Huge Text File		
		for (int i=0;i<lines.length;i++)
		{			
			
			// Set the annotation offset for each Document
			String docId = lines[i].split(" ",2)[0];
			curOff = docId.length() + curOff+1;
			String text = lines[i].split(" ",2)[1];		
		
		
		Chunking chunking = this.getNamedEntities(text);
		
		String chunkingOutput = chunking.chunkSet().toString();	
		
		// Initialize Variable
		String pattern = "(\\d*-\\d*):GENE@-Infinity";			
		Pattern genePattern = Pattern.compile(pattern);
				
		Matcher matcher = genePattern.matcher(chunkingOutput);
				
		while(matcher.find())
			{
			// Set CAS with Annotation Type and associated parameters for the annotation !
			GeneMention annotation = new GeneMention(aJCas);			
			//  Get Matched Positions
			int pos1 = Integer.parseInt(matcher.group().split(":")[0].split("-")[0]);
			int pos2 = Integer.parseInt(matcher.group().split(":")[0].split("-")[1]);
			
			// Remove Spaces and Search again
			String tmp_string = text.substring(pos1,pos2);
			tmp_string = tmp_string.replaceAll("\\s","");
			
			
			// Remove Spaces from Text also
			
			String tmptext = text;
			tmptext = tmptext.replaceAll("\\s","");
			
			
			// Get First match of pattern in String
			
			int first_index = tmptext.indexOf(tmp_string);
			int last_index = first_index + tmp_string.length()-1;		
			
			// Set Annotation 
			annotation.setBegin(curOff + first_index);
			annotation.setEnd(curOff + last_index);			
			annotation.setDocumentID(docId);
			annotation.setGeneName(text.substring(pos1,pos2));
			annotation.setSubText(text);
			annotation.setCurOff(curOff);
			annotation.addToIndexes();
			cnt+=1;			
			}		
		
			
			curOff+=text.length();
		}

		System.out.println(cnt);
	}	

}
