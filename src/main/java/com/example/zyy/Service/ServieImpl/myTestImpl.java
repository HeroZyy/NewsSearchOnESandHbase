package com.example.zyy.Service.ServieImpl;

import com.example.zyy.zyyModel.dao.myTestDao;
import com.example.zyy.zyyModel.pojo.myTest;
import com.example.zyy.Service.myTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class myTestImpl implements myTestService {
    @Autowired
    myTestDao testDao;
    @Override
    public myTest SearchTest(String id) {
        return testDao.selectByPrimaryKey("1");
    }
}
