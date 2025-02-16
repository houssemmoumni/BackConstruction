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
                                        categorie_id INT,
                                        status ENUM('A_LOUER', 'DISPONIBLE', 'NON_DISPONIBLE'),
                                        FOREIGN KEY (categorie_id) REFERENCES category(id)
);