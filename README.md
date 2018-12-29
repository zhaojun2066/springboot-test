"# springboot-test"

### 项目说明
    async-request ： servlet3 异步支持
    custom-properties： 自定义配置信息
    dynamic-datasource： saas 动态切库
    environment-aware： 读取aplication.properties
    file-upload： 文件上传
    filter： filter config
    get-bean-from-normal-class： 在bean中获取上下文
    global-exception： controller 全局异常拦截
    mvc-unittest： mvc test
    recive-json： 接受json @RequestBody
    redis-session: redis 共享session
    return-json： 返回json
    scheduling： 定时任务
    web-mvc-configurer：  url请求拦截器、异步callable 拦截器、跨域、视图、异步线程池、返回json的配置
    tomcat-config: : 修改内嵌tomcat 一些server 的配置参数，因为application.properties 内不能配置

### 改变包扫面路径
      @ComponentScan(basePackages={"cn.jufeng","org.jufeng"})
### 加载xml
     Spring Boot理念就是零配置编程，但是如果绝对需要使用XML的配置，我们建议您仍旧从一个@Configuration类开始，
     你可以使用@ImportResouce注解加载XML配置文件
     @ImportResource(locations={"classpath:application-bean.xml"})

### spring boot 驱动器
    1）spring-boot-starter
    这是Spring Boot的核心启动器，包含了自动配置、日志和YAML。
    2）spring-boot-starter-actuator
    帮助监控和管理应用。
    3）spring-boot-starter-amqp
    通过spring-rabbit来支持AMQP协议（Advanced Message Queuing Protocol）。
    4）spring-boot-starter-aop
    支持面向方面的编程即AOP，包括spring-aop和AspectJ。
    5）spring-boot-starter-artemis
    通过Apache Artemis支持JMS的API（Java Message Service API）。
    6）spring-boot-starter-batch
    支持Spring Batch，包括HSQLDB数据库。
    7）spring-boot-starter-cache
    支持Spring的Cache抽象。
    8）spring-boot-starter-cloud-connectors
    支持Spring Cloud Connectors，简化了在像Cloud Foundry或Heroku这样的云平台上连接服务。
    9）spring-boot-starter-data-elasticsearch
    支持ElasticSearch搜索和分析引擎，包括spring-data-elasticsearch。
    10）spring-boot-starter-data-gemfire
    支持GemFire分布式数据存储，包括spring-data-gemfire。
    11）spring-boot-starter-data-jpa
    支持JPA（Java Persistence API），包括spring-data-jpa、spring-orm、Hibernate。
    12）spring-boot-starter-data-mongodb
    支持MongoDB数据，包括spring-data-mongodb。
    13）spring-boot-starter-data-rest
    通过spring-data-rest-webmvc，支持通过REST暴露Spring Data数据仓库。
    14）spring-boot-starter-data-solr
    支持Apache Solr搜索平台，包括spring-data-solr。
    15）spring-boot-starter-freemarker
    支持FreeMarker模板引擎。
    16）spring-boot-starter-groovy-templates
    支持Groovy模板引擎。
    17）spring-boot-starter-hateoas
    通过spring-hateoas支持基于HATEOAS的RESTful Web服务。
    18）spring-boot-starter-hornetq
    通过HornetQ支持JMS。
    19）spring-boot-starter-integration
    支持通用的spring-integration模块。
    20）spring-boot-starter-jdbc
    支持JDBC数据库。
    21）spring-boot-starter-jersey
    支持Jersey RESTful Web服务框架。
    22）spring-boot-starter-jta-atomikos
    通过Atomikos支持JTA分布式事务处理。
    23）spring-boot-starter-jta-bitronix
    通过Bitronix支持JTA分布式事务处理。
    24）spring-boot-starter-mail
    支持javax.mail模块。
    25）spring-boot-starter-mobile
    支持spring-mobile。
    26）spring-boot-starter-mustache
    支持Mustache模板引擎。
    27）spring-boot-starter-redis
    支持Redis键值存储数据库，包括spring-redis。
    28）spring-boot-starter-security
    支持spring-security。
    29）spring-boot-starter-social-facebook
    支持spring-social-facebook
    30）spring-boot-starter-social-linkedin
    支持pring-social-linkedin
    31）spring-boot-starter-social-twitter
    支持pring-social-twitter
    32）spring-boot-starter-test
    支持常规的测试依赖，包括JUnit、Hamcrest、Mockito以及spring-test模块。
    33）spring-boot-starter-thymeleaf
    支持Thymeleaf模板引擎，包括与Spring的集成。
    34）spring-boot-starter-velocity
    支持Velocity模板引擎。
    35）spring-boot-starter-web
    支持全栈式Web开发，包括Tomcat和spring-webmvc。
    36）spring-boot-starter-websocket
    支持WebSocket开发。
    37）spring-boot-starter-ws
    支持Spring Web Services。
    Spring Boot应用启动器面向生产环境的还有2种，具体如下：
    1）spring-boot-starter-actuator
    增加了面向产品上线相关的功能，比如测量和监控。
    2）spring-boot-starter-remote-shell
    增加了远程ssh shell的支持。
    最后，Spring Boot应用启动器还有一些替换技术的启动器，具体如下：
    1）spring-boot-starter-jetty
    引入了Jetty HTTP引擎（用于替换Tomcat）。
    2）spring-boot-starter-log4j
    支持Log4J日志框架。
    3）spring-boot-starter-logging
    引入了Spring Boot默认的日志框架Logback。
    4）spring-boot-starter-tomcat
    引入了Spring Boot默认的HTTP引擎Tomcat。
    5）spring-boot-starter-undertow
    引入了Undertow HTTP引擎（用于替换Tomcat）。

### 定时任务CRON表达式    含义
    "*/5 * * * * ? "    每隔5秒执行一次
    "0 */1 * * * ? "   每隔1分钟执行一次
    "0 0 12 * * ?"    每天中午十二点触发
    "0 0 23 * * ?"    每天23点执行一次
    "0 0 1 * * ?"    每天凌晨1点执行一次
    "0 0 1 1 * ?"    每月1号凌晨1点执行一次
    "0 0 23 L * ?"    每月最后一天23点执行一次
    "0 0 1 ? * L"    每周星期天凌晨1点实行一次
    "0 26,29,33 * * * ?"    在26分、29分、33分执行一次
    "0 0 0,13,18,21 * * ?"    每天的0点、13点、18点、21点都执行一次
    "0 15 10 ? * *"    每天早上10：15触发
    "0 15 10 * * ?"    每天早上10：15触发
    "0 15 10 * * ? *"    每天早上10：15触发
    "0 15 10 * * ? 2005"    2005年的每天早上10：15触发
    "0 * 14 * * ?"    每天从下午2点开始到2点59分每分钟一次触发
    "0 0/5 14 * * ?"    每天从下午2点开始到2：55分结束每5分钟一次触发
    "0 0/5 14,18 * * ?"    每天的下午2点至2：55和6点至6点55分两个时间段内每5分钟一次触发
    "0 0-5 14 * * ?"    每天14:00至14:05每分钟一次触发
    "0 10,44 14 ? 3 WED"    三月的每周三的14：10和14：44触发
    "0 15 10 ? * MON-FRI"    每个周一、周二、周三、周四、周五的10：15触发
