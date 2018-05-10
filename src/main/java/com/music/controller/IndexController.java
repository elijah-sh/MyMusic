package com.music.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller  
@RequestMapping("/music") 
public class IndexController {
 
    @RequestMapping("/") 
	public String Index()throws Exception{
		System.out.println("启动成功");
		return "home/index";
	}
    @RequestMapping("/select") 
 	public String Test(ModelMap map)throws Exception{
			File File = new File("D:/foot.html");  
	        Document doc = Jsoup.parse(File,"UTF-8"  );  
    	  map.addAttribute("headerContent", doc);
  		map.addAttribute("sideBarContent", doc.select("title").toString());    
  			System.out.println(doc.body());
    //  map.addAttribute("Content", doc.select("#ul").first().toString());
      
 		return "home/center";
 	}
     
    @RequestMapping("/index")
    public String backgroud(ModelMap map  ) throws Exception{
    	File directory = new File("");//参数为空 
    	String courseFile = directory.getCanonicalPath() ; 
    	System.out.println(courseFile); 
    	
    	//String fileUrl = courseFile+"\\target\\classes\\static\\";
    	String tt=Thread.currentThread().getContextClassLoader().getResource("").getPath(); 
    	String path=tt.substring(1,tt.length()).replace('/', '\\');
    	//  D:\MyDocuments\Java%20EE\Workspaces\Music\target\classes\classes\static\view\home\foot.html
    	//		 D:\MyDocuments\Java%20EE\Workspaces\Music\target\classes\view\home\foot.html
    	// 物理知道   D:\MyDocuments\Java EE\Workspaces\Music\target\classes\view\home\foot.html
    	System.out.println("path: "+path);
    	
    	String fileUrl = path+"view\\home\\";
    	fileUrl = fileUrl + "foot.html"; 
    	System.out.println(fileUrl);
     	 File File = new File(fileUrl );  
    	  Document doc = Jsoup.parse(File,"UTF-8" );  
    	 map.addAttribute("foot", doc); 
    	
    	return "home/index";
    }
    
    public void getNavigation(Integer naviType,ModelMap map){   
    	String fileUrl = null;   
    	switch(naviType){     
	    	case 1:       //admin navigatioin      
	    		fileUrl = fileUrl + "header_admin.html";  
	    		break;        
	    	case 2:  //user navigation          
    			fileUrl = fileUrl + "header_trader.html";   
    			break;         
	    	default:          
				fileUrl = fileUrl + "header_trader.html";  
    		 break;  
    	}try {
			
    		InputStream input = this.getClass().getResourceAsStream(fileUrl);  
    		Document doc = Jsoup.parse(input,"UTF-8","http://www.mychuangao.com/");  
    		map.addAttribute("headerContent", doc.select("header").toString());    
    		map.addAttribute("sideBarContent", doc.select("#admin-offcanvas").first().toString());            map.addAttribute("footerContent", changeAttrAddress(doc.select("footer"),"script","src"));            map.addAttribute("headContent", changeAttrAddress(doc.select("head"),"link","href"));  
    	} catch (Exception e){    
    			map.addAttribute("headContent", "");     
    			map.addAttribute("headerContent", "");     
    			map.addAttribute("sideBarContent", "");    
    			map.addAttribute("footerContent", "");    
    			}  
    		
    }    
    
		private String changeAttrAddress(Elements parentNode,String dealingNodeName,String attrName){   
				Elements elements = parentNode.select(dealingNodeName);   
				for(Element elment : elements){       
					String orignalAddress = elment.attr(attrName);    
					if(orignalAddress.isEmpty()){      
						continue;      
					}         
			orignalAddress = delInnerPath(orignalAddress);        
			elment.attr(attrName,orignalAddress);     
			
				}     
				return parentNode.toString();  
				
		} 
		
		private String delInnerPath(String address){   
			String keyWord = "static";     
			if(address.contains(keyWord)==false){   
				return address;      
				}      
			int position = address.indexOf(keyWord) + keyWord.length() + 1;    
			return address.substring(position); 
			
		}
    	
    
   
}