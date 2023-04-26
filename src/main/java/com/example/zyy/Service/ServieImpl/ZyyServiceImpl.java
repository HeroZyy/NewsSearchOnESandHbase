package com.example.zyy.Service.ServieImpl;

import com.example.zyy.Service.ZyyService;
import com.example.zyy.zyyModel.pojo.Student;
import com.example.zyy.zyyModel.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZyyServiceImpl implements ZyyService {
    @Autowired
    StudentDao studentDao;
    @Override
    public Student getStudent() {
        return studentDao.selectByPrimaryKey(1);
    }

}
