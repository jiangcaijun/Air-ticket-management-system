package com.app.UI.singleton;

import com.app.UI.main.LoginFrame;
import com.app.UI.main.OperatorFrame;
import com.app.UI.operator.IssuePanel;
import com.app.UI.operator.Reg;

public class OperatorSingleton {

	  private static OperatorSingleton mySingleton ; 
	  private String loginFrameUserName;             //登录的操作员账号ID
	  private OperatorFrame op;
	  public String getLoginFrameUserName() {
		return loginFrameUserName;
	  }
	  public void setLoginFrameUserName(String loginFrameUserName) {
		  this.loginFrameUserName = loginFrameUserName;
	  }
	  private String userName;
	  private String myFlightId;
	  private LoginFrame loginFrame;
	  private OperatorFrame operatorFrame;
	  private IssuePanel issuePanel;
	  private Reg reg;
	  
	
	  public String getMyFlightId() {
		return myFlightId;
	}
	public void setMyFlightId(String myFlightId) {
		this.myFlightId = myFlightId;
	}
	// 私有的构造函数，限制外部环境的非法创建和访问 
	  private OperatorSingleton() { 
	    //一些初始化操作 
	  } 
	  // 静态方法，用于创建单例类的“唯一”实例 
		 public static OperatorSingleton getInstance() { 
		   if (mySingleton == null) { 
		     mySingleton = new OperatorSingleton(); 
		   } 
	    return mySingleton; 
	  } 
	  // 单例类也需要提供其他静态方法给外部环境访问，完成一定的服务 
	  public void doSomethings() { 
	    System.out.println("do somethings ..."); 
	  }
	public static OperatorSingleton getMySingleton() {
		return mySingleton;
	}
	public static void setMySingleton(OperatorSingleton mySingleton) {
		OperatorSingleton.mySingleton = mySingleton;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String name) {
		this.userName = name;
	}
	public LoginFrame getLoginFrame() {
		return loginFrame;
	}
	public void setLoginFrame(LoginFrame loginFrame) {
		this.loginFrame = loginFrame;
	}
	public OperatorFrame getOperatorFrame() {
		return operatorFrame;
	}
	public void setOperatorFrame(OperatorFrame operatorFrame) {
		this.operatorFrame = operatorFrame;
	}
	public IssuePanel getIssuePanel() {
		return issuePanel;
	}
	public void setIssuePanel(IssuePanel issuePanel) {
		this.issuePanel = issuePanel;
	}
	public Reg getReg() {
		return reg;
	}
	public void setReg(Reg reg) {
		this.reg = reg;
	}
	public OperatorFrame getOp() {
		return op;
	}
	public void setOp(OperatorFrame op) {
		this.op = op;
	}
	
	
}

