package top.lldwb.abc;

import org.junit.jupiter.api.Test;
import java.awt.*;
import java.io.*;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.URL;

public class ABCTest {
    @Test
    public void fss() {
        System.out.println("E:\\我的世界\\测压工具\\EndMinecraftPlus-master".replaceAll("\\\\[^\\\\]*$", ""));
    }

    /**
     * 以post或get方式调用对方接口方法，
     * @param pathUrl
     */
    public static void doPostOrGet(String pathUrl, String data){
        // 用于接收的转换流，把字节流转换成字符流
        OutputStreamWriter out = null;
        // 字符缓冲流
        BufferedReader br = null;
        // 结果
        String result = "";
        try {
            // URL表示一个统一的资源定位符，一个指向万维网上“资源”的指针
            URL url = new URL(pathUrl);
            // 打开和url之间的连接
            // HttpURLConnection实例用于发出一个请求
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            // 请求方式
            conn.setRequestMethod("POST");
            //conn.setRequestMethod("GET");

            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
            conn.setRequestProperty("Content-Type", "application/json;charset=utf-8");

            //DoOutput设置是否向httpUrlConnection输出，DoInput设置是否从httpUrlConnection读入，此外发送post请求必须设置这两个
            conn.setDoOutput(true);
            conn.setDoInput(true);

            /**
             * 下面的三句代码，就是调用第三方http接口
             */
            // 获取URLConnection对象对应的输出流
            out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
            //发送请求参数即数据
            out.write(data);
            //flush输出流的缓冲
            out.flush();

            /**
             * 下面的代码相当于，获取调用第三方http接口后返回的结果
             */
            //获取URLConnection对象对应的输入流
            InputStream is = conn.getInputStream();
            //构造一个字符流缓存
            br = new BufferedReader(new InputStreamReader(is));
            String str = "";
            while ((str = br.readLine()) != null){
                result += str;
            }
            System.out.println(result);
            //关闭流
            is.close();
            //断开连接，disconnect是在底层tcp socket链接空闲时才切断，如果正在被其他线程使用就不切断。
            conn.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null){
                    out.close();
                }
                if (br != null){
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void f() {
        doPostOrGet("https://steamcommunity.com/market/appfilters/730?l=schinese", "");
    }
}