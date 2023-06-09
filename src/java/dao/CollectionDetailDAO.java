/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBContext;
import static dao.QuestionDAO.conn;
import static dao.QuestionDAO.ps;
import static dao.QuestionDAO.rs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Account;
import model.CollectionDetail;

/**
 *
 * @author W
 */
public class CollectionDetailDAO {

    static Connection conn;
    static PreparedStatement ps;
    static ResultSet rs;

    public List<CollectionDetail> getAllCollectionDetail() {
        List<CollectionDetail> list = new ArrayList<>();

        String sql = "Select * From CollectionDetail";

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
//            PreparedStatement st = connection.prepareStatement(sql);
//            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                AccountDAO accDAO = new AccountDAO();
                Account acc = accDAO.getAccountById(rs.getString(3));
                CollectionDetail cd = new CollectionDetail(rs.getInt(1), rs.getString(2), acc);
                list.add(cd);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public CollectionDetail getCollectionDetailById(int id) {

        String sql = "Select * From CollectionDetail Where CollectionDetailID = " + id;

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                AccountDAO accDAO = new AccountDAO();
                Account acc = accDAO.getAccountById(rs.getString(3));
                CollectionDetail cd = new CollectionDetail(rs.getInt(1), rs.getString(2), acc);
                return cd;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public List<CollectionDetail> getCollectionDetailByOwner(Account account) {

        String sql = "Select * From CollectionDetail Where Owner = " + account.getId();
        List<CollectionDetail> list = new ArrayList<>();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                AccountDAO accDAO = new AccountDAO();
                Account acc = accDAO.getAccountById(rs.getString(3));
                CollectionDetail cd = new CollectionDetail(rs.getInt(1), rs.getString(2), acc);
                list.add(cd);
            }
        } catch (Exception e) {
        }
        return list;
    }
}
