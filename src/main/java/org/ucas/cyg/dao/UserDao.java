package org.ucas.cyg.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.ucas.cyg.domain.User;

/**
 * @Author: yunguan cheng
 * @Date: 2018/5/28 17:26
 * @Description:
 */

@Mapper
public interface UserDao {

    @Select("select * from user where id = #{id}")
    public User getById(@Param("id") int id);

    @Insert("insert into user(id, name) values(#{id}, #{name})")
    void insert(User user);
}
