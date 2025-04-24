package org.yuliu.wordcloud.demos.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.yuliu.wordcloud.demos.web.service.UsePython;

import java.io.*;

@Controller
public class p1 {

    @RequestMapping("/upload_test")
    @ResponseBody
    public String upload_test() {
        return "/img/22.PNG";
    }

    //好这里接受String，，保存到txt，然后调用python生成图片
    @RequestMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam("text") String text) {
        try {
            // 指定相对路径，这里假设在项目根目录下创建一个名为 upload 的文件夹来保存文件
            String relativePath = "python/wordCloud/doc/text1.txt";
            File file = new File(relativePath);
            // 创建文件所在的目录
            file.getParentFile().mkdirs();

            // 使用 FileWriter 将文本写入文件
            try (FileWriter writer = new FileWriter(file)) {
                writer.write(text);
            }

            UsePython usePython = new UsePython();
            usePython.getWordCloudPicture();

            // 这里可以返回图片路径，假设图片路径固定
            return "python/wordCloud/Images/alice.png";
        } catch (IOException e) {
            // 处理文件写入异常
            e.printStackTrace();
            return "Error saving text to file";
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }




    //这个是尝试调用python脚本
    @RequestMapping("/p")
    @ResponseBody
    public String hello() throws IOException {
        //创建进程，执行进程
        ProcessBuilder pb = new ProcessBuilder("python", "python/test.py", "python","--age","20");
        Process process = pb.start();
        //读取进程输出
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream(), "gbk"));
        String line;
        String lines="Python输出:";
        while ((line = reader.readLine()) != null) {
            lines+=line;
            System.out.println("Python输出: " + line);
        }
        return lines;
    }

}
