package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media{
	private List<String> authors = new ArrayList<String>();
	
	//getters and setters
	public List<String> getAuthors() {
		return authors;
	}

	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}

	public Book(String title) {
        this.setTitle(title);
    }
	
	public Book(String title, String category) {
        this.setTitle(title);
        this.setCategory(category);
    }

    public Book(String title, String category, float cost, List<String> authors) {
        this.setTitle(title);
        this.setCategory(category);
        this.setCost(cost);
        this.authors = authors;
    }

    public Book(String title, String category, float cost) {
        this.setTitle(title);
        this.setCategory(category);
        this.setCost(cost);
    }

	//addAuthor
	public void addAuthor(String author) {
		if(author == null || author.trim().isEmpty()) {
			System.out.println("tên tác giả không hợp lệ!");
			return;
		}
		
		if(authors.contains(author)) {
			System.out.println("tác giả " + author + " đã có trong danh sách!");
		}else {
			authors.add(author);
			System.out.println("tác giả " + author + " đã được thêm vào danh sách!");
		}
	}
	
	//removeAuthor
	public void removeAuthor(String author) {
		if(authors.contains(author)) {
			authors.remove(author);
			System.out.println("Đã xóa " + author + " thành công!");
		}else {
			System.out.println("Tác giả " + author + " không tìm thấy để xóa!");
		}
	}
	
}
