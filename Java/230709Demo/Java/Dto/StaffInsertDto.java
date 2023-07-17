package bms.staff.dto;

import java.sql.Date;

public class StaffInsertDto {
	 //------基本情報--------
	private int SYAIN_ID;
	//社員ID
	private String FIRST_NAME_KANJI;
	//社員名(漢字) 姓
	private String LAST_NAME_KANJI;
	//社員名(漢字) 名
	private String FIRST_NAME_KANA;
	//社員名(カタカナ) セイ
	private String LAST_NAME_KANA;
	//社員名(カタカナ) メイ
	private String FIRST_NAME_EIGO;
	//社員名(英語) first name
	private String LAST_NAME_EIGO;
	//社員名(英語)  last name
	private int SEIBETU;
	//性別
	private Date TANJYOBI;
	//誕生日　
	private int KOKUSEKI;
	//国籍
	private String SYUSSINN;
	//出身地
	private int HAIGUSYA;
	//配偶者有り無し

	//------個人証明情報-------

	private String PASSPORT_NUM;
	//パスポート番号
	private Date PASSPORT_END_DATE;
	//パスポート有効日
	private int VISA_KIKAN;
	//ビザ期限
	private Date VISA_END_DATE;
	//ビザ有効日
	private int ZAIRYU_SIKAKU;
	//在留資格名称
	private String KOJIN_NUM;
	//マイナンバー
	private String ZAIRYU_NUM;
	//在留番号 

	//-----会社関連情報---------

	private int SYOZOKU_KAISYA;
	//所属会社
	private Date NYUUSYA_DATE;
	//入社日
	private Date TAISYA_DATE;
	//退社日
	private int SYOKUGYO_KIND;
	//職業種類　
	private Date RAINITI_DATE;
	//来日時期
	private String BIKOU;
	//備考

	//-------連絡先-----

	private String YUUBIN;
	//住所の〒 
	private String JYUSYO_1;
	//住所の 番地まで
	private String JYUSYO_2;
	//住所のマンション名.号室など
	private String MOYORI_EKI;
	//最寄駅
	private String TEL;
	//携帯電話
	private String EMAIL;
	//メールアドレス
	private String WECHAT;
	//WechatID
	private String LINE;
	//LineID

	//-----母国関連-----

	private String BOKOKU_JYUSYO;
	//住所
	private String BOKOKU_KINNKYUU_RENNRAKU;
	//緊急連絡先

	//-----学歴情報----

