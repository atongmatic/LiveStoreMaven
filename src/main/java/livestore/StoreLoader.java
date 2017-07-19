package livestore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StoreLoader {

    private String dbName;
    private String username;
    private String password;

    public StoreLoader(String dbName, String username, String password) {
        this.dbName = dbName;
        this.username = username;
        this.password = password;
    }

    public List<ItemDTO> LoadItems() {

        String mysqlJdbcUrl = "jdbc:mysql://localhost/" + dbName
                + "?user=" + username
                + "&password=" + password + "";

        Connection conn = null;
        
        ArrayList<ItemDTO> items = new ArrayList();

        try {
            // for H2 = Connection conn = dataSource.getConnection();
            conn = DriverManager.getConnection(mysqlJdbcUrl);

            PreparedStatement pstmt = conn.prepareStatement("Select id,type,size,color,price,cost from item");

            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
/*
                System.out.println(rs.getString("id"));
                System.out.println(rs.getString("type"));
                System.out.println(rs.getString("size"));
                System.out.println(rs.getString("color").charAt(0));
                System.out.println(rs.getString("price").charAt(0));
                System.out.println(rs.getString("cost"));
*/
                ItemDTO dto = new ItemDTO();
                dto.setType(rs.getString("type"));
                dto.setSize(rs.getString("size"));
                dto.setColor(rs.getString("color"));
                dto.setPrice(rs.getDouble("price"));
                dto.setCost(rs.getDouble("cost"));
                items.add(dto);
                System.out.println(" ============================= ");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
            }
        }
        return items;
    }
}
