package dom;

import java.io.File;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DomCreateXml {
	public static void main(String[] args) throws Exception {
		//writeXmlByDom2();
		readXml();
	}
	public static void writeXmlByDom() {
		try {  

			DocumentBuilderFactory factory =  DocumentBuilderFactory.newInstance();  
			DocumentBuilder builder = factory.newDocumentBuilder();  

			Document document = builder.newDocument();   
			//��������������ֵ  
			Element root = document.createElement("treelist");  

			//������һ�����ڵ㡢��ֵ  
			Element lan = document.createElement("tree");  
			lan.setAttribute("id", "1");  
			Element treeno = document.createElement("treeno");  
			treeno.setTextContent("1");
			Element uptreeno = document.createElement("uptreeno");  
			uptreeno.setTextContent("0");  
			Element rescriptumno = document.createElement("rescriptumno");  
			rescriptumno.setTextContent("20190817"); 
			Element amt = document.createElement("amt");  
			amt.setTextContent("1"); 
			lan.appendChild(treeno);  
			lan.appendChild(uptreeno); 
			lan.appendChild(rescriptumno);
			lan.appendChild(amt);
			
			
			//������һ�����ڵ㡢��ֵ  
			Element lan2 = document.createElement("tree");  
			lan2.setAttribute("id", "2");  
			Element treeno2 = document.createElement("treeno");  
			treeno2.setTextContent("2");  
			Element uptreeno2 = document.createElement("uptreeno");  
			uptreeno2.setTextContent("1");  
			Element rescriptumno2 = document.createElement("rescriptumno");  
			rescriptumno2.setTextContent("20190817"); 
			Element amt2 = document.createElement("amt");  
			amt2.setTextContent("2"); 
			lan2.appendChild(treeno2);  
			lan2.appendChild(uptreeno2); 
			lan2.appendChild(rescriptumno2);
			lan2.appendChild(amt2);
			
			
			
			Element lan3 = document.createElement("tree");  
			lan3.setAttribute("id", "3");  
			Element treeno3 = document.createElement("treeno");  
			treeno3.setTextContent("3");  
			Element uptreeno3 = document.createElement("uptreeno");  
			uptreeno3.setTextContent("1");  
			Element rescriptumno3 = document.createElement("rescriptumno");  
			rescriptumno3.setTextContent("20190817"); 
			Element amt3 = document.createElement("amt");  
			amt3.setTextContent("3"); 
			lan3.appendChild(treeno3);  
			lan3.appendChild(uptreeno3); 
			lan3.appendChild(rescriptumno3);
			lan3.appendChild(amt3);
			
			Element lan4 = document.createElement("tree");                  
			lan4.setAttribute("id", "4");                                   
			Element treeno4 = document.createElement("treeno");             
			treeno4.setTextContent("4");                                    
			Element uptreeno4 = document.createElement("uptreeno");         
			uptreeno4.setTextContent("1");                                  
			Element rescriptumno4 = document.createElement("rescriptumno"); 
			rescriptumno4.setTextContent("20190817");                       
			Element amt4 = document.createElement("amt");                   
			amt4.setTextContent("4");                                       
			lan4.appendChild(treeno4);                                      
			lan4.appendChild(uptreeno4);                                    
			lan4.appendChild(rescriptumno4);                                
			lan4.appendChild(amt4);                                         

			Element lan5 = document.createElement("tree");
			lan5.setAttribute("id", "5");
			Element treeno5 = document.createElement("treeno");
			treeno5.setTextContent("5");
			Element uptreeno5 = document.createElement("uptreeno");
			uptreeno5.setTextContent("1");
			Element rescriptumno5 = document.createElement("rescriptumno");
			rescriptumno5.setTextContent("20190817");
			Element amt5 = document.createElement("amt");
			amt5.setTextContent("5");
			lan5.appendChild(treeno5);
			lan5.appendChild(uptreeno5);
			lan5.appendChild(rescriptumno5);
			lan5.appendChild(amt5);


			//��ӵ������С�  
			root.appendChild(lan);  
			root.appendChild(lan2);    
			root.appendChild(lan3);    
			root.appendChild(lan4);    
			root.appendChild(lan5);    
			document.appendChild(root);  

			//���������ڴ���ת��ָ��Լ�ִ�д�Դ�������ת����  
			TransformerFactory transformerFactory = TransformerFactory.newInstance();  
			Transformer transformer = transformerFactory.newTransformer();  
			transformer.setOutputProperty("encoding", "UTF-8");  

			StringWriter writer = new StringWriter();  
			transformer.transform(new DOMSource(document), new StreamResult(writer));  
			System.out.println(writer.toString());  

			transformer.transform(new DOMSource(document), new StreamResult(new File("xmlPackage/tree02.xml")));     
		} catch (ParserConfigurationException | TransformerException e) {  
			e.printStackTrace();  
		} 
	}
	
	
	public static void writeXmlByDom2() {
		try {  

			DocumentBuilderFactory factory =  DocumentBuilderFactory.newInstance();  
			DocumentBuilder builder = factory.newDocumentBuilder();  

			Document document = builder.newDocument();   
			//��������������ֵ  
			Element root = document.createElement("treelist");  
			
			for(int i=1;i<=100;i++){
				
				//������һ�����ڵ㡢��ֵ  
				Element lan = document.createElement("tree");  
				lan.setAttribute("id", Integer.toString(i));  
				Element treeno = document.createElement("treeno");  
				treeno.setTextContent(Integer.toString(i));
				Element uptreeno = document.createElement("uptreeno");  
				uptreeno.setTextContent(Integer.toString(i-1));  
				Element rescriptumno = document.createElement("rescriptumno");  
				rescriptumno.setTextContent("20190817"); 
				Element amt = document.createElement("amt");  
				amt.setTextContent(Integer.toString(i)); 
				lan.appendChild(treeno);  
				lan.appendChild(uptreeno); 
				lan.appendChild(rescriptumno);
				lan.appendChild(amt);
				//��ӵ������С�  
				root.appendChild(lan);  
			}		
			
			document.appendChild(root);  

			//���������ڴ���ת��ָ��Լ�ִ�д�Դ�������ת����  
			TransformerFactory transformerFactory = TransformerFactory.newInstance();  
			Transformer transformer = transformerFactory.newTransformer();  
			transformer.setOutputProperty("encoding", "UTF-8");  

			StringWriter writer = new StringWriter();  
			transformer.transform(new DOMSource(document), new StreamResult(writer));  
			System.out.println(writer.toString());  

			transformer.transform(new DOMSource(document), new StreamResult(new File("xmlPackage/domTree04.xml")));     
		} catch (ParserConfigurationException | TransformerException e) {  
			e.printStackTrace();  
		} 
	}
	
	
	public static void  readXml() throws Exception {
		//1.���DOM����������
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		//2.���DOM������
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		//3.��ý�������
		Document document = documentBuilder.parse("xmlPackage/domTree04.xml");
		//4.��ʼ����
		NodeList treeList = document.getChildNodes();		
		for(int i=0;i<treeList.getLength();i++){
			Node tree = treeList.item(i);
			System.out.println(""+tree.getNodeName());
			NodeList treeChilds = tree.getChildNodes();
			for(int k=0;k<treeChilds.getLength();k++){
				Node n = treeChilds.item(k);
				
			}
		}
		
	}
	
	
	
}
