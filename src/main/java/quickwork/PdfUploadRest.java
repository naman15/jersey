package quickwork;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

@Path("/test")
public class PdfUploadRest {
	
	private static final String FOLDER_PATH = "/home/naman/Projects/";
	
	@POST
	@Path("/upload")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public String uploadFile(@Context final HttpServletRequest request,@FormDataParam("file") InputStream is , @FormDataParam("file") FormDataContentDisposition contentDisposition) 
	{
		String fileName = contentDisposition.getFileName();
		OutputStream outpuStream = null;
        String filePath = FOLDER_PATH + fileName;
        try {
            int read = 0;
            byte[] bytes = new byte[1024];
            outpuStream = new FileOutputStream(new File(filePath));
            while ((read = is.read(bytes)) != -1) {
                outpuStream.write(bytes, 0, read);
            }
            outpuStream.flush();
            outpuStream.close();
        } catch(IOException ioEx)
        {
        	ioEx.printStackTrace();
        } finally 
        {
            if(outpuStream != null)
            {
            	try{outpuStream.close();
            	} 
            	catch(Exception ex)
            	{
            		ex.printStackTrace();
            	}
            }
        }
        return "File is  Upload Successfully at Following Path :: "+ filePath;
	}

}
