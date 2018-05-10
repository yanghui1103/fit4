<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html> 
<html lang="en"> 
<head> 
    <meta charset="utf-8"> 
    <meta name="viewport" content="width=device-width, initial-scale=1"> 
    <title>信息管理系统</title> 
	<link href="<%=basePath%>common/fit/v4/static/lightblue/css/base.css" rel="stylesheet">
	<link href="<%=basePath%>common/fit/v4/custom/lightblue/uimaker/easyui.css"  rel="stylesheet" >
	<link href="<%=basePath%>common/fit/v4/static/lightblue/css/index.css"  rel="stylesheet" >
	<link href="<%=basePath%>common/fit/v4/static/lightblue/css/platform.css" rel="stylesheet">
	<script type="text/javascript" src="<%=basePath%>common/fit/v4/js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>common/fit/v4/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>common/fit/v4/js/easyui-lang-zh_CN.js"></script>	
	<%--     <jsp:include page="../../../../common/common.jsp" /> --%>
</head> 
<body>
    <div class="container">
        <div id="pf-hd">
            <div class="pf-logo">
                <img src="<%=basePath%>common/fit/v4/static/lightblue/images/main/main_logo.png" alt="logo">
            </div>     
            

            <div class="pf-user">
            	<span class="msgts">10</span>
                <div class="pf-user-photo">
                    <img src="<%=basePath%>common/fit/v4/static/lightblue/images/main/user.png" alt="">                   
                </div>
                <h4 class="pf-user-name ellipsis">uimaker</h4>
                <i class="iconfont xiala">&#xe607;</i>

                <div class="pf-user-panel">
                    <ul class="pf-user-opt">
                        <li>
                            <a href="javascript:;">
                                <i class="iconfont">&#xe60d;</i>
                                <span class="pf-opt-name">用户信息</span>
                            </a>
                        </li>
                         <li class="pf-modify-pwd">
                            <a href="http://www.uimaker.com">
                                <i class="iconfont">&#xe6f8;</i>
                                <span class="pf-opt-name">消息<i class="mailtext">[10]</i></span>
                            </a>
                        </li>
                        <li class="pf-modify-pwd">
                            <a href="http://www.uimaker.com">
                                <i class="iconfont">&#xe634;</i>
                                <span class="pf-opt-name">修改密码</span>
                            </a>
                        </li>
                        <li class="pf-logout">
                            <a href="javascript:;">
                                <i class="iconfont">&#xe60e;</i>
                                <span class="pf-opt-name">退出</span>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>

        </div>

        <div id="pf-bd">
            <div class="pf-sider-wrap">
              <!-- <div id="pf-sider">
                  <h2 class="pf-model-name">
                      <span class="iconfont">&#xe633;</span>
                      <span class="pf-name">组织管理</span>
                      <span class="toggle-icon"></span>
                  </h2>

                  <ul class="sider-nav">
                       <li class="current">
                          <a href="javascript:;">
                              <span class="iconfont sider-nav-icon">&#xe633;</span>
                              <span class="sider-nav-title">供应商组织</span>
                              <i class="iconfont">&#xe642;</i>
                          </a>
                          <ul class="sider-nav-s">
                             <li class="active"><a href="#">供应商组织1</a></li>
                             <li><a href="#">供应商组织2</a></li>
                             <li><a href="#">供应商组织3</a></li>
                             <li><a href="#">供应商组织4</a></li>
                          </ul>
                       </li>
                       <li>
                          <a href="javascript:;">
                              <span class="iconfont sider-nav-icon">&#xe633;</span>
                              <span class="sider-nav-title">采购组织</span>
                              <i class="iconfont">&#xe642;</i>
                          </a>
                          <ul class="sider-nav-s">
                             <li class="active"><a href="#">供应商组织1</a></li>
                             <li><a href="#">供应商组织2</a></li>
                             <li><a href="#">供应商组织3</a></li>
                             <li><a href="#">供应商组织4</a></li>
                          </ul>
                       </li>
                       <li>
                          <a href="javascript:;">
                              <span class="iconfont sider-nav-icon">&#xe633;</span>
                              <span class="sider-nav-title">专家库</span>
                              <i class="iconfont">&#xe642;</i>
                          </a>
                          <ul class="sider-nav-s">
                             <li class="active"><a href="#">供应商组织1</a></li>
                             <li><a href="#">供应商组织2</a></li>
                             <li><a href="#">供应商组织3</a></li>
                             <li><a href="#">供应商组织4</a></li>
                          </ul>
                       </li>
                       <li>
                          <a href="javascript:;">
                              <span class="iconfont sider-nav-icon">&#xe633;</span>
                              <span class="sider-nav-title">注册供应商</span>
                              <i class="iconfont">&#xe642;</i>
                          </a>
                          <ul class="sider-nav-s">
                             <li class="active"><a href="#">供应商组织1</a></li>
                             <li><a href="#">供应商组织2</a></li>
                             <li><a href="#">供应商组织3</a></li>
                             <li><a href="#">供应商组织4</a></li>
                          </ul>
                       </li>
                       <li>
                          <a href="javascript:;">
                              <span class="iconfont sider-nav-icon">&#xe633;</span>
                              <span class="sider-nav-title">RFI动态信息</span>
                              <i class="iconfont">&#xe642;</i>
                          </a>
                       </li>
                       <li>
                          <a href="javascript:;">
                              <span class="iconfont sider-nav-icon">&#xe633;</span>
                              <span class="sider-nav-title">资质过期</span>
                              <i class="iconfont">&#xe642;</i>
                          </a>
                       </li>
                   </ul> 
              </div> -->
            </div>
            

            <div id="pf-page">
                <!-- <div class="easyui-tabs1" style="width:100%;height:100%;">
                  <div title="首页" style="padding:10px 5px 5px 10px;">
                    <iframe class="page-iframe" src="workbench.html" frameborder="no"   border="no" height="100%" width="100%" scrolling="auto"></iframe>
                  </div>
                  <div title="采购组织" style="padding:10px 5px 5px 10px;" data-options="closable:true">
                    <iframe class="page-iframe" src="index.html" frameborder="no"   border="no" height="100%" width="100%" scrolling="auto"></iframe>
                    </div>
                  <div title="基本信息" data-options="closable:true" style="padding:10px 5px 5px 10px;">
                    <iframe class="page-iframe" src="basic_info.html" frameborder="no"   border="no" height="100%" width="100%" scrolling="auto"></iframe>
                  </div>
                  <div title="业务流程" data-options="closable:true" style="padding:10px 5px 5px 10px;">
                    <iframe class="page-iframe" src="process.html" frameborder="no"   border="no" height="100%" width="100%" scrolling="auto"></iframe>
                  </div>
                </div> -->
            </div>
        </div>

        <div id="pf-ft">
            <div class="system-name">
              <i class="iconfont">&#xe6fe;</i>
              <span>信息管理系统&nbsp;v1.0</span>
            </div>
            <div class="copyright-name">
              <span>CopyRight&nbsp;2016&nbsp;&nbsp;uimaker.com&nbsp;版权所有</span>
              <i class="iconfont" >&#xe6ff;</i>
            </div>
        </div>
    </div>

    <div id="mm" class="easyui-menu tabs-menu" style="width:120px;display:none;">
         <div id="mm-tabclose">关闭</div>
         <div id="mm-tabcloseall">关闭所有</div>
         <div id="mm-tabcloseother">关闭其他</div> 
    </div>
    <div id="dlg" class="easyui-dialog" title="业务日志查看" data-options="closed:true,modal:true" style="width:720px;height:490px;padding:10px;display:none;">
      <link rel="stylesheet" type="text/css" href="<%=basePath%>common/fit/v4/static/lightblue/css/process.css">
      <div class="time-line">
        <div class="time-item date">
          <div class="content-left first">
            <span>2016-04-25</span>
            <label><span class="dot"></span><i class="line"></i></label>
          </div>
        </div>
        <div class="time-item time">
          <div class="content-left">
            <span>15:58:34</span>
            <label><i class="line"></i><span class="dot"></span></label>
          </div>
          <div class="content-right">
            <span class="left-arrow"></span>
            <div class="detail-outer">
              <div class="detail">
                <div>
                  <span class="name">占立中</span>
                  <label>[买方]</label>
                  <span class="status">发布</span>
                </div>
                <div>
                  <span class="name">占立中</span>
                  <label>[买方]</label>
                  <span class="status">发布</span>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="time-item time important">
          <div class="content-left">
            <span>17:00:21</span>
            <label><i class="line"></i><span class="dot"></span></label>
          </div>
          <div class="content-right">
            <span class="left-arrow"></span>
            <div class="detail-outer">
              <div class="detail">
                <div>
                  <span class="name">纪相东</span>
                  <label>[供方]</label>
                  <span class="status">石家庄华能电力有限公司。报价已发布，报价单号：<span class="order">121568215782</span></span>
                </div>
                <div>
                  <span class="name">纪相东</span>
                  <label>[供方]</label>
                  <span class="status">石家庄华能电力有限公司。报价已发布，报价单号：<span class="order">121568215782</span></span>
                </div>
                <div>
                  <span class="name">纪相东</span>
                  <label>[供方]</label>
                  <span class="status">石家庄华能电力有限公司。报价已发布，报价单号：<span class="order">121568215782</span></span>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="time-item date">
          <div class="content-left">
            <span>2016-04-26</span>
            <label><span class="dot"></span><i class="line"></i></label>
          </div>
        </div>
        <div class="time-item time">
          <div class="content-left">
            <span>09:21:14</span>
            <label><i class="line"></i><span class="dot"></span></label>
          </div>
          <div class="content-right">
            <span class="left-arrow"></span>
            <div class="detail-outer">
              <div class="detail">
                <div>
                  <span class="name">占立中</span>
                  <label>[买方]</label>
                  <span class="status">发布</span>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="time-item last">
          <div class="content-left">
            <label><i class="line"></i><span class="dot"></span></label>
          </div>
        </div>
      </div>
    </div>
    <script type="text/javascript" src="<%=basePath%>common/fit/v4/static/lightblue/js/menu.js"></script>
    <script type="text/javascript" src="<%=basePath%>common/fit/v4/static/lightblue/js/main.js"></script>
    <!--[if IE 7]>
      <script type="text/javascript">
        $(window).resize(function(){
          $('#pf-bd').height($(window).height()-76);
        }).resize();
        
      </script>
    <![endif]-->  

    
    <script type="text/javascript">
    $(window).resize(function(){
          $('.tabs-panels').height($("#pf-page").height()-46);
          $('.panel-body').not('.messager-body').height($(".easyui-dialog").height)
    }).resize();

    var page = 0,
        pages = ($('.pf-nav').height() / 70) - 1;

    if(pages === 0){
      $('.pf-nav-prev,.pf-nav-next').hide();
    }
    $(document).on('click', '.pf-nav-prev,.pf-nav-next', function(){


      if($(this).hasClass('disabled')) return;
      if($(this).hasClass('pf-nav-next')){
        page++;
        $('.pf-nav').stop().animate({'margin-top': -70*page}, 200);
        if(page == pages){
          $(this).addClass('disabled');
          $('.pf-nav-prev').removeClass('disabled');
        }else{
          $('.pf-nav-prev').removeClass('disabled');
        }
        
      }else{
        page--;
        $('.pf-nav').stop().animate({'margin-top': -70*page}, 200);
        if(page == 0){
          $(this).addClass('disabled');
          $('.pf-nav-next').removeClass('disabled');
        }else{
          $('.pf-nav-next').removeClass('disabled');
        }
        
      }
    })

    // setTimeout(function(){
    //    $('.tabs-panels').height($("#pf-page").height()-46);
    //    $('.panel-body').height($("#pf-page").height()-76)
    // }, 200)
    function replace(doc, style) {


      $('link', doc).each(function(index, one) {

        var path = $(one).attr('href').replace(/(static\/)\w+(\/css)/g, '$1' + style + '$2').replace(/(custom\/)\w+(\/)/g, '$1' + style + '$2'),
          sheet;

        if(doc.createStyleSheet) {

          sheet = doc.createStyleSheet(path);
          setTimeout(function() {

            $(one).remove();

          }, 500)

        } else {

          sheet = $('<link rel="stylesheet" type="text/css" href="' + path + '" />').appendTo($('head', doc));
          sheet = sheet[0];
          sheet.onload = function() {

            $(one).remove();

          }

        }

      })

      $('img', doc).each(function(index, one) {

        var path = $(one).attr('src').replace(/(static\/)\w+(\/images)/g, '$1' + style + '$2');

        $(one).attr('src', path);

      })

    }
    $('.skin-item').click(function() {

      var color = $(this).data('color');
      replaceAll(color);

    })
    function replaceAll(style) {

      $('iframe').each(function(index, one) {

        try {

          replace(one.contentWindow.document, style)

        } catch(e) {

          console.warn('origin cross');

        }

      })

      replace(document, style)

    }
    </script>
</body> 
</html>
