/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Windows;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ninh
 */
public class MyJInternalFrame extends javax.swing.JInternalFrame {

  /**
   * Creates new form MyJInternalFrame
   */
  public MyJInternalFrame() {
    initComponents();
  }

  public void renderTable(String searchValue) throws SQLException {
    DBHOCVIEN db = new DBHOCVIEN();
    Connection connection = db.getConnect();
    try {
      String header[] = {"MaHV", "TenHV"};
      DefaultTableModel tblModel = new DefaultTableModel(header, 0);

      Statement statement = connection.createStatement();

      ResultSet rs = statement.executeQuery("select hv.MaHocVien, hv.TenHocVien "
              + "from HOCVIEN hv "
              + "WHERE hv.TenHocVien like N'%" + searchValue + "%'");
      while (rs.next()) {
        String maHV = rs.getString("MaHocVien");
        String tenHV = rs.getString("TenHocVien");
        String row[] = {maHV, tenHV};
        tblModel.addRow(row);
      }

      jTable1.setModel(tblModel);
      connection.close();
    } catch (Exception ex) {
      System.out.print(ex.getMessage());
    }

  }

  /**
   * This method is called from within the constructor to initialize the form. WARNING: Do
   * NOT modify this code. The content of this method is always regenerated by the Form
   * Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    searchField = new javax.swing.JTextField();
    searchBtn = new javax.swing.JButton();
    jScrollPane1 = new javax.swing.JScrollPane();
    jTable1 = new javax.swing.JTable();

    searchBtn.setText("Tim");
    searchBtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        searchBtnActionPerformed(evt);
      }
    });

    jScrollPane1.setViewportView(jTable1);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(82, 82, 82)
        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(searchBtn)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addContainerGap(19, Short.MAX_VALUE)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(17, 17, 17))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(22, 22, 22)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(searchBtn))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(46, Short.MAX_VALUE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
    String searchValue = this.searchField.getText();
    if (searchValue.equals("")) {
      JOptionPane.showMessageDialog(null, "Input your search!!!");
      String header[] = {"MaHV", "TenHV"};
      DefaultTableModel tblModel = new DefaultTableModel(header, 0);
      jTable1.setModel(tblModel);
      return;
    }
    try {
      this.renderTable(searchValue);
    } catch (SQLException ex) {
      Logger.getLogger(MyJInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
    }
  }//GEN-LAST:event_searchBtnActionPerformed


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTable jTable1;
  private javax.swing.JButton searchBtn;
  private javax.swing.JTextField searchField;
  // End of variables declaration//GEN-END:variables
}
