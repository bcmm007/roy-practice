package com.roy.test;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import com.hrjlk.desk.BaseDeskETL;
import com.hrjlk.desk.BaseDeskFile;
import com.hrjlk.desk.DeskETLWork;

public class TestAction {

	public static void main(String[] args) throws IOException {
		int depth = 1;
		String filePath = "/Users/roy/Downloads/resumes";
		LinkedList<String> fileNameList =  find(filePath, depth);
		//get a BaseDeskETL object
        BaseDeskETL bde = new DeskETLWork();
//		for(String nameList:fileNameList) {
//			System.out.println(nameList);
//		}
		for(int i = 0;i < 3;i++) { 
	        //get a file object
	        BaseDeskFile bdf = bde.getDeskFileETLer(filePath + File.separator + fileNameList.get(i));
	        //get file input stream
	        bdf.getFileStreamIn();
	        //get deskInfo
	        String readStr = bdf.readDesk();
	        String clearStr = "";
	        //format str
	        clearStr = bde.curtailStr(readStr);
	        //return str default is ""
	        String retStr = "";
	        retStr = bde.formatStr(clearStr);
	        System.out.println(retStr);
		}
	}
    public static LinkedList<String> find(String pathName,int depth) throws IOException{
    	LinkedList<String> nameList = new LinkedList<String>();
        //获取pathName的File对象  
        File dirFile = new File(pathName);  
        //判断该文件或目录是否存在，不存在时在控制台输出提醒  
        if (!dirFile.exists()) {  
            System.out.println("do not exit");  
            return null;  
        }  
        //判断如果不是一个目录，就判断是不是一个文件，时文件则输出文件路径  
        if (!dirFile.isDirectory()) {  
            if (dirFile.isFile()) {  
                System.out.println(dirFile.getCanonicalFile());  
            }  
            return null;  
        }  
          
//        for (int j = 0; j < depth; j++) {  
//            System.out.print("  ");  
//        }  
//        System.out.print("|--");  
//        System.out.println(dirFile.getName());  
        //获取此目录下的所有文件名与目录名  
        String[] fileList = dirFile.list();  
        int currentDepth=depth+1;  
        for (int i = 0; i < fileList.length; i++) {  
            //遍历文件目录  
            String str = fileList[i];  
            //File("documentName","fileName")是File的另一个构造器  
            File file = new File(dirFile.getPath(),str);  
            String fileName = file.getName();  
            //如果是一个目录，搜索深度depth++，输出目录名后，进行递归  
            if (file.isDirectory()) {  
                //递归  
                find(file.getCanonicalPath(),currentDepth);  
            }else{  
//                //如果是文件，则直接输出文件名  
//                for (int j = 0; j < currentDepth; j++) {  
//                    System.out.print("   ");  
//                }  
//                System.out.print("|--");
            	nameList.add(fileName); 
            }  
        }
        return nameList;
    }  
}
