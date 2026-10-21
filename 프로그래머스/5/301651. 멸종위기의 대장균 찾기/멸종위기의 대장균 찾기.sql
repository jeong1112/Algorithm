-- 세대 별 자식이 없는 개체의 수와 세대를 출력
with recursive gen
as(
    select id, parent_id, 1 as generation
    from ecoli_data
    where parent_id is null
    
    union all
    
    select p.id, p.parent_id, g.generation + 1
    from ecoli_data p join gen g on g.id = p.parent_id
)

select count(*) as COUNT, g.generation
from gen g
where not exists(select 1 from ecoli_data e where e.parent_id = g.id)
group by g.generation
order by g.generation;
