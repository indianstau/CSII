<%@page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="jp">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>社內統合管理システム</title>
<style>
    body{margin: 0;}
    h1{text-align: center;}

    a{padding-right: 4px;}
    h2, h3{padding: 4px;}
    h2{background-color: rgb(204, 211, 212);}
    hr{color: blue;}


    ul{list-style: none;font-size: 14px;}
    li{margin-bottom:1%}
    label{
        width: 12%;
        display: inline-block;
    }
</style>
</head>
<body>

    <h1>社內統合管理システム</h1>

    <p><norb>　　登録日時: <div id="current_date">
            <script>
            document.getElementById("current_date").innerHTML = Date();
            </script></norb></div>
        <div style="text-align: right">ユ－ザ名:**<!-- 這裡抓取 -->　権限:ALL<a href="https://www.google.co.jp/" >社員管理画面へ</div></a></p><!-- 這裡抓取 -->
    <h2><span style="color: rgb(20, 156, 215);">　　■</span>社員登録</h2>
    <h3>　　基本情報</h3>
    <hr>

    <form action="/studentInsert"method="get">
        <ul>
            <li>
                <label for="syainmei">社員名(漢字)</label>
                姓　<input type="text" name="FIRST_NAME_KANJI" style="width: 60px;">
                　 　名<input type="text" name="LAST_NAME_KANJI" style="width: 60px;">
                <span style="color: red;">必須</span>
            </li>
            <li>
                <label for="katakana"><nobr>社員名(カタカナ)</nobr></label>
                セイ<input type="text" name="FIRS_NAME_KANA" style="width: 60px;">
               　 メイ<input type="text" name="LAST_NAME_KANA" style="width: 60px;">
                <span style="color: red;">必須</span>
            </li>
            <li>
                <label for="cusname"><nobr>社員名(英語)</nobr></label>
                first name<input type="text" name="FIRS_NAME_EIGO" style="width: 60px;">
                last name<input type="text" name="LAST_NAME_EIGO" style="width: 60px;">
                <span style="color: red;">必須</span>
            </li>
            <li>
                <nobr><label>性別　　　 　　 　　　　　

                <input type="radio" name="gender" value="SEIBETU" checked>男
           　　 <input type="radio" name="gender" value="SEIBETU">女
                </nobr>
			</label>
            </li>
            <li>
                <nobr><label>
				誕生日　　 　 　　 　　　　
				<input type="date" id="start" name="TANJYOBI"
             min="1950-01-01">
                 </label></nobr>
            </li>
            <li>
                <nobr><label>
				国籍　　　　   　　 　 　　　
				<select id="KOKUSEKI">
                    <option value="日本">日本</option>
                    <option value="中国">中国</option>
                    <option value="台湾">台湾</option>
                    <option value="韓国">韓国</option>
                    <option value="アメリカ">アメリカ</option>
                </select>
			</label></nobr>
            </li>
            <li>
                <label for="cusname"><nobr>出身地</label>
            <input type="text" name="SYUSSINN" style="width:620px;">
            </li></nobr>
			<nobr><label>
				配偶者有り無し 　　　　　
				<input type="radio" name="HAIGUSYA" value="h1" checked>有
				<input type="radio" name="HAIGUSYA" value="h2">無
			</label></nobr>
    <h3>個人証明情報</h3>
            <li><label for="passport"><nobr>
                 パスポート番号
				　 　　 　 　<input type="text" name="PASSPORT_NUM">
            </li></nobr>
            <li>
                <nobr><label>
				パスポート有効日　 　 　 　
				<input type="date" id="start" name="PASSPORT_END_DATE"
             min="2012-01-01">
                 </label></nobr>
            </li>
            <li>
                <nobr><label>
				ビザ期限　　　　   　 　 　　
				<select id="VISA_KIKAN">
                    <option value="１年">１年</option>
                    <option value="３年">３年</option>
                    <option value="５年">５年</option>
                    <option value="１０年">１０年</option>
                    <option value="無期限">無期限</option>
                </select>
			</label></nobr>
            </li>
            <li>
                <nobr><label>
				ビザ有効日　　 　　 　　 　
				<input type="date" id="start" name="VISA_END_DATE"
             min="2013-06-01">
                 </label></nobr>
            </li>
            <li>
                <nobr><label>
				在留資格名称　 　 　 　　　
				<select id="ZAIRYU_SIKAKU">
                    <option value="技術・人文知識・国際業務">技術・人文知識・国際業務<!-- 這裡抓取 --></option>
                    <option value="特定活動(ワーキングなど)">特定活動(ワーキングなど)<!-- 這裡抓取 --></option>
                    <option value="家族滞在">家族滞在<!-- 這裡抓取 --></option>
                    <option value="永住者の配偶者等">永住者の配偶者等<!-- 這裡抓取 --></option>
                    <option value="日本人の配偶者等">日本人の配偶者等<!-- 這裡抓取 --></option>
                    <option value="永住者">永住者</option>
                </select>
			</label></nobr>
            </li>
            <li><label for="KOJIN_NUM"><nobr>
                マイナンバー
               　 　　　 　 　<input type="text" name="KOJIN_NUM">
           </li></nobr>
           <li>
            <li><label for="ZAIRYU_NUM"><nobr>
                在留番号
               　 　 　 　　　　　<input type="text" name="ZAIRYU_NUM">
           </li></nobr>
           <h3>会社関連情報</h3>
           <hr>
           <li>
            <nobr><label>
            所属会社　　　 　 　 　　　
            <select id="SYOZOKU_KAISYA">
                <option value="株式会社シエス">株式会社シエス</option>
                <option value="株式会社ブサンド">株式会社ブサンド</option>
                <option value="株式会社なすみ">株式会社なすみ</option>
            </select>
        </label></nobr>
        </li>
        <li>
            <nobr><label>
            入社日　　　　 　　 　　 　
            <input type="date" id="start" name="NYUUSYA_DATE"
         min="2000-01-01">
             </label></nobr>
        </li>
        <li>
            <label for="TAISYA_DATE"><nobr>退社日</nobr></label>
           <input type="text" name="TAISYA_DATE" style="width: 160px;">
            <span style="color: red;">※YYYY-MM-DD</span>
        </li>
        <li>
            <nobr><label>
            職業種類　　　 　 　 　　　
            <select id="SYOKUGYO_KIND">
                <option value="役員">役員<!-- 這裡抓取 --></option>
                <option value="総務">総務<!-- 這裡抓取 --></option>
                <option value="IT営業">IT営業<!-- 這裡抓取 --></option>
                <option value="ITエンジニア">ITエンジニア<!-- 這裡抓取 --></option>
                <option value="不動産スタッフ">不動産スタッフ<!-- 這裡抓取 --></option>
                <option value="個人事業主">個人事業主<!-- 這裡抓取 --></option>
            </select>
        </label></nobr>
        </li>
        <li>
            <nobr><label>
            来日時期　　　 　　 　　 　
            <input type="date" id="start" name="RAINITI_DATE"
         min="2000-01-01">
             </label></nobr>
        </li>
    　　 <li>
        <nobr><label for="BIKOU">備考</label>
                <textarea name="BIKOU" cols="110" rows="3"></textarea></nobr>
            </li>
    <h3>連絡先</h3>
    <hr>
            <li>
            <label for="addsArea">住所</label>〒&nbsp; &nbsp;
            <input type="text" name="YUUBIN" style="width: 100px;">
            </li>
            <li>
            <label for="addsRoad"></label>
            <input type="text" name="JYUSYO_1" style="width: 400px;">
            <span style="color: black;">番地まで</span><br/>
            </li>
            <li>
            <label for="addsRoom"></label>
            <input type="text" name="JYUSYO_2" style="width: 400px;">
            <span style="color: black;">マンション名.号室など</span><br/>
            </li>
            <li>
            <label for="MOYORI_EKI">最寄駅</label>
            <input type="text" name="MOYORI_EKI">
            </li>
            <li>
            <label for="TEL">携帯電話</label>
            <input type="text" name="TEL">
            </li>
            <li>
             <label for="EMAIL">メールアドレス</label>
             <input type="text" name="EMAIL" style="width: 400px;">
            </li>
	　　　<li>
                <label for="WECHAT_ID">WechatID</label>
                <input type="text" name="WECHAT_ID">
            </li>
	　　　<li>
                <label for="LINE_ID">LineID</label>
                <input type="text" name="LINE_ID">
            </li>
 <h3>母国関連</h3>
 	　　　<li>
         <label for="other;valign="top>住所</label>
                <textarea name="BOKOKU_JYUSYO" cols="120" rows="5"></textarea>
            </li>
	　　　<li>
                <label for="BOKOKU_KINNKYUU_RENNRAKU">緊急連絡先</label>
                <textarea name="BOKOKU_KINNKYUU_RENNRAKU" cols="120" rows="5"></textarea>
            </li>
 <h3>学歴情報</h3>
