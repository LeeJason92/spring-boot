CREATE TABLE product (
    product_id BIGSERIAL PRIMARY KEY NOT NULL,
    product_name VARCHAR(255) NOT NULL DEFAULT '',
    product_desc TEXT NOT NULL DEFAULT '',
    product_price DECIMAL(10,2) NOT NULL DEFAULT 0,
    product_stock INT NOT NULL DEFAULT 0,
    product_gram_weight DECIMAL(10,2) NOT NULL DEFAULT 0,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE category (
    category_id BIGSERIAL PRIMARY KEY NOT NULL,
    category_name VARCHAR(255) NOT NULL DEFAULT '',
    category_desc TEXT NOT NULL DEFAULT '',
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE product_category (
    product_id BIGSERIAL NOT NULL,
    category_id BIGSERIAL NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY(product_id, category_id),
    FOREIGN KEY(product_id) REFERENCES product(product_id),
    FOREIGN KEY(category_id) REFERENCES category(category_id)
);

CREATE INDEX idx_product_name ON product(product_name);
CREATE INDEX idx_category_name ON category(category_name);