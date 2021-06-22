create table category
(
    id    bigint       not null
        constraint category_pk
            primary key,
    title varchar(255) not null,
    tag   varchar(2)   not null
);

alter table category
    owner to postgres;

INSERT INTO public.category (id, title, tag) VALUES (19, 'UX/UI', 'UX');
INSERT INTO public.category (id, title, tag) VALUES (21, 'Backend', 'BE');
INSERT INTO public.category (id, title, tag) VALUES (23, 'Dev Ops', 'DO');
INSERT INTO public.category (id, title, tag) VALUES (24, 'Quality Assurance', 'QA');
INSERT INTO public.category (id, title, tag) VALUES (25, 'Game Dev', 'GD');
INSERT INTO public.category (id, title, tag) VALUES (26, 'Art & Culture', 'AC');
INSERT INTO public.category (id, title, tag) VALUES (20, 'Business Analysis', 'BA');
INSERT INTO public.category (id, title, tag) VALUES (22, 'Frontend', 'FE');