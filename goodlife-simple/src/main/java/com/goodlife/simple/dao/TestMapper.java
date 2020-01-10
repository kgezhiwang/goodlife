package com.goodlife.simple.dao;

import com.goodlife.simple.model.Testa;
import com.goodlife.simple.model.Testb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


/**
 * @Auther: zcx
 * @Date: 2019/10/28 17:28
 * @Description:
 */
public interface TestMapper extends JpaRepository<Testb,String>,JpaSpecificationExecutor<Testb> {

}
