package gui;

import java.awt.Color;

import javax.swing.UIManager;

public class GUIThread extends Thread{
	private static GUITaiGioiThieu guiTai;
	public GUIThread() {
		
	}
	public static void main(String[] args) {
		guiTai = new GUITaiGioiThieu();
		try {
			for(int i =1 ; i <= 100 ;i++) {
				Thread.sleep(30);
				guiTai.lblSo.setText(i+"");
				guiTai.process.setValue(i);
				guiTai.process.setForeground(new Color(253-(i+2),150-i,54+i));
			}
			Thread.sleep(10);
			guiTai.dispose();
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
			 new GUIGioiThieu();
		} catch (Exception e) {
			e.printStackTrace();
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
