create table furniture (
    furnitureId int not null primary key,
    category varchar(50) not null,
    imageUrl varchar(50) not null,
    details varchar(200) not null
);

create table rating (
    furnitureId int not null,
    userId int not null,
    comment varchar(200),
    imageUrl varchar(50),
    starRating int not null check(starRating >=1 and starRating <=5),
    primary key(userId, furnitureId),
    foreign key (furnitureId) REFERENCES furniture(furnitureId)
);