import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;
import java.util.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class Main {
	
	
	    public static void main( String args[] ){
	    
	      // 按指定模式在字符串查找
	    	Scanner scan = new Scanner(System.in);
	    	String line = scan.nextLine();
	    	
	    	char all[] = line.toCharArray();
	    	int i;
	    	int j;
	    	//提取电话
	    	Pattern p = Pattern.compile("[0-9\\.]{11}" );
	    	Matcher m = p.matcher(line);
	    	System.out.println("{");
	    	//打印名字
	    	char test = ',';
	    	for(i=0;i< all.length;i++)
	    	{
	    		if( all[i]==test )break;
	    	}
	    	System.out.println("\"姓名\":\"" + line.substring(0,i) + "\",");
	    	//打印电话
	    	while(m.find()){

	    		//System.out.println(line.replaceAll(m.group(),""));
	    		   System.out.println("\"手机\":\"" + m.group()+",");  
	    	}
	    	//提取纯地址字符串
	    	String c = m.replaceAll("");
	    	String d = c.substring(i+1);
	    	//System.out.println(d);
	    	//地址划分
	    	
	           
	    	String regex="((?<province>[^省]+省|.+自治区)|上海|北京|天津|重庆)?(?<city>[^市]+市|.+自治州)(?<county>[^县]+县|.+区|.+镇|.+局)?(?<town>[^区]+区|.+镇|.+街|.+道|.+乡|.+路)?(?<village>.*)";
	        Matcher n=Pattern.compile(regex).matcher(d);
	        System.out.println("\"" + "地址" + "\"" + ":" + "[");
	        while(n.find()){
	        	//System.out.println(n.group(1));
	        	System.out.println("\""+n.group(2)+"\""+",");
	        	System.out.println("\""+n.group(3)+"\""+",");
	        	System.out.println("\""+n.group(4)+"\""+",");
	        	System.out.println("\""+n.group(5)+"\""+",");
	        	System.out.println("\""+n.group(6)+"\"");
	        }
	        System.out.println("]");
	        System.out.println("}");
	   }
	
	
}
