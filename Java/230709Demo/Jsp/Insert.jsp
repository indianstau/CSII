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
    .inline{display:inline;}
</style>
</head>
<body>
    <h1>社內統合管理システム</h1>
    <p class="inline">登録日時:<span id="current_date"></span></p>

 <!--       <div style="text-align: right">ユ－ザ名:**-->
 		    <!-- 這裡抓取 -->　
 <!-- 		権限:ALL<a href="StaffList" >社員管理画面へ</div></a></p>-->
 		    <!-- 這裡抓取 -->

    <h2><span style="color: rgb(20, 156, 215);">　　■</span>社員登録</h2>
    <h3>基本情報</h3><hr>

    <form action="/bmsweb/staffList" method="post">
        <ul><li><label for="syainmei">社員名(漢字)</label>
                姓<input type="text" name="FIRST_NAME_KANJI" required="required" style="width: 60px;">
                名<input type="text" name="LAST_NAME_KANJI" required="required" style="width: 60px;">
                <span style="color: red;">必須</span>
            </li>
            <li><label for="katakana"><nobr>社員名(カタカナ)</nobr></label>
                セイ<input type="text" name="FIRST_NAME_KANA" required="required" style="width: 60px;">
                メイ<input type="text" name="LAST_NAME_KANA" required="required" style="width: 60px;">
                <span style="color: red;">必須</span>
            </li>
            <li><label for="cusname"><nobr>社員名(英語)</nobr></label>
                first name<input type="text" name="FIRST_NAME_EIGO" required="required" style="width: 60px;">
                last name<input type="text" name="LAST_NAME_EIGO" required="required" style="width: 60px;">
                <span style="color: red;">必須</span>
            </li>
            <li><label class="inline">性別　　　 　　 　　　　　
                <input type="radio" name="SEIBETU" value="1" checked>男
           　　  <input type="radio" name="SEIBETU" value="2">女</label>
            </li>
            <li><label class="inline">誕生日　　 　 　　 　　　　
				<input type="date" id="start" name="TANJYOBI" min="1950-01-01"></label>
            </li>
            <li><label class="inline">国籍
            	<select name="KOKUSEKI" style="margin-left:20px;">
                    <option value="1">日本</option>
                    <option value="2">中国</option>
                    <option value="3">台湾</option>
                    <option value="4">韓国</option>
                    <option value="5">アメリカ</option>
                </select></label>
            </li>
            <li><label for="cusname">出身地</label>
            	<input type="text" name="SYUSSINN" style="width:620px;">
            </li>
           	<li><label class="inline">配偶者有り無し 　　　　　
				<input type="radio" name="HAIGUSYA" value="1" checked>有
				<input type="radio" name="HAIGUSYA" value="2">無</label>
			</li>
		</ul>

		<h3>個人証明情報</h3>
 		<ul><li><label for="passport" class="inline">パスポート番号
				<input type="text" name="PASSPORT_NUM"></label>
            </li>
            <li><label class="inline">パスポート有効日　 　 　 　
				<input type="date" id="start" name="PASSPORT_END_DATE" min="2012-01-01"></label>
            </li>
            <li><label class="inline">ビザ期限　　　　   　 　 　　
				<select name="VISA_KIKAN">
                    <option value="1">１年</option>
                    <option value="2">３年</option>
                    <option value="3">５年</option>
                    <option value="4">１０年</option>
                    <option value="5">無期限</option>
                </select></label>
            </li>
            <li><label class="inline">ビザ有効日　　 　　 　　 　
				<input type="date" id="start" name="VISA_END_DATE" min="2013-06-01"></label>
            </li>
            <li><label class="inline">在留資格名称　 　 　 　　　
				<select name="ZAIRYU_SIKAKU">
                    <option value="1">技術・人文知識・国際業務</option>
                    <option value="2">特定活動(ワーキングなど</option>
                    <option value="3">家族滞在</option>
                    <option value="4">永住者の配偶者等</option>
                    <option value="5">日本人の配偶者等</option>
                    <option value="6">永住者</option>
                </select></label>
            </li>
            <li><label for="KOJIN_NUM" class="inline">マイナンバー
    　 　　　 　 　<input type="text" name="KOJIN_NUM"></label>
            </li>
            <li>
			<li><label for="ZAIRYU_NUM" class="inline">在留番号
     　 　 　 　　<input type="text" name="ZAIRYU_NUM"></label>
			</li>
		</ul>

        <h3>会社関連情報</h3><hr>
        <ul><li><label class="inline">所属会社　　　 　 　 　　　
            	<select name="SYOZOKU_KAISYA">
	                <option value="1">株式会社シエス</option>
	                <option value="2">株式会社ブサンド</option>
	                <option value="3">株式会社なすみ</option>
            	</select></label>
        	</li>
        	<li><label class="inline">入社日　　　　 　　 　　 　
            	<input type="date" id="start" name="NYUUSYA_DATE" min="2000-01-01"></label>
        	</li>
        	<li><label for="TAISYA_DATE">退社日</label>
           		<input type="text" name="TAISYA_DATE" style="width: 160px;">
            	<span style="color: red;">※YYYY-MM-DD</span>
        	</li>
	        <li><label class="inline">職業種類　　　 　 　 　　　
	            <select name="SYOKUGYO_KIND">
	                <option value="1">役員</option>
	                <option value="2">総務</option>
	                <option value="3">IT営業</option>
	                <option value="4">ITエンジニア</option>
	                <option value="5">不動産スタッフ</option>
	                <option value="6">個人事業主</option>
	            </select></label>
	        </li>
	        <li><label class="inline">来日時期　　　 　　 　　 　
	            <input type="date" id="start" name="RAINITI_DATE" min="2000-01-01"></label>
	        </li>
	    　　 <li><label for="BIKOU" class="inline">備考</label>
                <textarea name="BIKOU" cols="110" rows="3"></textarea>
			</li>
		</ul>

    	<h3>連絡先</h3><hr>
    	<ul><li><label for="addsArea">住所</label>〒&nbsp; &nbsp;
            	<input type="text" name="YUUBIN" style="width: 100px;">
            </li>
            <li><label for="addsRoad"></label>
	            <input type="text" name="JYUSYO_1" style="width: 400px;">
	            <span style="color: black;">番地まで</span><br/>
            </li>
            <li><label for="addsRoom"></label>
	            <input type="text" name="JYUSYO_2" style="width: 400px;">
	            <span style="color: black;">マンション名.号室など</span><br/>
            </li>
            <li><label for="MOYORI_EKI">最寄駅</label>
	            <input type="text" name="MOYORI_EKI">
            </li>
            <li><label for="TEL">携帯電話</label>
	            <input type="text" name="TEL">
            </li>
            <li><label for="EMAIL">メールアドレス</label>
	            <input type="text" name="EMAIL" style="width: 400px;">
            </li>
	　　　	<li><label for="WECHAT">WechatID</label>
                <input type="text" name="WECHAT">
            </li>
	　　　	<li><label for="LINE">LineID</label>
                <input type="text" name="LINE">
            </li>
		</ul>

 		<h3>母国関連</h3>
		<ul><li class="inline"><label for="other">住所</label>
                <textarea name="BOKOKU_JYUSYO" cols="120" rows="5"></textarea>
            </li>
	　　　	<li class="inline"><label for="BOKOKU_KINNKYUU_RENNRAKU">緊急連絡先</label>
                <textarea name="BOKOKU_KINNKYUU_RENNRAKU" cols="120" rows="5"></textarea>
            </li>
        </ul>

 		<h3>学歴情報</h3><hr>
 		<ul>
			<li><label class="inline">職業種類
					<select name="SAISYUU_GAKUREKI">
			            <option value="1">大学院(博士)</option>
			            <option value="2">大学(修士)</option>
			            <option value="3">大学</option>
			            <option value="4">短期大学</option>
				</select></label>
			</li>
			<li><label for="GAKKOU_NAME">学校名</label>
				<input type="text" name="GAKKOU_NAME" style="width: 400px;">
			</li>
		　　 <li><label for="SENNMOM_NAME">専門</label>
				<input type="text" name="SENNMOM_NAME" style="width: 400px;">
			</li>
			<li><label class="inline">卒業年月日　　 　　 　　 　
				<input type="date" id="SOTUGYO_DATE" name="SOTUGYO_DATE" min="1980-06-01"></label>
			</li>
			<li style="text-align: center;">
				<input type="submit" value="登錄" class="button" style="display: inline-block;border: none;font-size: 20px;border-radius: 4px;padding: 4px 16px;">
			</li>
        </ul>
    </form>


<script>
	document.getElementById("current_date").innerHTML = Date();
</script>


</body>
</html>
