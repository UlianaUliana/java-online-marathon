//Develop a database with tables Roles, Employee, Directions and Projects.
//The Roles table contains the id (primary key), roleName.
//The Directions table contains the id (primary key), directionName.
//The Projects table contains id (primary key), projectName, directionId (foreign key).
//The Employee table contains id (primary key), firstName, roleId (foreign key), projectId (foreign key).
//
//
//Create next methods of the MyUtils class.
//public Connection createConnection() throws SQLException
//public void closeConnection() throws SQLException
//public Statement createStatement() throws SQLException
//public void closeStatement() throws SQLException
//public void createSchema(String schemaName) throws SQLException
//public void dropSchema() throws SQLException
//public void useSchema() throws SQLException
//
//Methods for creating tables
//public void createTableRoles() throws SQLException
//public void createTableDirections() throws SQLException
//public void createTableProjects() throws SQLException
//public void createTableEmployee() throws SQLException
//public void dropTable(String tableName) throws SQLException
//
//Methods for insert data to tables
//public void insertTableRoles(String roleName) throws SQLException
//public void insertTableDirections(String directionName) throws SQLException
//public void insertTableProjects(String projectName, String directionName) throws SQLException
//public void insertTableEmployee(String firstName, String roleName, String projectName) throws SQLException
//
//Methods to obtaining data from tables
//public int getRoleId(String roleName) throws SQLException
//public int getDirectionId(String directionName) throws SQLException
//public int getProjectId(String projectName) throws SQLException
//public int getEmployeeId(String firstName) throws SQLException
//public List<String> getAllRoles() throws SQLException
//public List<String> getAllDirestion() throws SQLException
//public List<String> getAllProjects() throws SQLException
//public List<String> getAllEmployee() throws SQLException
//public List<String> getAllDevelopers() throws SQLException
//public List<String> getAllJavaProjects() throws SQLException
//public List<String> getAllJavaDevelopers() throws SQLException
//
//For example, for a given data
//
//
//you should get by method getAllJavaDevelopers()
//[Ira, Ivan, Petro].

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MyUtils {
    private Connection connection;
    private Statement statement;
    private String schemaName;

    public Connection createConnection() throws SQLException {
        DriverManager.registerDriver(new org.h2.Driver());
        connection = DriverManager.getConnection("jdbc:h2:mem:test", "", "");
        return connection;
    }
    public void closeConnection() throws SQLException {
        connection.close();
    }
    public Statement createStatement() throws SQLException {
        statement = connection.createStatement();
        return statement;
    }
    public void closeStatement() throws SQLException {
        statement.close();
    }
    public void createSchema(String schemaName) throws SQLException {
        this.schemaName = schemaName;
        String sql = "CREATE SCHEMA IF NOT EXISTS " + schemaName + ";";
        statement.executeUpdate(sql);
    }
    public void dropSchema() throws SQLException {
        String sql = "DROP SCHEMA " + schemaName;
        statement.executeUpdate(sql);
    }
    public void useSchema() throws SQLException {
        statement.execute("USE " + schemaName + ";");
    }
    public void createTableRoles() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS Roles " +
                        "(id INTEGER NOT NULL AUTO_INCREMENT, " +
                        "roleName VARCHAR(20) NOT NULL, " +
                        "PRIMARY KEY (id));";
        statement.executeUpdate(sql);
    }
    public void createTableDirections() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS Directions " +
                "(id INTEGER NOT NULL AUTO_INCREMENT, " +
                "directionName VARCHAR NOT NULL, " +
                "PRIMARY KEY (id));";
        statement.executeUpdate(sql);
    }
    public void createTableProjects() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS Projects " +
                "(id INTEGER NOT NULL AUTO_INCREMENT, " +
                "projectName VARCHAR NOT NULL, " +
                "directionId INTEGER, " +
                "PRIMARY KEY (id), " +
                "FOREIGN KEY (directionId) REFERENCES Directions(id));";
        statement.executeUpdate(sql);
    }
    public void createTableEmployee() throws SQLException {
        String sql = "CREATE TABLE Employee " +
                "(id INTEGER NOT NULL AUTO_INCREMENT, " +
                "firstName VARCHAR NOT NULL, " +
                "roleId INTEGER NOT NULL, " +
                "PRIMARY KEY (id), " +
                "projectId INTEGER, " +
                "FOREIGN KEY (roleId) REFERENCES Roles(id), " +
                "FOREIGN KEY (projectId) REFERENCES Projects(id));";
        statement.executeUpdate(sql);
    }
    public void dropTable(String tableName) throws SQLException {
        statement.executeUpdate("DROP TABLE " + tableName + ";");
    }
    
    public void insertTableRoles(String roleName) throws SQLException {
        String sql = "INSERT INTO Roles (roleName) " +
                "VALUES ('" + roleName + "');";
        statement.executeUpdate(sql);
    }
    public void insertTableDirections(String directionName) throws SQLException {
        String sql = "INSERT INTO Directions (directionName) " +
                "VALUES ('" + directionName + "');";
        statement.executeUpdate(sql);
    }
    public void insertTableProjects(String projectName, String directionName) throws SQLException {
        int directionId = getDirectionId(directionName);
        String sql = "INSERT INTO Projects (projectName, directionId) " +
                "VALUES ('" + projectName + "', " + directionId + ");";
        statement.executeUpdate(sql);
    }
    public void insertTableEmployee(String firstName, String roleName, String projectName) throws SQLException {
        int roleId = getRoleId(roleName);
        int projectId = getProjectId(projectName);
        String sql = "INSERT INTO Employee (firstName, roleId, projectId) " +
                "VALUES ('" + firstName + "', " + roleId + ", " + projectId + ");";
        statement.executeUpdate(sql);
    }
    public int getRoleId(String roleName) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT id FROM Roles WHERE roleName='" + roleName + "';");
        int result =-1;
        if (resultSet.next()) {
            result = resultSet.getInt(1);
        }
        resultSet.close();
        return result;
    }
    public int getDirectionId(String directionName) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT id FROM Directions WHERE directionName='" + directionName + "';");
        int result =-1;
        if (resultSet.next()) {
            result = resultSet.getInt(1);
        }
        resultSet.close();
        return result;
    }
    public int getProjectId(String projectName) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT id FROM Projects WHERE projectName='" + projectName + "';");
        int result =-1;
        if (resultSet.next()) {
            result = resultSet.getInt(1);
        }
        resultSet.close();
        return result;
    }
    public int getEmployeeId(String firstName) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT id FROM Employee WHERE firstName='" + firstName + "';");
        int result =-1;
        if (resultSet.next()) {
            result = resultSet.getInt(1);
        }
        resultSet.close();
        return result;
    }
    public List<String> getAllRoles() throws SQLException {
        List<String> roles = new ArrayList<String>();
        String sql = "SELECT roleName FROM Roles;";
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
            roles.add(resultSet.getString(1));
        }
        return roles;
    }
    public List<String> getAllDirestion() throws SQLException {
        List<String> directions = new ArrayList<String>();
        String sql = "SELECT directionName FROM Directions;";
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
            directions.add(resultSet.getString(1));
        }
        return directions;
    }
    public List<String> getAllProjects() throws SQLException {
        List<String> projects = new ArrayList<String>();
        String sql = "SELECT projectName FROM Projects;";
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
            projects.add(resultSet.getString(1));
        }
        return projects;
    }
    public List<String> getAllEmployee() throws SQLException {
        List<String> employees = new ArrayList<String>();
        String sql = "SELECT firstName FROM Employee;";
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
            employees.add(resultSet.getString(1));
        }
        return employees;
    }
    public List<String> getAllDevelopers() throws SQLException {
        List<String> developers = new ArrayList<String>();
        String sql = "SELECT firstName FROM Employee WHERE roleId = 1;";
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
            developers.add(resultSet.getString(1));
        }
        return developers;
    }
    public List<String> getAllJavaProjects() throws SQLException {
        List<String> javaProjects = new ArrayList<String>();
        String sql = "SELECT projectName FROM Projects WHERE directionId = 1;";
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
            javaProjects.add(resultSet.getString(1));
        }
        return javaProjects;
    }
    public List<String> getAllJavaDevelopers() throws SQLException {
        List<String> javaDevelopers = new ArrayList<String>();
        String sql = "SELECT firstName FROM Employee WHERE roleId = 1 AND projectId IN (1, 2);";
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
            javaDevelopers.add(resultSet.getString(1));
        }
        return javaDevelopers;
    }

}
