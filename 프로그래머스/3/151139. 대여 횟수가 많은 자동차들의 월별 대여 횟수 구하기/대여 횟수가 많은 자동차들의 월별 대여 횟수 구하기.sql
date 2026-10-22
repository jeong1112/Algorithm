select month(start_date) as month, car_id, count(*) as records
from car_rental_company_rental_history
where month(start_date) between 8 and 10 and year(start_date) = '2022'
and car_id in(
    select car_id
    from car_rental_company_rental_history
    where month(start_date) between 8 and 10 and year(start_date) = '2022'
    group by car_id
    having count(*) >= 5
)
group by month(start_date), car_id
order by month(start_date), car_id desc;