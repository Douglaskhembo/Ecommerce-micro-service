INSERT INTO product (prd_id, name, description, available_quantity, price, category_id)
VALUES
    (nextval('product_seq'), 'Smartphone', 'Latest model with high-end features', 100, 799.99, 1501),
    (nextval('product_seq'), 'Laptop', 'High-performance laptop for gaming', 50, 1499.99, 1501),
    (nextval('product_seq'), 'T-Shirt', 'Comfortable cotton t-shirt', 200, 19.99, 1551),
    (nextval('product_seq'), 'Sofa', 'Modern design sofa for living room', 30, 599.99, 1601),
    (nextval('product_seq'), 'Fiction Book', 'Popular fiction novel', 150, 14.99, 1651),
    (nextval('product_seq'), 'Cereal', 'Healthy breakfast cereal', 500, 4.99, 1701);
