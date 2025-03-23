package com.dy.board;

import com.dy.board.persistence.migration.MigrationStrategy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

import static com.dy.board.persistence.config.ConnectionConfig.getConnection;

@SpringBootApplication
public class BoardApplication {

	public static void main(String[] args) throws SQLException {

		try(var connection = getConnection()){
			new MigrationStrategy(connection).executeMigration();
		}

		SpringApplication.run(BoardApplication.class, args);
	}

}
