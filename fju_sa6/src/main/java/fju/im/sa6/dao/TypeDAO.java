package fju.im.sa6.dao;

import java.util.ArrayList;

import fju.im.sa6.entity.Type;

public interface TypeDAO {
	public Type getType(Type type);

	public void add(Type addType);

	public void set(Type setType);

	public ArrayList<Type> getList(Type Type);
}
