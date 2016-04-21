package com.app.utils;

import java.awt.FlowLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JLabel;

/*
 * java气泡提示效果
 * @version 1.0
 * @since JDK1.6(建议)
 *
 */

public class TipTest extends Thread{
	private Map<String, String> feaMap = null;

	public TipTest() {
		feaMap = new HashMap<String, String>();
		feaMap.put("name", "退出提醒");
		feaMap.put("release", "2010-08-20 11:33:00");
		feaMap.put("feature", "10秒内无操作系统将退出");
	}

	public void run() {
		final TipWindow tw = new TipWindow(300, 220);
		tw.setTitle("重新登录提醒");
		JLabel label = new JLabel("<html>长时间未操作，系统自动退出<br/>请重新登录</html>");
		tw.setLayout(new FlowLayout());
		tw.add(label);		
		tw.setVisible(true);
		tw.run();
	}

	public static void main(String args[]) {
		new TipTest();
	}
}