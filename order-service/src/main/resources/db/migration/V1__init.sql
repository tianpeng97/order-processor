CREATE TABLE t_orders (
    id bigint GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    order_number TEXT DEFAULT NULL,
    sku_code TEXT,
    price NUMERIC(12, 2),
    quantity INT
);