<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE>累计折旧明细账</TITLE>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<STYLE type=text/css> 
{
	FONT-SIZE: 12px
}
th
{
	white-space: nowrap;
	text-overflow: ellipsis;overflow: hidden;
}
td
{
	white-space: nowrap;
	text-overflow: ellipsis;overflow: hidden;
}
.gridView {
	BORDER-RIGHT: #bad6ec 1px; BORDER-TOP: #bad6ec 1px; BORDER-LEFT: #bad6ec 1px; COLOR: #566984; BORDER-BOTTOM: #bad6ec 1px; FONT-FAMILY: Courier New
}
.gridViewHeader {
	BORDER-RIGHT: #bad6ec 1px solid; BORDER-TOP: #bad6ec 1px solid; BACKGROUND-IMAGE: url(/fixednetassets/images/bg_th.gif); BORDER-LEFT: #bad6ec 1px solid; LINE-HEIGHT: 27px; BORDER-BOTTOM: #bad6ec 1px solid
}
.gridViewItem {
	BORDER-RIGHT: #bad6ec 1px solid; BORDER-TOP: #bad6ec 1px solid; BORDER-LEFT: #bad6ec 1px solid; LINE-HEIGHT: 32px; BORDER-BOTTOM: #bad6ec 1px solid; TEXT-ALIGN: center
}
.cmdField {
	BORDER-RIGHT: 0px; BORDER-TOP: 0px; BACKGROUND-IMAGE: url(/fixednetassets/images/bg_rectbtn.png); OVERFLOW: hidden; BORDER-LEFT: 0px; WIDTH: 67px; COLOR: #364c6d; LINE-HEIGHT: 27px; BORDER-BOTTOM: 0px; BACKGROUND-REPEAT: repeat-x; HEIGHT: 27px; BACKGROUND-COLOR: transparent; TEXT-DECORATION: none
}
.buttonBlue {
	BORDER-RIGHT: 0px; BORDER-TOP: 0px; BACKGROUND-IMAGE: url(/fixednetassets/images/bg_button_blue.gif); BORDER-LEFT: 0px; WIDTH: 78px; COLOR: white; BORDER-BOTTOM: 0px; BACKGROUND-REPEAT: no-repeat; HEIGHT: 21px
}
</STYLE>
<META content="MSHTML 6.00.2900.5848" name=GENERATOR>
</HEAD>
<BODY 
style="BACKGROUND-POSITION-Y: -120px; BACKGROUND-IMAGE: url(/fixednetassets/images/bg.gif); BACKGROUND-REPEAT: repeat-x">
<SCRIPT type=text/javascript>
//<![CDATA[
var theForm = document.forms['aspnetForm'];
if (!theForm) {
    theForm = document.aspnetForm;
}
function __doPostBack(eventTarget, eventArgument) {
    if (!theForm.onsubmit || (theForm.onsubmit() != false)) {
        theForm.__EVENTTARGET.value = eventTarget;
        theForm.__EVENTARGUMENT.value = eventArgument;
        theForm.submit();
    }
}
//]]>
</SCRIPT>
<SCRIPT src="/fixednetassets/common/EmployeeMgr.files/WebResource.axd" type=text/javascript></SCRIPT>
<SCRIPT src="/fixednetassets/common/EmployeeMgr.files/ScriptResource.axd" 
type=text/javascript></SCRIPT>
<SCRIPT 
src="/fixednetassets/common/EmployeeMgr.files/ScriptResource(1).axd" 
type=text/javascript></SCRIPT>

