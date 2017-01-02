drop table if exists Brick;

create table Brick (
   Id identity,
   ElementCode varchar(16) not null,
   DesignCode varchar(16) not null,
   Name varchar(32) not null,
   ColorId integer not null,
   CategoryId integer not null,
   ImageUrl varchar(128) not null
);
