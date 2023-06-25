package com.spring.demo.mes;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;

@Slf4j
public class WechatMes {


    static void searchPerson(String friendNickName, String content) {
        // 创建Robot对象
        Robot robot = getRobot();
        //打开微信 Ctrl+Alt+W
        assert robot != null;
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ALT);
        robot.keyPress(KeyEvent.VK_W);

        //释放Ctrl按键，像Ctrl，退格键，删除键这样的功能性按键，在按下后一定要释放
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_ALT);
        // 该延迟不能少，否则无法搜索
        robot.delay(1000);
        // Ctrl + F 搜索指定好友
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_F);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        // 将好友昵称发送到剪切板
        Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable tText = new StringSelection(friendNickName);
        clip.setContents(tText, null);
        // 以下两行按下了ctrl+v，完成粘贴功能
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.delay(1000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(1000);
        // 发送消息
        try {
            sendMsg(content);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static Robot getRobot() {
        // 创建Robot对象
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        return robot;
    }

    private static void sendMsg(String content) throws InterruptedException {
        if (StringUtils.isBlank(content)) {
            return;
        }
        sendOneMsg(content);

    }

    private static void sendOneMsg(String msg) {
        Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable tText;
        //创建Robot对象
        Robot robot = getRobot();
        //延迟十秒，主要是为了预留出打开窗口的时间，括号内的单位为毫秒
        if (null != robot) {
            robot.delay(500);
            tText = new StringSelection(msg);
            clip.setContents(tText, null);
            // 按下了ctrl+v，完成粘贴功能
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.delay(500);
            //回车发送消息
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.delay(500);
        }
    }

    public static void closeWechat() {
        // 创建Robot对象
        Robot robot = getRobot();
        //打开微信 Ctrl+Alt+W
        assert robot != null;
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ALT);
        robot.keyPress(KeyEvent.VK_W);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_ALT);
        // 该延迟不能少，否则无法搜索
        robot.delay(1000);
    }
}