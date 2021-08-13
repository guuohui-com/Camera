package com.example.camerserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.util.Stack;

@SpringBootApplication
public class CamerServerApplication {

    public static void main(String[] args) {
//        SpringApplication.run(CamerServerApplication.class, args);
        SpringApplicationBuilder builder = new SpringApplicationBuilder(CamerServerApplication.class);
        builder.headless(false).run(args);
        System.out.println("---------------启动成功---------------");

        /**
         * 采用远程监控没专用摄像头作为视频源
         * */
        // 运行，设置视频源和推流地址
        /*try {
            new ConvertVideoPakcet()
                    .rtsp("rtsp://admin:a1234567@192.168.0.121:554/h264/ch1/main/av_stream") // ip 厂家提供的的摄像头地址
                    .rtmp("rtmp://127.0.0.1:1935/live/stream")
                    .start();
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        /**
         * 采用备抵摄像头当做视频源
         * */
        //设置rtmp服务器推流地址
        String outputPath = "rtmp://127.0.0.1:1935/live/stream";
        RecordPush recordPush = new RecordPush();
        try {
            recordPush.getRecordPush(outputPath, 25);
//            recordPush.getRecordPush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
