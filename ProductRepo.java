package com.store.dal.repo;

import com.store.dal.entity.Country;
import com.store.dal.entity.Products;
import com.store.dal.manager.DBManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProductRepo {

    public void insertProduct(Products product) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = DBManager.getConnection();
            stmt = conn.prepareStatement("INSERT INTO PRODUCT (PRODUCT_ID , PRODUCT_NAME ,PRODUCT_PRICE ,PRODUCT_QTY) VALUES (? , ? , ? , ?)");

            stmt.setInt(1, product.getProductId());
            stmt.setString(2, product.getProductName());
            stmt.setInt(3, product.getProductPrice());
            stmt.setInt(4, product.getProductQuantity());

            int r = stmt.executeUpdate();
            System.out.println(r);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBManager.closePreparedstatmen(stmt);
            DBManager.closeConnection(conn);
        }
    }

    public void deleteProductByPK(Products product) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = DBManager.getConnection();
            stmt = conn.prepareStatement("DELETE FROM PRODUCT WHERE PRODUCT_ID = ?");

            stmt.setInt(1, product.getProductId());

            int r = stmt.executeUpdate();
            System.out.println(r);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBManager.closePreparedstatmen(stmt);
            DBManager.closeConnection(conn);
        }
    }

    public void updateRecord(Products product) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = DBManager.getConnection();
            stmt = conn.prepareStatement("UPDATE PRODUCT SET PRODUCT_NAME = ? , PRODUCT_QTY = ? WHERE PRODUCT_ID = ?");
            stmt.setString(1, product.getProductName());
            stmt.setInt(2, product.getProductQuantity());
            stmt.setInt(3, product.getProductId());

            int r = stmt.executeUpdate();
            System.out.println(r);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBManager.closePreparedstatmen(stmt);
            DBManager.closeConnection(conn);
        }
    }

    public ArrayList<Products> findAllProduct() {
        ArrayList<Products> al = new ArrayList<>();
        Products product = null;
        Country country = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = DBManager.getConnection();
            stmt = conn.prepareStatement("SELECT PRODUCT_ID , PRODUCT_NAME , PRODUCT_PRICE , PRODUCT_QTY , COUNTRY_NAME , SEQ_ID ,  PRODUCT_COUNTRY_QTY , PRODUCT_MODEL\n"
                    + "FROM PRODUCT , PRODUCT_COUNTRY\n"
                    + "WHERE PRODUCT.PRODUCT_ID = PRODUCT_COUNTRY.PRODUCT_ID_FK ");

            rs = stmt.executeQuery();

            while (rs.next()) {
                product = new Products();
                country = new Country();
                product.setProductId(rs.getInt("PRODUCT_ID"));
                product.setProductName(rs.getString("PRODUCT_NAME"));
                product.setProductPrice(rs.getInt("PRODUCT_PRICE"));
                product.setProductQuantity(rs.getInt("PRODUCT_QTY"));
                product.setProductCountry(country);
                country.setCountryName(rs.getString("COUNTRY_NAME"));
                country.setSeqId(rs.getInt("SEQ_ID"));
                country.setProductCountryQuantity(rs.getInt("PRODUCT_COUNTRY_QTY"));
                country.setProductModel(rs.getInt("PRODUCT_MODEL"));
                al.add(product);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBManager.closeResultSet(rs);
            DBManager.closePreparedstatmen(stmt);
            DBManager.closeConnection(conn);
        }
        return al;

    }
    public ArrayList<Products> findAllProductWithoutDetails() {
        ArrayList<Products> al = new ArrayList<>();
        Products product = null;
        Country country = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = DBManager.getConnection();
            stmt = conn.prepareStatement("SELECT PRODUCT_ID , PRODUCT_NAME ,PRODUCT_PRICE ,PRODUCT_QTY FROM PRODUCT");

            rs = stmt.executeQuery();

            while (rs.next()) {
                product = new Products();
                country = new Country();
                product.setProductId(rs.getInt("PRODUCT_ID"));
                product.setProductName(rs.getString("PRODUCT_NAME"));
                product.setProductPrice(rs.getInt("PRODUCT_PRICE"));
                product.setProductQuantity(rs.getInt("PRODUCT_QTY"));
                
                al.add(product);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBManager.closeResultSet(rs);
            DBManager.closePreparedstatmen(stmt);
            DBManager.closeConnection(conn);
        }
        return al;

    }
}
