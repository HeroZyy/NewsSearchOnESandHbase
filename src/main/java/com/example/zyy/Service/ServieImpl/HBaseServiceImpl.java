package com.example.zyy.Service.ServieImpl;

import com.example.zyy.Service.HBaseService;
import com.example.zyy.utils.HBaseUtil;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

@Service
public class HBaseServiceImpl implements HBaseService {
    @Override
    public Map<String, String> getFromHBase(String tableName, String rowKey) throws IOException {
        //根据Rowky返回读取到的HBase数据
        Map<String, String> map = HBaseUtil.getFromHBase(tableName, rowKey);
        return map;
    }
}
