extentableXMLHandler
====================

extendableXMLHandler is a java package to manipulate XML files. 
You can create different XMLHandlers for different xml files, according to their DOM structure.

## Usage

This package includes `DeveloperXMLHandler` Class to manipulate **developer.xml** file and its methods are written according to the structure of **developer.xml**.

```xml 
<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<team>
	<developer id="1">
		<name>KAAN BURAK SENER</name>
		<age>22</age>
		<location>IZMIR</location>
	</developer>
	<developer id="2">
		<name>ERDI IZGI</name>
		<age>23</age>
		<location>RIZE</location>
	</developer>
	<developer id="3">
		<name>SEFIK YUNUS OZCAN</name>
		<age>23</age>
		<location>IZMIR</location>
	</developer>
</team>
```

Firstly, create an object of `DeveloperXMLHandler` Class by specifying the path of xml file as a parameter

```java 
DeveloperXMLHandler dxh = new DeveloperXMLHandler("src/data/developer.xml");
```

After that, 

you can print the xml file by calling `printXML()` method of `dxh` object

```java 
dxh.printXML();
```

you can get all elements of the xml file by calling `readXML()` method of `dxh` object

```java 
dxh.readXML();
```

you can add a new developer element according to its DOM structure by calling `addElement(String id, String name, String age, String location)` method of `dxh` object

```java 
dxh.addElement("4", "GORKEM SAGDAS", "22", "IZMIR");
dxh.saveXML();
```

you can remove the existed developer element by calling `removeElement(String id)` method of `dxh` object

```java 
dxh.removeElement("4");
dxh.saveXML();
```
If you want to perform multiple add and remove operation, It will be sufficient to call `saveXML` method only once at the end of all these operations

```java 
dxh.addElement("4", "GORKEM SAGDAS", "22", "IZMIR");
dxh.addElement("5", "ALI AKDURAK", "26", "IZMIR");
dxh.removeElement("4");
dxh.saveXML();
```

## Extend

If you want to manipulate different xml files, you can create different XMLHandler Classes which should extends from `AbstractXMLHandler` Class.
