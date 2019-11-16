package dom4j;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class Dom4JCreateXml {
	public static void main(String[] args) {
		writeXmlByDom4J();
		
//		readXmlByDom4J();

	}
	public static void writeXmlByDom4J() {
		try {
			// �����ĵ��������ĵ��ĸ�Ԫ�ؽڵ�   
			Element root = DocumentHelper.createElement("peoples");  
			Document document = DocumentHelper.createDocument(root);  
			//���ڵ�  
			root.addAttribute("name","peoplesvalue");  
			//�ӽڵ�  
			Element element1 = root.addElement("people");  
			element1.addAttribute( "id", "1" );
			element1.addElement("name", "С��"); 
			element1.addElement("age","22");
			
			Element element2 = root.addElement("people");  
			element2.addAttribute( "id", "2" );
			element2.addElement("name", "����"); 
			element2.addElement("age","23");
			//���  
			XMLWriter xmlwriter2 = new XMLWriter();  
			xmlwriter2.write(document);  
			//�����ļ�  
			OutputFormat format = new OutputFormat();  

			format = OutputFormat.createPrettyPrint();
			//�趨����
			format.setEncoding("UTF-8");
			XMLWriter xmlwriter = new XMLWriter(new FileOutputStream("d:/dom4jpeople2.xml"), format);
			xmlwriter.write(document);
			xmlwriter.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}  
	} 
}
