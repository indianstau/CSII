INSERT INTO `syain_main` 
VALUES (6,'宮', '之本', NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL, 
NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, '2016-08-19', null,2, 
NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 
NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 
'2021-10-07 13:25:40', NULL);  


/* 新增一個社員....   也太多了吧  == */
INSERT INTO `syain_main` 
(`FIRST_NAME_KANJI`, `LAST_NAME_KANJI`, `FIRST_NAME_KANA`, `LAST_NAME_KANA`, 
`FIRST_NAME_EIGO`, `LAST_NAME_EIGO`, `SEIBETU`, `TANJYOBI`, `KOKUSEKI`, `SYUSSINN`, 
`HAIGUSYA`, `PASSPORT_NUM`, `PASSPORT_END_DATE`, `VISA_KIKAN`, `VISA_END_DATE`, 
`ZAIRYU_SIKAKU`, `KOJIN_NUM`, `ZAIRYU_NUM`, `SYOZOKU_KAISYA`, `NYUUSYA_DATE`, 
`TAISYA_DATE`, `SYOKUGYO_KIND`, `RAINITI_DATE`, `BIKOU`, `YUUBIN`, `JYUSYO_1`, 
`JYUSYO_2`, `MOYORI_EKI`, `TEL`, `EMAIL`, `WECHAT`, `LINE`, `BOKOKU_JYUSYO`, 
`BOKOKU_KINNKYUU_RENNRAKU`, `SAISYUU_GAKUREKI`, `GAKKOU_NAME`, `SENNMOM_NAME`, 
`SOTUGYO_DATE`, `GYUMU_NENSU`, `IT_OS`, `IT_GENGO`, `IT_DB`, `IT_WEB_SERVER`, 
`IT_FW`, `IT_OTHER`, `IT_BIKOU`, `DELETE_FLAG`, `TOUROKUBI`, `KOUSINNBI`) 
VALUES ('佐々', '久留', NULL, NULL, NULL, NULL, 2, NULL, NULL, NULL, 
NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, '2016-08-19', '2018-01-15', 6, 
NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 
NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 
'2021-10-07 13:25:40', '2022-10-07 13:25:40');



/*TABLE NAME -> syain_main 
SYOKUGYO_KIND   職業種類  1-6   （TABLE NAME kind）
                         1 役員 2.総務 3.IT營業 4.ITエンジニア 5.不動産スタッフ 6.個人事業主   
NYUUSYA_DATE    入社日
TAISYA_DATE     退社日
SEIBETU         性別    1男   2女  （TABLE NAME m_sex）
SYOZOKU_KAISYA  公司名  1ブライトスター    2トップクラウド    （TABLE NAME syo）


insert name, NYUUSYA_DATE,  TAISYA_DATE, SYOKUGYO_KIND */
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


/*Create kind */
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

/*Create syo */
create table syo(
   id INT NOT NULL AUTO_INCREMENT,
   com VARCHAR(100) NOT NULL,
   PRIMARY KEY ( id )
);

INSERT INTO `syo` (`id`, `com`) VALUES (1, '株式会社ブライトスター');
INSERT INTO `syo` (`id`, `com`) VALUES (2, '株式会社トップクラウド');


/* search name
SELECT 
syain_id,NYUUSYA_DATE,TAISYA_DATE,m_sex.sex,kind.pjt,syo.com
,CONCAT(syain_main.first_name_kanji, '',syain_main.LAST_NAME_KANJI) as name
FROM syain_main JOIN m_sex ON syain_main.SEIBETU = m_sex.id 
JOIN kind ON syain_main.SYOKUGYO_KIND = kind.id 
JOIN syo ON syain_main.syozoku_kaisya = syo.id 
having name LIKE '%中%';
 */


/*姓名合起來
SELECT concat(a.FIRST_NAME, '' ,a.LAST_NAME) FROM torihikisaki_tantou a;
*/


/* 
category2
com setting  
SYOZOKU_KAISYA
1 株式会社ブライトスター 
2 株式会社トップクラウド
SELECT category2,VALUE1 FROM tg_setting
WHERE category1 = '1' AND category3 = '1';

category3
SYOKUGYO_KIND
職種  1-6
SELECT category3,VALUE1 FROM tg_setting
WHERE category1 = '3' AND category2 = '4';
*/

/* 拚字串   四個選項*/
SELECT 
syain_id,NYUUSYA_DATE,TAISYA_DATE,m_sex.sex,kind.pjt,syo.com
,CONCAT(syain_main.first_name_kanji, '',syain_main.LAST_NAME_KANJI) as name
FROM syain_main JOIN m_sex ON syain_main.SEIBETU = m_sex.id 
JOIN kind ON syain_main.SYOKUGYO_KIND = kind.id 
JOIN syo ON syain_main.syozoku_kaisya = syo.id 
having name LIKE '%' AND com = '株式会社ブライトスター' AND TAISYA_DATE IS not NULL 
ORDER BY syain_id;


/* 入社 退社 判斷  
SELECT TAISYA_DATE FROM syain_main WHERE TAISYA_DATE IS NULL;
SELECT TAISYA_DATE FROM syain_main WHERE TAISYA_DATE IS not null;
*/


