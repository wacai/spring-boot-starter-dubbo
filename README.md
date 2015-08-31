# 项目介绍

Dubbo项目的SpringBoot自动配置module项目， 会提供一个CommandLineRunner来帮助latch当前dubbo服务端进程的退出。

# 使用说明

在要开发的基于dubbo和springboot的微服务项目的pom.xml中追加如下依赖配置：


~~~~~~~ {.xml}
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>dubbo</artifactId>
            <version>2.5.3</version>
            <exclusions>
                <exclusion>
                    <groupId>org.springframework</groupId>
                    <artifactId>spring</artifactId>
                </exclusion>
            </exclusions>
        </dependency>

        <dependency>
            <groupId>com.wacai</groupId>
            <artifactId>spring-boot-starter-dubbo</artifactId>
            <version>1.0.1</version>
        </dependency>
~~~~~~~

然后， 在SpringBootApplication启动类中加载dubbo相关的spring xml配置即可：


~~~~~~~ {.java}
@SpringBootApplication
public class DubboWithSpringbootApplication {
    /**
     * SpringApplication的构造参数中， 标注了@SpringBootApplication的Main入口类是必须的；
     * 后面的参数一般传入dubbo服务的bean定义所在的配置文件路径，比如"classpath*:/spring/*.xml"
     * 之后，直接运行即可；（当然也可以设置一些参数，比如禁止banner打印等）
     */
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(DubboWithSpringbootApplication.class, "classpath*:/spring/**/*.xml");
        application.run(args);
    }
}
~~~~~~~


就这些~



