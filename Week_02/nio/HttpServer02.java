import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Auther: lizhaowen
 * @Date: 2021/1/17 17:27
 * @Description: TODO
 */
public class HttpServer02 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8082);
        while(true){
            try {
                Socket socket = serverSocket.accept();
                new Thread(()->{
                    service(socket);
                }).start();
            }catch (IOException e){
                e.printStackTrace();
            }

        }
    }
    private static void service(Socket socket){
        try {
            Thread.sleep(20);
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (true){
                String clientData = reader.readLine();
                if (clientData==null){
                    break;
                }
                System.out.println("server 收到的数据:"+clientData);
                writer.println("Hello zhaowen");
                writer.flush();
            }
        }catch (IOException |InterruptedException e){
            e.printStackTrace();
        }
    }
}
