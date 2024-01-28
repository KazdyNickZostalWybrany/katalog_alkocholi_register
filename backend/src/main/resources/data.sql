Insert into BRAND(id, name) VALUES (1,'Martini');
Insert into BRAND(id, name) VALUES (2,'Jim Beam');
Insert into BRAND(id, name) VALUES (3,'Aperol');
Insert into BRAND(id, name) VALUES (4,'Finlandia');
Insert into BRAND(id, name) VALUES (5,'Captain Morgan');

Insert into ALCOHOL(id,brand_id,name) VALUES (1,1,'Bianco');
Insert into ALCOHOL(id,brand_id,name) VALUES (2,1,'Extra dry');
Insert into ALCOHOL(id,brand_id,name) VALUES (3,1,'Fiero');
Insert into ALCOHOL(id,brand_id,name) VALUES (4,1,'Floreale Aperitivo');
Insert into ALCOHOL(id,brand_id,name) VALUES (5,1,'Riserva Speciale Ambrato');

Insert into ALCOHOL(id,brand_id,name) VALUES (6,2,'White Label');
Insert into ALCOHOL(id,brand_id,name) VALUES (7,2,'Honey');

Insert into ALCOHOL(id,brand_id,name) VALUES (8,3,'Aperitivo');
Insert into ALCOHOL(id,brand_id,name) VALUES (9,3,'Apertif Aperol Bitter');

Insert into ALCOHOL(id,brand_id,name) VALUES (10,4,'Vodka');

Insert into ALCOHOL(id,brand_id,name) VALUES (11,5,'Spiced Gold');
Insert into ALCOHOL(id,brand_id,name) VALUES (12,5,'White');

ALTER TABLE ALCOHOL ALTER COLUMN ID RESTART WITH (SELECT MAX(ID) FROM ALCOHOL) + 1;
ALTER TABLE BRAND ALTER COLUMN ID RESTART WITH (SELECT MAX(ID) FROM BRAND) + 1;

Insert into LOGIN(id,login,password) VALUES (1,'username','password');
ALTER TABLE LOGIN ALTER COLUMN ID RESTART WITH (SELECT MAX(ID) FROM LOGIN) + 1;