<DIV>

  <TABLE height="100%" cellSpacing=0 cellPadding=0 width="100%" border=0>
    <TBODY>
    	
   
      <TR>
      	
        
        <TD 
    style="PADDING-RIGHT: 10px; PADDING-LEFT: 10px; PADDING-BOTTOM: 10px; COLOR: #566984; PADDING-TOP: 10px; BACKGROUND-COLOR: white" 
    vAlign=top align=middle>
          <DIV>
	   		<form action="/fixednetassets/fixedratedetail/add.do" align="left">
			<Button class="gridViewItem" style="color:#566984;" type="button" id="export" name="export">导出excel</Button>
			<Button class="gridViewItem" style="color:#566984;" id="delete" type="button">删除</Button>&nbsp&nbsp
			<Button class="gridViewItem" style="color:#566984;" id="add" type="submit">增加</Button>&nbsp&nbsp		
			<Button class="gridViewItem" style="color:#566984;" id="cancel" type="button">取消折旧</Button>&nbsp&nbsp		
			</form>
				
            <TABLE class=gridView id=ctl00_ContentPlaceHolder2_GridView1 
      style="WIDTH: 100%; BORDER-COLLAPSE: collapse" cellSpacing=0 rules=all 
      border=1 >
              <TBODY>
              <TR>
              	  <TH colspan=2>结构规格： ${fixednetasset.ssize }</TH>
              	  <TH colspan=2>计量单位：${fixednetasset.units } </TH>
              	  <TH colspan=2>使用年限： ${fixednetasset.life }</TH>
              	  <TH colspan=2>折旧率(年)：${fixednetasset.year } </TH>
              	  <TH colspan=2>折旧率(月)：${fixednetasset.month } </TH>
              	  <TH colspan=2>总页： ${fixednetasset.total }</TH>
              	  <TH colspan=2>分页：${fixednetasset.page } </TH>
              	  <TH colspan=2>编号： ${fixednetasset.code }</TH>
              	  <TH colspan=2>名称： ${fixednetasset.name }</TH>
              	</TR>
                <TR>
                  <TH rowspan="3"><input type="checkbox" id="allselect"/>全选/反选</TH>  
                  <TH colspan=4 >年凭证(${year})</TH>
                  <TH rowspan="3">摘要</TH>
                  <TH colspan=7>固定资产原值</TH> 
                  <TH colspan=2>累计折旧</TH> 
                  <TH rowspan="3">固定资产净值</TH> 
                  <TH rowspan="3" >编辑</TH> 
                </TR>
                <tr>
                  <TH rowspan="2">月</TH>
                  <TH rowspan="2">日</TH>
                  <TH rowspan="2">类别</TH>
                  <TH rowspan="2">号数</TH>               
                  <TH colspan=3 >借（增）方</TH>
                  <TH colspan=2 >贷（减）方</TH>
                  <TH colspan=2 >余额</TH>
                  <TH rowspan="2">本月提取金额</TH>
                  <TH rowspan="2">累计金额</TH>
                </tr>
                <tr>
                  
                  <TH>数量</TH>
                  <TH>单价</TH>
                  <TH>金额</TH>
                  <TH>数量</TH>
                  <TH>金额</TH>
                  <TH>数量</TH>
                  <TH>金额</TH>
                  
                </tr>
                <c:forEach items="${fixedDetailList }" var = "fixedDetail">
                <TR>
                  <TD class=gridViewItem><input type="checkbox" name="checks" value="${fixedDetail.guid }" /></TD>                  
                  <TD class=gridViewItem>${fixedDetail.yearproffMonth }</TD>
                  <TD class=gridViewItem>${fixedDetail.yearproffDay }</TD>
                  <TD class=gridViewItem>${fixedDetail.yearproffType }</TD> 
                  <TD class=gridViewItem>${fixedDetail.yearproffNum }</TD> 
                  <TD class=gridViewItem>${fixedDetail.remark }</TD> 
                  <TD class=gridViewItem>${fixedDetail.fixedAddNum }</TD> 
                  <TD class=gridViewItem>${fixedDetail.fixedAddPrice }</TD> 
                  <TD class=gridViewItem>${fixedDetail.fixedAddTotal }</TD> 
                  <TD class=gridViewItem>${fixedDetail.fixedReduceNum }</TD> 
                  <TD class=gridViewItem>${fixedDetail.fixedReducePrice }</TD> 
                  <TD class=gridViewItem>${fixedDetail.fixedBalanceNum }</TD> 
                  <TD class=gridViewItem>${fixedDetail.fixedBalancePrice }</TD> 
                  <TD class=gridViewItem>${fixedDetail.sumDepreciationCurrentmonth }</TD> 
                  <TD class=gridViewItem>${fixedDetail.sumDepreciationTotal }</TD> 
                  <TD class=gridViewItem>${fixedDetail.fixedNetWorth }</TD> 
                  <TD align="center" onclick="edit('${fixedDetail.guid}')">
                	编辑          
            	  </TD>           
                </TR>
     
                </c:forEach>
                
              </TBODY>
            </TABLE>
            
          </DIV>
        </TD>
        
      </TR>
  
    </TBODY>
  </TABLE>
</DIV>
<script type="text/javascript" src="/fixednetassets/js/jquery-1.8.1.min.js"></script>
<SCRIPT type=text/javascript>
//<![CDATA[
Sys.Application.initialize();
//]]>
	$('#allselect').click(
 		function(){
 			if($('#allselect').is(':checked')){
 				$("[name=checks]:checkbox").each(function(){
 					this.checked = true; 
 				}
 				)				 
 			}else{
				$("[name=checks]:checkbox").each(function(){
 					this.checked = false; 
 				})
 			}})
	$("#delete").click(function(){
		var checked = "";
		if(confirm("确认删除？"))
		{
			$("[name=checks]:checkbox").each(function(){			
				if(this.checked == true)
				{
					checked += $(this).val()+",";
				}			
			})
			$.post("/fixednetassets/fixedratedetail/delete.do?guid="+checked, 
			function(data)
			{
		//		alert(data);
				if(data == true)
				{
				 window.location.href="/fixednetassets/fixedratedetail/select.do?page=1";
				}
			}); 
		}
	})
	$("#cancel").click(function(){
		var checked = "";
		if(confirm("确认取消折旧？"))
		{
			$("[name=checks]:checkbox").each(function(){			
				if(this.checked == true)
				{
					checked += $(this).val()+",";
				}			
			})
			$.post("/fixednetassets/fixedratedetail/cancelrate.do?guid="+checked, 
			function(data)
			{
		//		alert(data);
				if(data == true)
				{
				 window.location.href="/fixednetassets/fixedratedetail/select.do?guid=${fixednetasset.guid}";
				}
			}); 
		}
	})
	function edit(data){
		window.location.href="/fixednetassets/fixedratedetail/edit.do?guid="+data;
	}
</SCRIPT>

</BODY>
</HTML>
