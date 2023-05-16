/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.openmarket.client.presentation;

import co.unicauca.openmarket.client.domain.service.CategoryService;
import co.unicauca.openmarket.commons.domain.Product;
import co.unicauca.openmarket.client.domain.service.ProductService;
import co.unicauca.openmarket.commons.domain.Category;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Libardo Pantoja
 */
public class GUIProductsFind extends javax.swing.JDialog {

    private ProductService productService;
    private CategoryService categoryService;

    /**
     * Creates new form GUIProductsFind
     */
    public GUIProductsFind(java.awt.Frame parent, boolean modal, ProductService productService,CategoryService categoryService) {
        super(parent, modal);
        initComponents();
        initializeTable();
        this.productService = productService;
        this.categoryService=categoryService;
        setLocationRelativeTo(null); //centrar al ventana
    }

    private void initializeTable() {
        tblProducts.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Id", "Name", "Description","Categoria"
                }
        ));
    }

    private void fillTable(List<Product> listProducts) throws Exception {
        initializeTable();
        DefaultTableModel model = (DefaultTableModel) tblProducts.getModel();

        Object rowData[] = new Object[4];//No columnas
        for (int i = 0; i < listProducts.size(); i++) {
            rowData[0] = listProducts.get(i).getProductId();
            rowData[1] = listProducts.get(i).getName();
            rowData[2] = listProducts.get(i).getDescription();
                  if ((listProducts.get(i).getCategoryId())!=null) {
                 Long catId=listProducts.get(i).getCategoryId();
                String catName= categoryService.findCategoryById(catId).getName();
                rowData[3] = catName;
            } else {
                rowData[3] = "No establecido";
            }
            model.addRow(rowData);
        }
    }

    private void fillTableId(Product producto) throws Exception {
        initializeTable();
        DefaultTableModel model = (DefaultTableModel) tblProducts.getModel();

        Object rowData[] = new Object[4];//No columnas
        rowData[0] = producto.getProductId();
        rowData[1] = producto.getName();
        rowData[2] = producto.getDescription();
          if ((producto.getCategoryId())!=null) {
                 Long catId=producto.getCategoryId();
                String catName= categoryService.findCategoryById(catId).getName();
                rowData[3] = catName;
            } else {
                rowData[3] = "No establecido";
            }

        model.addRow(rowData);
    }

    private void fillTableName(List<Product> listProducts) throws Exception {
        initializeTable();
        DefaultTableModel model = (DefaultTableModel) tblProducts.getModel();

        Object rowData[] = new Object[4];//No columnas
        for (int i = 0; i < listProducts.size(); i++) {
            rowData[0] = listProducts.get(i).getProductId();

            rowData[1] = listProducts.get(i).getName();
            rowData[2] = listProducts.get(i).getDescription();
           if ((listProducts.get(i).getCategoryId())!=null) {
                 Long catId=listProducts.get(i).getCategoryId();
                String catName= categoryService.findCategoryById(catId).getName();
                rowData[3] = catName;
            } else {
                rowData[3] = "No establecido";
            }
            model.addRow(rowData);
        }
    }

    private void fillTableCategory(List<Product> listProducts) throws Exception {
        initializeTable();
        DefaultTableModel model = (DefaultTableModel) tblProducts.getModel();
       
        Object rowData[] = new Object[3];//No columnas
        for (int i = 0; i < listProducts.size(); i++) {
         
            rowData[0] = listProducts.get(i).getProductId();

            rowData[1] = listProducts.get(i).getName();
            rowData[2] = listProducts.get(i).getDescription();
            if ((listProducts.get(i).getCategoryId())!=null) {
                 Long catId=listProducts.get(i).getCategoryId();
                String catName= categoryService.findCategoryById(catId).getName();
                rowData[3] = catName;
            } else {
                rowData[3] = "No establecido";
            }
            model.addRow(rowData);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        pnlCenter = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProducts = new javax.swing.JTable();
        pnlNorth = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        rdoId = new javax.swing.JRadioButton();
        rdoCategory = new javax.swing.JRadioButton();
        rdoName = new javax.swing.JRadioButton();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnSearchAll = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Búsqueda de productos");

        pnlCenter.setLayout(new java.awt.BorderLayout());

        tblProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblProducts);

        pnlCenter.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jLabel1.setText("Buscar por:");
        pnlNorth.add(jLabel1);

        buttonGroup1.add(rdoId);
        rdoId.setSelected(true);
        rdoId.setText("Id");
        rdoId.setName("rdId"); // NOI18N
        pnlNorth.add(rdoId);

        buttonGroup1.add(rdoCategory);
        rdoCategory.setText("Categoria");
        pnlNorth.add(rdoCategory);

        buttonGroup1.add(rdoName);
        rdoName.setText("Nombre del producto");
        rdoName.setName("rdoName"); // NOI18N
        rdoName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoNameActionPerformed(evt);
            }
        });
        pnlNorth.add(rdoName);

        txtSearch.setName("txtSearch"); // NOI18N
        txtSearch.setPreferredSize(new java.awt.Dimension(62, 32));
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        pnlNorth.add(txtSearch);

        btnSearch.setText("Buscar");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        pnlNorth.add(btnSearch);

        btnSearchAll.setText("Buscar Todos");
        btnSearchAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchAllActionPerformed(evt);
            }
        });
        pnlNorth.add(btnSearchAll);

        pnlCenter.add(pnlNorth, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(pnlCenter, java.awt.BorderLayout.CENTER);

        btnClose.setText("Cerrar");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        jPanel1.add(btnClose);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnSearchAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchAllActionPerformed
        try {
            fillTable(productService.findAllProducts());
        } catch (Exception ex) {
            Logger.getLogger(GUIProductsFind.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSearchAllActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        try {
            if (this.rdoId.isSelected() == true) {

                fillTableId(productService.findProductById(Long.valueOf(this.txtSearch.getText())));
            } else if (this.rdoCategory.isSelected() == true) {
                fillTableCategory(productService.findProductsByCategory(this.txtSearch.getText()));
            } else {
                fillTableName(productService.findProductsByName(this.txtSearch.getText()));
            }
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null,
                    "Envia la informacion correspondiente",
                    "Error tipo de dato",
                    JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_btnSearchActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void rdoNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoNameActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnSearchAll;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlCenter;
    private javax.swing.JPanel pnlNorth;
    private javax.swing.JRadioButton rdoCategory;
    private javax.swing.JRadioButton rdoId;
    private javax.swing.JRadioButton rdoName;
    private javax.swing.JTable tblProducts;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}