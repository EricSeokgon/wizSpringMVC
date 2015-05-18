package com.spring_mybatis.dao;

import com.spring_mybatis.dto.ContentDto;

import java.util.ArrayList;

public interface IDao {
	
	public ArrayList<ContentDto> listDao();
	public void writeDao(String mWriter, String mContent);
	public ContentDto viewDao(String strID);
	public void deleteDao(String bId);
	
}
