import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Auther: lizhaowen
 * @Date: 2021/1/17 17:27
 * @Description: TODO
 */
public class HttpServer03 {
    public static void main(String[] args) throws IOException {
        ExecutorService executorService  = Executors.newFixedThreadPool(40);
        final ServerSocket serverSocket = new ServerSocket(8083);
        while(true){
            try {
                Socket socket = serverSocket.accept();
                executorService.execute(()->service(socket));
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    private static void service(Socket socket){
        try {
            Thread.sleep(20);
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            printWriter.println("HTTP/1.1 200 OK");
            printWriter.println("Content-Type:text/html;charset=utf-8");
            printWriter.println();
            printWriter.write("hello,nio");
            printWriter.close();
            socket.close();
        }catch (IOException |InterruptedException e){
            e.printStackTrace();
        }
    }
}
