with recursive hours as(
    select 0 as hour
    
    union all
    
    select hour + 1
    from hours
    where hour < 23
)


select h.hour, count(a.datetime) as count
from animal_outs a right join hours h on hour(a.datetime) = h.hour
group by h.hour
order by h.hour;