package DataAccessLayer;

import com.mysql.cj.xdevapi.Statement;
import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DataAccess {

    private static DataAccess instance;
    private Connection con = null;
    private java.sql.Statement statement;
    private ResultSet resultSet;

    private DataAccess() {
    }

    public static DataAccess Instance() {
        if (instance == null) {
            instance = new DataAccess();
        }
        return instance;
    }

    public void conectarDB() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/farmaciasdb1", "fdb", "pvj86cX258.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la conexión: " + e.getMessage());
        }
    }

    private void DesconectarDB() {
        try {
            statement.close();
            resultSet.close();
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la desconexión: " + e.getMessage());

        }
    }
    public boolean isCellEditable(int row, int column) {
            return false;
        }
    
    public DefaultTableModel Query(String query) {
        try {
            conectarDB();
            statement = con.createStatement();
            resultSet = statement.executeQuery(query);
            Vector<String> columnNames = new Vector<String>();
            int columnCount = resultSet.getMetaData().getColumnCount();
            for (int column = 1; column <= columnCount; column++) {
                columnNames.add(resultSet.getMetaData().getColumnName(column));
                
            }
            Vector<Vector<Object>> data = new Vector<Vector<Object>>();
            while (resultSet.next()) {
                Vector<Object> vector = new Vector<Object>();
                for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                    vector.add(resultSet.getObject(columnIndex));
                }
                data.add(vector);
            }
            return new DefaultTableModel(data, columnNames){
            public boolean isCellEditable(int row, int column) { 
                return false;
            }
            };
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la consulta: " + e.getMessage());
            return null;
        } finally {
            
            DesconectarDB();
        }
        
    }

    public int Execute(String query) {
        try {
            conectarDB();
            statement = con.createStatement();
            return statement.executeUpdate(query);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en el comando: " + e.getMessage());
            return 0;
        } finally {
            DesconectarDB();
        }
    }
}
