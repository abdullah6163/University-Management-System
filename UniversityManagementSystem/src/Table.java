import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class Table extends Database{
    DefaultTableModel model;
    Table(String name){
        try {
            ResultSet resultSet = statement.executeQuery("select * from `" + name + "`;");
            model = new DefaultTableModel();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            for (int i = 1; i <= columnCount; i++) {
                model.addColumn(metaData.getColumnName(i));
            }

            while (resultSet.next()){
                Object[] row = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i-1] = resultSet.getObject(i);
                }
                model.addRow(row);
            }
        }catch (Exception es){
            System.out.println(es + " Table not created");
        }
    }
}
