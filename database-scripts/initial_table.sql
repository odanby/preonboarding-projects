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

insert into stocks values (-1, 'Krolmeister', 'KROL', 'If you can think of it, we already built it.', 
'C:\Users\orian\preonboarding-projects\krol.jpg', 50, 100, 5000);

select * from stocks;