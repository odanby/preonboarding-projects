create table task_user (
					id serial primary key,
					first_name varchar(50),
					username varchar(50),
					user_password varchar(50),
					email varchar (50),
					zip_code varchar(5)
					);

create table notebook (
					notebook_id serial primary key,
					entry_title varchar(50),
					entry_date date,
					entry_content varchar(500),
					task_user_id int,
					constraint user_notebook_constraint
						foreign key(task_user_id)
						references task_user(id)
					);

create table task_category (
					category_id serial primary key,
					category_title varchar(50),
					task_user_id int,
					constraint user_category_constraint
						foreign key(task_user_id)
						references task_user(id)
					);
				
create table calendar (
					event_id serial primary key,
					event_title varchar(50),
					event_desc varchar(300),
					event_status char(1),
					event_start timestamp, 
					event_end timestamp,
					day_status char(1),
					task_user_id int,
					constraint user_calendar_constraint
						foreign key(task_user_id)
						references task_user(id)
					);

create table task_list (
					task_id serial primary key,
					task_desc varchar(300),
					task_frequency int,
					task_status char(1),
					task_user_id int,
					category_id int,
					constraint user_list_constraint
						foreign key(task_user_id)
						references task_user(id),
					constraint category_list_constraint
						foreign key(category_id)
						references task_category(category_id)
					);
				
--dummy data--

insert into task_user values (default,'Luca','lucatest','test123','luca@gmail.com','99950');
select * from task_user;

insert into notebook values (default, 'Test', '2023-01-19', 'I am testing my notebook table.', 1);
select * from notebook;

insert into task_category values (default, 'Test Category', 1);
select * from task_category;

insert into calendar values (default, 'Test Event', 'This is a test event.', 'N', '2023-01-19 08:00:00', '2023-01-19 09:00:00', 'N', 1);
select * from calendar;

insert into task_list values (default, 'Test Task', 2, 'N', 1, 1);
select * from task_list;