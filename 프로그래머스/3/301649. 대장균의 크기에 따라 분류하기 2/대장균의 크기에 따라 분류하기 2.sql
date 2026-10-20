select id, 
        case
            when grade = 1 then 'CRITICAL'
            when grade = 2 then 'HIGH'
            when grade = 3 then 'MEDIUM'
            when grade = 4 then 'LOW'
            end as colony_name
from (
    select id, ntile(4) over (order by size_of_colony desc) as grade
    from ecoli_data
) e
order by id;
