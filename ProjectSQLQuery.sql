CREATE TABLE Item
(
upc Integer,
title varchar(40),
category varchar(40),
company varchar(40),
year Integer,
price float,
stock Integer
PRIMARY KEY (upc)
)

CREATE TABLE LeadSinger
(
upc Integer,
name varchar(40),
PRIMARY KEY (upc, name),
FOREIGN KEY (upc) REFERENCES Item(upc)
)

CREATE TABLE HasSong
(
upc Integer,
title varchar(40)
PRIMARY KEY (upc, title),
FOREIGN KEY (upc) REFERENCES Item(upc)
)

CREATE TABLE Orders
(
receiptId integer,
date date,
cid varchar(40),
card# varchar(40),
expiryDate varchar(40),
expectedDate date,
deliveredDate date
PRIMARY KEY (receiptId)
)

CREATE TABLE PurchaseItem
(
receiptId integer,
upc integer,
quantity integer
PRIMARY KEY (receiptId, upc),
FOREIGN KEY (receiptId) REFERENCES Orders(receiptId),
FOREIGN KEY (upc) REFERENCES Item(upc))

CREATE TABLE Customer
(
cid varchar(40),
password varchar(40),
name varchar(40),
address varchar(40),
phone varchar(40)
PRIMARY KEY (cid)
)

CREATE TABLE Returns
(
retid integer,
date date,
receiptId integer,
PRIMARY KEY (retid)
)

CREATE TABLE ReturnItem
(
retid integer,
upc integer,
quantity integer
PRIMARY KEY (retid, upc)
FOREIGN KEY (retid) REFERENCES Returns(retid),
FOREIGN KEY (upc) REFERENCES Item(upc))