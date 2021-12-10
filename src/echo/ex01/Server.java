package echo.ex01;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {

	public static void main(String []args)throws IOException{
		
		ServerSocket serverSocket=new ServerSocket();
		serverSocket.bind(new InetSocketAddress("127.0.0.1", 10001));
		
		System.out.println("서버시작");
		System.out.println("======================");
		System.out.println("서버 연결 기다림");
		
		Socket socket=serverSocket.accept();
		
		//input
		System.out.println("클라이언트연결");
		InputStream is = socket.getInputStream();
		InputStreamReader isr =new InputStreamReader(is, "UTF-8");
		BufferedReader br=new BufferedReader(isr);
		
		//output
		OutputStream os=socket.getOutputStream();
		OutputStreamWriter osw=new OutputStreamWriter(os, "UTF-8");
		BufferedWriter bw = new BufferedWriter(osw);
		
		String msg=br.readLine();
		System.out.println("받은 메세지"+msg);
			
		bw.write(msg);
		bw.newLine();
		bw.flush();
		
		socket.close();
		
		serverSocket.close();
	}
}
