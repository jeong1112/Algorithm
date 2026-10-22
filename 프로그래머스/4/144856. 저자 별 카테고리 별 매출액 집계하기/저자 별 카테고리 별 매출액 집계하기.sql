select a.author_id, a.author_name, b.category, sum((b.price * s.sales)) as TOTAL_PRICE
from author a join book b on a.author_id = b.author_id join book_sales s on b.book_id = s.book_id
where year(s.sales_date) = '2022' and month(s.sales_date) = '1'
group by a.author_id, b.category
order by a.author_id, b.category desc;
