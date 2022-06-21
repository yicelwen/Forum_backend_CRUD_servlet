package tw.com.westeros.categories.model.bean;

import java.io.Serializable;

public class Categories implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int catId;
	private String catName;
	private String catDescript;
	
	public Categories() {}
	
	public Categories(int catId, String catName, String catDescript) {
		super();
		this.catId = catId;
		this.catName = catName;
		this.catDescript = catDescript;
	}

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public String getCatName() {
		return catName;
	}

	public void setCatName(String catName) {
		this.catName = catName;
	}

	public String getCatDescript() {
		return catDescript;
	}

	public void setCatDescript(String catDescript) {
		this.catDescript = catDescript;
	}

	
}
