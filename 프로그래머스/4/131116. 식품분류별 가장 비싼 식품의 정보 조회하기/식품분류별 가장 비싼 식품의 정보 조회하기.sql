select p1.category, p1.price, product_name
from food_product p1 join (
    select category, max(price) as max_price
    from food_product p2
    where p2.category in ('과자', '국', '김치', '식용유')
    group by p2.category
) j on p1.category = j.category
where p1.price = j.max_price
order by p1.price desc;
