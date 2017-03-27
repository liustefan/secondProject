/**
 * 
 */
package com.bithealth;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.JAXBException;

import org.apache.commons.lang.StringUtils;
import org.docx4j.XmlUtils;
import org.docx4j.convert.in.xhtml.XHTMLImporterImpl;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.exceptions.InvalidFormatException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.NumberingDefinitionsPart;

/**
 * html转wordxml
 * @ClassName: Docx4jUtil 
 * @Description: 
 * @author zj
 * @date 2015年8月26日 下午6:20:53
 */
public class Docx4jUtil {
	
//	/**
//	 * 转wordxml
//	 * @param smr1s
//	 * @return String
//	 * @Description:
//	 * @author zj   
//	 * @date 2015年9月23日 上午9:25:51 
//	 * @version V1.0
//	 */
//	public static String getDocxXmlContent(List<Smr1> smr1s){
//		if(smr1s != null && smr1s.size() > 0){
//			return getDocxXmlContent(smr1s.get(0).getAuditDesc());
//		}else{
//			return "<w:p wsp:rsidR=\"00000000\" wsp:rsidRDefault=\"00A87B76\"><w:pPr><w:rPr><w:rFonts w:hint=\"fareast\"/></w:rPr></w:pPr><w:r wsp:rsidRPr=\"007F0274\"><w:t> </w:t></w:r></w:p>";
//		}
//	}
	