	private int SAISYUU_GAKUREKI;
	//職業種類
	private String GAKKOU_NAME;
	//学校名
	private String SENNMOM_NAME;
	//専門
	private Date SOTUGYO_DATE;
	//卒業年月日
	public int getSYAIN_ID() {
		return SYAIN_ID;
	}
	public void setSYAIN_ID(int sYAIN_ID) {
		SYAIN_ID = sYAIN_ID;
	}
	public String getFIRST_NAME_KANJI() {
		return FIRST_NAME_KANJI;
	}
	public void setFIRST_NAME_KANJI(String fIRST_NAME_KANJI) {
		FIRST_NAME_KANJI = fIRST_NAME_KANJI;
	}
	public String getLAST_NAME_KANJI() {
		return LAST_NAME_KANJI;
	}
	public void setLAST_NAME_KANJI(String lAST_NAME_KANJI) {
		LAST_NAME_KANJI = lAST_NAME_KANJI;
	}
	public String getFIRST_NAME_KANA() {
		return FIRST_NAME_KANA;
	}
	public void setFIRST_NAME_KANA(String fIRST_NAME_KANA) {
		FIRST_NAME_KANA = fIRST_NAME_KANA;
	}
	public String getLAST_NAME_KANA() {
		return LAST_NAME_KANA;
	}
	public void setLAST_NAME_KANA(String lAST_NAME_KANA) {
		LAST_NAME_KANA = lAST_NAME_KANA;
	}
	public String getFIRST_NAME_EIGO() {
		return FIRST_NAME_EIGO;
	}
	public void setFIRST_NAME_EIGO(String fIRST_NAME_EIGO) {
		FIRST_NAME_EIGO = fIRST_NAME_EIGO;
	}
	public String getLAST_NAME_EIGO() {
		return LAST_NAME_EIGO;
	}
	public void setLAST_NAME_EIGO(String lAST_NAME_EIGO) {
		LAST_NAME_EIGO = lAST_NAME_EIGO;
	}
	public int getSEIBETU() {
		return SEIBETU;
	}
	public void setSEIBETU(int sEIBETU) {
		SEIBETU = sEIBETU;
	}
	public Date getTANJYOBI() {
		return TANJYOBI;
	}
	public void setTANJYOBI(Date tANJYOBI) {
		TANJYOBI = tANJYOBI;
	}
	public int getKOKUSEKI() {
		return KOKUSEKI;
	}
	public void setKOKUSEKI(int kOKUSEKI) {
		KOKUSEKI = kOKUSEKI;
	}
	public String getSYUSSINN() {
		return SYUSSINN;
	}
	public void setSYUSSINN(String sYUSSINN) {
		SYUSSINN = sYUSSINN;
	}
	public int getHAIGUSYA() {
		return HAIGUSYA;
	}
	public void setHAIGUSYA(int hAIGUSYA) {
		HAIGUSYA = hAIGUSYA;
	}
	public String getPASSPORT_NUM() {
		return PASSPORT_NUM;
	}
	public void setPASSPORT_NUM(String pASSPORT_NUM) {
		PASSPORT_NUM = pASSPORT_NUM;
	}
	public Date getPASSPORT_END_DATE() {
		return PASSPORT_END_DATE;
	}
	public void setPASSPORT_END_DATE(Date pASSPORT_END_DATE) {
		PASSPORT_END_DATE = pASSPORT_END_DATE;
	}
	public int getVISA_KIKAN() {
		return VISA_KIKAN;
	}
	public void setVISA_KIKAN(int vISA_KIKAN) {
		VISA_KIKAN = vISA_KIKAN;
	}
	public Date getVISA_END_DATE() {
		return VISA_END_DATE;
	}
	public void setVISA_END_DATE(Date vISA_END_DATE) {
		VISA_END_DATE = vISA_END_DATE;
	}
	public int getZAIRYU_SIKAKU() {
		return ZAIRYU_SIKAKU;
	}
	public void setZAIRYU_SIKAKU(int zAIRYU_SIKAKU) {
		ZAIRYU_SIKAKU = zAIRYU_SIKAKU;
	}
	public String getKOJIN_NUM() {
		return KOJIN_NUM;
	}
	public void setKOJIN_NUM(String kOJIN_NUM) {
		KOJIN_NUM = kOJIN_NUM;
	}
	public String getZAIRYU_NUM() {
		return ZAIRYU_NUM;
	}
	public void setZAIRYU_NUM(String zAIRYU_NUM) {
		ZAIRYU_NUM = zAIRYU_NUM;
	}
	public int getSYOZOKU_KAISYA() {
		return SYOZOKU_KAISYA;
	}
	public void setSYOZOKU_KAISYA(int sYOZOKU_KAISYA) {
		SYOZOKU_KAISYA = sYOZOKU_KAISYA;
	}
	public Date getNYUUSYA_DATE() {
		return NYUUSYA_DATE;
	}
	public void setNYUUSYA_DATE(Date nYUUSYA_DATE) {
		NYUUSYA_DATE = nYUUSYA_DATE;
	}
	public Date getTAISYA_DATE() {
		return TAISYA_DATE;
	}
	public void setTAISYA_DATE(Date tAISYA_DATE) {
		TAISYA_DATE = tAISYA_DATE;
	}
	public int getSYOKUGYO_KIND() {
		return SYOKUGYO_KIND;
	}
	public void setSYOKUGYO_KIND(int sYOKUGYO_KIND) {
		SYOKUGYO_KIND = sYOKUGYO_KIND;
	}
	public Date getRAINITI_DATE() {
		return RAINITI_DATE;
	}
	public void setRAINITI_DATE(Date rAINITI_DATE) {
		RAINITI_DATE = rAINITI_DATE;
	}
	public String getBIKOU() {
		return BIKOU;
	}
	public void setBIKOU(String bIKOU) {
		BIKOU = bIKOU;
	}
	public String getYUUBIN() {
		return YUUBIN;
	}
	public void setYUUBIN(String yUUBIN) {
		YUUBIN = yUUBIN;
	}
	public String getJYUSYO_1() {
		return JYUSYO_1;
	}
	public void setJYUSYO_1(String jYUSYO_1) {
		JYUSYO_1 = jYUSYO_1;
	}
	public String getJYUSYO_2() {
		return JYUSYO_2;
	}
	public void setJYUSYO_2(String jYUSYO_2) {
		JYUSYO_2 = jYUSYO_2;
	}
	public String getMOYORI_EKI() {
		return MOYORI_EKI;
	}
	public void setMOYORI_EKI(String mOYORI_EKI) {
		MOYORI_EKI = mOYORI_EKI;
	}
	public String getTEL() {
		return TEL;
	}
	public void setTEL(String tEL) {
		TEL = tEL;
	}
	public String getEMAIL() {
		return EMAIL;
	}
	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}
	public String getWECHAT() {
		return WECHAT;
	}
	public void setWECHAT(String wECHAT) {
		WECHAT = wECHAT;
	}
	public String getLINE() {
		return LINE;
	}
	public void setLINE(String lINE) {
		LINE = lINE;
	}
	public String getBOKOKU_JYUSYO() {
		return BOKOKU_JYUSYO;
	}
	public void setBOKOKU_JYUSYO(String bOKOKU_JYUSYO) {
		BOKOKU_JYUSYO = bOKOKU_JYUSYO;
	}
	public String getBOKOKU_KINNKYUU_RENNRAKU() {
		return BOKOKU_KINNKYUU_RENNRAKU;
	}
	public void setBOKOKU_KINNKYUU_RENNRAKU(String bOKOKU_KINNKYUU_RENNRAKU) {
		BOKOKU_KINNKYUU_RENNRAKU = bOKOKU_KINNKYUU_RENNRAKU;
	}
	public int getSAISYUU_GAKUREKI() {
		return SAISYUU_GAKUREKI;
	}
	public void setSAISYUU_GAKUREKI(int sAISYUU_GAKUREKI) {
		SAISYUU_GAKUREKI = sAISYUU_GAKUREKI;
	}
	public String getGAKKOU_NAME() {
		return GAKKOU_NAME;
	}
	public void setGAKKOU_NAME(String gAKKOU_NAME) {
		GAKKOU_NAME = gAKKOU_NAME;
	}
	public String getSENNMOM_NAME() {
		return SENNMOM_NAME;
	}
	public void setSENNMOM_NAME(String sENNMOM_NAME) {
		SENNMOM_NAME = sENNMOM_NAME;
	}
	public Date getSOTUGYO_DATE() {
		return SOTUGYO_DATE;
	}
	public void setSOTUGYO_DATE(Date sOTUGYO_DATE) {
		SOTUGYO_DATE = sOTUGYO_DATE;
	}
	

}
