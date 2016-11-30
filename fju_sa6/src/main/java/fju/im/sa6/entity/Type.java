package fju.im.sa6.entity;

public class Type {

	private String typeName;

	private int typeNum;

	public Type(String typeName, int typeNum) {
		this.typeName = typeName;
		this.typeNum = typeNum;
	}

	public Type() {
		this.typeName = null;
		this.typeNum = 0;

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

}
