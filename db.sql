drop database webdevcon;

create database webdevcon default character set utf8mb4 collate utf8mb4_unicode_ci;

create table webdevcon.user
(
    userId   varchar(20) primary key not null,
    userPw   varchar(64)             not null,
    salt     varchar(8)              not null,
    userName varchar(10)             not null
);

create table webdevcon.market
(
    marketId   int unsigned primary key      not null auto_increment,
    marketName varchar(20)                   not null,
    marketDesc varchar(100)                  not null,
    longitude  double                        not null,
    latitude   double                        not null,
    openTime   time       default '09:00:00' null,
    closeTime  time       default '20:00:00' null,
    openDay    varchar(7) default '0123456'  null
);

create table webdevcon.parking
(
    parkingId   int unsigned primary key not null auto_increment,
    marketId    int unsigned             not null,
    parkingName varchar(20)              not null,
    longitude   double                   not null,
    latitude    double                   not null,
    capacity    int default 0            not null,
    foreign key (marketId) references webdevcon.market (marketId)
);

create table webdevcon.file
(
    fileId       int unsigned primary key not null auto_increment,
    originalName varchar(100)             not null,
    type         varchar(5)               not null,
    userId       varchar(20)              not null,
    uploaded     datetime                 not null default now(),
    foreign key (userId) references webdevcon.user (userId)
);

create table webdevcon.comment
(
    commentId integer unsigned primary key not null auto_increment,
    userId    varchar(20)                  not null,
    marketId  integer unsigned             not null,
    content   varchar(100)                 not null,
    fileId    int unsigned                          default null,
    created   datetime                     not null default now(),
    foreign key (fileId) references webdevcon.file (fileId),
    foreign key (userId) references webdevcon.user (userId)
);

create table webdevcon.like
(
    likeId    integer unsigned primary key not null auto_increment,
    userId    varchar(20)                  not null,
    marketId  integer unsigned default null,
    commentId integer unsigned default null,
    foreign key (userId) references webdevcon.user (userId),
    foreign key (marketId) references webdevcon.market (marketId),
    foreign key (commentId) references webdevcon.comment (commentId)
);

create table webdevcon.images
(
    marketId integer unsigned default null,
    fileId   integer unsigned not null,
    foreign key (marketId) references webdevcon.market (marketId),
    foreign key (fileId) references webdevcon.file (fileId),
    primary key (marketId, fileId)
)