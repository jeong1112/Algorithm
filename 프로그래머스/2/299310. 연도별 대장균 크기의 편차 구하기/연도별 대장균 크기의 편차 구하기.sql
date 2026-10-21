select year(e.differentiation_date) as YEAR, max(size_of_colony) over(partition by year(e.differentiation_date)) - e.size_of_colony as YEAR_DEV, e.id
from ecoli_data e
order by year(e.differentiation_date), YEAR_DEV;

