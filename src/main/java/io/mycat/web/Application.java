package io.mycat.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类。启动mycat，启动web服务器
 * Created by jiang on 2016/11/24 0024.
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
//        MycatStartup.startmain(args);
        SpringApplication.run(Application.class, args);

    }
}
