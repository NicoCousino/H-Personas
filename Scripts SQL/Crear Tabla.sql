/*
create table personas 
(
	id_persona int not null identity,
	nombre varchar(50),
	apellido varchar(50),
	direccion varchar(100),
	edad int,
	fechaNacimiento date,
	constraint pk_personas primary key (id_persona)
)
*/


insert into personas values ('Roberto', 'Nafausti', 'Calle falsa 123', 40, '1-11-1999')
insert into personas values ('Jorge', 'Fernandez', 'Alem 423', 20, '4-8-2000')
insert into personas values ('Humberto', 'Diferze', 'Madariaga 7730', 10, '10-1-1996')
insert into personas values ('Luis', 'Chombi', 'Comechingones 143', 90, '10-9-1999')


select * from personas
