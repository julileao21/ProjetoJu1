package support;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class ProxyUtils {

    private static Robot robot;

    private static void setTab(){
        sleep(1);
        try {
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void sleep(long timeOut){
        try {
            Thread.sleep(timeOut * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void getCopy(String url) {
        sleep(1);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection selection = new StringSelection(url);
        clipboard.setContents(selection, null);
    }

    private static void getPaste(){
        sleep(1);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
    }

    private static void setEnter(){
        sleep(1);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    public static void setUrl(String url){
        sleep(3);
        try {
            robot = new Robot();
            setTab();
            setTab();
            getCopy(url);
            getPaste();
            setEnter();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setUserAndPass(String user, String pass){
        sleep(5);
        getCopy(user);
        getPaste();
        setTab();
        getCopy(pass);
        getPaste();
        setEnter();
    }
}
