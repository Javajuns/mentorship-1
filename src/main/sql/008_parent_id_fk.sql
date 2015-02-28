ALTER TABLE category ADD CONSTRAINT fk_parent_id
FOREIGN KEY (parent_id)
REFERENCES public.category (id);