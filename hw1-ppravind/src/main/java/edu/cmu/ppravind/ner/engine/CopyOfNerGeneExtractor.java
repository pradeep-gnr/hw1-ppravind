package edu.cmu.ppravind.ner.engine;
import com.aliasi.chunk.Chunker;
import com.aliasi.chunk.Chunking;
import com.aliasi.util.AbstractExternalizable;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import edu.cmu.ppravind.ner.types.*;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CopyOfNerGeneExtractor extends JCasAnnotator_ImplBase {

	public Chunking getNamedEntities(String file, String contents)
	{
			String annotations = "";
			File modelFile = new File (file);
            try {   	
            	
				Chunker chunker = (Chunker) AbstractExternalizable.readObject(modelFile);
				Chunking chunking = chunker.chunk(contents);
				return chunking;				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			} catch (ClassNotFoundException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}         
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
		String model_file = "src/main/resources/ner/models/ne-en-bio-genetag.HmmChunker";
		// Initialize Model File	
		
		// Parse Input File and generate Sentences
		String lines[] = docText.split("\\r?\\n");
		Map idText = new HashMap();
		
		// Read Each Line in Huge Text File		
		for (int i=0;i<lines.length;i++)
		{
			String docId = lines[i].split(" ")[0];
			String text = lines[i].split(" ")[1];			
		
	    //Get Chunked Output
		System.out.println(text);	
		
		
		Chunking chunking = this.getNamedEntities(model_file,text);		
		String chunkingOutput = chunking.chunkSet().toString();
				
		// Set CAS with Annotation Type and associated parameters for the annotation !		
		GeneMention annotation = new GeneMention(aJCas);
		
		// Initialize Variable
		String pattern = "(\\d*-\\d*):GENE@-Infinity";			
		Pattern genePattern = Pattern.compile(pattern);
				
		Matcher matcher = genePattern.matcher(chunkingOutput);
				
		while(matcher.find())
			{
			int pos1 = Integer.parseInt(matcher.group().split(":")[0].split("-")[0]);
			int pos2 = Integer.parseInt(matcher.group().split(":")[0].split("-")[1]);			
			annotation.setBegin(pos1);
			annotation.setEnd(pos2);			
			annotation.setDocumentID(docId);			
			}		
		}

	}
	
	public static void main(String[] args)
	{
	System.out.println("Hello");	
	CopyOfNerGeneExtractor a = new CopyOfNerGeneExtractor();
	System.out.println(a.getNamedEntities("src/main/resources/ner/models/ne-en-bio-genetag.HmmChunker","p43 this is good"));
	}
	

}
