  cloud:
    nacos:
      discovery:
        server-addr: 192.168.2.101:8848
    gateway:
      routes:
      (恒志的service)
        - id: SalaryService
          uri: http://192.168.2.103:18501
          predicates:
            - Path=/xst/salary/**
       (黄泉的service)
        - id: UserService
          uri: http://192.168.2.101:18502
          predicates:
            - Path=/xst/user/**
