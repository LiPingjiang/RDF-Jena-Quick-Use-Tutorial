package org.ModelAndRDF;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.StmtIterator;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ModelStructureExample();
    }
    
    public static Model ImportRDFtoModel(){
    	Model mod = ModelFactory.createDefaultModel() ;
    	mod.read("C:\\Users\\pli\\Desktop\\obs_data_individuals_rdf\\incident_15000.rdf") ;
    	
    	return mod;
    }
    
    public static void ModelStructureExample(){
    	
    	System.out.println("***********************************************************");
    	System.out.println("This model shows the Model structure in Jena");
    	//A model is a basic type in Jena, consist of statements. So we could get all statements using listStatements()
    	//A statement consists of a subject, a predication and a object.
    	//In Jena, the subject and predication are Property class. The object is RDFNode class.
    	//for example, a statement: Tom has StudentID 0531. Tom is subject, "has StudentID" is prediction, "0531" is the object.
    	
    	Model model = ImportRDFtoModel();
    	
    	StmtIterator  stas = model.listStatements();
    	while(stas.hasNext()){
    		
    		Statement sta = stas.next();
    		
    		System.out.println(sta.getSubject().toString());
    		System.out.println(sta.getPredicate().toString());
    		System.out.println(sta.getObject().toString());
    		
    		/*if( sta.getObject().isLiteral() ){
    			if( sta.getPredicate().getURI().toString().equals( "http://localhost/SensorSchema/ontology#hasID" ) ){
    				System.out.println("-------------------------------------------------------------");
        			System.out.println("CarID : " + sta.getString());
    			}
    			
    		}*/
    		
    	}
    	
    }
}
