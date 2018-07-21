package quickwork.restService;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

@Path("/test")
public class PdfUploadRest {
	
	private static final String FOLDER_PATH = "/home/naman/Projects/";
	
	@POST
	@Path("/upload")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public String uploadFile(@FormDataParam("file") InputStream inputStream , @FormDataParam("file") FormDataContentDisposition contentDisposition) 
	{
		String fileName = contentDisposition.getFileName();
        String filePath = FOLDER_PATH + fileName;
        if(!fileName.endsWith(".pdf")) 
        {
        	return "Only PDF files Supported";
        }
        try 
        {
            saveFile(inputStream, filePath);
        } 
        catch(Exception ioEx)
        {
        	ioEx.printStackTrace();
        	return ioEx.getMessage();
        } 
        return "File is  Upload Successfully at Following Path :: "+ filePath;
	}

	private void saveFile(InputStream is, String filePath) throws Exception 
	{
		ByteArrayOutputStream outpuStream = new ByteArrayOutputStream();
		int read = 0;
		byte[] bytes = new byte[1024];
		OutputStream fileStream = new FileOutputStream(filePath);
		try 
		{
			while ((read = is.read(bytes)) != -1) 
			{
			    outpuStream.write(bytes, 0, read);
			    if(outpuStream.size() > 2*1024*1024) 
				{
					throw new Exception("File Size Should be less than 2MB");
				}
			}
			outpuStream.writeTo(fileStream);
			fileStream.flush();
			fileStream.close();
			outpuStream.close();
		}
		catch(IOException ex) 
		{
			throw new Exception(ex.getMessage());
		}
		finally
		{
			if(outpuStream != null)
            {
            	try
            	{
            		outpuStream.close();
            	} 
            	catch(IOException ex)
            	{
            		throw new Exception(ex.getMessage());
            	}
            }
			if(fileStream != null)
            {
            	try
            	{
            		fileStream.close();
            	} 
            	catch(IOException ex)
            	{
            		throw new Exception(ex.getMessage());
            	}
            }
		}
	}

}
