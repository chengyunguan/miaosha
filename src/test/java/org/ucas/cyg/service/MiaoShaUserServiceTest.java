package org.ucas.cyg.service;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.ucas.cyg.ApplicationTests;
import org.ucas.cyg.domain.MiaoShaUser;


/**
 * @Author: yunguan cheng
 * @Date: 2018/6/2 16:27
 * @Description:
 */
public class MiaoShaUserServiceTest extends ApplicationTests {

    @Autowired
    private MiaoShaUserService miaoShaUserService;

    @Test
    @Ignore
    public void getById() {
        MiaoShaUser user = miaoShaUserService.getById(18915522854L);
        System.out.println(user);
    }
}