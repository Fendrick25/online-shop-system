

CREATE OR REPLACE FUNCTION update_cart_subtotal()
    RETURNS TRIGGER
    LANGUAGE PLPGSQL
    AS
$$
BEGIN    
    UPDATE cart_item
    SET sub_total = pr.price * cart_item.quantity
    FROM cart_item as item
    JOIN products as pr ON pr.id = item.product_id
    WHERE pr.id = cart_item.product_id;
    
RETURN NEW;
END;
$$;


CREATE OR REPLACE FUNCTION update_cart_price()
    RETURNS TRIGGER
    LANGUAGE PLPGSQL
    AS
$$
BEGIN
    UPDATE carts
    SET price = subtotal
    FROM(
        SELECT cart_id, SUM(sub_total) as subtotal
        FROM cart_item
        JOIN carts ON carts.id = cart_item.cart_id
        WHERE cart_item.cart_id = carts.id
        GROUP BY cart_id
    )as t2
    WHERE t2.cart_id = carts.id;

RETURN NEW;
END;
$$;


CREATE OR REPLACE FUNCTION update_product_quantity()
    RETURNS TRIGGER
    LANGUAGE PLPGSQL
    AS

$$
BEGIN
    IF OLD.order_status = 'PENDING' AND NEW.order_status = 'PAID' THEN
    UPDATE products
    SET quantity = quantity - buyAmount
    FROM(
        SELECT product_id, order_items.quantity AS buyAmount
        FROM order_items
        JOIN products ON products.id = order_items.product_id
        WHERE products.id = order_items.product_id
    )as t2
    WHERE t2.product_id = products.id;
    END IF;

RETURN NEW;
END;
$$;


CREATE OR REPLACE FUNCTION update_product_rating()
    RETURNS TRIGGER
    LANGUAGE PLPGSQL
    AS
$$
BEGIN
    UPDATE products
    SET rating = avgRating
    FROM (
        SELECT product_id, ROUND(AVG(ALL product_ratings.rating), 1) as avgRating
        FROM product_ratings
        JOIN products ON products.id = product_ratings.product_id
        WHERE products.id = product_ratings.product_id
        GROUP BY product_id
    )as t2
    WHERE t2.product_id = products.id;
RETURN NEW;
END;
$$;


CREATE TRIGGER update_cart_subtotal
    AFTER UPDATE ON products
    FOR EACH ROW
EXECUTE PROCEDURE update_cart_subtotal();


CREATE TRIGGER update_cart_price
AFTER UPDATE OF sub_total ON cart_item
FOR EACH ROW
EXECUTE PROCEDURE update_cart_price();


CREATE TRIGGER update_product_quantity
AFTER UPDATE OF order_status on orders
FOR EACH ROW
EXECUTE PROCEDURE update_product_quantity();


CREATE TRIGGER update_product_rating
AFTER INSERT OR UPDATE ON product_ratings
FOR EACH ROW
EXECUTE PROCEDURE update_product_rating();