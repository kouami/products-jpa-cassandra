CREATE TYPE product_key_space.product_details (
    sku text,
    productdesc text
);

CREATE TABLE product_key_space.products (
    id uuid PRIMARY KEY,
    name text,
    price double,
    product_details frozen<product_details>
);