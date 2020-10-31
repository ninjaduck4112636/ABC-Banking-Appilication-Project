package com.bank.devaiah;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Model implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String customer_id;
	private Integer account_no;
	private String password;
	private Integer balance;
	private String e_mail;
	private int reciverAccountNO;
	private Connection con = null;
	
	public Model() {
		
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test", "postgres", "system");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public Model(String name, String customer_id, Integer account_no, String password, Integer balance, String e_mail) {
		this.name = name;
		this.customer_id = customer_id;
		this.account_no = account_no;
		this.password = password;
		this.balance = balance;
		this.e_mail = e_mail;
	}
	
	public int getReciverAccountNO() {
		return reciverAccountNO;
	}
	public void setReciverAccountNO(int reciverAccountNO) {
		this.reciverAccountNO = reciverAccountNO;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	public Integer getAccount_no() {
		return account_no;
	}
	public void setAccount_no(Integer account_no) {
		this.account_no = account_no;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getBalance() {
		return balance;
	}
	public void setBalance(Integer balance) {
		this.balance = balance;
	}
	public String getE_mail() {
		return e_mail;
	}
	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}
	public boolean register() {
		Integer result = 0;
		
		try {
			PreparedStatement pstmt = con.prepareStatement("INSERT INTO BANK_DATABASE VALUES (?,?,?,?,?,?)");
			pstmt.setString(1, name);
			pstmt.setString(2, customer_id);
			pstmt.setInt(3, account_no);
			pstmt.setString(4, password);
			pstmt.setInt(5, balance);
			pstmt.setString(6, e_mail);
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(result>0)
			return true;
		else
			return false;
	}
	public Boolean login() {
		try {
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM BANK_DATABASE WHERE CUSTOMER_ID=? AND PASSWORD=?");
			pstmt.setString(1, customer_id);
			pstmt.setString(2, password);
			
			ResultSet res = pstmt.executeQuery();
			while(res.next()) {
				account_no = res.getInt("ACCOUNT_NO");
				name = res.getString("NAME");
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public Boolean showBalance() {
		
		try {
			PreparedStatement pstmt = con.prepareStatement("SELECT BALANCE FROM BANK_DATABASE WHERE ACCOUNT_NO=?");
			pstmt.setInt(1, account_no);
			
			ResultSet res = pstmt.executeQuery();
			while(res.next()) {
				balance = res.getInt("BALANCE");
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	public Boolean changePassword() {
		
		try {
			PreparedStatement pstmt = con.prepareStatement("UPDATE BANK_DATABASE SET PASSWORD=? WHERE ACCOUNT_NO=?");
			pstmt.setString(1, password);
			pstmt.setInt(2, account_no);
			
			Integer num = pstmt.executeUpdate();
			
			if(num>0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	public boolean transferAmount() {
		try {
			int sender_balance = 0;
			int reciver_balance = 0;
			int reciver_balance_addition = 0;
			int sender_balance_substraction = 0;
			PreparedStatement sender_pstmt = con.prepareStatement("SELECT * FROM BANK_DATABASE WHERE ACCOUNT_NO=?");
			sender_pstmt.setInt(1, account_no);
			ResultSet sender_res = sender_pstmt.executeQuery();
			while(sender_res.next()) {
				sender_balance = sender_res.getInt("BALANCE");
				if(sender_balance>0 && sender_balance>=balance) {
					
					PreparedStatement reciver_pstmt = con.prepareStatement("SELECT * FROM BANK_DATABASE WHERE ACCOUNT_NO=?");
					reciver_pstmt.setInt(1, reciverAccountNO);
					ResultSet reciver_res = reciver_pstmt.executeQuery();
					while(reciver_res.next()) {
						reciver_balance = reciver_res.getInt("BALANCE");
					}
					reciver_balance_addition = reciver_balance + balance;
					sender_balance_substraction = sender_balance - balance;
					PreparedStatement reciver_update_pstmt = con.prepareStatement("UPDATE BANK_DATABASE SET BALANCE=? WHERE ACCOUNT_NO=?");
					reciver_update_pstmt.setInt(1, reciver_balance_addition);
					reciver_update_pstmt.setInt(2, reciverAccountNO);
					int reciver_verification = reciver_update_pstmt.executeUpdate();
					
					PreparedStatement sender_update_pstmt = con.prepareStatement("UPDATE BANK_DATABASE SET BALANCE=? WHERE ACCOUNT_NO=?");
					sender_update_pstmt.setInt(1, sender_balance_substraction);
					sender_update_pstmt.setInt(2, account_no);
					int sender_verification = sender_update_pstmt.executeUpdate();
					
					PreparedStatement bank_statement_pstmt = con.prepareStatement("INSERT INTO BANK_BALANCE_STATEMENT_TABLE VALUES (?,?,?)");
					bank_statement_pstmt.setInt(1, account_no);
					bank_statement_pstmt.setInt(2, reciverAccountNO);
					bank_statement_pstmt.setInt(3, balance);
					int bank_statement_verification = bank_statement_pstmt.executeUpdate();
					
					if(reciver_verification>0 && sender_verification>0 && bank_statement_verification>0) {
						return true;
					}
					else {
						return false;
					}
				}
				else {
					return false;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	
	public ResultSet getMiniStatement() {
		ResultSet res = null;
		try {
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM BANK_BALANCE_STATEMENT_TABLE WHERE ACCOUNT_NO=?");
			pstmt.setInt(1, account_no);
			res = pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
		
}
