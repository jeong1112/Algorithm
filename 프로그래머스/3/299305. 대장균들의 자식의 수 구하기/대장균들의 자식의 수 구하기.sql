select parent.id, count(child.id) as child_count
from ecoli_data parent left join ecoli_data child on parent.id = child.parent_id
group by parent.id
order by parent.id