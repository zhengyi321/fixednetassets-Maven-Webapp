package test;

import org.zhyan.fixed.util.MD5;

public class test {

	public static void main(String args[]){
		String pass = MD5.passToMd5("123");
		System.out.println(pass);
	}
}
