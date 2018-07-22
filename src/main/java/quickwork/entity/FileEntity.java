package quickwork.entity;

import java.util.Date;

public class FileEntity 
{
	private String name;
	private int size;
	private String author;
	private Date creationDate;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	@Override
	public String toString() {
		return "FileEntity [name=" + name + ", size=" + size + ", author=" + author + ", creationDate=" + creationDate
				+ "]";
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
}
