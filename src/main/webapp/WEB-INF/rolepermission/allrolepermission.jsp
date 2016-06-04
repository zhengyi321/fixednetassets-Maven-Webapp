<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE>Untitled Page</TITLE>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<STYLE type=text/css> 
{
	FONT-SIZE: 12px
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
	   		<form action="/fixednetassets/rolepermission/add.do" align="left">
	   		<input type="hidden" id="page" name="page" value="1"/>
			<Button class="gridViewItem" style="color:#566984;" type="submit">增加</Button>
			<Button class="gridViewItem" style="color:#566984;" id="delete" type="button">删除</Button>
			<DIV> <SPAN id=lblDep></SPAN>当前页为: ${currentpage } </DIV>
			</form>
            <TABLE class=gridView id=ctl00_ContentPlaceHolder2_GridView1 
      style="WIDTH: 100%;table-layout:fixed;word-break:break-all; BORDER-COLLAPSE: collapse" cellSpacing=0 rules=all 
      border=1>
              <TBODY>
                <TR>
                  <TH class=gridViewHeader scope=col><input type="checkbox" id="allselect"/>全选/反选</TH>  
                  <TH class=gridViewHeader scope=col>角色</TH>
                  <TH class=gridViewHeader scope=col>权限</TH>
                  <TH class=gridViewHeader scope=col>编辑</TH> 
                </TR>
                <c:forEach items="${rolePermissionList }" var = "rolePermission">
                <TR>
                  <TD class=gridViewItem><input type="checkbox" name="checks" value="${rolePermission.guid }" /></TD>                  
                  <TD class=gridViewItem>${rolePermission.rolename }</TD>
                  <TD class=gridViewItem>${rolePermission.permissionname }</TD>
                  <TD align="center" >
                	编辑/查看               
            	  </TD>           
                </TR>
     
                </c:forEach>
                
              </TBODY>
            </TABLE>
            <div class="gridView" align="right">
         共${nums}条记录 ${pages.pageNow}/${pages.totalPageCount} 页 
         <a href='/fixednetassets/rolepermission/index.do?page=1' >首页</a>  
			<c:choose>
				<c:when test="${pages.pageNow - 1 > 0}">
					<a href="/fixednetassets/rolepermission/index.do?page=${pages.pageNow - 1}">上一页</a>
				</c:when>
				<c:when test="${pages.pageNow - 1 <= 0}">
					<a href="/fixednetassets/rolepermission/index.do?page=1">上一页</a>
				</c:when>
			</c:choose>
			<c:choose>
				<c:when test="${pages.pageNow + 1 < pages.totalPageCount}">
					<a href="/fixednetassets/rolepermission/index.do?page=${pages.pageNow + 1}">下一页</a>
				</c:when>
				<c:when test="${pages.pageNow + 1 >= pages.totalPageCount}">
					<a href="/fixednetassets/rolepermission/index.do?page=${pages.totalPageCount}">下一页</a>
				</c:when>
			</c:choose>
	
	
         <a href='/fixednetassets/rolepermission/index.do?page=${pages.totalPageCount}' >最后一页</a>    
         </div>
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
		//	alert(checked);
			$.post("/fixednetassets/rolepermission/delete.do?guid="+checked, 
			function(data)
			{
		//		alert(data);
				if(data == true)
				{
				 	window.location.href="/fixednetassets/rolepermission/index.do?page=1";
				}
			}); 
		}
		})				
 			
 			
</SCRIPT>

</BODY>
</HTML>
