INSERT INTO `ragency`.`company`
(`name`,
`contacts`)
VALUES
('Google', 'US, 1600 Amphitheatre Parkway, Mountain View, CA'),
('Yandex', 'Russia, 119021, Москва, ул. Льва Толстого, 16'),
('Газпром','Россия, Москва ....'),
('MediaMarkt','Russia, Moscow, Strioteley, 3');

INSERT INTO `ragency`.`lang`
(`langname`)
VALUES
('English'),('Русский'),('Deutsch'),('French'),('Chinese');

INSERT INTO `ragency`.`educationtype`
(`typename`)
VALUES
('Высшее'),('Высшее неоконченное'),('Средне-специальное'),('Среднее'),('Без образования');

INSERT INTO `ragency`.`post`
(`postname`)
VALUES
('Директор IT-отдела'),('Java-senior'),('Java-junior'),('C++-programmer'),('Designer');

INSERT INTO `ragency`.`skill`
(`skillname`)
VALUES
('STL'),('GlassFish'),('MSSQL'),('PostgreSQL'),('Perl');

INSERT INTO `ragency`.`specialization`
(`specname`)
VALUES
('Проектировщик БД'),('Веб-разработчик'),('Менеджер'),
('Рудодобывающая промышленность'),('Специалист по спорт-товарам'),('Археолог'),
('Архитектор'),('Программист, математик');
INSERT INTO `ragency`.`sphere`
(`spherename`)
VALUES
('Сфера обслуживания'),('IT-сфера'),('Менеджмент и управление'),('Наука и образование'),
('Бухгалтерия'),('Маркетинг'),('Строительство'),('Производство'),
('Банки'),('Транспорт'),('Туризм'),('Юриспруденция'),('Исскуство, медиа'),('Безопасность'),
('Добыча сырья'),('Страхование'),('Госслужба'),('Спорт, фитнес');

INSERT INTO `ragency`.`education`
(`studyplace`,
`idtype`,
`idspec`)
VALUES
('МГУ им. Ломоносова',1,8);









