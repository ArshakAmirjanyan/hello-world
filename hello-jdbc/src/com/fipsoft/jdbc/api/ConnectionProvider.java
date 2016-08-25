package com.fipsoft.jdbc.api;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by aamirjanyan on 6/27/16.
 */
public interface ConnectionProvider {

    Connection getConnection();
}
