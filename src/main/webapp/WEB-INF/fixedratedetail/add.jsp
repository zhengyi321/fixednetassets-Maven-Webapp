<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE>累计折旧明细账</TITLE>
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
<script type="text/javascript" src="/fixednetassets/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="/fixednetassets/js/My97DatePicker/calendar.js"></script>
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
			
				<form action="/fixednetassets/fixedratedetail/addsubmit.do" method="post" class="gridView" enctype="multipart/form-data">
			
			    <table class="gridView" align="left">

			        
			        <tr>
			            <td width="10%" class="tableleft">摘要:</td>
			            
			            <td><input type="xt" name="remark" id="remark" class="gridViewItem"/></td>
			        </tr> 
			      	<tr>
			            <td width="10%" class="tableleft">余额(数量):</td>
			            
			            <td><input type="text" name="fixedBalanceNum" id="fixedBalanceNum" class="gridViewItem"/></td>
			        </tr> 
			        <tr>
			            <td width="10%" class="tableleft">余额(金额):</td>
			            
			            <td><input type="text" name="fixedBalancePrice" id="fixedBalancePrice" class="gridViewItem"/></td>
			        </tr>
			        
			        <tr style="display:none">
			            <td width="10%" class="tableleft" >本月提取金额:</td>
			            
			            <td><input type="text" name="sumDepreciationCurrentmonth" id="sumDepreciationCurrentmonth" class="gridViewItem"/></td>
			        </tr>
			        
			        <tr>
			            <td width="10%" class="tableleft">累计折旧:</td>
			            
			            <td><input type="text" name="sumDepreciationTotal" id="sumDepreciationTotal" class="gridViewItem"/></td>
			        </tr>
			        
			        <tr style="display:none">
			            <td width="10%" class="tableleft">固定资产净值:</td>
			            
			            <td><input type="text" name="fixedNetWorth" id="fixedNetWorth" class="gridViewItem"/></td>
			        </tr>
			        
			      	<tr>
			            <td width="10%" class="tableleft">
			            	费用类别
			            </td>
			            
			            <td><select id="feetype" name="feetype">
			            <option value="manage">管理费用</option>
			            <option value="made">制造费用</option>
			            </select></td>
			        </tr>
			        
			       
			        <tr>
			        <td class="tableleft"></td>
			        <td><button type="submit"   class="gridViewItem">添加</button>  &nbsp;&nbsp;<button type="button" class="gridViewItem" name="back" id="back">返回</button>	</td>
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
