package com.test;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;


public class DemoQR {

	public static void main(String[] args) throws Exception {
		 String text = "https://example.com"; // Replace with your QR code data
         int width = 300;
         int height = 300;

         // Generate the QR code
         QRCodeWriter qrCodeWriter = new QRCodeWriter();
         BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

         // Create a BufferedImage to represent the QR code
         BufferedImage qrImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
         Graphics2D graphics = qrImage.createGraphics();

         // Set the background color of the QR code
         graphics.setColor(Color.WHITE);
         graphics.fillRect(0, 0, width, height);

         // Set the QR code color
         graphics.setColor(Color.BLACK);

         // Render the QR code onto the BufferedImage
         for (int x = 0; x < width; x++) {
             for (int y = 0; y < height; y++) {
                 if (bitMatrix.get(x, y)) {
                     graphics.fillRect(x, y, 1, 1);
                 }
             }
         }

         // Load your images
         BufferedImage logo = ImageIO.read(new File("D:\\QR gen\\DSC_0633.jpg"));

         // Calculate the position to center the image on the QR code
         int xPos = (width - logo.getWidth()) / 2;
         int yPos = (height - logo.getHeight()) / 2;

//         Overlay the image onto the QR code
         graphics.drawImage(logo, xPos, yPos, null);

         // Save the final QR code with the image
         ImageIO.write(qrImage, "PNG", new File("D:\\QR gen\\d.png"));
        System.out.println("Success");
    } 
}
		
