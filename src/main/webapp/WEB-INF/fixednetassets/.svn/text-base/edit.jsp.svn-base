<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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

<script type="text/javascript" src="/fixednetassets/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="/fixednetassets/js/My97DatePicker/calendar.js"></script>
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
			
				<form action="/fixednetassets/fixednetassets/editsubmit.do" method="post" class="gridView" enctype="multipart/form-data">
				<input type="hidden" id="guid" name="guid" value="${fixed.guid }" />
			    <table class="gridView" align="left">

			        
			        <tr>
			            <td width="10%" class="tableleft">总页:</td>
			            
			            <td><input type="xt" name="total" id="total" value="${fixed.total }" class="gridViewItem"/></td>
			        </tr> 
			      	<tr>
			            <td width="10%" class="tableleft">分页:</td>
			            
			            <td><input type="text" name="page" id="page" value="${fixed.page }" class="gridViewItem"/></td>
			        </tr> 
			        <tr>
			            <td width="10%" class="tableleft">编号:</td>
			            
			            <td><input type="text" name="code" id="code" value="${fixed.code }" class="gridViewItem"/></td>
			        </tr>
			        
			        <tr>
			            <td width="10%" class="tableleft">名称:</td>
			            
			            <td><input type="text" name="name" id="name" value="${fixed.name }" class="gridViewItem"/></td>
			        </tr>
			        
			        <tr>
			            <td width="10%" class="tableleft">结构规格:</td>
			            
			            <td><input type="text" name="ssize" id="ssize" value="${fixed.ssize }" class="gridViewItem"/></td>
			        </tr>
			        
			        <tr>
			            <td width="10%" class="tableleft">计量单位:</td>
			            
			            <td><input type="text" name="units" id="units" value="${fixed.units }" class="gridViewItem"/></td>
			        </tr>
			        
			        <tr>
			            <td width="10%" class="tableleft">使用年限:</td>
			            
			            <td><input type="text" name="life" id="life" value="${fixed.life }" class="gridViewItem"/></td>
			        </tr>
			        

			        

			        
			        <tr>
			            <td width="10%" class="tableleft">折旧率(年):</td>
			            
			            <td><input type="text" name="year" id="year" value="${fixed.year }" class="gridViewItem"/></td>
			        </tr>
			        
			        <tr>
			            <td width="10%" class="tableleft">折旧率(月):</td>
			            
			            <td><input type="text" name="month" id="month" value="${fixed.month }" class="gridViewItem"/></td>
			        </tr>
			        
			       <tr>
			            <td width="10%" class="tableleft">设备购入时间:</td>
			            
			            <td><input type="text" name="buytime" id="buytime" class="gridViewItem" value=<fmt:formatDate value="${fixed.createTime }" pattern="yyyy-MM-dd HH:mm" /> onclick="WdatePicker({dateFmt:'yyyy-MM-dd',readOnly:true})"/></td>
			        </tr>
			        
			       
			        <tr>
			        <td class="tableleft"></td>
			        <td><button type="submit"   class="gridViewItem">修改</button>  &nbsp;&nbsp;<button type="button" class="gridViewItem" name="back" id="back" >返回</button>	</td>
			        </tr>

			    </table>
				</form>
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
	$("#back").click(function(){		
		window.history.go(-1);	
	});
</SCRIPT>

</BODY>
</HTML>
