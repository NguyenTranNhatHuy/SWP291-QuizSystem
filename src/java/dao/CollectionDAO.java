package dao;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Collection;

public class CollectionDAO {

    static Connection conn;
    static PreparedStatement ps;
    static ResultSet rs;

    public static ArrayList<Collection> getListCollections() {
        try {
            String query = "select * from Collection";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            ArrayList<Collection> list = new ArrayList<>();
            while (rs.next()) {
                Collection a = new Collection(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                list.add(a);
            }
            return list;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public static void insertCollection(String username, String password, String email, String phone) {
        String query = "INSERT INTO Collection([username],[passwords],[email],[phone]) VALUES(?,?,?,?)";
        try {
            conn = new DBContext().getConnection();
            System.out.println(conn);
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, email);
            ps.setString(4, phone);
            ps.executeQuery();

        } catch (Exception e) {
        }
    }

    public static void deleteCollection(String id) {
        String query = "DELETE  FROM Collection  WHERE CollectionID =?";
        try {
            conn = new DBContext().getConnection();
            System.out.println(conn);
            ps = conn.prepareStatement(query);
            ps.setInt(1, Integer.parseInt(id));
            System.out.println("Thanh cong");
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public static Collection getCollection(String id) {
        String query = "select * from Collection where CollectionID=?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, Integer.parseInt(id));
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Collection(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
            }
        } catch (Exception e) {
            System.out.println("Hello");
        }
        return null;
    }

    public static Collection getCollectionByName(String name) {
        String query = "select * from Collection where Name = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Collection(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
            }
        } catch (Exception e) {
            System.out.println("Hello");
        }
        return null;
    }

    public static int checkName(String name) {
        String query = "select * from Collection where Name = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            rs = ps.executeQuery();
            while (rs.next()) {
                return 1;
            }
        } catch (Exception e) {
            return 1;
        }
        return 0;
    }

    public void updateCollection(int id, String username, String password, String email, String phone) {
        String query = "UPDATE Collection SET AccountID = ?, Name = ?, NumberOfQuestion = ? WHERE CollectionID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, email);
            ps.setString(4, phone);
            ps.setInt(5, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
//        System.out.println(getCollection("1").toString()); 
//        insertCollection("111","Nguyen Tien Thinh","111","111","111"); 
//        deleteCollection("3"); //Co loi o phan delete
//            System.out.println(getCollectionByName("admin").toString());
//            updateCollection(4,"Nguyen Tien Thinh","1","111","Nguyen Tien Thinh");
//            System.out.println(checkName("ABC"));
    }
}
