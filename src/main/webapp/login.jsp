<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE>固定资产净值系统</TITLE>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<LINK 
href="/fixednetassets/css/public.css" type=text/css rel=stylesheet>
<LINK 
href="/fixednetassets/css/login.css" type=text/css rel=stylesheet>
<script type="text/javascript" src="/fixednetassets/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="/fixednetassets/js/My97DatePicker/calendar.js"></script>
<script type="text/javascript" src="/fixednetassets/js/jquery-1.8.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$.post("/fixednetassets/account/all.do",function(data){
		//	alert(data[0].year);
			for(var i=0;i<data.length;i++){
				var temp = "<option value='"+data[i].year+"'>"+data[i].year+"-01-01</option>";
				$("#account").append(temp);
			}
		})
	
	
	
		$("#account").change(function(){
			
			if($(this).val() == "99"){
				$("#accountyear").show();
			}else{
				$("#accountyear").hide();
				$("#year").empty();
				$("#year").html("<option value='"+$(this).val()+"'>"+$(this).val()+"</option>");
			}
				
		})
		$("#newaccountsubmit").click(function(){
			$.post("/fixednetassets/account/add.do",{year:$("#newaccount").val()},function(data){
				if(data == true){
					alert("添加成功");
					window.location.href="/fixednetassets/login.jsp";
				}
			})
		})
	
	})
	function check(){
		if($("#year").val() == ""){
			alert("请选择年份");
			return false;
		}
		if($("#logintime").val() == ""){
			alert("请选择登录时间");
			return false;
		}
	
	}

</script>
<STYLE type=text/css>

</STYLE>
<META content="MSHTML 6.00.2900.5848" name=GENERATOR>
</HEAD>
<BODY>
<form action="/fixednetassets/system/login.do" Method="post" onsubmit="return check()">
<DIV id=div1>
  <TABLE id=login height="100%" cellSpacing=0 cellPadding=0 width=800 
align=center >
    <TBODY>
      <TR id=main>
        <TD>
          <TABLE height="100%" cellSpacing=0 cellPadding=0 width="100%">
            <TBODY>
              <TR>
                <TD style="text-align:right;font-size:40px">&nbsp;固定资产净值系统</TD>
              </TR>
              
              <TR height=30>
                <TD rowSpan=6>&nbsp;</TD>
                <TD>用户名：</TD>
                <TD>
                  <INPUT class=textbox id="name" name="name">
                </TD>
                <TD width=120>&nbsp;</TD>
              </TR>
              <TR height=40>
                <TD>密　码：</TD>
                <TD>
                  <INPUT class=textbox id="pass" type=password 
            name="pass">
                </TD>
                <TD width=120>&nbsp;</TD>
              </TR>

      		<TR height=50>
                <TD>所属账套：</TD>
                <TD>
                  <select id="account" name="account"> <option value="">请选择帐套</option><option value="99">新建帐套</option></select>
                </TD>
                <TD width=120>&nbsp;</TD>                
            </TR>
			<TR id="accountyear" height=50 style="display:none">
			 	<TD>帐套年份</TD>
				<TD><input id="newaccount" name="newaccount" onclick="WdatePicker({dateFmt:'yyyy',readOnly:true})"></TD>
				<TD><button type="button" id="newaccountsubmit">提交</button></TD>
			</TR>
      		<TR height=60>
                <TD>所属年份：</TD>
                <TD>
                  <select id="year" name="year"> </select>
                </TD>
                <TD width=120>&nbsp;</TD>
            </TR>
            	<TR height=60>
                <TD>登录时间：</TD>
                <TD>
                  <INPUT class=textbox id="logintime" name="logintime" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',readOnly:true})">
                </TD>
                <TD width=120>&nbsp;</TD>
              </TR>  
          

              <TR height=40>
                <TD></TD>
                <TD align=right>
                  <INPUT id=btnLogin type=submit value=" 登 录 " name=btnLogin>
                </TD>
                <TD width=120>&nbsp;</TD>
              </TR>
              <TR height=110>
                <TD colSpan=4>&nbsp;</TD>
              </TR>
            </TBODY>
          </TABLE>
        </TD>
      </TR>
      <TR id=root height=104>
        <TD>&nbsp;</TD>
      </TR>
    </TBODY>
  </TABLE>
</DIV>
</form>
<DIV id=div2 style="DISPLAY: none"></DIV>
</CONTENTTEMPLATE>
</BODY>
</HTML>
