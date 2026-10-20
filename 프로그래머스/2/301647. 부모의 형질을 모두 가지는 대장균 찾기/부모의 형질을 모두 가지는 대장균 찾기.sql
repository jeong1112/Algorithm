select child.id, child.genotype, parent.genotype
from ecoli_data parent join ecoli_data child on parent.id = child.parent_id
where child.genotype & parent.genotype = parent.genotype
order by id;