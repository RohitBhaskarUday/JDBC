###JDBC Overview

This guide outlines the basic steps to interact with a database using JDBC in Java.
##Load the Database Driver
The driver for your database must be loaded. Typically, this is done using the Class.forName() method. For example, to load the MySQL driver:

`Class.forName("com.mysql.cj.jdbc.Driver");`

Note that each database (MySQL, MariaDB, etc.) has its own driver, which must be included in the classpath before executing queries.

Driver Dependency
MySQL requires the MySQL Connector/J, while MariaDB has its own connector. These dependencies should be set up manually in your project. This approach falls under 1-Tier Architecture since everything is executed locally.

Establish a Connection
After loading the driver, create a connection to the database using the credentials of your database server:

`Connection connection = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/mydb", "username", "password");`

Execute Queries
Once the connection is established, you can execute SQL queries using different types of statements:

    Statement for general queries.
    PreparedStatement for precompiled queries, ideal for preventing SQL injection.
    CallableStatement for calling stored procedures.

Compile and Run Queries
Use the execute() or executeUpdate() methods to run your queries. For example:


`Statement stmt = connection.createStatement();
ResultSet rs = stmt.executeQuery("SELECT * FROM users");`

Close the Connection
It's important to close the connection after completing your operations to free up resources:


`connection.close();`
