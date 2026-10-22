select i.food_type, i.rest_id, i.rest_name, i.favorites
from rest_info i
join (
    select i2.food_type, max(favorites) as max_f
    from rest_info i2
    group by i2.food_type
) j on j.food_type = i.food_type
where i.favorites = j.max_f
order by i.food_type desc;