package hello01;

public class Application {
	public static void main(String[] args) {
		System.out.println("application");
		
		MessagePrinter printer = new MessagePrinter();
		MessageService service = new MessageService();
		
		printer.setService(service);/*一个参数的构造方法*/
		printer.printMessage();
	}/*没有自动装配*/
}
