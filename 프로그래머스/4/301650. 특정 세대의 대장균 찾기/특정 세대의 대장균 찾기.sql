select t.id
from ecoli_data f join ecoli_data s on f.id = s.parent_id
join ecoli_data t on s.id = t.parent_id
where f.parent_id is null
order by t.id;