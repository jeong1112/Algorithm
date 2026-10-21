select year(e.differentiation_date) as YEAR, (m.size - e.size_of_colony) as YEAR_DEV, e.id
from ecoli_data e, (select max(e2.size_of_colony) size, year(differentiation_date) as y
                    from ecoli_data e2
                    group by year(differentiation_date)
                   ) m
where year(e.differentiation_date) = m.y
order by year(e.differentiation_date), YEAR_DEV;

