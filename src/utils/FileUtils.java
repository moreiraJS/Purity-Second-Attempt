package utils;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

public abstract class FileUtils {
	
	public static List<String> listClass(File srcFolder){
		List<String> result= new ArrayList<String>();
		
		File[] files=srcFolder.listFiles();
		
		for(File file:files) {
			if(file.isDirectory())
				result.addAll(listClass(file,file.getName()));
			else
				if(file.getName().toLowerCase().endsWith(".java"))
					result.add(file.getName().substring(0, file.getName().lastIndexOf(".")));
				
		}
		
		return result;
		
	}
	
	public static List<String> listClass(File srcFolder,String name){
		List<String> result= new ArrayList<String>();
		
		File[] files=srcFolder.listFiles();
		
		
		for(File file:files) {
			if(file.isDirectory())
				result.addAll(listClass(file,name+"."+file.getName()));
			else
				if(file.getName().toLowerCase().endsWith(".java"))
					result.add(name+"."+file.getName().substring(0, file.getName().lastIndexOf(".")));
				
		}
		
		return result;
		
	}
	
	public static File find(File srcFolder,String regex){
		
		File[] files=srcFolder.listFiles();
		File f;
		for(File file:files) {
			if(file.isDirectory()) {
				if((f=find(new File(srcFolder,file.getName()),regex))!=null)
					return f;
			}
			else 
				if(file.getName().matches(regex))
					return file;
				
		}
		
		return null;
		
	}

}