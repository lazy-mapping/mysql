package hello01;

public class CdPlayer {
	
	private CompactDiscs mp;
	
	public  CdPlayer() {
		super();
		System.out.println("CdPlayer的无参构造方法"+this.toString());
	} //无参调用方法
	
	public  CdPlayer(CompactDiscs mp) {
		this.mp=mp;
		System.out.println("CdPlayer的有参构造方法"+this.toString());
	} //有参调用方法
	
	public void play() {
	    mp.play();
	}
}
