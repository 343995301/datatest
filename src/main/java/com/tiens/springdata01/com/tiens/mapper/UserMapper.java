package com.tiens.springdata01.com.tiens.mapper;

import com.tiens.springdata01.com.tiens.entity.BaseEntity;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM test1 where id=#{id}")
    BaseEntity findUserByID(@Param("id") int id);
    @Delete("DELETE FROM test1 where id=#{id}")
    String deleteUserById(@Param("id") int id);
    @Update("update test1 set name=#{name},pass=#{pass} where id=#{id}")
    void updateUserById(BaseEntity baseEntity);
//    @Insert()
}
