package fju.im.sa6.entity;

public class Type {

	private String typeName;

	private int typeNum;
	
	private int availabletype;

	public Type(String typeName, int typeNum, int availabletype) {
		this.typeName = typeName;
		this.typeNum = typeNum;
		this.availabletype = availabletype;
	}

	

	public Type() {
		this.typeName = null;
		this.typeNum = 0;
		this.availabletype = 0;

	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public int getTypeNum() {
		return typeNum;
	}
public int getAvailabletype() {
		return availabletype;
	}

	public void setAvailabletype(int availabletype) {
		this.availabletype = availabletype;
	}
}
