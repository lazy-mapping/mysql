package Swing;

import javax.swing.JFrame;
/*GUI 创建一个空白窗口，后来测试git，修改窗口大小300->500;之后本地接着修改为900*/
public class TestJFrame {
	public static void main(String[] args) {
		JFrame f=new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//f.setSize(300,300);
		f.setSize(900,900);
		f.setVisible(true);
	}
}
