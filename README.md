# Add Multiple Query
declare @id int 
select @id = 1
while @id >=1 and @id <= 1000
begin
    insert into Employee  values( 'Jack' + convert(varchar(5), @id), 'Toren' + convert(varchar(5), @id), 'jackT' + convert(varchar(5), @id)+'gmail.com')
    select @id = @id + 1
end
# Spring-Hibernate-Boot-Rest
# Hibernate 1TO1 Cascade Type
![github-small](https://github.com/SohamRoyNoel/Spring-Hibernate-Boot-Rest/blob/master/Hibernate%201TO1%20Cascade%20Type.PNG?raw=true)
# Hibernate 1TO1 Entity LifeCycle
![github-small](https://github.com/SohamRoyNoel/Spring-Hibernate-Boot-Rest/blob/master/Hibernate%201TO1%20Entity%20LifeCycle.PNG?raw=true)
# Hibernate Entity Lifecycle Method Call Diagram View
![github-small](https://github.com/SohamRoyNoel/Spring-Hibernate-Boot-Rest/blob/master/Hibernate%20Entity%20Lifecycle%20Method%20Call%20Diagram%20View.PNG?raw=true)
