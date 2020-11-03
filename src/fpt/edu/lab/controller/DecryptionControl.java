/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.edu.lab.controller;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author nguye
 */
public class DecryptionControl {

    private static int lengthMessage = 0;

    public static String decrypt(String imgPath) {
        try {
            BufferedImage img = readImageFile(imgPath);
            String bitString = decodeTheMessage(img);
            return bitToString(bitString);
        } catch (Exception e) {
            return null;
        }
    }

    private static String bitToString(String bitString) {
        String message = "";
        for (int i = 0; i < lengthMessage * 8; i += 8) {
            String subString = bitString.substring(i, i + 8);
            //lấy mã ascii của kí tự
            int ascii = Integer.parseInt(subString, 2);
            //chuyển sang char
            message += (char) ascii;
        }
        return message;
    }

    private static BufferedImage readImageFile(String imgPath) throws Exception {
        BufferedImage theImage = null;
        File p = new File(imgPath);
        theImage = ImageIO.read(p);
        return theImage;
    }

    private static String decodeTheMessage(BufferedImage yImage) throws Exception {
        String bitMessage = "";
        int currentBitEntry = 0;
        String bitMessageLength = "";
        for (int x = 0; x < yImage.getWidth(); x++) {
            for (int y = 0; y < yImage.getHeight(); y++) {
                //lấy length của message từ tọa độ (0;0) đến (0;4)
                if (x == 0 && y < 4) {
                    //lấy pixel từ tọa độ (x;y)
                    int currentPixel = yImage.getRGB(x, y);
                    Color color = new Color(currentPixel, true);
                    //lấy màu green từ pixel
                    int green = color.getGreen();
                    bitMessageLength += getLastBit(green, currentPixel);
                    //lấy màu blue từ pixel
                    int blue = color.getBlue();
                    bitMessageLength += getLastBit(blue, currentPixel);
                    if (y == 3) {
                        lengthMessage = Integer.parseInt(bitMessageLength, 2);
                    }
                    //lấy message từ tọa độ (0;4) đến hết ảnh
                } else if (currentBitEntry < lengthMessage * 8) {
                    //lấy pixel từ tọa độ (x;y)
                    int currentPixel = yImage.getRGB(x, y);
                    Color color = new Color(currentPixel, true);
                    int green = color.getGreen();
                    //lấy bit được giấu trong green binary
                    bitMessage += getLastBit(green, currentBitEntry++);
                    //lấy màu blue từ pixel
                    int blue = color.getBlue();
                    //lấy bit được giấu trong blue binary
                    bitMessage += getLastBit(blue, currentBitEntry++);
                }
            }
        }
        return bitMessage;
    }

    public static char getLastBit(int colorCode, int currentPixel) {
        String binary = Integer.toBinaryString(colorCode);
        //lấy bit cuối cùng của binary blue
        return binary.charAt(binary.length() - 1);
    }
}