	/**
	 * 转wordxml
	 * @param htmlBody
	 * @return String
	 * @Description:
	 * @author zj   
	 * @date 2015年8月27日 上午10:49:47 
	 * @version V1.0
	 */
	public static String getDocxXmlContent(String htmlBody){
		if(StringUtils.isBlank(htmlBody))
			return "<w:p wsp:rsidR=\"00000000\" wsp:rsidRDefault=\"00A87B76\"><w:pPr><w:rPr><w:rFonts w:hint=\"fareast\"/></w:rPr></w:pPr><w:r wsp:rsidRPr=\"007F0274\"><w:t> </w:t></w:r></w:p>";;
		htmlBody = htmlBody.replace("&nbsp;", "").replace("\n", "").replace("\r", "");
		if(!isHtml(htmlBody))
			return "<w:p wsp:rsidR=\"00000000\" wsp:rsidRDefault=\"00A87B76\"><w:pPr><w:rPr><w:rFonts w:hint=\"fareast\"/></w:rPr></w:pPr><w:r wsp:rsidRPr=\"007F0274\"><w:t>"+htmlBody+"</w:t></w:r></w:p>";
		List<String> imgs = getImgsBASE64(htmlBody);
		htmlBody = replaceImg("<html><body>" + htmlBody + "</body></html>");
		try {
			WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage .createPackage();
			NumberingDefinitionsPart ndp = new NumberingDefinitionsPart();
			wordMLPackage.getMainDocumentPart().addTargetPart(ndp);
			ndp.unmarshalDefaultNumbering();
			
			XHTMLImporterImpl xHTMLImporter = new XHTMLImporterImpl(wordMLPackage);
			xHTMLImporter.setHyperlinkStyle("Hyperlink");

			wordMLPackage.getMainDocumentPart().getContent()
			        .addAll(xHTMLImporter.convert(htmlBody, null));
			
			htmlBody =  XmlUtils.marshaltoString(wordMLPackage
			        .getMainDocumentPart().getContents(), true, true);
//			for(int i=0; i < imgs.size(); i++){
//			List<Integer> indexs = getIndexAll(htmlBody, "{{}}");
			for(int i = 0; i< imgs.size(); i++){
				int index = htmlBody.indexOf("{{}}");
				htmlBody = htmlBody.substring(0, index)+imgs.get(i)+htmlBody.substring(index+4);
			}
//			}
			System.out.println(htmlBody);
			return htmlBody.substring(htmlBody.indexOf("<w:body>")+8, htmlBody.indexOf("<w:sectPr>"));
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Docx4JException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	/**
	 * 
	 * @param htmlBody
	 * @return boolean
	 * @Description:
	 * @author zj   
	 * @date 2015年8月27日 上午11:00:23 
	 * @version V1.0
	 */
	public static boolean isHtml(String htmlBody){
		
		return Pattern.compile("<([a-z]+)([^<]+)*(?:>(.*)<\\/\\1>|\\s+\\/>)").matcher(htmlBody).find();
	}
	
	public static String replaceImg(String html){
		
		return html.replaceAll("<img[^>]*/>", "{{}}");
	}
	
	public static String getBASE64(String urlpath) {
		ByteArrayOutputStream outSteam = new ByteArrayOutputStream();  
		    byte[] buffer = new byte[1024]; 
		    int len = -1; 
		    URLConnection conn = null;    
		    InputStream in = null;
		try {
			URL url = new URL(urlpath);
			conn = url.openConnection();
			conn.connect();
			in = conn.getInputStream();
			while ((len = in.read(buffer)) != -1) {  
		        outSteam.write(buffer, 0, len);  
		    }  
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(in != null)
					in.close(); 
				if(outSteam != null)
					outSteam.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return new sun.misc.BASE64Encoder().encode(outSteam.toByteArray());
	}

    public static List<String> getImgsBASE64(String htmlStr){   
        String img="";   
        Pattern p_image;   
        Matcher m_image;   
        List<String> imgs = new ArrayList<String>();
        String regEx_img = "<img[^>]*/>";
        p_image = Pattern.compile(regEx_img,Pattern.CASE_INSENSITIVE);   
        m_image = p_image.matcher(htmlStr); 
        while(m_image.find()){   
            img = m_image.group();   
            Matcher m  = Pattern.compile("src\\s*=\\s*\"?(.*?)(\"|>|\\s+)").matcher(img);
            if(m.find()){
            	imgs.add(getWordXmlPict(getBASE64(m.group(1)), imgs.size()));
            }
        }
        return imgs;
    }  
    
	/**
	 * wordxml图片标签
	 * @param base64
	 * @param i
	 * @return String
	 * @Description:
	 * @author zj   
	 * @date 2015年9月22日 下午2:42:45 
	 * @version V1.0
	 */
	public static String getWordXmlPict(String base64, int i){
		StringBuffer content = new StringBuffer();
		content.append("<w:pict><v:shapetype id=\"_x0000_t75\" coordsize=\"21600,21600\" o:spt=\"75\" o:preferrelative=\"t\" path=\"m@4@5l@4@11@9@11@9@5xe\" filled=\"f\" stroked=\"f\"><v:stroke joinstyle=\"miter\"/><v:formulas><v:f eqn=\"if lineDrawn pixelLineWidth 0\"/><v:f eqn=\"sum @0 1 0\"/><v:f eqn=\"sum 0 0 @1\"/><v:f eqn=\"prod @2 1 2\"/><v:f eqn=\"prod @3 21600 pixelWidth\"/><v:f eqn=\"prod @3 21600 pixelHeight\"/><v:f eqn=\"sum @0 0 1\"/><v:f eqn=\"prod @6 1 2\"/><v:f eqn=\"prod @7 21600 pixelWidth\"/><v:f eqn=\"sum @8 21600 0\"/><v:f eqn=\"prod @7 21600 pixelHeight\"/><v:f eqn=\"sum @10 21600 0\"/></v:formulas><v:path o:extrusionok=\"f\" gradientshapeok=\"t\" o:connecttype=\"rect\"/><o:lock v:ext=\"edit\" aspectratio=\"t\"/></v:shapetype>");
		content.append("<w:binData w:name=\"wordml://03000201--"+i+".png\" xml:space=\"preserve\">").append(base64).append("</w:binData>");
		content.append("<v:shape id=\"_x0000_i1025\" type=\"#_x0000_t75\"><v:imagedata src=\"wordml://03000201--"+i+".png\" o:title=\"1440052601495536\"/></v:shape></w:pict>");
		return content.toString();
	}
	
	public static void main(String[] args) {
//		String html = "adf<a>aa</a>sdf";
//		System.out.println(isHtml(html));
		
//		System.out.println(getDocxXmlContent(html));
		
		
//		getDocxXmlContent(html);
		
		
//		System.out.println(replaceImg(html));
//		 String regEx_img = "<img.*src=(.*?)[^>]*?>"; 
		
//		 String s = "&lt;IMG height=55 src=\"http://www.gobygo.com/TheGoByGo/images/book-channel.gif\" width=210 border=0 /&gt;";
//	   Pattern p1 = Pattern.compile("<img[^>]*/>");
//	   Matcher m = p1.matcher(html);
//	   while (m.find()) {
//	    String str = m.group();
//	    Pattern p = Pattern.compile("src=\"[\\w\\s\\d\\p{Punct}]*\"");
//	    Matcher m1 = p.matcher(html);
//	    while (m1.find()) {
//	     String str1 = m1.group();
//	     str = str1.substring(5, str1.length() - 1);
//	     System.out.println(str);
//	    }
//	   }
//		URL url = new URL("http://e.hiphotos.baidu.com/image/pic/item/7aec54e736d12f2e6d6537ec4dc2d562843568de.jpg");
//		URLConnection conn = url.openConnection();
		String html = "<a>aa</a><a>aa</a><img src=\"http://h.hiphotos.baidu.com/image/w%3D310/sign=b60048c9d52a60595210e71b1834342d/2fdda3cc7cd98d10e6e6a831233fb80e7bec9084.jpg\" border='0' alt='' />";
//		getDocxXmlContent(html);
		System.out.println(replaceImg(html));
//		for(Iterator<String> it = urls.iterator(); it.hasNext();){
//			String s = new sun.misc.BASE64Encoder().encode(getByte(it.next()));
//			System.out.println(s);
//		}
		
//		test();
	}
	
	public static void test(){
		String str="sssbbssssccsssss";

		str=str.replaceAll("(sss)(.*?)(\\1)(.*?)", "$1$2hello$4");

		System.out.println(str);
	}
	
}
