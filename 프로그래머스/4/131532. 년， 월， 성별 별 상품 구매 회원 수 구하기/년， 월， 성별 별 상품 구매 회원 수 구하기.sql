select year(s.sales_date) as year, month(s.sales_date) as month, u.gender, count(distinct u.user_id) as users
from user_info u join online_sale s on u.user_id = s.user_id
group by year(s.sales_date), month(s.sales_date), u.gender
having u.gender is not null
order by year(s.sales_date), month(s.sales_date), u.gender;