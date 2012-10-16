package edu.cmu.ppravind.ner.cas;


import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import java.io.*;

import org.apache.uima.collection.CasConsumer_ImplBase;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceProcessException;
import edu.cmu.ppravind.ner.types.GeneMention_Type;
import edu.cmu.ppravind.ner.types.GeneMention;
import java.util.Iterator;
import org.apache.uima.jcas.tcas.Annotation;
import org.apache.uima.resource.ResourceConfigurationException;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.resource.ResourceProcessException;
import org.apache.uima.util.ProcessTrace;

public class OutputFileProcessor extends CasConsumer_ImplBase {

	public File OutputFile;
	BufferedWriter out;
	
	public void initialize() {
		
		// Initialize the OutPut File
		//OutputFile = new File ((String) getConfigParameterValue("OutputFile"));		
		try {
			out = new BufferedWriter(new FileWriter((String) getConfigParameterValue("OutputFile")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		}
	
	@Override
	public void processCas(CAS aCAS) throws ResourceProcessException {
		// TODO Auto-generated method stub		
		
		/*
		 * Do Post Processing of the text. Reads from CAS, and writes in the output format requi
		 * 
		 */			 
		  try {		   
          JCas jcas = aCAS.getJCas();        
		  // Itrerate through CAS and write Output to O/P File		  
		  Iterator annotationIter = jcas.getAnnotationIndex(GeneMention.typeIndexID).iterator();			
			
			int cnt=0;
		    while (annotationIter.hasNext()) {
		      GeneMention annot = (GeneMention) annotationIter.next();
		      //System.out.println(annot);	      
		      
		      Integer startOffset = annot.getBegin();
		      startOffset -= annot.getCurOff();		      
		      Integer endOffset = annot.getEnd();
		      endOffset-= annot.getCurOff();
		      String docId = annot.getDocumentID();
		      String geneName = annot.getGeneName();
		      
		      // Write all the Strings in the OutPut File
		      
		      String opString = docId+"|"+startOffset+" "+endOffset+"|"+geneName+"\n";
		      System.out.println(opString);
		      
		     
		    // Write O/P to File  
			try {
				cnt+=1;
				//System.out.println(opString);
				out.write(opString);			
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}    
		  }
		    System.out.println(cnt);
		    
		  }
		  catch (CASException e) {
		    throw new ResourceProcessException(e);
		  }   		 
		

	}

}
