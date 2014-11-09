package com.websystique.spring.scheduling;

import org.springframework.stereotype.Component;

@Component("evenAnotherBean")
public class EvenAnotherBean {
    
        
 String member;

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }
	
	public void printAnotherMessage(){
		System.out.println("I am even another bean:" + member);
	}
	
}
