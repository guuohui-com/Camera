package com.example.camserclient;

import org.bytedeco.javacpp.opencv_core;
import org.bytedeco.javacv.CanvasFrame;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.OpenCVFrameConverter;

import javax.swing.*;

/**
 * @功能职责:
 * @描述：
 * @作者: 郭辉
 * @创建时间: 2020-12-02
 * @copyright Copyright (c) 2020 中国软件与技术服务股份有限公司
 * @company 中国软件与技术服务股份有限公司
 */
public class PullStream {


    /**
     * 播流器
     * @param inputPath  rtmp服务器地址
     * @throws Exception
     * @throws org.bytedeco.javacv.FrameRecorder.Exception
     */
    public void getPullStream(String inputPath) throws Exception, org.bytedeco.javacv.FrameRecorder.Exception {
        //创建+设置采集器
        FFmpegFrameGrabber grabber = FFmpegFrameGrabber.createDefault(inputPath);
        grabber.setOption("rtsp_transport", "tcp");
        grabber.setImageWidth(960);
        grabber.setImageHeight(540);

//        //开启采集器
        grabber.start();

        //直播播放窗口
        CanvasFrame canvasFrame = new CanvasFrame("直播------来自"+inputPath);
        canvasFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        canvasFrame.setAlwaysOnTop(true);
        OpenCVFrameConverter.ToMat converter = new OpenCVFrameConverter.ToMat();

        //播流
        while (true){
            Frame frame = grabber.grabImage();  //拉流
            opencv_core.Mat mat = converter.convertToMat(frame);
            canvasFrame.showImage(frame);   //播放
        }
    }
}
