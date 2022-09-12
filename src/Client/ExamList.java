/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import db.CommonFunction;
import java.awt.Color;
import java.awt.Container;
import java.awt.Image;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pratik
 */
public class ExamList extends javax.swing.JFrame {

    /**
     * Creates new form ExamList
     */
    CommonFunction cf=new CommonFunction();
    Connection cnn;
    public ResultSet rst;
    public ExamList() {
        initComponents();
        try{
            Container ctx=getContentPane();
            ctx.setBackground(new Color(255,255,150));
            setTitle("Exam List");
Image icon=new ImageIcon(this.getClass().getResource("removebg/online1.png")).getImage();
setIconImage(icon);
           // jPanel1.setBackground(new Color(255,255,150));
          cnn=db.MyConnection.getConnection();
         rst=cf.getResultset("exam");
           DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
           
       //    System.out.println("CName"+rst.getString("cname"));
  //          System.out.println("Course"+rs.getString("course"));
            while(rst.next())
            {    
                ResultSet rs=cf.getResultset("course");
                while(rs.next())
                {    
                 if(rst.getString("cname").equals(rs.getString("cname")))
               {
                model.addRow(new Object[]{rst.getString("eid"),rst.getString("cname"),rst.getString("sname"),rst.getString("totalq"),rst.getString("dur"),rst.getString("max"),rst.getString("pass"),rst.getString("date"),rst.getString("state")});
               }
                
               // System.out.println(""+rst.getString("cname"));
            }
            }
//            while(rst.next())
//                {  
//                    ResultSet rs=cf.getResultset("student");
//                if(rst.getString("cname").equals(rs.getString("course")))
//            {
//                model.addRow(new Object[]{rst.getString("eid"),rst.getString("cname"),rst.getString("sname"),rst.getString("totalq"),rst.getString("dur"),rst.getString("max"),rst.getString("pass"),rst.getString("date"),rst.getString("state")});
//            }
//            }
        }catch(Exception ee)
        {
            System.out.println("Exception is"+ee);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Exam Id", "Course Name", "Subject Name", "Total Questions", "Duration", "Maximum Marks", "Passing Marks", "Date", "State"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 977, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 748, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ExamList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExamList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExamList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExamList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExamList().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}