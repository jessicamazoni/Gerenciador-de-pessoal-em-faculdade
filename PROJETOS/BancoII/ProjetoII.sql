CREATE DATABASE GERENCIADOR_P
GO
USE GERENCIADOR_P
GO

--CRIAÇÃO DE TABELAS
create table unieuro(
campus int not null constraint pk_campus primary key identity,
local varchar(35)not null,
reitor varchar(40)not null
)
go
create table curso(
idcurso bigint not null constraint pk_curso primary key identity,
nome varchar(30)not null unique,
semestre int not null,
valor float not null
)
go
create table usuario(
id int not null identity primary key,
tipo varchar(20)not null,
login varchar(20)not null,
senha varchar(20)not null
)
go
create table aluno(
idalu bigint not null constraint pk_alu primary key identity,
nome varchar(50)not null,
sexo char(1) not null check(sexo in('M','F')),
data_nasc date,
rg bigint unique,
id_curso bigint not null,
endereco varchar(45)not null,
id_cam_alu int not null,
constraint fk_aluno_curso
foreign key(id_curso)references curso(idcurso),
constraint fk_aluno_unieuro
foreign key(id_cam_alu)references unieuro(campus)
)
Go
create table salario(
idsal int not null constraint pk_salario primary key identity,
valor float not null
)
Go
create table profissao(
idProf int not null constraint pk_profissao primary key identity,
nome varchar(20) not null unique,
id_sal int not null,
constraint fk_prof_sal
foreign key(id_sal)references salario(idsal)
)
Go
create table funcionario(
idFun bigint not null constraint pk_funcionario primary key identity,
nome varchar(40)not null,
data_nasc date not null,
sexo char(1)not null check(sexo in('F','M')),
rg bigint not null,
endereco varchar(45)not null,
id_prof int not null,
id_campus int not null,
constraint fk_func_prof
foreign key(id_prof)references profissao(idProf),
constraint fk_func_campus
foreign key(id_campus)references unieuro(campus)
)
Go
create table disciplina(
idDis int not null constraint pk_discip primary key identity,
nome varchar(25)not null,
id_cur bigint not null,
id_fun bigint not null,
constraint fk_disc_curso
foreign key(id_cur)references curso(idcurso),
constraint fk_disc_fun
foreign key(id_fun)references funcionario(idFun)
)
Go
--INSERÇÕES
--CURSO
insert into curso values('Engenharia Civil',8,40.999)
insert into curso values('Direito',10,78.557)
insert into curso values('Educação fisíca',4,29.998)
insert into curso values('Enfermagem',5,55.555)
insert into curso values('Administração',3,30.210)
go
--UNIEURO
insert into unieuro values('Águas Claras','João Doidão')
go
--ALUNO
insert into aluno values('Emilio M.','M','1996/10/16',43534533,2,'Vicente Pires',1)
insert into aluno values('Didi nobre.','M','1990/09/06',46464564,3,'Guara',1)
insert into aluno values('Ratinha.','F','1946/11/07',4467456,4,'Sobradinho',1)
insert into aluno values('Maria','F','1992/12/01',5757565,5,'Taguatinga',1)
insert into aluno values('Godzzzila','M','1990/01/19',2423422,1,'Águas Claras',1)
go
--SALARIO
insert into salario values(2000)
insert into salario values(5000)
insert into salario values(2500)
insert into salario values(3500)
insert into salario values(10000)
insert into salario values(7600)
insert into salario values(12000)
insert into salario values(20000)
insert into salario values(1000000)
go
--PROFISSAO
insert into profissao values('Professor',1)
insert into profissao values('Porteiro',2)
insert into profissao values('Atendente',3)
insert into profissao values('Reitor',4)
insert into profissao values('Coordenador',5)
insert into profissao values('Faxineiro',6)
go
--FUNCIONARIO
insert into funcionario values('Persival J.','1970/08/08','M',34534534,'Park
Way',1,1)
insert into funcionario values('Fábio M.','1980/10/18','M',397634534,'Guara',2,1)
insert into funcionario values('Goibinha.','1990/12/07','M',3999834534,'Vicente
Pires',3,1)
insert into funcionario values('Alexia.','1980/08/01','M',397634534,'Santo
Antonio',4,1)
insert into funcionario values('FErnanda.','1980/02/05','M',309834534,'Recanto das
Emas',5,1)
insert into funcionario values('Larah.','1980/01/06','M',399984534,'Sobradinho',6,1)
insert into funcionario values('Didi.','1956/11/08','M',900034534,'Guara',1,1)
go
--DISCIPLINA
insert into disciplina values('Banco de Dados',1,1)
insert into disciplina values('Primeiros Socorros',3,7)
insert into disciplina values('Finanças',5,1)
insert into disciplina values('Legislação',2,7)
go
--USUÁRIO
insert into usuario values('Professor',1,1234)
insert into usuario values('Atendente',2,0098)
go
--SELECT

select a.nome as Aluno,d.nome as Materia,c.nome as Curso from aluno a
join curso c
on a.id_curso = c.idcurso
join disciplina d
on d.id_cur = c.idcurso
where c.nome = 'Direito'
go

select a.nome as Aluno,d.nome as Materia,c.nome as Curso from aluno a
join curso c
on a.id_curso = c.idcurso
join disciplina d
on d.id_cur = c.idcurso
where c.nome = 'Educação fisíca';
go


select f.nome as Funcionario,p.nome as Profissão, s.valor as Salario
from funcionario f
join profissao p
on f.id_prof = p.idProf
join salario s
on s.idsal = p.id_sal
where endereco = 'Guara'
go

select f.nome as Funcionario,p.nome as Profissão, s.valor as Salario
from funcionario f
join profissao p
on f.id_prof = p.idProf
join salario s
on s.idsal = p.id_sal
where endereco = 'Sobradinho'
go

--UPDATE
update aluno set nome = 'Maria' where idalu = 1
update aluno set endereco = 'Candangolândia' where idalu = 2
update aluno set sexo = 'M' where idalu = 3
go

select*from aluno

--DELETE
alter table profissao drop constraint fk_prof_salario
go
delete from salario where idsal = 1
delete from salario where idsal = 2
delete from salario where idsal = 3
go
select*from salario
go

--TRIGGERS
--1°

create table cursoII(
nome varchar(30)not null unique,
valor_antigo float not null,
valor_novo float not null,
usuario varchar(20)not null,
data date not null
)
go
create trigger backup_curso
on dbo.curso
for update as
if update(valor)
begin
insert into cursoII
(nome,valor_antigo,valor_novo,usuario,data)
select d.nome,d.valor,i.valor,SUSER_NAME(),getdate()
from deleted d, inserted i
end
go
update curso set valor = 200 where idcurso = 4
go
update curso set valor = 55000 where idcurso = 5
go
select*from cursoII
go

--2°
create table Assalariado(
velho_sal float,
novo_sal float,
usuario varchar(20)not null,
data date not null
)
go
create trigger atualizaSal
on dbo.salario
for update as
if update(valor)
begin
insert into Assalariado
(velho_sal,novo_sal,usuario,data)
select d.valor,i.valor,suser_name(),getdate()
from deleted d, inserted i
where d.idsal = i.idsal
end
go
update salario set valor = valor * 1.1
go
select*from salario
go
select *from Assalariado
go

--3°

create table Identidade(
campus int not null,
local varchar(30)not null,
reitor varchar(30)not null,
usuario varchar(30)not null,
)
Go

create trigger iesNova
on dbo.unieuro
for insert as
begin
insert into Identidade
(campus,local,reitor,usuario)
select i.campus,i.local,i.reitor,suser_name()
from inserted i
end
go
insert into unieuro values('Pedrinhas','Pedrin do Mangal')
go
select*from unieuro
go
select*from Identidade
go

--PROCEDURES
--1°

create procedure p_profissional @profissao varchar(30)
as
begin
select f.nome as Nome,f.data_nasc as DataDeNasc,p.nome as Profissao, u.local as Unidade,u.reitor
from funcionario f
join profissao p
on f.id_prof = p.idProf
join unieuro u
on u.campus = f.id_campus
where p.nome = @profissao
end
go
exec p_profissional 'Porteiro'
go
exec p_profissional 'Professor'
go

--2°
select*from curso go
create procedure p_salario_media
as
begin
select max(valor)as MaiorSalario from salario
end
go
exec p_salario_media
go


--3°
create procedure Disc @Dis varchar(20)
as
begin
select f.nome as Nome,d.nome as Disciplina from disciplina d
join funcionario f
on f.idFun = d.id_fun
join profissao p
on f.id_prof = p.idProf
join salario s
on p.id_sal = s.idsal
where d.nome = @Dis
end
go
exec Disc 'Banco de Dados'
go
exec Disc 'Primeiros Socorros'
go


--VIEWS

--1°
create view v_Descubra(nome,sexo,endereco,semestre)
as
select a.nome,a.sexo,a.endereco,c.nome from aluno a
join curso c
on a.id_curso = c.idcurso
where a.nome = 'Godzzzila'
go
select*from v_Descubra
go

--2°
create view v_O2(Nome,curso)
as
select a.nome as Nome, c.nome as Curso from curso c
join aluno a
on c.idcurso = a.id_curso
where sexo = 'M'
go
select*from v_O2
go


--3°
create view v_Oo(nome,materia,semestre,valor)
as
select a.nome as Nome,c.nome as Matéria,c.semestre as Semestre, c.valor from aluno a
join curso c
on a.id_curso = c.idcurso
where c.semestre = 3
go
select*from v_Oo
go



--Blob

create table imagem(
id int primary key identity,
nome varchar(100), 
arquivo varbinary(max)
)
go

insert into imagem(nome,arquivo)
select '1391512_634396169945350_371454248_n.jpg', *
from openrowset(bulk N'C:\Teste\1391512_634396169945350_371454248_n.jpg',
single_blob
) load;

insert into imagem(nome,arquivo)
select 'Feliz Natal..jpg', *
from openrowset(bulk N'C:\Teste\Feliz Natal..jpg',
single_blob
) load;

insert into imagem(nome,arquivo)
select 'natal bsb..jpg', *
from openrowset(bulk N'C:\Teste\natal bsb..jpg',
single_blob
) load;

select * from imagem
go

--Indice

-- Agilizar a procura pelos alunos com os campos nome e sexo na tabela aluno.
create index aluno on dbo.aluno (nome,sexo);


-- Agilizar a procura pelos cursos através dos campos nome e sexo na tabela curso.
create index curso on dbo.curso (nome,semestre);

-- Agilizar a procura pelas disciplinas através dos campos nome e id_curso na tabela disciplina.
create index disciplina on dbo.disciplina (nome,id_cur);

