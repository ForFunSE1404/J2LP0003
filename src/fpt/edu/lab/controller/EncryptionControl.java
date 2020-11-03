/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.edu.lab.controller;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author nguye
 */
public class EncryptionControl {

    public static boolean encrypt(String msg, String imgPath) {
        System.out.println("run");
        try {
            BufferedImage xImage = readImageFile(imgPath);
            byte[] bits = toBitArray(msg);
            return hideTheMessage(bits, xImage, "stego.png");
        } catch (Exception e) {
            return false;
        }
    }

    private static BufferedImage readImageFile(String imgPath) throws Exception {
        BufferedImage theImage = null;
        File p = new File(imgPath);
        try {
            theImage = ImageIO.read(p);
        } catch (IOException e) {
            System.exit(1);
        }
        return theImage;
    }

    private static byte[] toBitArray(String msg) {
        int j = 0;
        //tạo 1 mảng lưu trữ binary message với độ dài bằng 8 lần độ dài của chữ
        byte[] binaryMessage = new byte[msg.length() * 8];
        //chuyển các chữ trong chuỗi thành 1 mã binary
        for (int i = 0; i < msg.length(); i++) {
            //chuyển từ sang hệ ascii
            int ascii = msg.charAt(i);
            //chuyển ascii sang binary
            String wordBinary = Integer.toBinaryString(ascii);
            //đảm bảo bit phải đủ 8 kí tự
            while (wordBinary.length() != 8) {
                wordBinary = '0' + wordBinary;
            }
            //đưa vào mảng binary message
            for (int k = 0; k < wordBinary.length(); k++) {
                binaryMessage[j++] = Byte.parseByte("" + wordBinary.charAt(k));
            }
        }
        return binaryMessage;
    }

    public static boolean hideTheMessage(byte[] bits, BufferedImage theImage, String stegoPath) {
        boolean isChange = false;
        //rút gọn bit length đi 8 lần
        int bitLength = bits.length / 8;
        byte[] bitLengthMessage = new byte[8];
        String bitLengthStr = Integer.toBinaryString(bitLength);
        //đảm bảo bit phải đủ 8 kí tự
        while (bitLengthStr.length() != 8) {
            bitLengthStr = '0' + bitLengthStr;
        }
        for (int i = 0; i < 8; i++) {
            bitLengthMessage[i] = Byte.parseByte("" + bitLengthStr.charAt(i));
        }
        int i = 0;
        int currentBitEntry = 0;
        for (int x = 0; x < theImage.getWidth(); x++) {
            for (int y = 0; y < theImage.getHeight(); y++) {
                //ghi (length của binary message sau khi rút gọn) vào tọa độ từ (0:0) đến (0:3) 
                if (x == 0 && y < 4) {
                    //lấy pixel trên ảnh tại tọa độ (x, y)
                    int currentPixel = theImage.getRGB(x, y);
                    int newPixel = changePixel(currentPixel, bitLengthMessage[i++], bitLengthMessage[i++]);
                    if (newPixel != currentPixel) {
                        //đặt lại màu mới tại tọa độ (x,y)
                        theImage.setRGB(x, y, newPixel);
                    }
                    //ghi chuỗi binary message vào tọa độ từ (0:3) trở đi
                } else if (currentBitEntry < bits.length) {
                    //lấy pixel trên ảnh tại tọa độ (x, y)
                    int currentPixel = theImage.getRGB(x, y);
                    int newPixel = changePixel(currentPixel, bits[currentBitEntry++], bits[currentBitEntry++]);
                    //đặt lại màu mới tại tọa độ (x,y)
                    if (newPixel != currentPixel) {
                        //đặt lại màu mới tại tọa độ (x,y)
                        theImage.setRGB(x, y, newPixel);
                    }
                }
            }
        }
        //ghi lại ảnh
        try {
            isChange = ImageIO.write(theImage, "png", new File(stegoPath));
        } catch (IOException ex) {
        }
        return isChange;
    }

    public static int changePixel(int currentPixel, int writeBitGreen, int writeBitBlue) {
        //lấy mã màu rgb từ pixel
        Color color = new Color(currentPixel, true);
        int red = color.getRed();
        int green = color.getGreen();
        //chuyển mã green thành chuỗi binary
        String greenBinary = Integer.toBinaryString(green);
        //lấy 7 chữ số đầu của dãy green binary
        greenBinary = greenBinary.substring(0, greenBinary.length() - 1);
        //thay đổi số binary thứ 8 của green binary thành bit của message
        greenBinary = greenBinary + Integer.toString(writeBitGreen);
        int newGreen = Integer.parseInt(greenBinary, 2);
        int blue = color.getBlue();
        //chuyển mã blue thành chuỗi binary
        String blueBinary = Integer.toBinaryString(blue);
        //lấy 7 chữ số đầu của dãy blue binary
        blueBinary = blueBinary.substring(0, blueBinary.length() - 1);
        //thay đổi số binary thứ 8 của blue binary thành bit của message
        blueBinary = blueBinary + Integer.toString(writeBitBlue);
        //chuyển chuỗi binary thành số hệ thập phân
        int newBlue = Integer.parseInt(blueBinary, 2);

        //lấy pixel mới từ mã màu rgb sau khi thay đổi
        return rgbToPixel(red, newGreen, newBlue);
    }

    public static int rgbToPixel(int red, int green, int blue) {
        int alpha = 255;
        int rgb = (alpha << 24) | (red << 16) | (green << 8) | blue;
        return rgb;
    }

}
