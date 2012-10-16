

/* First created by JCasGen Tue Oct 16 13:23:57 EDT 2012 */
package edu.cmu.ppravind.ner.types;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** A Class for Handling Gene Mentions. Supertyped from the main Java Annotations method
 * Updated by JCasGen Tue Oct 16 13:23:57 EDT 2012
 * XML source: /home/pradeep/git/hw1-ppravind/hw1-ppravind/src/main/resources/ner/descriptors/NerDescriptor.xml
 * @generated */
public class GeneMention extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(GeneMention.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated  */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected GeneMention() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public GeneMention(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public GeneMention(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public GeneMention(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: GeneName

  /** getter for GeneName - gets A Particular Gene Mention and its name
   * @generated */
  public String getGeneName() {
    if (GeneMention_Type.featOkTst && ((GeneMention_Type)jcasType).casFeat_GeneName == null)
      jcasType.jcas.throwFeatMissing("GeneName", "edu.cmu.ppravind.ner.types.GeneMention");
    return jcasType.ll_cas.ll_getStringValue(addr, ((GeneMention_Type)jcasType).casFeatCode_GeneName);}
    
  /** setter for GeneName - sets A Particular Gene Mention and its name 
   * @generated */
  public void setGeneName(String v) {
    if (GeneMention_Type.featOkTst && ((GeneMention_Type)jcasType).casFeat_GeneName == null)
      jcasType.jcas.throwFeatMissing("GeneName", "edu.cmu.ppravind.ner.types.GeneMention");
    jcasType.ll_cas.ll_setStringValue(addr, ((GeneMention_Type)jcasType).casFeatCode_GeneName, v);}    
   
    
  //*--------------*
  //* Feature: DocumentID

  /** getter for DocumentID - gets 
   * @generated */
  public String getDocumentID() {
    if (GeneMention_Type.featOkTst && ((GeneMention_Type)jcasType).casFeat_DocumentID == null)
      jcasType.jcas.throwFeatMissing("DocumentID", "edu.cmu.ppravind.ner.types.GeneMention");
    return jcasType.ll_cas.ll_getStringValue(addr, ((GeneMention_Type)jcasType).casFeatCode_DocumentID);}
    
  /** setter for DocumentID - sets  
   * @generated */
  public void setDocumentID(String v) {
    if (GeneMention_Type.featOkTst && ((GeneMention_Type)jcasType).casFeat_DocumentID == null)
      jcasType.jcas.throwFeatMissing("DocumentID", "edu.cmu.ppravind.ner.types.GeneMention");
    jcasType.ll_cas.ll_setStringValue(addr, ((GeneMention_Type)jcasType).casFeatCode_DocumentID, v);}    
   
    
  //*--------------*
  //* Feature: subText

  /** getter for subText - gets 
   * @generated */
  public String getSubText() {
    if (GeneMention_Type.featOkTst && ((GeneMention_Type)jcasType).casFeat_subText == null)
      jcasType.jcas.throwFeatMissing("subText", "edu.cmu.ppravind.ner.types.GeneMention");
    return jcasType.ll_cas.ll_getStringValue(addr, ((GeneMention_Type)jcasType).casFeatCode_subText);}
    
  /** setter for subText - sets  
   * @generated */
  public void setSubText(String v) {
    if (GeneMention_Type.featOkTst && ((GeneMention_Type)jcasType).casFeat_subText == null)
      jcasType.jcas.throwFeatMissing("subText", "edu.cmu.ppravind.ner.types.GeneMention");
    jcasType.ll_cas.ll_setStringValue(addr, ((GeneMention_Type)jcasType).casFeatCode_subText, v);}    
   
    
  //*--------------*
  //* Feature: curOff

  /** getter for curOff - gets 
   * @generated */
  public int getCurOff() {
    if (GeneMention_Type.featOkTst && ((GeneMention_Type)jcasType).casFeat_curOff == null)
      jcasType.jcas.throwFeatMissing("curOff", "edu.cmu.ppravind.ner.types.GeneMention");
    return jcasType.ll_cas.ll_getIntValue(addr, ((GeneMention_Type)jcasType).casFeatCode_curOff);}
    
  /** setter for curOff - sets  
   * @generated */
  public void setCurOff(int v) {
    if (GeneMention_Type.featOkTst && ((GeneMention_Type)jcasType).casFeat_curOff == null)
      jcasType.jcas.throwFeatMissing("curOff", "edu.cmu.ppravind.ner.types.GeneMention");
    jcasType.ll_cas.ll_setIntValue(addr, ((GeneMention_Type)jcasType).casFeatCode_curOff, v);}    
  }

    