/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.edu.lab.gui;

import fpt.edu.lab.controller.DecryptionControl;
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author MTC
 */
public class LSB_Decrypt_GUI extends javax.swing.JFrame {

    /**
     * Creates new form LBS_Encrypt_GUI
     */
    public LSB_Decrypt_GUI() {
        initComponents();
        setLocationRelativeTo(null);
    }

    private ImageIcon resizeImage(String ImagePath, JLabel label) {
        ImageIcon myImage = new ImageIcon(ImagePath);
        Image img = myImage.getImage();
        Image newImg = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnGettingData = new javax.swing.JPanel();
        jlbGettingData = new javax.swing.JLabel();
        jlbStegoImagePath = new javax.swing.JLabel();
        jtxtStegoImagePath = new javax.swing.JTextField();
        jbtnBrowse = new javax.swing.JButton();
        jpnStegoImage = new javax.swing.JPanel();
        jlbStegoImage = new javax.swing.JLabel();
        jpnDisplayStego = new javax.swing.JPanel();
        jlbDisplayStego = new javax.swing.JLabel();
        jbtnShowHiddenMess = new javax.swing.JButton();
        jpnSecretText = new javax.swing.JPanel();
        jlbSecretText = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaSecretMess = new javax.swing.JTextArea();
        jbtnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LSB Decrypt");

        jlbGettingData.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jlbGettingData.setText("Getting data from setego-image");

        jlbStegoImagePath.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jlbStegoImagePath.setText("Stego-image file:");

        jbtnBrowse.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jbtnBrowse.setText("Browse");
        jbtnBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBrowseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnGettingDataLayout = new javax.swing.GroupLayout(jpnGettingData);
        jpnGettingData.setLayout(jpnGettingDataLayout);
        jpnGettingDataLayout.setHorizontalGroup(
            jpnGettingDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnGettingDataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnGettingDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlbGettingData, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpnGettingDataLayout.createSequentialGroup()
                        .addComponent(jlbStegoImagePath)
                        .addGap(22, 22, 22)
                        .addComponent(jtxtStegoImagePath, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbtnBrowse)))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jpnGettingDataLayout.setVerticalGroup(
            jpnGettingDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnGettingDataLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbGettingData)
                .addGap(20, 20, 20)
                .addGroup(jpnGettingDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbStegoImagePath)
                    .addComponent(jtxtStegoImagePath, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnBrowse, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jlbStegoImage.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jlbStegoImage.setText("Stego-image");

        jpnDisplayStego.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jpnDisplayStego.setPreferredSize(new java.awt.Dimension(330, 330));

        javax.swing.GroupLayout jpnDisplayStegoLayout = new javax.swing.GroupLayout(jpnDisplayStego);
        jpnDisplayStego.setLayout(jpnDisplayStegoLayout);
        jpnDisplayStegoLayout.setHorizontalGroup(
            jpnDisplayStegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnDisplayStegoLayout.createSequentialGroup()
                .addComponent(jlbDisplayStego, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jpnDisplayStegoLayout.setVerticalGroup(
            jpnDisplayStegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbDisplayStego, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
        );

        jbtnShowHiddenMess.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jbtnShowHiddenMess.setText("Show the hidden message");
        jbtnShowHiddenMess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnShowHiddenMessActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnStegoImageLayout = new javax.swing.GroupLayout(jpnStegoImage);
        jpnStegoImage.setLayout(jpnStegoImageLayout);
        jpnStegoImageLayout.setHorizontalGroup(
            jpnStegoImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnStegoImageLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnStegoImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnStegoImageLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jlbStegoImage))
                    .addComponent(jbtnShowHiddenMess)
                    .addComponent(jpnDisplayStego, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnStegoImageLayout.setVerticalGroup(
            jpnStegoImageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnStegoImageLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbStegoImage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpnDisplayStego, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbtnShowHiddenMess, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jlbSecretText.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jlbSecretText.setText("Secret text:");

        jtaSecretMess.setEditable(false);
        jtaSecretMess.setColumns(20);
        jtaSecretMess.setRows(5);
        jScrollPane1.setViewportView(jtaSecretMess);

        javax.swing.GroupLayout jpnSecretTextLayout = new javax.swing.GroupLayout(jpnSecretText);
        jpnSecretText.setLayout(jpnSecretTextLayout);
        jpnSecretTextLayout.setHorizontalGroup(
            jpnSecretTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnSecretTextLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbSecretText, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnSecretTextLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jpnSecretTextLayout.setVerticalGroup(
            jpnSecretTextLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnSecretTextLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbSecretText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
                .addContainerGap())
        );

        jbtnBack.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jbtnBack.setText("Back To Main Menu");
        jbtnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jpnGettingData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jpnStegoImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jpnSecretText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbtnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(63, 63, 63))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jpnGettingData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpnStegoImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jpnSecretText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBrowseActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        //lọc những file image trong hộp thoại chooser
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "bmp", "jpg", "gif", "png");
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.addChoosableFileFilter(filter);
        int file = fileChooser.showSaveDialog(null);
        if (file == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            jtxtStegoImagePath.setText(path);
            jlbDisplayStego.setIcon(resizeImage(path, jlbDisplayStego));
        } else if (file == JFileChooser.CANCEL_OPTION) {
            JOptionPane.showMessageDialog(this, "No file selected");
        }
    }//GEN-LAST:event_jbtnBrowseActionPerformed

    private void jbtnShowHiddenMessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnShowHiddenMessActionPerformed
        String imgPath = jtxtStegoImagePath.getText();
        if (imgPath == null) {
            JOptionPane.showMessageDialog(this, "Please Choose a imgae");
            return;
        }
        String message = DecryptionControl.decrypt(imgPath);
        if (message == null) {
            JOptionPane.showMessageDialog(this, "Error Decrypt");
        } else {
            jtaSecretMess.setText(message);
        }
    }//GEN-LAST:event_jbtnShowHiddenMessActionPerformed

    private void jbtnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBackActionPerformed
        new MainFrame().setVisible(true);
        dispose();
    }//GEN-LAST:event_jbtnBackActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnBack;
    private javax.swing.JButton jbtnBrowse;
    private javax.swing.JButton jbtnShowHiddenMess;
    private javax.swing.JLabel jlbDisplayStego;
    private javax.swing.JLabel jlbGettingData;
    private javax.swing.JLabel jlbSecretText;
    private javax.swing.JLabel jlbStegoImage;
    private javax.swing.JLabel jlbStegoImagePath;
    private javax.swing.JPanel jpnDisplayStego;
    private javax.swing.JPanel jpnGettingData;
    private javax.swing.JPanel jpnSecretText;
    private javax.swing.JPanel jpnStegoImage;
    private javax.swing.JTextArea jtaSecretMess;
    private javax.swing.JTextField jtxtStegoImagePath;
    // End of variables declaration//GEN-END:variables
}
