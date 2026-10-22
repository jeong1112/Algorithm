select h.car_id,
case 
    when exists(
        select 1 
        from car_rental_company_rental_history h2
        where h2.car_id = h.car_id
        and h2.start_date <= '2022-10-16'
        and h2.end_date >= '2022-10-16'
    ) then '대여중'
    else '대여 가능'
    end as AVAILABILITY
from car_rental_company_rental_history h
group by h.car_id
order by h.car_id desc;