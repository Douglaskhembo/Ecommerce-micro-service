-- Create category table
create table if not exists category
(
    categ_id integer not null primary key,  -- Primary key for category
    name varchar(255),
    description varchar(255)
);

-- Create product table
create table if not exists product
(
    prd_id integer not null primary key,    -- Primary key for product
    name varchar(255),
    description varchar(255),
    available_quantity double precision not null,
    price numeric(38,2),
    category_id integer
        constraint fk_em_prd_category references category -- Meaningful foreign key name
);

-- Sequence for category IDs
create sequence if not exists category_seq increment by 50;

-- Sequence for product IDs
create sequence if not exists product_seq increment by 50;