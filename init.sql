BEGIN;

DROP TABLE IF EXISTS buyers CASCADE;
CREATE TABLE buyers (id bigserial PRIMARY KEY, name VARCHAR(255));
INSERT INTO buyers (name) VALUES
('Jone'),
('Mikl');

DROP TABLE IF EXISTS products CASCADE;
CREATE TABLE products (id bigserial PRIMARY KEY, name VARCHAR(255), cost double);
INSERT INTO products (name, cost) VALUES
('Car', 1000.00,
('Bike', 5.60);

DROP TABLE IF EXISTS buyer_products CASCADE;
CREATE TABLE buyer_products (buyer_id bigint, product_id bigint, FOREIGN KEY (buyer_id) REFERENCES buyers (id), FOREIGN KEY (product_id) REFERENCES products (id));
INSERT INTO buyer_products (book_id, product_id) VALUES
(1, 1),
(2, 1),
(1, 2),
(2, 2);

COMMIT;