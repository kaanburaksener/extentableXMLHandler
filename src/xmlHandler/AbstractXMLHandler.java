package xmlHandler;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

public abstract class AbstractXMLHandler {
	protected Document doc;
	protected String path;

	/**
	* This is used to open XML file
	* @param path The location of XML file 
	* @return The document which is parsed from XML file
	*/
	public Document openXML(String path) {
		try {
			this.path = path;
			File xml = new File(path);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.parse(xml);
			doc.getDocumentElement().normalize();
		}
		catch (Exception e) {
		    e.printStackTrace();
		}
		
		return doc;
	}
	
	/**
	* This is used to save the edited content of XML file
	*/
	public void saveXML() {
		try {
			TransformerFactory tFactory = TransformerFactory.newInstance();
			Transformer transformer = tFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(path));
			transformer.transform(source, result);
		}
		catch (Exception e) {
		    e.printStackTrace();
		}
	}
	
	abstract public void addElement(String no, String name, String age, String location);
	abstract public void removeElement(String no);
	abstract public ArrayList<ArrayList<String>> readXML();
	abstract public void printXML();
}
