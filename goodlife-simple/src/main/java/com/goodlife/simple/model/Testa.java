package com.goodlife.simple.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Auther: zcx
 * @Date: 2019/10/28 17:29
 * @Description:
 */
@Data
@Entity
@Table(name="test")
public class Testa {
    @Id
    private String id;

    private String name;

    private String age;
}
