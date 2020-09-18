package com.example.jsondowntest2.demo.util;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class VerifyUtil {
    // 验证码字符集
//    private static final char[] CHARS = {
//            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
//            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
//            'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
//            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
//            'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    private static final String[] CHARS = {
            "长恨歌", "月下独酌", "琵琶行", "关山月", "燕歌行", "游子吟", "李白", "杜甫", "李商隐", "王维",
            "白居易", "孟浩然", "乌衣巷", "赤壁", "九月九日", "忆山东", "兄弟", "相思", "春晓", "咏鹅",
            "江南", "敕勒歌", "汉乐府", "劝学", "满江红", "怒发冲冠", "金缕衣", "偶成", "长歌行", "学而不厌",
            "将进酒", "游山西村", "相思", "静夜思", "草", "凉州词", "登岳阳楼", "乌衣巷", "咏柳", "黄鹤楼",
            "清明", "古浪月行", "静夜思", "小儿垂钓", "赠汪伦", "使至塞上", "浪淘沙", "无题", "出塞", "王昌龄"};

    // 字符数量
//    private static final int SIZE = 4;
    private static final int SIZE = 1;
    // 干扰线数量
    private static final int LINES = 3;
    // 宽度
//    private static final int WIDTH = 80;
    private static final int WIDTH = 100;
    // 高度
//    private static final int HEIGHT = 35;
    private static final int HEIGHT = 40;
    // 字体大小
//    private static final int FONT_SIZE = 25;
    private static final int FONT_SIZE = 23;

    /**
     * 生成随机验证码及图片
     */
    public static Map<String, Object> createImageCode() {
        StringBuffer sb = new StringBuffer();
        // 1.创建空白图片
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        // 2.获取图片画笔
        Graphics graphic = image.getGraphics();
        // 3.设置画笔颜色
        graphic.setColor(Color.LIGHT_GRAY);
        // 4.绘制矩形背景
        graphic.fillRect(0, 0, WIDTH, HEIGHT);
        // 5.画随机字符
        Random ran = new Random();
        for (int i = 0; i < SIZE; i++) {
            // 取随机字符索引
            int n = ran.nextInt(CHARS.length);
            // 设置随机颜色
            graphic.setColor(getRandomColor());
            // 设置字体大小
            graphic.setFont(new Font(null, Font.BOLD + Font.ITALIC, FONT_SIZE));
            // 画字符
            graphic.drawString(CHARS[n] + "", i * WIDTH / SIZE, HEIGHT * 2 / 3);
            // 记录字符
            sb.append(CHARS[n]);
        }
        // 6.画干扰线
        for (int i = 0; i < LINES; i++) {
            // 设置随机颜色
            graphic.setColor(getRandomColor());
            // 随机画线
            graphic.drawLine(ran.nextInt(WIDTH), ran.nextInt(HEIGHT), ran.nextInt(WIDTH), ran.nextInt(HEIGHT));
        }
        // 7.返回验证码和图片
        Map<String, Object> map = new HashMap<>();
        //验证码
        map.put("code", sb.toString());
        //图片
        map.put("image", image);
        return map;
    }

    /**
     * 随机取色
     */
    public static Color getRandomColor() {
        Random ran = new Random();
        return new Color(ran.nextInt(256), ran.nextInt(256), ran.nextInt(256));
    }
}


