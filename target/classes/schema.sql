CREATE TABLE IF NOT EXISTS COUNTRY (
    id BIGINT SERIAL PRIMARY KEY,
    name  VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS REGION (
    id BIGINT SERIAL PRIMARY KEY,
    id_country FOREIGN KEY REFERENCES COUNTRY(id)
    name  VARCHAR(250) NOT NULL
);

CREATE TABLE IF NOT EXISTS LOCAL (
    id BIGINT SERIAL PRIMARY KEY,
    id_region FOREIGN KEY REFERENCES REGION(id)
    name  VARCHAR(250) NOT NULL
);

CREATE TABLE IF NOT EXISTS SPORT (
    id BIGINT SERIAL PRIMARY KEY,
    name  VARCHAR(250) NOT NULL
);

CREATE TABLE IF NOT EXISTS LOCAL_SPORT (
    id BIGINT SERIAL PRIMARY KEY,
    id_sport FOREIGN KEY REFERENCES SPORT(id),
    id_local FOREIGN KEY REFERENCES LOCAL(id),
    start DATE,
    end DATE,
    cost_day int UNSIGNED,
);

create table CUNTRY (
	id BIGINT SERIAL,
	first_name VARCHAR(50)
);

insert into CUNTRY (id, name) values (DEFAULT, 'Romania');
insert into CUNTRY (id, name) values (DEFAULT, 'Ecuador');
insert into CUNTRY (id, name) values (DEFAULT, 'Indonesia');
insert into CUNTRY (id, name) values (DEFAULT, 'Latvia');
insert into CUNTRY (id, name) values (DEFAULT, 'Canada');
insert into CUNTRY (id, name) values (DEFAULT, 'Tanzania');
insert into CUNTRY (id, name) values (DEFAULT, 'Indonesia');
insert into CUNTRY (id, name) values (DEFAULT, 'France');
insert into CUNTRY (id, name) values (DEFAULT, 'Brazil');
insert into CUNTRY (id, name) values (DEFAULT, 'Albania');
DEFAULT
insert into REGION (id, id_country, name) values (DEFAULT, 1, 'Cluj');
insert into REGION (id, id_country, name) values (DEFAULT, 1, 'Iasi');
insert into REGION (id, id_country, name) values (DEFAULT, 1, 'Constanța');
insert into REGION (id, id_country, name) values (DEFAULT, 1, 'Suceava');
insert into REGION (id, id_country, name) values (DEFAULT, 1, 'Brașov');
insert into REGION (id, id_country, name) values (DEFAULT, 1, 'Buzau');
insert into REGION (id, id_country, name) values (DEFAULT, 1, 'Sibiu');
insert into REGION (id, id_country, name) values (DEFAULT, 1, 'Timisoara');
insert into REGION (id, id_country, name) values (DEFAULT, 1, 'Harghita');
insert into REGION (id, id_country, name) values (DEFAULT, 1, 'Caras-Severin');

insert into LOCAL (id, id_region, name) values (DEFAULT, 1, 'Cheile Turzii');
insert into LOCAL (id, id_region, name) values (DEFAULT, 1, 'Satul Luncani');
insert into LOCAL (id, id_region, name) values (DEFAULT, 2, 'Cozmeşti');
insert into LOCAL (id, id_region, name) values (DEFAULT, 2, 'Miclăuşeni');
insert into LOCAL (id, id_region, name) values (DEFAULT, 3, 'Cheile Dobrogei');
insert into LOCAL (id, id_region, name) values (DEFAULT, 3, 'Techirghiol');
insert into LOCAL (id, id_region, name) values (DEFAULT, 4, 'Cheile Lucavei');
insert into LOCAL (id, id_region, name) values (DEFAULT, 4, 'Cheile Zugreni');
insert into LOCAL (id, id_region, name) values (DEFAULT, 5, 'Muntele Tâmpa');
insert into LOCAL (id, id_region, name) values (DEFAULT, 5, 'Cetatea Râșnov');
insert into LOCAL (id, id_region, name) values (DEFAULT, 6, 'Lacul Vulturilor');
insert into LOCAL (id, id_region, name) values (DEFAULT, 6, 'Drumul Luanei');
insert into LOCAL (id, id_region, name) values (DEFAULT, 7, 'Cindrel');
insert into LOCAL (id, id_region, name) values (DEFAULT, 7, 'Lotru');
insert into LOCAL (id, id_region, name) values (DEFAULT, 8, 'Pestera Bolii');
insert into LOCAL (id, id_region, name) values (DEFAULT, 8, 'Crucea Eroilor');
insert into LOCAL (id, id_region, name) values (DEFAULT, 9, 'Lacul Roșu');
insert into LOCAL (id, id_region, name) values (DEFAULT, 9, 'Salina Praid');
insert into LOCAL (id, id_region, name) values (DEFAULT, 10, 'Cascada Bigar');
insert into LOCAL (id, id_region, name) values (DEFAULT, 10, 'Lacul Ochiul Beiului');


insert into SPORT (id, name) values (DEFAULT, 'ZORBING');
insert into SPORT (id, name) values (DEFAULT, 'SKIING');
insert into SPORT (id, name) values (DEFAULT, 'MOUNTAIN BOARDING');
insert into SPORT (id, name) values (DEFAULT, 'KITING');
insert into SPORT (id, name) values (DEFAULT, 'PARASAILING');
insert into SPORT (id, name) values (DEFAULT, 'BAREFOOTING');
insert into SPORT (id, name) values (DEFAULT, 'XPOGO');
insert into SPORT (id, name) values (DEFAULT, 'PARKOUR');
insert into SPORT (id, name) values (DEFAULT, 'SKATEBOADING');
insert into SPORT (id, name) values (DEFAULT, 'MOUNTAIN KARTING');
insert into SPORT (id, name) values (DEFAULT, 'DRIFTING');
insert into SPORT (id, name) values (DEFAULT, 'BMX');
insert into SPORT (id, name) values (DEFAULT, 'MOTOCROSS');
insert into SPORT (id, name) values (DEFAULT, 'FMX');
insert into SPORT (id, name) values (DEFAULT, 'MOUNTAIN BIKING');

insert into LOCAL_SPORT (id, id_sport, id_local, start_season, end_season, cost_day) values (DEFAULT, 1, 1, '16.11.2020', '6/12/2021', 109);
insert into LOCAL_SPORT (id, id_sport, id_local, start_season, end_season, cost_day) values (DEFAULT, 2, 2, '14.10.2020', '5/14/2021', 367);
insert into LOCAL_SPORT (id, id_sport, id_local, start_season, end_season, cost_day) values (DEFAULT, 3, 3, '21.10.2020', '5/7/2021', 865);
insert into LOCAL_SPORT (id, id_sport, id_local, start_season, end_season, cost_day) values (DEFAULT, 4, 4, '14.09.2020', '5/8/2021', 230);
insert into LOCAL_SPORT (id, id_sport, id_local, start_season, end_season, cost_day) values (DEFAULT, 5, 5, '07.09.2020', '5/5/2021', 777);
insert into LOCAL_SPORT (id, id_sport, id_local, start_season, end_season, cost_day) values (DEFAULT, 6, 6, '29.09.2020', '6/5/2021', 570);
insert into LOCAL_SPORT (id, id_sport, id_local, start_season, end_season, cost_day) values (DEFAULT, 7, 7, '15.09.2020', '6/22/2021', 334);
insert into LOCAL_SPORT (id, id_sport, id_local, start_season, end_season, cost_day) values (DEFAULT, 8, 8, '21.09.2020', '6/30/2021', 471);
insert into LOCAL_SPORT (id, id_sport, id_local, start_season, end_season, cost_day) values (DEFAULT, 9, 9, '29.11.2020', '6/5/2021', 448);
insert into LOCAL_SPORT (id, id_sport, id_local, start_season, end_season, cost_day) values (DEFAULT, 10, 10, '24.09.2020', '5/3/2021', 780);
insert into LOCAL_SPORT (id, id_sport, id_local, start_season, end_season, cost_day) values (DEFAULT, 11, 11, '18.11.2020', '5/29/2021', 141);
insert into LOCAL_SPORT (id, id_sport, id_local, start_season, end_season, cost_day) values (DEFAULT, 12, 12, '28.11.2020', '5/2/2021', 275);
insert into LOCAL_SPORT (id, id_sport, id_local, start_season, end_season, cost_day) values (DEFAULT, 13, 13, '03.10.2020', '5/1/2021', 20);
insert into LOCAL_SPORT (id, id_sport, id_local, start_season, end_season, cost_day) values (DEFAULT, 14, 14, '29.10.2020', '6/17/2021', 325);
insert into LOCAL_SPORT (id, id_sport, id_local, start_season, end_season, cost_day) values (DEFAULT, 15, 15, '21.10.2020', '6/15/2021', 884);
insert into LOCAL_SPORT (id, id_sport, id_local, start_season, end_season, cost_day) values (DEFAULT, 1, 2, '11.09.2020', '6/11/2021', 110);
insert into LOCAL_SPORT (id, id_sport, id_local, start_season, end_season, cost_day) values (DEFAULT, 2, 3, '08.10.2020', '5/6/2021', 557);
insert into LOCAL_SPORT (id, id_sport, id_local, start_season, end_season, cost_day) values (DEFAULT, 3, 4, '31.10.2020', '5/3/2021', 901);
insert into LOCAL_SPORT (id, id_sport, id_local, start_season, end_season, cost_day) values (DEFAULT, 5, 6, '22.11.2020', '5/22/2021', 161);
insert into LOCAL_SPORT (id, id_sport, id_local, start_season, end_season, cost_day) values (DEFAULT, 6, 7, '30.10.2020', '5/27/2021', 708);
insert into LOCAL_SPORT (id, id_sport, id_local, start_season, end_season, cost_day) values (DEFAULT, 7, 8, '13.10.2020', '5/26/2021', 723);
insert into LOCAL_SPORT (id, id_sport, id_local, start_season, end_season, cost_day) values (DEFAULT, 8, 9, '07.11.2020', '6/6/2021', 697);
insert into LOCAL_SPORT (id, id_sport, id_local, start_season, end_season, cost_day) values (DEFAULT, 9, 10, '16.10.2020', '5/6/2021', 363);
insert into LOCAL_SPORT (id, id_sport, id_local, start_season, end_season, cost_day) values (DEFAULT, 10, 11, '12.10.2020', '6/16/2021', 927);
insert into LOCAL_SPORT (id, id_sport, id_local, start_season, end_season, cost_day) values (DEFAULT, 11, 12, '17.11.2020', '6/10/2021', 854);
insert into LOCAL_SPORT (id, id_sport, id_local, start_season, end_season, cost_day) values (DEFAULT, 12, 13, '15.10.2020', '5/18/2021', 879);
insert into LOCAL_SPORT (id, id_sport, id_local, start_season, end_season, cost_day) values (DEFAULT, 13, 14, '19.10.2020', '5/16/2021', 64);
insert into LOCAL_SPORT (id, id_sport, id_local, start_season, end_season, cost_day) values (DEFAULT, 14, 15, '19.11.2020', '6/15/2021', 351);
insert into LOCAL_SPORT (id, id_sport, id_local, start_season, end_season, cost_day) values (DEFAULT, 1, 3, '17.11.2020', '5/6/2021', 448);
insert into LOCAL_SPORT (id, id_sport, id_local, start_season, end_season, cost_day) values (DEFAULT, 2, 5, '07.09.2020', '6/5/2021', 275);
insert into LOCAL_SPORT (id, id_sport, id_local, start_season, end_season, cost_day) values (DEFAULT, 3, 7, '11.11.2020', '6/13/2021', 26);
insert into LOCAL_SPORT (id, id_sport, id_local, start_season, end_season, cost_day) values (DEFAULT, 4, 9, '30.11.2020', '6/5/2021', 551);
insert into LOCAL_SPORT (id, id_sport, id_local, start_season, end_season, cost_day) values (DEFAULT, 5, 11, '31.10.2020', '6/23/2021', 418);
insert into LOCAL_SPORT (id, id_sport, id_local, start_season, end_season, cost_day) values (DEFAULT, 6, 13, '25.09.2020', '6/13/2021', 845);
insert into LOCAL_SPORT (id, id_sport, id_local, start_season, end_season, cost_day) values (DEFAULT, 7, 15, '28.09.2020', '6/24/2021', 207);
insert into LOCAL_SPORT (id, id_sport, id_local, start_season, end_season, cost_day) values (DEFAULT, 8, 17, '30.09.2020', '6/17/2021', 757);
insert into LOCAL_SPORT (id, id_sport, id_local, start_season, end_season, cost_day) values (DEFAULT, 9, 19, '20.09.2020', '5/16/2021', 126);
insert into LOCAL_SPORT (id, id_sport, id_local, start_season, end_season, cost_day) values (DEFAULT, 10, 20, '08.10.2020', '6/27/2021', 171);
insert into LOCAL_SPORT (id, id_sport, id_local, start_season, end_season, cost_day) values (DEFAULT, 2, 7, '02.10.2020', '6/29/2021', 933);
insert into LOCAL_SPORT (id, id_sport, id_local, start_season, end_season, cost_day) values (DEFAULT, 2, 4, '30.09.2020', '5/27/2021', 965);