import java.sql.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("Using MySQL!");

        String query;
        String url = "jdbc:mysql://localhost:3306/employees_database";

        CompleteTable ctable = new CompleteTable();

        // Mostar la tabla
        query = "SELECT * FROM employees_tbl";
        ctable.show(url,query);

        // Mostar la tabla por depto
        query = "SELECT * FROM employees_tbl where dept = 'Sales'";
        ctable.show(url,query);

        // Agregar un registro
        query = "Insert into employees_tbl values(800,'Fer','Legal',5500)";
        //ctable.agrega(url,query);

        // Actualizar un campo
        query = "Update employees_tbl set salary = 60 where id = 800";
        ctable.agrega(url,query);

        // delete a record
        query = "Delete from employees_tbl where id = 800";
        ctable.agrega(url,query);

        // create a new table
        query = "CREATE TABLE IF NOT EXISTS familia (id INT PRIMARY KEY, name VARCHAR(15), last VARCHAR(15), age INT)";
        ctable.agrega(url,query);
    }

}