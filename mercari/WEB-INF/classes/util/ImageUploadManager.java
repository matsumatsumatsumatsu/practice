package util;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import context.RequestContext;

public class ImageUploadManager {
	Map fields = new HashMap();
	public Map upload(RequestContext reqc){
		HttpServletRequest req = (HttpServletRequest)reqc.getRequest();
		try {
			req.setCharacterEncoding("");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}

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
	              filename = UUID.randomUUID().toString()+".jpg";
	              item.write(new File("C:\\Users\\koyama\\git\\practice\\mercari\\WebContent\\images\\" + filename));
	              fields.put("itemImage",filename);
	            }
	          }else if (item.isFormField()) {
	        	  this.setFormField(item);
	          }
	        }
	      }catch (FileUploadException e) {
	        e.printStackTrace();
	      }catch (Exception e) {
	        e.printStackTrace();
	      }
	    return fields;
	}
	public void setFormField(FileItem item) throws ServletException {
		try {
			String name = item.getFieldName();
			String field = item.getString("UTF8");

			fields.put(name,field);
			System.out.println("ImageUploadManager:name="+name+",field="+field);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	public Map getFields() {
		return fields;
	}
}
