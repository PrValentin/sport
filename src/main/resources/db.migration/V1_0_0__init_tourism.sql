CREATE TABLE IF NOT EXISTS COUNTRY (
    id BIGINT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);
create sequence SEQ_ID_COUNTRY START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;


CREATE TABLE IF NOT EXISTS REGION (
    id BIGINT PRIMARY KEY,
    id_country BIGINT,
    name VARCHAR(250) NOT NULL
);
create sequence SEQ_ID_REGION START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;


CREATE TABLE IF NOT EXISTS LOCALITY (
    id BIGINT PRIMARY KEY,
    id_region BIGINT,
    name VARCHAR(250) NOT NULL
);
create sequence SEQ_ID_LOCALITY START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;


CREATE TABLE IF NOT EXISTS SPORT (
    id BIGINT  PRIMARY KEY,
    name VARCHAR(250) NOT NULL
);
create sequence SEQ_ID_SPORT START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;


CREATE TABLE IF NOT EXISTS LOCALITY_SPORT (
    id BIGINT PRIMARY KEY,
    id_sport BIGINT,
    id_locality BIGINT,
    start_season DATE,
    end_season DATE,
    cost_day BIGINT NOT NULL
);
create sequence SEQ_ID_LOCALITY_SPORT START WITH 1 INCREMENT BY 1 NO MINVALUE NO MAXVALUE CACHE 1;


insert into COUNTRY (id, name) values (nextval('SEQ_ID_COUNTRY'), 'Romania');
insert into COUNTRY (id, name) values (nextval('SEQ_ID_COUNTRY'), 'Ecuador');
insert into COUNTRY (id, name) values (nextval('SEQ_ID_COUNTRY'), 'Indonesia');
insert into COUNTRY (id, name) values (nextval('SEQ_ID_COUNTRY'), 'Latvia');
insert into COUNTRY (id, name) values (nextval('SEQ_ID_COUNTRY'), 'Canada');
insert into COUNTRY (id, name) values (nextval('SEQ_ID_COUNTRY'), 'Tanzania');
insert into COUNTRY (id, name) values (nextval('SEQ_ID_COUNTRY'), 'Indonesia');
insert into COUNTRY (id, name) values (nextval('SEQ_ID_COUNTRY'), 'France');
insert into COUNTRY (id, name) values (nextval('SEQ_ID_COUNTRY'), 'Brazil');
insert into COUNTRY (id, name) values (nextval('SEQ_ID_COUNTRY'), 'Albania');

insert into REGION (id, id_country, name) values (nextval('SEQ_ID_REGION'), 1, 'Cluj');
insert into REGION (id, id_country, name) values (nextval('SEQ_ID_REGION'), 1, 'Iasi');
insert into REGION (id, id_country, name) values (nextval('SEQ_ID_REGION'), 1, 'Constanta');
insert into REGION (id, id_country, name) values (nextval('SEQ_ID_REGION'), 1, 'Suceava');
insert into REGION (id, id_country, name) values (nextval('SEQ_ID_REGION'), 1, 'Brasov');
insert into REGION (id, id_country, name) values (nextval('SEQ_ID_REGION'), 1, 'Buzau');
insert into REGION (id, id_country, name) values (nextval('SEQ_ID_REGION'), 1, 'Sibiu');
insert into REGION (id, id_country, name) values (nextval('SEQ_ID_REGION'), 1, 'Timisoara');
insert into REGION (id, id_country, name) values (nextval('SEQ_ID_REGION'), 1, 'Harghita');
insert into REGION (id, id_country, name) values (nextval('SEQ_ID_REGION'), 1, 'Caras-Severin');

