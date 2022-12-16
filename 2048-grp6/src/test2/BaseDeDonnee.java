/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test2;


import java.sql.;

public class BaseDeDonnee {

  public static void main(String args[])
  {
    try
    {
        // 
      Class.forName("com.mysql.jdbc.Driver");
      Connection conn = DriverManager.getConnection(
      "jdbc:mysql://localhost/phpmyadmin/index.php?route=/database/structure&server=1&db=2048", "root", "");
      Statement stmt = conn.createStatement();
      System.out.println("Insertion...");



      System.out.println("Données insérés dans la table...");
      conn.close();
    }
    catch(Exception e){ 
      System.out.println(e);
    }
  }
}