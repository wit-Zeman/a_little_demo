package io.zeman.captcha;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.captcha.ShearCaptcha;
import cn.hutool.captcha.generator.MathGenerator;
import cn.hutool.core.lang.Console;



/**
 * 验证码测试demo
 */
public class CaptchaDemo {
    public static void main(String[] args) {
        creatCustomCaptcha();
    }

    /**
     * 扭曲干扰验证码
     */
    private static void creatShearCaptcha() {
        //定义图形验证码的长、宽、验证码字符数、干扰线宽度
        ShearCaptcha captcha = CaptchaUtil.createShearCaptcha(200, 100, 4, 4);
        //ShearCaptcha captcha = new ShearCaptcha(200, 100, 4, 4);
        //图形验证码写出，可以写出到文件，也可以写出到流
        captcha.write("d:/shear.png");
        //验证图形验证码的有效性，返回boolean值
        boolean verify = captcha.verify("1234");
        Console.log(verify);
    }

    /**
     * 圆圈干扰验证码
     */
    private static void creatCircleCaptcha() {
        //定义图形验证码的长、宽、验证码字符数、干扰元素个数
        CircleCaptcha captcha = CaptchaUtil.createCircleCaptcha(200, 100, 4, 20);
        //图形验证码写出，可以写出到文件，也可以写出到流
        captcha.write("d:/circle.png");
        // 输出code
        Console.log(captcha.getCode());
    }

    /**
     * 线段干扰验证码
     */
    private static void creatLineCaptcha() {
        // 定义图形验证码的长和宽
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(200, 100,4,100);
        // 输出到指定目录
        lineCaptcha.write("d:/line.png");
        //输出code
        Console.log(lineCaptcha.getCode());
    }

    /**
     * 自定义验证码
     */
    private static void creatCustomCaptcha() {
        ShearCaptcha captcha = CaptchaUtil.createShearCaptcha(200, 45, 4, 4);
        // 普通验证码
        Console.log(captcha.getCode());
        // 自定义验证码内容为四则运算方式
        captcha.setGenerator(new MathGenerator());
        // 输出指定目录
        captcha.write("d:/shear.png");
        // 重新生成code
        captcha.createCode();
        // 输出code
        Console.log(captcha.getCode());
    }
}
