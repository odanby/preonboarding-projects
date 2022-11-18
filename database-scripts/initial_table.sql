create table stocks (
	id serial primary key, -- serials sets the column so it auto increments, primary key adds the unique id
	company_name varchar(50),
	ticker varchar(4),
	description varchar(300),
	image_url varchar(500),
	amount_stocks integer,
	price_per_stock integer,
	market_cap integer
);

delete from stocks where id = -1;

insert into stocks values (1, 'Krolmeister', 'KROL', 'If you can think of it, we already built it.', 
'C:\Users\orian\preonboarding-projects\\krol.jpg', 50, 100, 5000);

insert into stocks values (2, 'Big Kahuna Burger', 'BGKH', 'No, we do not codone crime.', 
'C:\Users\orian\preonboarding-projects\database-scripts\images\bgkh.jpg', 15, 40, 600);

insert into stocks values (3, 'Bluth Company', 'BLTH', 'These houses are totally well-built and safe.', 
'C:\Users\orian\preonboarding-projects\database-scripts\images\blth.jpg', 100, 70, 7000);

insert into stocks values (4, 'The Drunken Clam', 'DKCL', 'Iii1 am NTO drunk!', 
'C:\Users\orian\preonboarding-projects\database-scripts\images\dkcl.jpg', 150, 15, 2250);

insert into stocks values (5, 'Dunder Mifflin', 'DRMF', 'The best mid-sized company for all your paper needs.', 
'C:\Users\orian\preonboarding-projects\database-scripts\images\drmf.jpg', 400, 300, 120000);

insert into stocks values (6, 'Gringotts', 'GRGT', 'The trustiest place to store all your secrets.', 
'C:\Users\orian\preonboarding-projects\database-scripts\images\grgt.jpg', 600, 550, 330000);

insert into stocks values (7, 'iCarly', 'ICLY', 'In 3...2...', 
'C:\Users\orian\preonboarding-projects\database-scripts\images\icly.jpg', 500, 5, 2500);

insert into stocks values (8, 'The Krusty Krab', 'KRKB', 'The BEST burger you''ll find under the sea.', 
'C:\Users\orian\preonboarding-projects\database-scripts\images\krkb.jpg', 100, 30, 300);

insert into stocks values (9, 'Men in Black', 'MNBK', 'You didn''t see anything.', 
'C:\Users\orian\preonboarding-projects\database-scripts\images\mnbk.jpg', 25, 700, 17500);

insert into stocks values (10, 'Monsters Inc.', 'MSTR', 'BOO!', 
'C:\Users\orian\preonboarding-projects\database-scripts\images\mstr.jpg', 100, 90, 9000);

insert into stocks values (11, 'Los Pollos Hermanos', 'PLLO', 'The freshest and most delicious chicken of the Southwest.', 
'C:\Users\orian\preonboarding-projects\database-scripts\images\pllo.jpg', 70, 425, 29750);

insert into stocks values (12, 'Umbrella Corporation', 'UMBR', 'We are definitely not evil.', 
'C:\Users\orian\preonboarding-projects\database-scripts\images\umbr.jpg', 60, 460, 27600);

insert into stocks values (13, 'Willy Wonka and the Chocolate Factory', 'WYWK', 'We bring out the child in everyone.', 
'C:\Users\orian\preonboarding-projects\database-scripts\images\wywk.jpg', 5, 200, 1000);

select * from stocks;