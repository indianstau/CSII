
/* insert name, NYUUSYA_DATE,  TAISYA_DATE */
/*
UPDATE `csiisysdb2`.`syain_main` SET `FIRST_NAME_KANJI`='田中', `LAST_NAME_KANJI`='菜々子',`NYUUSYA_DATE`='2023-07-01',`SYOKUGYO_KIND` =1 WHERE  `SYAIN_ID`=1;
UPDATE `csiisysdb2`.`syain_main` SET `FIRST_NAME_KANJI`='渡辺', `LAST_NAME_KANJI`='高介',`TAISYA_DATE`='2022-12-03',`NYUUSYA_DATE`='2016-07-01',`SYOKUGYO_KIND` =2 WHERE  `SYAIN_ID`=2;
UPDATE `csiisysdb2`.`syain_main` SET `FIRST_NAME_KANJI`='高崎', `LAST_NAME_KANJI`='龍介',`NYUUSYA_DATE`='2019-02-15',`SYOKUGYO_KIND` =3 WHERE  `SYAIN_ID`=3;
UPDATE `csiisysdb2`.`syain_main` SET `FIRST_NAME_KANJI`='山本', `LAST_NAME_KANJI`='治野',`NYUUSYA_DATE`='2020-09-20',`SYOKUGYO_KIND` =4 WHERE  `SYAIN_ID`=4;
UPDATE `csiisysdb2`.`syain_main` SET `FIRST_NAME_KANJI`='廣末', `LAST_NAME_KANJI`='小丸子',`NYUUSYA_DATE`='2021-01-28',`SYOKUGYO_KIND` =5 WHERE  `SYAIN_ID`=5;
UPDATE `csiisysdb2`.`syain_main` SET `FIRST_NAME_KANJI`='堂本', `LAST_NAME_KANJI`='まくろ',`TAISYA_DATE`='2020-07-07',`NYUUSYA_DATE`='2019-05-01',`SYOKUGYO_KIND` =6 WHERE  `SYAIN_ID`=6;
UPDATE `csiisysdb2`.`syain_main` SET `FIRST_NAME_KANJI`='濱崎', `LAST_NAME_KANJI`='高島',`NYUUSYA_DATE`='2015-01-02',`SYOKUGYO_KIND` =3 WHERE  `SYAIN_ID`=7;
UPDATE `csiisysdb2`.`syain_main` SET `FIRST_NAME_KANJI`='長島', `LAST_NAME_KANJI`='冰茶',`NYUUSYA_DATE`='2018-11-18',`SYOKUGYO_KIND` =4 WHERE  `SYAIN_ID`=8;
UPDATE `csiisysdb2`.`syain_main` SET `FIRST_NAME_KANJI`='花輪', `LAST_NAME_KANJI`='崢蟀',`NYUUSYA_DATE`='2017-12-01',`SYOKUGYO_KIND` =6 WHERE  `SYAIN_ID`=9;
UPDATE `csiisysdb2`.`syain_main` SET `FIRST_NAME_KANJI`='佐々木',`LAST_NAME_KANJI`='久留美',`TAISYA_DATE`='2016-01-15',`NYUUSYA_DATE`='2013-03-08',`SYOKUGYO_KIND` =3 WHERE  `SYAIN_ID`=10;


create table kind(
   id INT NOT NULL AUTO_INCREMENT,
   pjt VARCHAR(100) NOT NULL,
   PRIMARY KEY ( id )
);

INSERT INTO `kind` (`id`, `pjt`) VALUES (1, '役員');
INSERT INTO `kind` (`id`, `pjt`) VALUES (2, '総務');
INSERT INTO `kind` (`id`, `pjt`) VALUES (3, 'IT營業');
INSERT INTO `kind` (`id`, `pjt`) VALUES (4, 'ITエンジニア');
INSERT INTO `kind` (`id`, `pjt`) VALUES (5, '不動産スタッフ');
INSERT INTO `kind` (`id`, `pjt`) VALUES (6, '個人事業主');


create table syo(
   id INT NOT NULL AUTO_INCREMENT,
   com VARCHAR(100) NOT NULL,
   PRIMARY KEY ( id )
);

INSERT INTO `syo` (`id`, `com`) VALUES (1, '株式会社ブライトスター');
INSERT INTO `syo` (`id`, `com`) VALUES (2, '株式会社トップクラウド');

*/


SELECT 
syain_id,NYUUSYA_DATE,TAISYA_DATE,m_sex.sex,kind.pjt,syo.com
,CONCAT(syain_main.first_name_kanji, '',syain_main.LAST_NAME_KANJI) as name
FROM syain_main JOIN m_sex ON syain_main.SEIBETU = m_sex.id 
JOIN kind ON syain_main.SYOKUGYO_KIND = kind.id 
JOIN syo ON syain_main.syozoku_kaisya = syo.id 
having name LIKE '%中%';




/*
SYOKUGYO_KIND  職業種類  
NYUUSYA_DATE   入社
TAISYA_DATE    退社
SEIBETU   性別   1男   2女
*/

/*
姓名合起來
SELECT concat(a.FIRST_NAME, '' ,a.LAST_NAME) FROM torihikisaki_tantou a;
*/


/* 
category2
com setting  
SYOZOKU_KAISYA
1 株式会社ブライトスター 
2 株式会社トップクラウド
 */
SELECT category2,VALUE1 FROM tg_setting
WHERE category1 = '1' AND category3 = '1';


/*
category3
SYOKUGYO_KIND
職種  1-6
1 役員
2.総務
3.IT營業
4.ITエンジニア
5.不動産スタッフ
6.個人事業主
*/
SELECT category3,VALUE1 FROM tg_setting
WHERE category1 = '3' AND category2 = '4';
