create table article
(
    title             varchar(255) not null,
    author_first_name varchar(255) not null,
    author_last_name  varchar(255),
    id                bigint       not null
        constraint article_pk
            primary key,
    summary           varchar(140),
    content           varchar(2000),
    create_date       date,
    publish_date      date
);

alter table article
    owner to postgres;

INSERT INTO public.article (title, author_first_name, author_last_name, id, summary, content, create_date, publish_date) VALUES ('Test new Article 2', 'Tomasz', 'Buga', 29, 'Something about music', 'So I just wanted to say a few words', '2021-03-06', '2021-03-06');
INSERT INTO public.article (title, author_first_name, author_last_name, id, summary, content, create_date, publish_date) VALUES ('Test new Article 2', 'Tomasz', 'Buga', 54, 'Something about music', 'So I just wanted to say a few words: few words', '2021-05-18', null);
INSERT INTO public.article (title, author_first_name, author_last_name, id, summary, content, create_date, publish_date) VALUES ('Good article about something useful', 'Tomasz', 'Buga', 27, 'Test summary of the article to prove that it is being displayed.', '<p>Test article content<br>Something something else<br></p><p>I was today at the mall and it was great.</p> I tell you', '2021-03-06', '2021-03-06');
INSERT INTO public.article (title, author_first_name, author_last_name, id, summary, content, create_date, publish_date) VALUES ('Test Article for test purpose', 'Tomasz', 'Buga', 28, 'Test somethings<br><br>Testing more', '<p>Test article content<br>Something something else<br></p><p>I was today at the mall and it was great.</p><br>test', '2021-03-06', '2021-03-06');
INSERT INTO public.article (title, author_first_name, author_last_name, id, summary, content, create_date, publish_date) VALUES ('New article', 'Tomasz', 'Buga', 41, null, null, '2021-04-14', '2021-04-14');
INSERT INTO public.article (title, author_first_name, author_last_name, id, summary, content, create_date, publish_date) VALUES ('New article of the awesome something', 'Tomasz', 'Buga', 40, null, null, '2021-04-14', '2021-04-14');
INSERT INTO public.article (title, author_first_name, author_last_name, id, summary, content, create_date, publish_date) VALUES ('New Article 007', 'Tomasz', 'Buga', 46, 'Test summary', 'Test content', '2021-04-17', '2021-04-17');
INSERT INTO public.article (title, author_first_name, author_last_name, id, summary, content, create_date, publish_date) VALUES ('Testing new functionality', 'Tomasz', 'Buga', 39, 'sum', 'test', '2021-04-14', '2021-04-14');
INSERT INTO public.article (title, author_first_name, author_last_name, id, summary, content, create_date, publish_date) VALUES ('New Title', 'Tomasz', 'Buga', 44, 'Something amazing', 'Test<br><br>Of the breaks<br><br>Inside<br><br>Text', '2021-04-17', '2021-04-17');
INSERT INTO public.article (title, author_first_name, author_last_name, id, summary, content, create_date, publish_date) VALUES ('Nowy artykuł na dzień 2021-04-15', 'Tomasz', 'Buga', 42, 'test', 'test <br> testuję dalej <br> Tutaj moi drodzy jest więcej linijek po polsku<br><br>test', '2021-04-15', '2021-04-15');
INSERT INTO public.article (title, author_first_name, author_last_name, id, summary, content, create_date, publish_date) VALUES ('Nowy artukul', 'Tomasz', 'Buga', 43, 'Podsumowanue', 'Contwnt', '2021-04-17', '2021-04-17');
INSERT INTO public.article (title, author_first_name, author_last_name, id, summary, content, create_date, publish_date) VALUES ('New article about UX UI', 'Tomasz', 'Buga', 48, 'Testowy opis', 'Testowy content<br><br>z testowym textem', '2021-04-17', null);
INSERT INTO public.article (title, author_first_name, author_last_name, id, summary, content, create_date, publish_date) VALUES ('Testowy artykuł dot. backendu', 'Tomasz', 'Buga', 49, 'Podpis dotyczący backendu', 'Text dotyczący backendu', '2021-04-17', null);
INSERT INTO public.article (title, author_first_name, author_last_name, id, summary, content, create_date, publish_date) VALUES ('New article 2012121', 'Tomasz', 'Buga', 50, 'Test', 'Test', '2021-04-17', null);
INSERT INTO public.article (title, author_first_name, author_last_name, id, summary, content, create_date, publish_date) VALUES ('Something great and innovative', 'Tomasz', 'Buga', 51, null, null, '2021-05-03', null);
INSERT INTO public.article (title, author_first_name, author_last_name, id, summary, content, create_date, publish_date) VALUES ('testowy', 'Tomasz', 'Buga', 52, null, null, '2021-05-03', null);
INSERT INTO public.article (title, author_first_name, author_last_name, id, summary, content, create_date, publish_date) VALUES ('Test article', 'Tomasz', 'Buga', 53, null, null, '2021-05-17', null);
INSERT INTO public.article (title, author_first_name, author_last_name, id, summary, content, create_date, publish_date) VALUES ('New Article', 'Tomasz', 'Buga', 30, 'Test summary of the article to prove that it is being displayed.', '<p>Test article content<br>Something something else<br></p>', '2021-03-06', '2021-03-06');