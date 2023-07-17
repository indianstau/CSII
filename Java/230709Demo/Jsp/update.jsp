<%@page import="bms.staff.dto.*"%>
<%@page import="java.util.*"%>
<%@page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="jp">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>社內統合管理システム</title>
<style>
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
    form{margin-bottom:10%;}
    .inline{display:inline;}
    .btn{
    	display: inline-block;
    	border: none;
    	font-size: 22px;
    	border-radius: 4px;
    	padding: 8px 30px;
    	margin-top:100px;
    	background-color:lightgreen;
    }
</style>
</head>
<body>
    <h1>社內統合管理システム</h1>
    <div><a href="/bmsweb/menu.jsp" style="margin-right:3%;">
    		<img src="https://cdn-icons-png.flaticon.com/512/151/151409.png" style="width:3%;"></a>
    <p class="inline">登録日時:
    	<span id="current_time"></span>
    	<a href="staffSearch.jsp">回上一頁</a>
   	</p>

 <!--       <div style="text-align: right">ユ－ザ名:**-->
 		    <!-- 這裡抓取 -->　
 <!-- 		権限:ALL<a href="StaffList" >社員管理画面へ</div></a></p>-->
 		    <!-- 這裡抓取 -->

    <h2><span style="color: rgb(20, 156, 215);">　　■</span>社員登録</h2>
    <h3>基本情報</h3><hr>

<%
	StaffInsertDto stfIdto = (StaffInsertDto)request.getAttribute("keyStaff");
	ArrayList<StaffOptComDto> alCom = (ArrayList) request.getAttribute("comAl");
	ArrayList<StaffOptPjtDto> alPjt = (ArrayList) request.getAttribute("pjtAl");
	
