package util;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import context.RequestContext;

public class ImageUploadManager {
	public static void upload(RequestContext reqc){
		HttpServletRequest req = (HttpServletRequest)reqc.getRequest();

		String path = req.getServletContext().getRealPath("data");
		System.out.println("ImageUploadManager:path="+path);

		DiskFileItemFactory factory = new DiskFileItemFactory();
	    ServletFileUpload sfu = new ServletFileUpload(factory);

	    try {
	        List list = sfu.parseRequest(req);
	        Iterator iterator = list.iterator();

	        while(iterator.hasNext()){
	          FileItem item = (FileItem)iterator.next();

	          if (!item.isFormField()){
	            String filename = item.getName();

	            if ((filename != null) && (!filename.equals(""))){
	              filename = (new File(filename)).getName();
	              item.write(new File("C:\\Users\\koyama\\git\\practice\\mercari\\WebContent\\images\\" + filename));
	            }
	          }
	        }
	      }catch (FileUploadException e) {
	        e.printStackTrace();
	      }catch (Exception e) {
	        e.printStackTrace();
	      }

	}
}
