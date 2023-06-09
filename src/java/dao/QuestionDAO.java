/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Account;
import model.Question;

/**
 *
 * @author W
 */
public class QuestionDAO {

    static Connection conn;
    static PreparedStatement ps;
    static ResultSet rs;

    public ArrayList<Question> getListQuestions() {
        try {
            String query = "select * from Question";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            ArrayList<Question> list = new ArrayList<>();
            while (rs.next()) {
                Question q = new Question(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                list.add(q);
            }
            return list;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public int lastPagesP(int size, int id) {
        int lastPages = 0;
        String createQuery = "select count(*) from collection where CollectionDetailID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(createQuery);
            rs = ps.executeQuery();
            ps.setInt(1, id);
            while (rs.next()) {
                int total = rs.getInt(1);
                lastPages = total / size;

                if (total % size != 0) {
                    lastPages++;
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return lastPages;
    }

    public Question getQuestionById(int id) {
        String sql = "Select * From Question Where QuestionId = ?";

        try {
//            PreparedStatement st = connection.prepareStatement(sql);
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Question question = new Question(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)
                );
                return question;
            }
        } catch (Exception e) {
        }
        return null;
    }
}
