package org.ucas.cyg.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.ucas.cyg.domain.MiaoShaUser;

/**
 * @Author: yunguan cheng
 * @Date: 2018/6/2 15:51
 * @Description:
 */

@Mapper
public interface MiaoShaUserDao {

    @Select("select * from miaosha_user where id = #{id}")
    public MiaoShaUser getById(@Param("id") long id);
}
