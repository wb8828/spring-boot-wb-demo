package com.spring.demo.demo;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

public class HolidayAPIExample {
    public static void main(String[] args) {
//        String countryCode = "CN"; // 国家代码，中国为CN
//        String year = "2023"; // 年份
//        String apiUrl = String.format("https://api.timeanddate.com/io/holidays/%s/%s", countryCode, year);
//
//        try {
//            URL url = new URL(apiUrl);
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//            connection.setRequestMethod("GET");
//            connection.setRequestProperty("Accept", "application/json");
//            connection.connect();
//
//            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//            StringBuilder response = new StringBuilder();
//            String line;
//            while ((line = reader.readLine()) != null) {
//                response.append(line);
//            }
//            reader.close();
//
//            // 处理API返回的JSON数据，这里仅打印节假日信息
//            System.out.println(response.toString());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        String string = "{\"01-01\":{\"holiday\":true,\"name\":\"元旦\",\"wage\":3,\"date\":\"2023-01-01\",\"rest\":1},\"01-02\":{\"holiday\":true,\"name\":\"元旦\",\"wage\":2,\"date\":\"2023-01-02\",\"rest\":1},\"01-21\":{\"holiday\":true,\"name\":\"除夕\",\"wage\":3,\"date\":\"2023-01-21\",\"rest\":2},\"01-22\":{\"holiday\":true,\"name\":\"初一\",\"wage\":3,\"date\":\"2023-01-22\",\"rest\":1},\"01-23\":{\"holiday\":true,\"name\":\"初二\",\"wage\":3,\"date\":\"2023-01-23\",\"rest\":1},\"01-24\":{\"holiday\":true,\"name\":\"初三\",\"wage\":3,\"date\":\"2023-01-24\",\"rest\":1},\"01-25\":{\"holiday\":true,\"name\":\"初四\",\"wage\":2,\"date\":\"2023-01-25\",\"rest\":1},\"01-26\":{\"holiday\":true,\"name\":\"初五\",\"wage\":2,\"date\":\"2023-01-26\",\"rest\":1},\"01-27\":{\"holiday\":true,\"name\":\"初六\",\"wage\":2,\"date\":\"2023-01-27\",\"rest\":1},\"01-28\":{\"holiday\":false,\"name\":\"春节后补班\",\"wage\":1,\"after\":true,\"target\":\"春节\",\"date\":\"2023-01-28\",\"rest\":1},\"01-29\":{\"holiday\":false,\"name\":\"春节后补班\",\"wage\":1,\"after\":true,\"target\":\"春节\",\"date\":\"2023-01-29\",\"rest\":1},\"04-05\":{\"holiday\":true,\"name\":\"清明节\",\"wage\":3,\"date\":\"2023-04-05\",\"rest\":67},\"04-23\":{\"holiday\":false,\"name\":\"劳动节前补班\",\"wage\":1,\"target\":\"劳动节\",\"after\":false,\"date\":\"2023-04-23\",\"rest\":1},\"04-29\":{\"holiday\":true,\"name\":\"劳动节\",\"wage\":2,\"date\":\"2023-04-29\",\"rest\":7},\"04-30\":{\"holiday\":true,\"name\":\"劳动节\",\"wage\":2,\"date\":\"2023-04-30\",\"rest\":1},\"05-01\":{\"holiday\":true,\"name\":\"劳动节\",\"wage\":3,\"date\":\"2023-05-01\",\"rest\":1},\"05-02\":{\"holiday\":true,\"name\":\"劳动节\",\"wage\":3,\"date\":\"2023-05-02\",\"rest\":1},\"05-03\":{\"holiday\":true,\"name\":\"劳动节\",\"wage\":3,\"date\":\"2023-05-03\",\"rest\":1},\"05-06\":{\"holiday\":false,\"name\":\"劳动节后补班\",\"after\":true,\"wage\":1,\"target\":\"劳动节\",\"date\":\"2023-05-06\",\"rest\":2},\"06-22\":{\"holiday\":true,\"name\":\"端午节\",\"wage\":3,\"date\":\"2023-06-22\",\"rest\":2},\"06-23\":{\"holiday\":true,\"name\":\"端午节\",\"wage\":3,\"date\":\"2023-06-23\",\"rest\":1},\"06-24\":{\"holiday\":true,\"name\":\"端午节\",\"wage\":2,\"date\":\"2023-06-24\",\"rest\":1},\"06-25\":{\"holiday\":false,\"name\":\"端午节后补班\",\"wage\":1,\"target\":\"端午节\",\"after\":true,\"date\":\"2023-06-25\",\"rest\":1},\"09-29\":{\"holiday\":true,\"name\":\"中秋节\",\"wage\":3,\"date\":\"2023-09-29\",\"rest\":46},\"09-30\":{\"holiday\":true,\"name\":\"中秋节\",\"wage\":3,\"date\":\"2023-09-30\",\"rest\":1},\"10-01\":{\"holiday\":true,\"name\":\"国庆节\",\"wage\":3,\"date\":\"2023-10-01\",\"rest\":1},\"10-02\":{\"holiday\":true,\"name\":\"国庆节\",\"wage\":3,\"date\":\"2023-10-02\",\"rest\":1},\"10-03\":{\"holiday\":true,\"name\":\"国庆节\",\"wage\":2,\"date\":\"2023-10-03\",\"rest\":1},\"10-04\":{\"holiday\":true,\"name\":\"国庆节\",\"wage\":2,\"date\":\"2023-10-04\",\"rest\":1},\"10-05\":{\"holiday\":true,\"name\":\"国庆节\",\"wage\":2,\"date\":\"2023-10-05\",\"rest\":1},\"10-06\":{\"holiday\":true,\"name\":\"国庆节\",\"wage\":2,\"date\":\"2023-10-06\",\"rest\":1},\"10-07\":{\"holiday\":false,\"after\":true,\"wage\":1,\"name\":\"国庆节后补班\",\"target\":\"国庆节\",\"date\":\"2023-10-07\",\"rest\":1},\"10-08\":{\"holiday\":false,\"after\":true,\"wage\":1,\"name\":\"国庆节后补班\",\"target\":\"国庆节\",\"date\":\"2023-10-08\",\"rest\":1},\"12-31\":{\"holiday\":true,\"name\":\"元旦\",\"wage\":2,\"date\":\"2023-12-31\",\"rest\":85}}\n";

        Map<String,Holiday> map = JSON.parseObject(string, Map.class);

        System.out.println(map);
//
        Map<String, Holiday> holidayMap = new HashMap<>();
        holidayMap.put("222", Holiday.builder().holiday(true).date("2023-01-01").build());
        holidayMap.put("223122", Holiday.builder().holiday(false).date("2023-01-06").build());
        System.out.println(JSON.toJSONString(holidayMap));
    }


}