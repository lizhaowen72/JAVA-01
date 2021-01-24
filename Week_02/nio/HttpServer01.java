import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Auther: lizhaowen
 * @Date: 2021/1/17 16:39
 * @Description: TODO
 */
public class HttpServer01 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8081);
        while(true){
            try {
                Socket socket = serverSocket.accept();
                service(socket);
            }catch (IOException e){
                e.printStackTrace();
            }

        }
    }

    public HttpServer01() throws IOException {
    }

    private static void service(Socket socket){
        try {
            Thread.sleep(20);
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (true){
                String clientData = reader.readLine();
                if (clientData==null){
                    break;
                }
                System.out.println("server 收到的数据:"+clientData);
            }
            printWriter.println("HTTP/1.1 200 OK");
            printWriter.println("Content-Type:text/html;charset=utf-8");
            printWriter.println();
            printWriter.write("hello,nio");
            printWriter.close();
            socket.close();
        }catch (IOException|InterruptedException e){
            e.printStackTrace();
        }
    }
}
