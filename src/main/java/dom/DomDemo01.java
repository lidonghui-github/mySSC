package dom;

import java.io.File;
import java.io.StringWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
public class DomDemo01 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		cerateXml();
	}
	
	public static  void  cerateXml() throws Exception{
		//1.创建文档工厂
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		//2.创建文档工人
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		//3.创建文档对象
		Document document = documentBuilder.newDocument();
		//4.创建文档根节点
		Element root = document.createElement("treelist");
		//5.创建内部节点
		Element tree = document.createElement("tree");
		tree.setAttribute("id", Integer.toString(1));
		Element treeNo = document.createElement("treeNo");
		treeNo.setTextContent(Integer.toString(1));
		Element upTreeNo = document.createElement("upTreeNo");
		upTreeNo.setTextContent(Integer.toString(0));
		Element amt = document.createElement("amt");
		amt.setTextContent(Integer.toString(1));
		
		//6.把内部节点的属性添加进去
		tree.appendChild(treeNo);
		tree.appendChild(upTreeNo);
		tree.appendChild(amt);		
		//7.把内部节点添加到根节点里
		root.appendChild(tree);			
		//8.把根节点添加到文档对象里		
		document.appendChild(root);		
		//9.定义转换器工厂		
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		//10.创建转换器
		Transformer transformer = transformerFactory.newTransformer();
		//11.设置输出属性
		transformer.setOutputProperty("encoding", "UTF-8");		
		//12.创造输出流
		StringWriter stringWriter = new StringWriter();
		//13.创造dom源
		DOMSource domSource = new DOMSource(document);
		//14.创建流结果集
		StreamResult streamResult = new StreamResult(stringWriter);
		//15.执行转换方法,以便在控制台打印
		transformer.transform(domSource, streamResult);
		System.out.println(stringWriter);		
		//16.写入文件		
		transformer.transform(domSource,new StreamResult( new File("xmlPackage/DomDemo03.xml")));
	}

}
