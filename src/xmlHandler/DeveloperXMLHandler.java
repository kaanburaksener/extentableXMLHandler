package xmlHandler;

import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DeveloperXMLHandler extends AbstractXMLHandler {
	
	private Document doc;
	private NodeList nodeList;
	private Node team;
	
	/** 
	* Constructor of DeveloperXMLHandler Class
	* @param path The location of XML file 
	*/
	public DeveloperXMLHandler(String path) {
		
		doc = super.openXML(path);
		team = doc.getFirstChild();
		nodeList = doc.getElementsByTagName("developer");
	}
	
	
	/**
	* This is used to add a new developer element to XML file
	* @param id Developer's id
	* @param name Developer's name 
	* @param age Developer's age 
	* @param location Developer's location 
	*/
	@Override
	public void addElement(String id, String name, String age, String location) {
		
		try {
			// create a developer element
			Element developer = doc.createElement("developer");
			team.appendChild(developer);
	 
			// set id attribute of developer element
			developer.setAttribute("id", id);
	 
			// name of developer element
			Element name_holder = doc.createElement("name");
			name_holder.appendChild(doc.createTextNode(name));
			developer.appendChild(name_holder);
	 
			// age of developer element
			Element age_holder = doc.createElement("age");
			age_holder.appendChild(doc.createTextNode(age));
			developer.appendChild(age_holder);
			
			// location of developer element
			Element location_holder = doc.createElement("location");
			location_holder.appendChild(doc.createTextNode(location));
			developer.appendChild(location_holder);
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	* This is used to remove existed developer element in XML file
	* @param id Developer's id
	*/
	@Override
	public void removeElement(String id) {
		
		String tempId;
		boolean isExisted = false;
		
		try {	
			for (int i = 0; i < nodeList.getLength() && !isExisted; i++) {
				Node node = nodeList.item(i);
				
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element e = (Element) node;
					tempId = e.getAttribute("id");
					
					if(id.equals(tempId)) {
						isExisted = true;
						team.removeChild(node);
					}
				}
			}
		} 
	    catch (Exception e) {
		    e.printStackTrace();
		}
	}
	
	
	/**
	* This is used to get all developer elements from XML file
	* @return List of Developer Elements
	*/
	@Override
	public ArrayList<ArrayList<String>> readXML() {
		
		ArrayList<ArrayList<String>> elementList = new ArrayList<ArrayList<String>>();
		
		try {
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);
		 
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element e = (Element) node;
					
					ArrayList<String> element = new ArrayList<String>();
					
					element.add(0, e.getAttribute("id"));
					element.add(1, e.getElementsByTagName("name").item(0).getTextContent());
					element.add(2, e.getElementsByTagName("age").item(0).getTextContent());
					element.add(3, e.getElementsByTagName("location").item(0).getTextContent());
					
					elementList.add(element);
				}
			}
	    } 
		catch (Exception e) {
			e.printStackTrace();
	    }
		
		return elementList;
	}
	
	/**
	* This is used to print all developer elements from XML file
	*/
	@Override
	public void printXML() {
		
		try {
			System.out.println(doc.getDocumentElement().getNodeName().toUpperCase());
			System.out.println("-----------------------------");
	 
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);
		 
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element e = (Element) node;
		 
					System.out.println("Developer ID : " + e.getAttribute("id"));
					System.out.println("Full Name : " + e.getElementsByTagName("name").item(0).getTextContent());
					System.out.println("Age : " + e.getElementsByTagName("age").item(0).getTextContent());
					System.out.println("Location : " + e.getElementsByTagName("location").item(0).getTextContent());
					System.out.println();
				}
			}
	    } 
		catch (Exception e) {
			e.printStackTrace();
	    }
	}
}