insert into LOCALITY (id, id_region, name) values (nextval('SEQ_ID_LOCALITY'), 1, 'Cheile Turzii');
insert into LOCALITY (id, id_region, name) values (nextval('SEQ_ID_LOCALITY'), 1, 'Satul Luncani');
insert into LOCALITY (id, id_region, name) values (nextval('SEQ_ID_LOCALITY'), 2, 'Cozmesti');
insert into LOCALITY (id, id_region, name) values (nextval('SEQ_ID_LOCALITY'), 2, 'Miclauseni');
insert into LOCALITY (id, id_region, name) values (nextval('SEQ_ID_LOCALITY'), 3, 'Cheile Dobrogei');
insert into LOCALITY (id, id_region, name) values (nextval('SEQ_ID_LOCALITY'), 3, 'Techirghiol');
insert into LOCALITY (id, id_region, name) values (nextval('SEQ_ID_LOCALITY'), 4, 'Cheile Lucavei');
insert into LOCALITY (id, id_region, name) values (nextval('SEQ_ID_LOCALITY'), 4, 'Cheile Zugreni');
insert into LOCALITY (id, id_region, name) values (nextval('SEQ_ID_LOCALITY'), 5, 'Muntele Tampa');
insert into LOCALITY (id, id_region, name) values (nextval('SEQ_ID_LOCALITY'), 5, 'Cetatea Rasnov');
insert into LOCALITY (id, id_region, name) values (nextval('SEQ_ID_LOCALITY'), 6, 'Lacul Vulturilor');
insert into LOCALITY (id, id_region, name) values (nextval('SEQ_ID_LOCALITY'), 6, 'Drumul Luanei');
insert into LOCALITY (id, id_region, name) values (nextval('SEQ_ID_LOCALITY'), 7, 'Cindrel');
insert into LOCALITY (id, id_region, name) values (nextval('SEQ_ID_LOCALITY'), 7, 'Lotru');
insert into LOCALITY (id, id_region, name) values (nextval('SEQ_ID_LOCALITY'), 8, 'Pestera Bolii');
insert into LOCALITY (id, id_region, name) values (nextval('SEQ_ID_LOCALITY'), 8, 'Crucea Eroilor');
insert into LOCALITY (id, id_region, name) values (nextval('SEQ_ID_LOCALITY'), 9, 'Lacul Rosu');
insert into LOCALITY (id, id_region, name) values (nextval('SEQ_ID_LOCALITY'), 9, 'Salina Praid');
insert into LOCALITY (id, id_region, name) values (nextval('SEQ_ID_LOCALITY'), 10, 'Cascada Bigar');
insert into LOCALITY (id, id_region, name) values (nextval('SEQ_ID_LOCALITY'), 10, 'Lacul Ochiul Beiului');


insert into SPORT (id, name) values (nextval('SEQ_ID_SPORT'), 'ZORBING');
insert into SPORT (id, name) values (nextval('SEQ_ID_SPORT'), 'SKIING');
insert into SPORT (id, name) values (nextval('SEQ_ID_SPORT'), 'MOUNTAIN BOARDING');
insert into SPORT (id, name) values (nextval('SEQ_ID_SPORT'), 'KITING');
insert into SPORT (id, name) values (nextval('SEQ_ID_SPORT'), 'PARASAILING');
insert into SPORT (id, name) values (nextval('SEQ_ID_SPORT'), 'BAREFOOTING');
insert into SPORT (id, name) values (nextval('SEQ_ID_SPORT'), 'XPOGO');
insert into SPORT (id, name) values (nextval('SEQ_ID_SPORT'), 'PARKOUR');
insert into SPORT (id, name) values (nextval('SEQ_ID_SPORT'), 'SKATEBOADING');
insert into SPORT (id, name) values (nextval('SEQ_ID_SPORT'), 'MOUNTAIN KARTING');
insert into SPORT (id, name) values (nextval('SEQ_ID_SPORT'), 'DRIFTING');
insert into SPORT (id, name) values (nextval('SEQ_ID_SPORT'), 'BMX');
insert into SPORT (id, name) values (nextval('SEQ_ID_SPORT'), 'MOTOCROSS');
insert into SPORT (id, name) values (nextval('SEQ_ID_SPORT'), 'FMX');
insert into SPORT (id, name) values (nextval('SEQ_ID_SPORT'), 'MOUNTAIN BIKING');

