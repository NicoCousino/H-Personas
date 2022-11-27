create procedure getPersonasFiltro 
	@nombre varchar(50), 
	@edad int
as
	begin
		if @nombre ='' and @edad = -1
			begin
				select * from personas
			end
		else if @nombre=''
			begin
				select * from personas where edad = @edad
			end
		else if @edad = -1
			begin
				select * from personas where nombre = @nombre
			end
		else 
			begin
				select * from personas where nombre = @nombre and edad = @edad
			end
	end

execute getPersonasFiltro @nombre ='Jorge',@edad  = 20

select * from personas


select * from sysobjects where xtype = 'P'