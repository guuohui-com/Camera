package com.example.camserclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class CamserClientApplication {

    public static void main(String[] args) {
//        SpringApplication.run(CamserClientApplication.class, args);
        SpringApplicationBuilder builder = new SpringApplicationBuilder(CamserClientApplication.class);
        builder.headless(false).run(args);
        System.out.println("---------------启动成功---------------");

        //rtmp服务器拉流地址
        String inputPath = "rtmp://127.0.0.1/live/stream";
        PullStream pullStream = new PullStream();
        try {
            pullStream.getPullStream(inputPath);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
