package org.yuliu.wordcloud.demos.web.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


//这里保存调用python程序的方法
public class UsePython {
    public void getWordCloudPicture() throws IOException, InterruptedException {
        //创建进程，执行进程
        String pythonPath = "D:\\anaconda3\\envs\\NLPP\\python.exe";
        ProcessBuilder pb = new ProcessBuilder(pythonPath, "E:\\javaweb\\wordCloud\\python\\wordCloud\\demo.py");
        Process process = pb.start();
        StringBuilder output = new StringBuilder();
        StringBuilder error = new StringBuilder();
        // 读取进程的标准输出
        BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream(), "gbk"));
        String s;
        while ((s = stdInput.readLine()) != null) {
            output.append(s).append("\n");
        }

        // 读取进程的错误输出
        BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream(), "gbk"));
        while ((s = stdError.readLine()) != null) {
            error.append(s).append("\n");
        }

        // 等待进程执行完毕
        int exitCode = process.waitFor();
        if (exitCode == 0) {
            System.out.println("Python 程序执行完毕，标准输出：\n" + output.toString());
        } else {
            System.err.println("Python 程序执行出错，错误信息：\n" + error.toString());
        }
        /*//读取进程输出
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream(), "gbk"));
        String line;
        String lines="Python输出:";
        while ((line = reader.readLine()) != null) {
            lines+=line;
            System.out.println("Python输出: " + line);
        }
        return lines;*/

    }
}