%>

    <form action="/bmsweb/staffUpdate" method="post">
        <ul>
        	<li>
        		<label for="id"></label>
        		<input type="text" name="id" style="display:none;" value="<%=stfIdto.getSYAIN_ID() %>">
        	</li>
        	<li><label for="syainmei">社員名(漢字)</label>
                姓<input type="text" name="FIRST_NAME_KANJI" style="width: 60px;" value="<%=stfIdto.getFIRST_NAME_KANJI() %>">
                名<input type="text" name="LAST_NAME_KANJI" style="width: 60px;" value="<%=stfIdto.getLAST_NAME_KANJI() %>">
                <span style="color: red;">必須</span>
            </li>
            <li><label for="katakana"><nobr>社員名(カタカナ)</nobr></label>
                セイ<input type="text" name="FIRST_NAME_KANA" style="width: 60px;" value="<%=stfIdto.getFIRST_NAME_KANA() %>">
                メイ<input type="text" name="LAST_NAME_KANA" style="width: 60px;" value="<%=stfIdto.getLAST_NAME_KANA() %>">
                <span style="color: red;">必須</span>
            </li>
            <li><label for="cusname"><nobr>社員名(英語)</nobr></label>
                first name<input type="text" name="FIRST_NAME_EIGO" style="width: 60px;" value="<%=stfIdto.getFIRST_NAME_EIGO() %>">
                last name<input type="text" name="LAST_NAME_EIGO" style="width: 60px;" value="<%=stfIdto.getLAST_NAME_EIGO() %>">
                <span style="color: red;">必須</span>
            </li>
            <li><label class="inline">性別　　　 　　 　　　
				<span id="seb" style="display:none;"><%=stfIdto.getSEIBETU() %></span>　　
                <input type="radio" name="SEIBETU" value="1">男
           　　  <input type="radio" name="SEIBETU" value="2">女</label>
            </li>
            <li><label class="inline">誕生日　　 　 　　 　　　　
				<input type="date" name="TANJYOBI" min="1950-01-01" value="<%=stfIdto.getTANJYOBI() %>"></label>
            </li>
            <li><label class="inline">国籍
            	<span id="kok" style="display:none;"><%=stfIdto.getKOKUSEKI() %></span>　
            	<select name="KOKUSEKI" style="margin-left:150px;">
            		<option value="0"></option>
                    <option value="1">日本</option>
                    <option value="2">中国</option>
                    <option value="3">台湾</option>
                    <option value="4">韓国</option>
                    <option value="5">アメリカ</option>
                </select></label>
            </li>
            <li><label for="cusname">出身地</label>
            	<input type="text" name="SYUSSINN" style="width:620px;" value="<%=stfIdto.getSYUSSINN() %>">
            </li>
           	<li><label class="inline">配偶者有り無し 　　　
           		<span id="hai" style="display:none;"><%=stfIdto.getHAIGUSYA() %></span>　　　　
				<input type="radio" name="HAIGUSYA" value="1">有
				<input type="radio" name="HAIGUSYA" value="2">無</label>
			</li>
		</ul>

		<h3>個人証明情報</h3>
 		<ul><li><label for="passport" class="inline">パスポート番号
				<input type="text" name="PASSPORT_NUM" style="margin-left:80px;" value="<%=stfIdto.getPASSPORT_NUM() %>"></label>
            </li>
            <li><label class="inline">パスポート有効日　 　 　 　
				<input type="date" name="PASSPORT_END_DATE" min="2012-01-01" value="<%=stfIdto.getPASSPORT_END_DATE() %>"></label>
            </li>
            <li><label class="inline">ビザ期限　　　　
            	<span id="vis" style="display:none;"><%=stfIdto.getVISA_KIKAN() %></span>　　   　 　 　　
				<select name="VISA_KIKAN">
					<option value="0"></option>
                    <option value="1">１年</option>
                    <option value="2">３年</option>
                    <option value="3">５年</option>
                    <option value="4">１０年</option>
                    <option value="5">無期限</option>
                </select></label>
            </li>
            <li><label class="inline">ビザ有効日　　 　　 　　 　
				<input type="date" name="VISA_END_DATE" min="2013-06-01" value="<%=stfIdto.getVISA_END_DATE() %>"></label>
            </li>
            <li><label class="inline">在留資格名称　 　
            	<span id="zai" style="display:none;"><%=stfIdto.getZAIRYU_SIKAKU() %></span> 　 　　　
				<select name="ZAIRYU_SIKAKU">
					<option value="0"></option>
                    <option value="1">技術・人文知識・国際業務</option>
                    <option value="2">特定活動(ワーキングなど</option>
                    <option value="3">家族滞在</option>
                    <option value="4">永住者の配偶者等</option>
                    <option value="5">日本人の配偶者等</option>
                    <option value="6">永住者</option>
                </select></label>
            </li>
            <li><label for="KOJIN_NUM" class="inline">マイナンバー
    　 　　　 　 　<input type="text" name="KOJIN_NUM" value="<%=stfIdto.getKOJIN_NUM() %>"></label>
            </li>
            <li>
			<li><label for="ZAIRYU_NUM" class="inline">在留番号
     　 　 　 　　<input type="text" name="ZAIRYU_NUM" style="margin-left: 42px;" value="<%=stfIdto.getZAIRYU_NUM() %>"></label>
			</li>
		</ul>
		
        <h3>会社関連情報</h3><hr>
        <ul><li><label class="inline">所属会社　　
            　 　<select name="SYOZOKU_KAISYA" style="margin-left: 60px;">
            		<option value="0"></option>
<%  
	int syoSya = stfIdto.getSYOZOKU_KAISYA();
	if(alCom != null){
	for(StaffOptComDto arr:alCom){
%>         			
					<option value="<%=arr.getId() %>" <%=syoSya==arr.getId()?"selected":"" %>><%=arr.getCom() %></option>
<% }} %>   	    </select>
        　 　 　 　　　
<!--     <select name="SYOZOKU_KAISYA">
	                <option value="1">株式会社シエス</option>
	                <option value="2">株式会社ブサンド</option>
	                <option value="3">株式会社なすみ</option>
            	</select>
 -->
            	</label>
        	</li>
        	<li><label class="inline">入社日　　　　 　　 　　 　
            	<input type="date" name="NYUUSYA_DATE" min="2000-01-01" value="<%=stfIdto.getNYUUSYA_DATE() %>"></label>
        	</li>
        	<li><label for="TAISYA_DATE">退社日</label>
           		<input type="text" name="TAISYA_DATE" style="width: 160px;" value="<%=stfIdto.getTAISYA_DATE() %>">
            	<span style="color: red;">※YYYY-MM-DD</span>
        	</li>

	        <li><label class="inline">職業種類　　　 　 　 　　　
	            <select name="SYOKUGYO_KIND">
	            	<option value="0"></option>
<%  int syoKin = stfIdto.getSYOKUGYO_KIND();
	if(alPjt != null){
	for(StaffOptPjtDto arr:alPjt){
%>         		<option value="<%=arr.getId() %>" <%=syoKin == arr.getId()?"selected":"" %>>
							   <%=arr.getPjt() %></option>
<% }} %>  
<!--                  <option value="1">役員</option>
	                <option value="2">総務</option>
	                <option value="3">IT営業</option>
	                <option value="4">ITエンジニア</option>
	                <option value="5">不動産スタッフ</option>
	                <option value="6">個人事業主</option>  -->	
	            </select>

	            </label>
	        </li>
	        <li><label class="inline">来日時期　　　 　　 　　 　
	            <input type="date" name="RAINITI_DATE" min="2000-01-01" value="<%=stfIdto.getRAINITI_DATE() %>"></label>
	        </li>
	    　　 <li><label for="BIKOU" class="inline" style="margin-right:150px;">備考</label>
                <textarea name="BIKOU" cols="110" rows="3"><%=stfIdto.getBIKOU() %></textarea>
			</li>
		</ul>

    	<h3>連絡先</h3><hr>
    	<ul><li><label for="addsArea">住所</label>〒&nbsp; &nbsp;
            	<input type="text" name="YUUBIN" style="width: 100px;" value="<%=stfIdto.getYUUBIN() %>">
            </li>
            <li><label for="addsRoad"></label>
	            <input type="text" name="JYUSYO_1" style="width: 400px;" value="<%=stfIdto.getJYUSYO_1() %>">
	            <span style="color: black;">番地まで</span><br/>
            </li>
            <li><label for="addsRoom"></label>
	            <input type="text" name="JYUSYO_2" style="width: 400px;" value="<%=stfIdto.getJYUSYO_2() %>">
	            <span style="color: black;">マンション名.号室など</span><br/>
            </li>
            <li><label for="MOYORI_EKI">最寄駅</label>
	            <input type="text" name="MOYORI_EKI" value="<%=stfIdto.getMOYORI_EKI() %>">
            </li>
            <li><label for="TEL">携帯電話</label>
	            <input type="text" name="TEL" value="<%=stfIdto.getTEL() %>">
            </li>
            <li><label for="EMAIL">メールアドレス</label>
	            <input type="text" name="EMAIL" style="width: 400px;" value="<%=stfIdto.getEMAIL() %>">
            </li>
	　　　	<li><label for="WECHAT">WechatID</label>
                <input type="text" name="WECHAT" value="<%=stfIdto.getWECHAT() %>">
            </li>
	　　　	<li><label for="LINE">LineID</label>
                <input type="text" name="LINE" value="<%=stfIdto.getLINE() %>">
            </li>
		</ul>

 		<h3>母国関連</h3>
		<ul><li class="inline"><label for="other">住所</label>
                <textarea name="BOKOKU_JYUSYO" cols="120" rows="5" style="margin-bottom:20px;"><%=stfIdto.getBOKOKU_JYUSYO() %></textarea>
            </li>
	　　　	<li class="inline"><label for="BOKOKU_KINNKYUU_RENNRAKU">緊急連絡先</label>
                <textarea name="BOKOKU_KINNKYUU_RENNRAKU" cols="120" rows="5"><%=stfIdto.getBOKOKU_KINNKYUU_RENNRAKU() %></textarea>
            </li>
        </ul>

 		<h3>学歴情報</h3><hr>
 		<ul>
			<li><label class="inline">職業種類
					<span id="sgi" style="display:none;"><%=stfIdto.getSAISYUU_GAKUREKI() %></span>
					<select name="SAISYUU_GAKUREKI" style="margin-left: 120px;">
						<option value="0"></option>
			            <option value="1">大学院(博士)</option>
			            <option value="2">大学(修士)</option>
			            <option value="3">大学</option>
			            <option value="4">短期大学</option>
				</select></label>
			</li>
			<li><label for="GAKKOU_NAME">学校名</label>
				<input type="text" name="GAKKOU_NAME" style="width: 400px;" value="<%=stfIdto.getGAKKOU_NAME() %>">
			</li>
		　　 <li><label for="SENNMOM_NAME">専門</label>
				<input type="text" name="SENNMOM_NAME" style="width: 400px;" value="<%=stfIdto.getSENNMOM_NAME() %>">
			</li>
			<li><label class="inline">卒業年月日　　 　　 　　 　
				<input type="date" name="SOTUGYO_DATE" min="1980-06-01" value="<%=stfIdto.getSOTUGYO_DATE() %>"></label><br/>
			</li>
			<li style="text-align: center;">
				<input type="submit" value="更新" class="btn">
			</li>
        </ul>
    </form>


<script>

function showTime(){
		var NowDate = new Date();
		var y = NowDate.getFullYear();
		var m = NowDate.getMonth()+1;
		var d = NowDate.getDate();
		var h = NowDate.getHours();
		var min = NowDate.getMinutes();
		var s = NowDate.getSeconds();　
		document.getElementById('current_time').innerHTML = y+ "/"+m+"/"+d+ "__  " +h+"時"+min+"分"+s+"秒";
		setTimeout('showTime()',1000);
	
	
		//document.getElementById("current_time").innerHTML = new Date();
		//setTimeout('showTime()',1000);
	}

	showTime();

	// Radio
	// 性別      Id ("seb") value  ;  Name("SEIBETU")          tar
	// 有沒配偶   Id ("hai") value  ;  Name("HAIGUSYA")         tar
	
	// select option
	// 學歷      Id("sgi")  value  ;  Name("SAISYUU_GAKUREKI") tar
	
	// a[0].type
	function valueOn(tar,value){
		var a = document.getElementById(value);
		var b = document.getElementsByName(tar);
		
		// type 不是radio時
		if(b[0].type!="radio"){
			b = b[0];
		}
		
		for(var i=0; i<b.length; i++){
			if(b[i].value==a.textContent){
				if(b[0].type=="radio"){
					b[i].checked = true;
				}else{
					b[i].selected = true;
				}
			}
		}
	}
	
	valueOn("SEIBETU","seb");
	valueOn("HAIGUSYA","hai");
	
	valueOn("SAISYUU_GAKUREKI","sgi");
	valueOn("ZAIRYU_SIKAKU","zai");
	valueOn("VISA_KIKAN","vis");
	valueOn("KOKUSEKI","kok");
	
	//資格, Visa limlt, 国籍


</script>


</body>
</html>
