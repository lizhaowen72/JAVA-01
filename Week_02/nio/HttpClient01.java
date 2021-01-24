import java.io.*;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;

/**
 * @Auther: lizhaowen
 * @Date: 2021/1/24 10:30
 * @Description: TODO
 */
public class HttpClient01 {
    public static void main(String[] args) throws Exception {
        try {
            Socket socket = new Socket("localhost",8082);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            writer.println("Hello geek");
            while (true){
                String serverData = reader.readLine();
                if (serverData==null){
                    break;
                }
                System.out.println("客户端收到数据:"+serverData);
            }
            writer.close();
            socket.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
