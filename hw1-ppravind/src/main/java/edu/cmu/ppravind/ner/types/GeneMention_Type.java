
/* First created by JCasGen Tue Oct 16 13:23:57 EDT 2012 */
package edu.cmu.ppravind.ner.types;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.tcas.Annotation_Type;

/** A Class for Handling Gene Mentions. Supertyped from the main Java Annotations method
 * Updated by JCasGen Tue Oct 16 13:23:57 EDT 2012
 * @generated */
public class GeneMention_Type extends Annotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (GeneMention_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = GeneMention_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new GeneMention(addr, GeneMention_Type.this);
  			   GeneMention_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new GeneMention(addr, GeneMention_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = GeneMention.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.cmu.ppravind.ner.types.GeneMention");
 
  /** @generated */
  final Feature casFeat_GeneName;
  /** @generated */
  final int     casFeatCode_GeneName;
  /** @generated */ 
  public String getGeneName(int addr) {
        if (featOkTst && casFeat_GeneName == null)
      jcas.throwFeatMissing("GeneName", "edu.cmu.ppravind.ner.types.GeneMention");
    return ll_cas.ll_getStringValue(addr, casFeatCode_GeneName);
  }
  /** @generated */    
  public void setGeneName(int addr, String v) {
        if (featOkTst && casFeat_GeneName == null)
      jcas.throwFeatMissing("GeneName", "edu.cmu.ppravind.ner.types.GeneMention");
    ll_cas.ll_setStringValue(addr, casFeatCode_GeneName, v);}
    
  
 
  /** @generated */
  final Feature casFeat_DocumentID;
  /** @generated */
  final int     casFeatCode_DocumentID;
  /** @generated */ 
  public String getDocumentID(int addr) {
        if (featOkTst && casFeat_DocumentID == null)
      jcas.throwFeatMissing("DocumentID", "edu.cmu.ppravind.ner.types.GeneMention");
    return ll_cas.ll_getStringValue(addr, casFeatCode_DocumentID);
  }
  /** @generated */    
  public void setDocumentID(int addr, String v) {
        if (featOkTst && casFeat_DocumentID == null)
      jcas.throwFeatMissing("DocumentID", "edu.cmu.ppravind.ner.types.GeneMention");
    ll_cas.ll_setStringValue(addr, casFeatCode_DocumentID, v);}
    
  
 
  /** @generated */
  final Feature casFeat_subText;
  /** @generated */
  final int     casFeatCode_subText;
  /** @generated */ 
  public String getSubText(int addr) {
        if (featOkTst && casFeat_subText == null)
      jcas.throwFeatMissing("subText", "edu.cmu.ppravind.ner.types.GeneMention");
    return ll_cas.ll_getStringValue(addr, casFeatCode_subText);
  }
  /** @generated */    
  public void setSubText(int addr, String v) {
        if (featOkTst && casFeat_subText == null)
      jcas.throwFeatMissing("subText", "edu.cmu.ppravind.ner.types.GeneMention");
    ll_cas.ll_setStringValue(addr, casFeatCode_subText, v);}
    
  
 
  /** @generated */
  final Feature casFeat_curOff;
  /** @generated */
  final int     casFeatCode_curOff;
  /** @generated */ 
  public int getCurOff(int addr) {
        if (featOkTst && casFeat_curOff == null)
      jcas.throwFeatMissing("curOff", "edu.cmu.ppravind.ner.types.GeneMention");
    return ll_cas.ll_getIntValue(addr, casFeatCode_curOff);
  }
  /** @generated */    
  public void setCurOff(int addr, int v) {
        if (featOkTst && casFeat_curOff == null)
      jcas.throwFeatMissing("curOff", "edu.cmu.ppravind.ner.types.GeneMention");
    ll_cas.ll_setIntValue(addr, casFeatCode_curOff, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public GeneMention_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_GeneName = jcas.getRequiredFeatureDE(casType, "GeneName", "uima.cas.String", featOkTst);
    casFeatCode_GeneName  = (null == casFeat_GeneName) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_GeneName).getCode();

 
    casFeat_DocumentID = jcas.getRequiredFeatureDE(casType, "DocumentID", "uima.cas.String", featOkTst);
    casFeatCode_DocumentID  = (null == casFeat_DocumentID) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_DocumentID).getCode();

 
    casFeat_subText = jcas.getRequiredFeatureDE(casType, "subText", "uima.cas.String", featOkTst);
    casFeatCode_subText  = (null == casFeat_subText) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_subText).getCode();

 
    casFeat_curOff = jcas.getRequiredFeatureDE(casType, "curOff", "uima.cas.Integer", featOkTst);
    casFeatCode_curOff  = (null == casFeat_curOff) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_curOff).getCode();

  }
}



    