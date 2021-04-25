package com.wangpu.www;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.event.InputEvent;
import java.util.Calendar;
import java.util.Scanner;

public class AutoMouse {
    int x,y;
    public Robot robot;
    public Clipboard system;
    public AutoMouse() throws AWTException {
        robot = new Robot();
        system = Toolkit.getDefaultToolkit().getSystemClipboard();
    }
    private void leftClick(){
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
    }
    private void rightClick(){
        robot.mousePress(InputEvent.BUTTON3_MASK);
        robot.mouseRelease(InputEvent.BUTTON3_MASK);
    }
    public void PrintMain(){
        System.out.println();
        System.out.println("输入代码选择：");
        System.out.println();
        System.out.println("1.打开将图片转化为网址");
        System.out.println();
        System.out.println("2.开始抢（默认为整时）（记得将鼠标位置放到确定按钮位置）");
        System.out.println();
        System.out.println("3.打开使用说明");
        System.out.println();
        SelectMain();
    }
    public void SelectMain(){
        Scanner rader = new Scanner(System.in);
        int selectNumber = rader.nextInt();
        if(selectNumber == 1){
            exPhoto();
        }else if(selectNumber == 2){
            Go();
        }else if(selectNumber == 3){
            instruction();
        }else {
            System.out.println("输入错误请重新输入");
            PrintMain();
        }
    }
    public void OpenUrl(String ur){
        try {
            //博客网址
            java.net.URI uri = java.net.URI.create(ur);
            // 获取当前系统桌面扩展
            java.awt.Desktop dp = java.awt.Desktop.getDesktop();
            // 判断系统桌面是否支持要执行的功能
            if (dp.isSupported(java.awt.Desktop.Action.BROWSE)) {
                dp.browse(uri);// 获取系统默认浏览器打开链接
            }
        } catch (java.lang.NullPointerException e) {
            // 此为uri为空时抛出异常
            e.printStackTrace();
        } catch (java.io.IOException e) {
            // 此为无法获取系统默认浏览器
            e.printStackTrace();
        }
    }
    public void exPhoto(){
        OpenUrl("https://cli.im/deqr");
        PrintMain();
    }
    public void instruction(){
        OpenUrl("https://wangpu.work/archives/%E6%8A%A2%E5%BF%97%E6%84%BF%E8%80%85%E5%90%8D%E9%A2%9D%E8%BD%AF%E4%BB%B6%E4%BD%BF%E7%94%A8%E6%95%99%E7%A8%8B");
        PrintMain();
    }
    public void Go(){
        System.out.println("开始自动整点点击 请将鼠标移动到确定位置");
        int timeSecond,timeMinute;   //Calendar.HOUR_OF_DAY   MINUTE    SECOND
        int i = 0;
        do{
            i = i + 1;
            Calendar c= Calendar.getInstance();
            timeSecond = c.get(Calendar.SECOND);
            timeMinute = c.get(Calendar.MINUTE);
            if (i%100 == 0) System.out.println("现在时间是" +timeMinute +"分"+timeSecond +"秒，距离点击还有"+(59 - timeMinute)+"分"+(60-timeSecond)+"秒");
        }while (timeSecond != 0 || timeMinute != 0 );
        leftClick();
        System.out.println("点击完成,点击时间为"+timeMinute+"分"+timeSecond+"秒");
        System.out.println();
        System.out.println();
    }
    public static void main(String[] args) throws AWTException {
        AutoMouse si = new AutoMouse();
        si.PrintMain();
    }
}
