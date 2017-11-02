import java.io.*;
import java.net.*;
public class UDPServer
{
public static void main(String args[])throws Exception
{
int PORT=9999;
DatagramPacket dgp;
DatagramSocket dsk;
dsk=new DatagramSocket(PORT);
System.out.println("Server Started listening");
while(true)
{
byte[]buf=new byte[50];
dgp=new DatagramPacket(buf,buf.length);
dsk.receive(dgp);
String messageFromClient=new String(dgp.getData());
System.out.println(messageFromClient.toUpperCase());
BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
String Outmessage=input.readLine();

buf=("server say:"+Outmessage).getBytes();
DatagramPacket messageToClient=new DatagramPacket(buf,buf.length,dgp.getAddress(),dgp.getPort());
dsk.send(messageToClient);
if(messageFromClient.equals("exit")||(Outmessage.equals("exit")))
break;

}
}
} 