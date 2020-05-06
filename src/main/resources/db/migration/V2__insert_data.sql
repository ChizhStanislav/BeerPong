INSERT INTO country (id,name_english, name_russian)
VALUES (1,'Беларусь','Беларусь'),
(2,'Russia', 'Россия');

INSERT INTO city (name_english, name_russian, country_id)
VALUES
('Minsk','Минск',1),
('Bobruisk', 'Бобруйск',1),
('Moscow', 'Москва',2),
('Saint Petersburg', 'Санкт Петербург',2);