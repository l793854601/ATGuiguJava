package senior.day10.java1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/*
    URL网络编程：
    使用URL下载网络资源
 */
public class URLTest1 {
    public static void main(String[] args) {
        InputStream is = null;
        FileOutputStream fis = null;
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL("https://click.ali213.net/ALiClick-518.html?jumpurl=https%3A%2F%2F73709.xc.zhongguohao123.com%2Fxiaz%2F%E6%9E%81%E5%93%81%E9%A3%9E%E8%BD%A610%E5%8D%A1%E6%9C%AC%E5%B3%A1%E8%B0%B7%EF%BC%88Need%20For%20Speed%20Carbon%EF%BC%89%E8%8B%B1%E6%96%87%E7%89%88%E4%BF%AE%E6%94%B9%E5%99%A8%E9%94%A6%E9%9B%86%402192_4838.exe");
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.connect();
            is = urlConnection.getInputStream();
            fis = new FileOutputStream("极品飞车10修改器.exe");

            byte[] buffer = new byte[20];
            int length = -1;
            while ((length = is.read(buffer)) != -1) {
                fis.write(buffer, 0, length);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }
    }
}
