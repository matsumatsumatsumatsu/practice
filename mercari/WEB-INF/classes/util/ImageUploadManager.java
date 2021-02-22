package util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

@MultipartConfig(maxFileSize=1040008576)
public class ImageUploadManager {
	private static HttpServletRequest req;

	public static void uploadFile(String imageName) throws IOException,ServletException{
		Part part = req.getPart("itemImage");
		String name = getFileName(part);
		System.out.println("upload method:"+name);
		if(!name.equals("")){
			//指定が正しければAWSでは ../../../images/のはず
			part.write("../../../WebContent/images/" + name);
		}
	}

	private static String getFileName(Part part){
		String name = null;
		for(String dispotion : part.getHeader("Content-Disposition").split(";")){
			if(dispotion.trim().startsWith("filename")){
				name = dispotion.substring(dispotion.indexOf("=") + 1).replace("\"", "").trim();
				name = name.substring(name.lastIndexOf("\\") + 1);
				break;
			}
		}
		System.out.println("getFileName method" + name);
		return name;
	}
}
