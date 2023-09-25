# demo-logback

> 此 demo 主要演示了如何使用 logback 记录程序运行过程中的日志，以及如何配置 logback，可以同时生成控制台日志和文件日志记录，文件日志以日期和大小进行拆分生成。

## 配置文件中可以设置各个目录日志输出级别

~~~ xml
logging:
  level:
    com.spring.demo: debug
    ch.qos.logback: off
~~~