insert into LOCALITY_SPORT (id, id_sport, id_locality, start_season, end_season, cost_day) values (nextval('SEQ_ID_LOCALITY_SPORT'), 1, 1, '2021-02-20 14:54:21', '2021-07-17 16:34:14', 109);
insert into LOCALITY_SPORT (id, id_sport, id_locality, start_season, end_season, cost_day) values (nextval('SEQ_ID_LOCALITY_SPORT'), 2, 2, '2021-03-22 12:30:29', '2021-07-06 06:14:30', 367);
insert into LOCALITY_SPORT (id, id_sport, id_locality, start_season, end_season, cost_day) values (nextval('SEQ_ID_LOCALITY_SPORT'), 3, 3, '2020-11-16 22:49:31', '2021-07-03 11:56:11', 865);
insert into LOCALITY_SPORT (id, id_sport, id_locality, start_season, end_season, cost_day) values (nextval('SEQ_ID_LOCALITY_SPORT'), 4, 4, '2021-01-30 18:02:32', '2021-07-03 04:10:55', 230);
insert into LOCALITY_SPORT (id, id_sport, id_locality, start_season, end_season, cost_day) values (nextval('SEQ_ID_LOCALITY_SPORT'), 5, 5, '2020-12-28 23:29:39', '2021-07-02 11:10:17', 777);
insert into LOCALITY_SPORT (id, id_sport, id_locality, start_season, end_season, cost_day) values (nextval('SEQ_ID_LOCALITY_SPORT'), 6, 6, '2020-12-03 10:14:19', '2021-07-01 14:43:25', 570);
insert into LOCALITY_SPORT (id, id_sport, id_locality, start_season, end_season, cost_day) values (nextval('SEQ_ID_LOCALITY_SPORT'), 7, 7, '2021-01-12 01:10:38', '2021-07-06 10:03:07', 334);
insert into LOCALITY_SPORT (id, id_sport, id_locality, start_season, end_season, cost_day) values (nextval('SEQ_ID_LOCALITY_SPORT'), 8, 8, '2020-12-20 13:19:55', '2021-07-29 16:22:39', 471);
insert into LOCALITY_SPORT (id, id_sport, id_locality, start_season, end_season, cost_day) values (nextval('SEQ_ID_LOCALITY_SPORT'), 9, 9, '2020-11-04 10:09:47', '2021-07-08 18:50:19', 448);
insert into LOCALITY_SPORT (id, id_sport, id_locality, start_season, end_season, cost_day) values (nextval('SEQ_ID_LOCALITY_SPORT'), 10, 10, '2020-11-29 17:35:50', '2021-07-01 03:56:15', 780);
insert into LOCALITY_SPORT (id, id_sport, id_locality, start_season, end_season, cost_day) values (nextval('SEQ_ID_LOCALITY_SPORT'), 11, 11, '2020-12-05 19:16:05', '2021-07-21 05:19:37', 141);
insert into LOCALITY_SPORT (id, id_sport, id_locality, start_season, end_season, cost_day) values (nextval('SEQ_ID_LOCALITY_SPORT'), 12, 12, '2020-10-27 23:16:36', '2021-07-12 10:56:27', 275);
insert into LOCALITY_SPORT (id, id_sport, id_locality, start_season, end_season, cost_day) values (nextval('SEQ_ID_LOCALITY_SPORT'), 13, 13, '2020-11-04 09:16:19', '2021-07-11 15:44:33', 80);
insert into LOCALITY_SPORT (id, id_sport, id_locality, start_season, end_season, cost_day) values (nextval('SEQ_ID_LOCALITY_SPORT'), 14, 14, '2021-02-15 22:42:24', '2021-07-19 00:42:57', 325);
insert into LOCALITY_SPORT (id, id_sport, id_locality, start_season, end_season, cost_day) values (nextval('SEQ_ID_LOCALITY_SPORT'), 15, 15, '2020-11-20 13:47:16', '2021-07-28 13:36:16', 884);
insert into LOCALITY_SPORT (id, id_sport, id_locality, start_season, end_season, cost_day) values (nextval('SEQ_ID_LOCALITY_SPORT'), 1, 2, '2020-10-17 22:30:28', '2021-07-16 09:21:30', 110);
insert into LOCALITY_SPORT (id, id_sport, id_locality, start_season, end_season, cost_day) values (nextval('SEQ_ID_LOCALITY_SPORT'), 2, 3, '2020-12-07 04:51:30', '2021-07-04 04:11:00', 557);
insert into LOCALITY_SPORT (id, id_sport, id_locality, start_season, end_season, cost_day) values (nextval('SEQ_ID_LOCALITY_SPORT'), 3, 4, '2020-11-09 19:55:33', '2021-07-17 14:30:41', 901);
insert into LOCALITY_SPORT (id, id_sport, id_locality, start_season, end_season, cost_day) values (nextval('SEQ_ID_LOCALITY_SPORT'), 5, 6, '2021-01-09 01:43:32', '2021-07-31 06:24:11', 161);
insert into LOCALITY_SPORT (id, id_sport, id_locality, start_season, end_season, cost_day) values (nextval('SEQ_ID_LOCALITY_SPORT'), 6, 7, '2020-10-18 03:15:01', '2021-07-30 17:22:28', 708);
insert into LOCALITY_SPORT (id, id_sport, id_locality, start_season, end_season, cost_day) values (nextval('SEQ_ID_LOCALITY_SPORT'), 7, 8, '2021-02-04 23:43:33', '2021-07-22 14:32:12', 723);
insert into LOCALITY_SPORT (id, id_sport, id_locality, start_season, end_season, cost_day) values (nextval('SEQ_ID_LOCALITY_SPORT'), 8, 9, '2020-10-07 17:18:53', '2021-07-08 07:07:22', 697);
insert into LOCALITY_SPORT (id, id_sport, id_locality, start_season, end_season, cost_day) values (nextval('SEQ_ID_LOCALITY_SPORT'), 9, 10, '2020-10-28 18:50:05', '2021-07-19 04:07:07', 363);
insert into LOCALITY_SPORT (id, id_sport, id_locality, start_season, end_season, cost_day) values (nextval('SEQ_ID_LOCALITY_SPORT'), 10, 11, '2020-11-13 08:27:29', '2021-07-24 06:36:38', 927);
insert into LOCALITY_SPORT (id, id_sport, id_locality, start_season, end_season, cost_day) values (nextval('SEQ_ID_LOCALITY_SPORT'), 11, 12, '2020-10-03 04:03:20', '2021-07-24 14:32:33', 854);
insert into LOCALITY_SPORT (id, id_sport, id_locality, start_season, end_season, cost_day) values (nextval('SEQ_ID_LOCALITY_SPORT'), 12, 13, '2021-01-23 15:23:54', '2021-07-06 00:45:19', 879);
insert into LOCALITY_SPORT (id, id_sport, id_locality, start_season, end_season, cost_day) values (nextval('SEQ_ID_LOCALITY_SPORT'), 13, 14, '2021-01-24 12:19:08', '2021-07-12 19:52:33', 64);
insert into LOCALITY_SPORT (id, id_sport, id_locality, start_season, end_season, cost_day) values (nextval('SEQ_ID_LOCALITY_SPORT'), 14, 15, '2021-01-07 11:22:58', '2021-07-22 01:45:55', 351);
insert into LOCALITY_SPORT (id, id_sport, id_locality, start_season, end_season, cost_day) values (nextval('SEQ_ID_LOCALITY_SPORT'), 1, 3, '2021-01-07 15:42:05', '2021-07-08 17:10:02', 448);
insert into LOCALITY_SPORT (id, id_sport, id_locality, start_season, end_season, cost_day) values (nextval('SEQ_ID_LOCALITY_SPORT'), 2, 5, '2021-02-19 18:15:43', '2021-07-10 01:17:54', 275);
insert into LOCALITY_SPORT (id, id_sport, id_locality, start_season, end_season, cost_day) values (nextval('SEQ_ID_LOCALITY_SPORT'), 3, 7, '2020-12-18 13:47:25', '2021-07-09 02:27:36', 260);
insert into LOCALITY_SPORT (id, id_sport, id_locality, start_season, end_season, cost_day) values (nextval('SEQ_ID_LOCALITY_SPORT'), 4, 9, '2020-10-13 18:27:02', '2021-07-18 12:36:01', 551);
insert into LOCALITY_SPORT (id, id_sport, id_locality, start_season, end_season, cost_day) values (nextval('SEQ_ID_LOCALITY_SPORT'), 5, 11, '2021-01-31 04:46:20', '2021-07-16 13:30:07', 418);
insert into LOCALITY_SPORT (id, id_sport, id_locality, start_season, end_season, cost_day) values (nextval('SEQ_ID_LOCALITY_SPORT'), 6, 13, '2020-12-02 05:35:15', '2021-07-15 17:40:37', 845);
insert into LOCALITY_SPORT (id, id_sport, id_locality, start_season, end_season, cost_day) values (nextval('SEQ_ID_LOCALITY_SPORT'), 7, 15, '2020-11-27 17:52:52', '2021-07-03 23:54:19', 207);
insert into LOCALITY_SPORT (id, id_sport, id_locality, start_season, end_season, cost_day) values (nextval('SEQ_ID_LOCALITY_SPORT'), 8, 17, '2020-12-02 14:42:42', '2021-07-02 02:05:53', 757);
insert into LOCALITY_SPORT (id, id_sport, id_locality, start_season, end_season, cost_day) values (nextval('SEQ_ID_LOCALITY_SPORT'), 9, 19, '2020-12-05 23:05:15', '2021-07-04 04:40:11', 126);
insert into LOCALITY_SPORT (id, id_sport, id_locality, start_season, end_season, cost_day) values (nextval('SEQ_ID_LOCALITY_SPORT'), 10, 20, '2021-01-06 12:53:24', '2021-07-26 09:34:57', 171);
insert into LOCALITY_SPORT (id, id_sport, id_locality, start_season, end_season, cost_day) values (nextval('SEQ_ID_LOCALITY_SPORT'), 2, 7, '2021-03-01 15:41:17', '2021-07-20 14:08:49', 933);
insert into LOCALITY_SPORT (id, id_sport, id_locality, start_season, end_season, cost_day) values (nextval('SEQ_ID_LOCALITY_SPORT'), 2, 4, '2021-01-07 03:34:50', '2021-07-22 07:21:05', 965);
