package com.folder.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.StatementType;

@Mapper
public interface Temp1Mapper {

	@Select({"<script>"
			+ "SELECT * FROM temp1 "
			+ "<if test='accept == 1'>WHERE accept = 1</if> "
			+ "<if test='accept == 0'>WHERE accept = 0</if> "
			+ "</script>"})
	public List<Map<String, Object>> findList(String accept);
	
	@Select("SELECT * FROM temp1 WHERE no = #{no}")
	public Map<String, Object> findOne(int no);
	
	@Update("UPDATE temp1 SET title = #{title}, content = #{content} WHERE no = #{no}")
	public int edit(Map<String, Object> map);
	
	@Update("UPDATE temp1 SET accept = #{accept} WHERE no = #{no}")
	public int accept(Map<String, Object> map);
	
	@SelectKey(statementType = StatementType.PREPARED, statement = "select last_insert_id() as no", keyProperty = "no", before = false, resultType = int.class)
	@Insert("INSERT INTO temp1 (title, content) VALUE (#{title}, #{content})")
	public int save(Map<String, Object> map);
	
}
