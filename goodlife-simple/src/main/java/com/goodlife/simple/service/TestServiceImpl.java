package com.goodlife.simple.service;

import com.goodlife.simple.dao.TestMapper;
import com.goodlife.simple.model.Testa;
import com.goodlife.simple.model.Testb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: zcx
 * @Date: 2019/10/28 17:27
 * @Description:
 */

@Service("testServiceImpl")
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;
    @Override
    public void adfa(Testb test) {
        System.out.println("aaaaaaaaaaaaaaaaaaaaaa");
        testMapper.save(test);

        test2(1,3);

    }


    public int test2(int a,int b) {
        return  a+b;

    }


}
