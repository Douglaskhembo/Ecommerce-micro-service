-- Insert data into category table with correct sequence
INSERT INTO category (categ_id, name, description)
VALUES
    (nextval('category_seq'), 'Electronics', 'Devices and gadgets'),
    (nextval('category_seq'), 'Clothing', 'Apparel and garments'),
    (nextval('category_seq'), 'Furniture', 'Furniture for home and office'),
    (nextval('category_seq'), 'Books', 'Fiction, non-fiction, and academic books'),
    (nextval('category_seq'), 'Groceries', 'Food and kitchen supplies');
