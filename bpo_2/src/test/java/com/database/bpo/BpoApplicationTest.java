package com.database.bpo;

import com.database.bpo.dao.EmployeeDao;
import com.database.bpo.pojo.entity.Employee;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@MapperScan("com.database.bpo.dao")
public class BpoApplicationTest {

    @Autowired
    EmployeeDao employeeDao;

    @Test
    void ViewTest(){
        Employee tmp = employeeDao.SelectById(2);
        System.out.println(tmp.getEmployeeName());
        Employee m = new Employee();
        m.setEmployeeEnterprise("123");
        m.setEmployeeName("132");
        m.setEmployeePhone("123");
        m.setEmployeeRegion("123");
        m.setEmployeeSelfIntroduction("123");
        m.setUserEmployeeId(45);
    }
}
