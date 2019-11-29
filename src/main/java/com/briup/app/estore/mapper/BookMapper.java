package com.briup.app.estore.mapper;

import com.briup.app.estore.bean.Book;
import java.util.List;

import org.apache.ibatis.scripting.xmltags.ForEachSqlNode;

public interface BookMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Book record);

    Book selectByPrimaryKey(Integer id);

    List<Book> selectAll();
   

    int updateByPrimaryKey(Book record);
}