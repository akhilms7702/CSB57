import java.io.*;
import java.net.*;
public class UDPClient
{
public static void main(String args[])throws Exception
{

DatagramPacket dp;
DatagramSocket ds=new DatagramSocket();
InetAddress hostAddress=InetAddress.getByName("localhost");

System.out.println("Client ready for communication");



while(true)
{
byte[]buf=new byte[500];
dp=new DatagramPacket(buf,buf.length);
BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
String Outmessage=input.readLine();

String OutString="Client Say:"+Outmessage;
buf=OutString.getBytes();
DatagramPacket out=new DatagramPacket(buf,buf.length,hostAddress,9999);
ds.send(out);
ds.receive(dp);
String revd=new String(dp.getData(),0,dp.getLength());
if(revd.equals("exit")||(Outmessage.equals("exit")))
break;
System.out.println(revd.toUpperCase());
}

}
}