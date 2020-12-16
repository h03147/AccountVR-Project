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
            "tiger", "lion", "puma", "bear", "wolf", "cat", "cow", "owl", "horse", "donkey",
            "白居易", "孟浩然", "乌衣巷", "赤壁", "九月九日", "忆山东", "兄弟", "相思", "春晓", "咏鹅",
            "付款方法", "现金付款", "暂付款", "赤字", "ERP", "SAP", "固定资产", "折旧", "销货帐", "呆账",
            "sheep", "zebra", "deer", "rhin", "giraffe", "camel", "rat", "rabbit", "monkey", "bat",
            "江南", "敕勒歌", "汉乐府", "劝学", "满江红", "怒发冲冠", "金缕衣", "偶成", "长歌行", "学而不厌",
            "将进酒", "游山西村", "相思", "静夜思", "草", "凉州词", "登岳阳楼", "乌衣巷", "咏柳", "黄鹤楼",
            "结清差额", "miniMBA", "CFO", "MAT", "奶茶", "秋天喝", "单身勇士", "阿甘正传", "达摩", "庄周",
            "whale", "golden", "Kangaroo", "Snake", "汉堡", "牛肉干", "肖战", "王一博", "吐槽大会", "我喜欢你",
            "杠精", "硬核", "螺蛳粉", "益禾堂", "鹿角巷", "1点点", "古茗", "茶颜悦色", "喜茶", "蜜雪冰城",
            "良心po主", "4的4的", "易烊千玺", "四字弟弟", "忙狗", "拔娜娜", "小凶许", "小福泥", "大西几", "蜜雪冰城",
            "赵露思", "詹姆斯", "NBA", "湖人", "热火", "戴维斯", "雄鹿", "饭圈", "祖安人", "驰名双标",
            "后裔", "虞姬", "鲁班七号", "孙悟空", "扁鹊", "安琪拉", "武则天", "诸葛亮", "丁真", "王冰冰",
            "提桶进厂", "美年达", "鸡腿姑娘", "打工人", "修仙", "阿bin", "苏宁", "lpl", "s10", "大乌龟",
            "工具人", "集美", "雨女无瓜", "NPC精神", "小猪佩奇", "PUA", "专业团队", "duck不必", "爬山吗", "U1S1",
            "奥特曼", "边缘计算", "人工智能", "深度学习", "机器学习", "卷积网络", "强化学习", "好家伙", "厂长复出", "圣枪哥",
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


