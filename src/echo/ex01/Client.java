package echo.ex01;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;



public class Client {
	public static void main(String []args)throws IOException{

		Socket socket = new Socket();
		System.out.println("클라이언트 시작");
		System.out.println("======================");
		System.out.println("서버 연결 요청");
		
		socket.connect(new InetSocketAddress("127.0.0.1", 10001));
		System.out.println("서버 연결 완료");
		
		OutputStream os=socket.getOutputStream();
		OutputStreamWriter osw=new OutputStreamWriter(os, "UTF-8");
		BufferedWriter bw = new BufferedWriter(osw);
		
		InputStream is=socket.getInputStream();
		InputStreamReader isr=new InputStreamReader(is, "UTF-8");
		BufferedReader br=new BufferedReader(isr);
		
		String str ="안녕하세요 ";
		bw.write(str);
		bw.newLine();
		bw.flush();
		
		
		String reMsg=br.readLine();
		System.out.println("server:["+reMsg+"]");
		
		bw.close();
		socket.close();
	}
}
	