<hr>
  <li style="text-align: center;">

	　　　<li>
        <nobr><label>
        職業種類　　　 　 　 　　　
        <select id="SAISYUU_GAKUREKI">
            <option value="sg1">大学院(博士)<!-- 這裡抓取 --></option>
            <option value="sg2">大学(修士)<!-- 這裡抓取 --></option>
            <option value="sg3">大学<!-- 這裡抓取 --></option>
            <option value="sg4">短期大学<!-- 這裡抓取 --></option>
        </select>
    </label></nobr>
    </li>
	　　　<li>
                <label for="GAKKOU_NAME">学校名</label>
                <input type="text" name="GAKKOU_NAME" style="width: 400px;">
            </li>
	　　　<li>
                <label for="SENNMOM_NAME">専門</label>
                <input type="text" name="SENNMOM_NAME" style="width: 400px;">
            </li>
            　　　<li>
                <nobr><label>
				卒業年月日　　 　　 　　 　
				<input type="date" id="start" name="SOTUGYO_DATE"
             min="1980-06-01">
                 </label></nobr>
            </li>
            <li style="text-align: center;">
                <input type="submit" value="登錄" style="display: inline-block;border: none;font-size: 20px;border-radius: 4px;padding: 4px 16px;">
            </li>
        </ul>
    </form>
</body>
</html>
