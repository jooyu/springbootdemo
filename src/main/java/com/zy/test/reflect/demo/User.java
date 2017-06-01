package com.zy.test.reflect.demo;

public class User {
	  private int id;
	    private String username;
	    private String password;
	    private String email;
	    private int grade;
	    
	    public User(){
	        
	    }
	    
	    public User(int id,String username,String password,String email,int grade){
	        this.id = id;
	        this.username = username;
	        this.password = password;
	        this.email = email;
	        this.grade = grade;
	    }

	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getUsername() {
	        return username;
	    }

	    public void setUsername(String username) {
	        this.username = username;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public int getGrade() {
	        return grade;
	    }

	    public void setGrade(int grade) {
	        this.grade = grade;
	    }
}
