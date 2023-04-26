package com.example.zyy.Service;

import java.io.IOException;
import java.util.Map;

public interface HBaseService {
    Map<String,String> getFromHBase(String tableName,String rowKey) throws IOException;
}
