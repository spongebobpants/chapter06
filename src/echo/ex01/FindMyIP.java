package echo.ex01;
import java.net.InetAddress;

public class FindMyIP {
public static void main(String [] arg) {
	try {
		InetAddress ip=InetAddress.getLocalHost();
		System.out.println("Host name= ["+ip.getHostName()+"]");
		System.out.println("Host address= ["+ip.getHostAddress()+"]");
	}
	catch(Exception e) {
		System.out.println(e);
	}
}

}
