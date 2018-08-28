package com.bw.fit.system.common.util;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import cn.xsshome.taip.imageclassify.TAipImageClassify;
import cn.xsshome.taip.ocr.TAipOcr;
import cn.xsshome.taip.util.FileUtil;

public class Test {

	public static void main(String[] args) throws Exception {
        // 初始化一个TAipOcr
       TAipOcr aipOcr = new TAipOcr("2107905993","pc5vlDrIqLNmQVup");
       TAipImageClassify aipImageClassify = new TAipImageClassify("2107905993","pc5vlDrIqLNmQVup");
        // 调用接口
        String path = "d:/test/11.png";
        String result = aipOcr.bcOcr(path);
        System.out.println(result);
//        String filePath = path;//本地文件路径
//        byte[] image = FileUtil.readFileByBytes(filePath);//获取文件的byte数据
//        String result = aipImageClassify.visionScener(image, 1, 5);//场景识别
//        System.out.println(result);
//         result = aipImageClassify.visionObjectr(image, 1, 5);//物体识别
//         System.out.println(result);
    }

}
