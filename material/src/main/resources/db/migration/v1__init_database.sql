USE material;

CREATE TABLE IF NOT EXISTS category (
                                        id INT AUTO_INCREMENT PRIMARY KEY,
                                        description VARCHAR(255),
                                        name VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS material (
                                        id INT AUTO_INCREMENT PRIMARY KEY,
                                        name VARCHAR(255),
                                        description VARCHAR(255),
                                        available_quantity DOUBLE NOT NULL,
                                        price DECIMAL(38, 2),
                                        category_id INT,  -- Make sure this column matches the field name in the entity
                                        status ENUM('A_LOUER', 'DISPONIBLE', 'NON_DISPONIBLE'),
                                        FOREIGN KEY (category_id) REFERENCES category(id)
);
