create database notification_demo;
 use notification_demo;
create table `user`
(
	id int auto_increment primary key,
    username nvarchar(100) not null,
    notification_code varchar(200)
);

INSERT INTO `notification_demo`.`user`
(`id`,
`username`)
VALUES(1, "Pando"),
	  (2, "Elaina"),
      (3, "Mito"),
      (4, "Chiyo");

create table product
(
	id int auto_increment primary key,
    productName nvarchar(100) not null,
    userId INT,
	FOREIGN KEY (userId) REFERENCES user(id)
);

INSERT INTO `notification_demo`.`product`
(`id`,
`productName`, `userId`)
VALUES(1, "product 1", 1),
	  (2, "product 2", 2),
      (3, "product 3", 2),
      (4, "product 4", 3);

create table `entityType`
(
	id int auto_increment primary key,
    entity nvarchar(25) not null,
    description nvarchar(100) not null
);

INSERT INTO `notification_demo`.`entitytype` (`id`, `entity`, `description`) VALUES ('1', 'trading', 'đã thực hiện giao dịch cho');
INSERT INTO `notification_demo`.`entitytype` (`id`, `entity`, `description`) VALUES ('2', 'trading', 'đã thanh toán giao dịch cho');
INSERT INTO `notification_demo`.`entitytype` (`id`, `entity`, `description`) VALUES ('3', 'rating', 'đã đánh giá về trang Web.');
INSERT INTO `notification_demo`.`entitytype` (`id`, `entity`, `description`) VALUES ('4', 'report', 'đã khiếu nại về sản phẩm');
INSERT INTO `notification_demo`.`entitytype` (`id`, `entity`, `description`) VALUES ('5', 'report', 'Yêu cầu khiếu nại_đã được chấp nhận');
INSERT INTO `notification_demo`.`entitytype` (`id`, `entity`, `description`) VALUES ('6', 'report', 'Yêu cầu khiếu nại_đã bị từ chối');
INSERT INTO `notification_demo`.`entitytype` (`id`, `entity`, `description`) VALUES ('7', 'banking', 'Yêu cầu nạp tiền đã được chấp nhận');
INSERT INTO `notification_demo`.`entitytype` (`id`, `entity`, `description`) VALUES ('8', 'banking', 'Yêu cầu rút tiền đã được chấp nhận');

create table `notifications`
(
	id int auto_increment primary key, 
    code varchar(200),
    url nvarchar(255),   
    `status` bit,
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    entityTypeId int,
    foreign key (entityTypeId) references `entityType`(id)
);

create table `subject`
(
	id int auto_increment primary key,
    actorId int,
    foreign key (actorId) references `user`(id),
    notificationsId int,
    foreign key (notificationsId) references `notifications`(id)
);

create table `in_subject`
(
	id int auto_increment primary key, 
    notificationsId int,
    receiverId int,
    foreign key (receiverId) references `user`(id),
    foreign key (notificationsId) references `notifications`(id)
);

create table `di_subject`
(
	id int auto_increment primary key,
    productId int,
    foreign key (productId) references `product`(id),
    notificationsId int,
    foreign key (notificationsId) references `notifications`(id)
)
