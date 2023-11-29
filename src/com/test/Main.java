package com.test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Scanner;

import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		try {
			System.out.println("Enter your File name First: ");
			String qr=sc.nextLine();
			File f=new File("D:\\QR gen\\"+qr+".png");
			System.out.println("Enter your Content here : ");
			String content=sc.nextLine();
			
			ByteArrayOutputStream out= QRCode.from(content).to(ImageType.PNG).stream();
			
			FileOutputStream tos=new FileOutputStream(f);
			
			tos.write(out.toByteArray());
			
			tos.close();
			
			System.out.println("Success");
		}
		catch(Exception e) {
				e.printStackTrace();
			}
		finally {
			sc.close();
		}
	}
}