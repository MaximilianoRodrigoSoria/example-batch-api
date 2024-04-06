package ar.com.laboratory.examplebatchapi.batch.readers;

import ar.com.laboratory.examplebatchapi.models.entities.Product;
import lombok.AllArgsConstructor;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

@AllArgsConstructor
@Component
public class DataBaseReader {

    private DataSource dataSource;


    @Bean
    public JdbcCursorItemReader<Product> reader() {
        JdbcCursorItemReader<Product> reader = new JdbcCursorItemReader<>();
        reader.setDataSource(dataSource);
        reader.setSql("SELECT id, category, name, price, stock FROM product_scheme.products");
        reader.setRowMapper(new RowMapper<Product>() {
                                @Override
                                public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
                                    Product product = new Product();
                                    product.setId(rs.getLong("id"));
                                    product.setCategory(rs.getInt("category"));
                                    product.setName(rs.getString("name"));
                                    product.setStock(rs.getInt("stock"));
                                    product.setPrice(rs.getDouble("price"));
                                    return product;
                                }
                            }
        );
        return reader;
    }
}
