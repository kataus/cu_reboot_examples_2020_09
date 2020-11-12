package ru.sbrf.cu.h2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.sbrf.cu.core.model.User;

public class H2demo {
  private static final String URL = "jdbc:h2:mem:";
  private static Logger logger = LoggerFactory.getLogger(H2demo.class);
  private final Connection connection;

  private H2demo() throws SQLException {
    this.connection = DriverManager.getConnection(URL);
    this.connection.setAutoCommit(false);
  }

  public static void main(String[] args) throws SQLException {
    H2demo demo = new H2demo();
    demo.createTable();
    int id = 1;
    demo.insertRecord(id);
    demo.selectRecord(id);
    demo.close();
  }

  private void createTable() throws SQLException {
    try (PreparedStatement pst = connection.prepareStatement("create table test(id int, name varchar(50))")) {
      pst.executeUpdate();
    }
  }

  private void insertRecord(int id) throws SQLException {
    try (PreparedStatement pst = connection.prepareStatement("insert into test(id, name) values (?, ?)")) {
      Savepoint savePoint = this.connection.setSavepoint("savePointName");
      pst.setInt(1, id);
      pst.setString(2, "NameValue");
      try {
        int rowCount = pst.executeUpdate(); //Блокирующий вызов
        this.connection.commit();
        logger.info("inserted rowCount: {}", rowCount);
      } catch (SQLException ex) {
        this.connection.rollback(savePoint);
        logger.error(ex.getMessage(), ex);
      }
    }
  }

  private void selectRecord(int id) throws SQLException {
    try (PreparedStatement pst
                 = this.connection.prepareStatement("select name from test where id  = ?")) {
      pst.setInt(1, id);
      try (ResultSet rs = pst.executeQuery()) {
        StringBuilder outString = new StringBuilder();
        outString.append("name:");
        if (rs.next()) {
          outString.append(rs.getString("name"));
        }
        logger.info(outString.toString());
      }
    }
  }

  private void close() throws SQLException {
    this.connection.close();
  }

  public Optional<User> getUser(int id) throws SQLException {
      Optional<User> result = Optional.empty();
      try (Connection connection = DriverManager.getConnection(URL);
        PreparedStatement ps
                = connection.prepareStatement("select id, name from users where id = ? and age > ?")){
        ps.setInt(1, id);
        ps.setInt(2, 30);
        try(ResultSet rs = ps.executeQuery()){
         if (rs.next()){
           int cur = rs.getInt("id");
           String name = rs.getString(2);
           result = Optional.of(new User(cur, name));
         }
        }
      }
      return result;
  }

  public Optional<User> updateUser(User user) throws SQLException {
    Optional<User> result = Optional.empty();
    try (Connection connection = DriverManager.getConnection(URL);
         PreparedStatement ps
                 = connection.prepareStatement("update ...id = ? and age > ?")){
      connection.setAutoCommit(false);
      ps.setInt(1, Math.toIntExact(user.getId()));
      ps.setInt(2, 30);
      int rs = ps.executeUpdate();
//      connection.r
    }
    return result;
  }


}
