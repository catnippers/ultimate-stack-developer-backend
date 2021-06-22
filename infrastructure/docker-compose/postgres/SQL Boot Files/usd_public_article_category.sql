create table article_category
(
    article_id  bigint not null
        constraint fkrw5912jiy0vyqoyqlo5r65igk
            references article,
    category_id bigint not null
        constraint fk855bhtvb75kxl2e0nmf2sd7la
            references category
);

alter table article_category
    owner to postgres;

INSERT INTO public.article_category (article_id, category_id) VALUES (27, 19);
INSERT INTO public.article_category (article_id, category_id) VALUES (27, 20);
INSERT INTO public.article_category (article_id, category_id) VALUES (27, 21);
INSERT INTO public.article_category (article_id, category_id) VALUES (28, 21);
INSERT INTO public.article_category (article_id, category_id) VALUES (28, 22);
INSERT INTO public.article_category (article_id, category_id) VALUES (28, 23);
INSERT INTO public.article_category (article_id, category_id) VALUES (29, 23);
INSERT INTO public.article_category (article_id, category_id) VALUES (29, 26);
INSERT INTO public.article_category (article_id, category_id) VALUES (29, 22);
INSERT INTO public.article_category (article_id, category_id) VALUES (29, 24);
INSERT INTO public.article_category (article_id, category_id) VALUES (39, 20);
INSERT INTO public.article_category (article_id, category_id) VALUES (39, 23);
INSERT INTO public.article_category (article_id, category_id) VALUES (39, 24);
INSERT INTO public.article_category (article_id, category_id) VALUES (39, 26);
INSERT INTO public.article_category (article_id, category_id) VALUES (40, 20);
INSERT INTO public.article_category (article_id, category_id) VALUES (40, 22);
INSERT INTO public.article_category (article_id, category_id) VALUES (40, 19);
INSERT INTO public.article_category (article_id, category_id) VALUES (41, 20);
INSERT INTO public.article_category (article_id, category_id) VALUES (41, 21);
INSERT INTO public.article_category (article_id, category_id) VALUES (41, 22);
INSERT INTO public.article_category (article_id, category_id) VALUES (30, 19);
INSERT INTO public.article_category (article_id, category_id) VALUES (30, 20);
INSERT INTO public.article_category (article_id, category_id) VALUES (42, 19);
INSERT INTO public.article_category (article_id, category_id) VALUES (42, 20);
INSERT INTO public.article_category (article_id, category_id) VALUES (42, 23);
INSERT INTO public.article_category (article_id, category_id) VALUES (43, 20);
INSERT INTO public.article_category (article_id, category_id) VALUES (43, 22);
INSERT INTO public.article_category (article_id, category_id) VALUES (43, 24);
INSERT INTO public.article_category (article_id, category_id) VALUES (44, 21);
INSERT INTO public.article_category (article_id, category_id) VALUES (44, 23);
INSERT INTO public.article_category (article_id, category_id) VALUES (46, 21);
INSERT INTO public.article_category (article_id, category_id) VALUES (46, 19);
INSERT INTO public.article_category (article_id, category_id) VALUES (48, 19);
INSERT INTO public.article_category (article_id, category_id) VALUES (48, 21);
INSERT INTO public.article_category (article_id, category_id) VALUES (49, 21);
INSERT INTO public.article_category (article_id, category_id) VALUES (50, 24);
INSERT INTO public.article_category (article_id, category_id) VALUES (50, 23);
INSERT INTO public.article_category (article_id, category_id) VALUES (50, 19);
INSERT INTO public.article_category (article_id, category_id) VALUES (51, 19);
INSERT INTO public.article_category (article_id, category_id) VALUES (52, 19);
INSERT INTO public.article_category (article_id, category_id) VALUES (52, 21);
INSERT INTO public.article_category (article_id, category_id) VALUES (53, 24);
INSERT INTO public.article_category (article_id, category_id) VALUES (54, 26);