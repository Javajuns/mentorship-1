ALTER TABLE category ADD CONSTRAINT fk_parent_id
FOREIGN KEY (parentId)
REFERENCES public.category (id);