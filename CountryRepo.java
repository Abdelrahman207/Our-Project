
package com.store.dal.repo;

import com.store.dal.entity.Country;
import com.store.dal.entity.Products;
import com.store.dal.manager.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;


public class CountryRepo {
    public void insertProductCountry(Country country , Products product) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = DBManager.getConnection();
            stmt = conn.prepareStatement("INSERT INTO PRODUCT_COUNTRY (SEQ_ID , PRODUCT_ID_FK ,COUNTRY_NAME ,PRODUCT_MODEL ,PRODUCT_COUNTRY_QTY) VALUES (? , ? ,? ,? ,?)");

            stmt.setInt(1, country.getSeqId());
            stmt.setInt(2, product.getProductId());
            stmt.setString(3, country.getCountryName());
            stmt.setInt(4, country.getProductModel());
            stmt.setInt(5, country.getProductCountryQuantity());

            int r = stmt.executeUpdate();
            System.out.println(r);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBManager.closePreparedstatmen(stmt);
            DBManager.closeConnection(conn);
        }
    }

    public void deleteCountryByPK(Country country , Products product) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = DBManager.getConnection();
            stmt = conn.prepareStatement("DELETE FROM PRODUCT_COUNTRY WHERE SEQ_ID = ?");

            stmt.setInt(1, country.getSeqId());

            int r = stmt.executeUpdate();
            System.out.println(r);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBManager.closePreparedstatmen(stmt);
            DBManager.closeConnection(conn);
        }
    }
    public void updateRecord(Country country , Products product) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = DBManager.getConnection();
            stmt = conn.prepareStatement("UPDATE PRODUCT_COUNTRY set PRODUCT_ID_FK = ? , PRODUCT_MODEL = ? WHERE SEQ_ID = ?");
            stmt.setInt(1, product.getProductId());
            stmt.setInt(2, country.getProductModel());
            stmt.setInt(3, country.getSeqId());

            int r = stmt.executeUpdate();
            System.out.println(r);

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBManager.closePreparedstatmen(stmt);
            DBManager.closeConnection(conn);
        }
    }
}
