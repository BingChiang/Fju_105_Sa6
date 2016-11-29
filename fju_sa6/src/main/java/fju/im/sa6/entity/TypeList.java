package fju.im.sa6.entity;

import java.util.ArrayList;

public class TypeList {

	private static ArrayList<Type> typeList;

	private int typeAmount;
  

	public TypeList() {
		TypeList.typeList = new ArrayList<Type>();
	}

	
	public static ArrayList<Type> getTypeList() {
		return typeList;
	}

	public static void setTypeList(ArrayList<Type> typeList) {
		TypeList.typeList = typeList;
	}

	public int getTypeAmount() {
		this.typeAmount = typeList.size();
		return typeAmount;
	}

	
	

}
