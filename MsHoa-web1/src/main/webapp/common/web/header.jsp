<%--
  Created by IntelliJ IDEA.
  User: trinhngoclinh
  Date: 4/13/2018
  Time: 11:20 PM
  To change this template use File | Settings | File Templates.
--%>
<!--================Header Menu Area =================-->
<%@include file="/common/taglib.jsp"%>
<header class="main_menu_area">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#"><img src="../template/web/img/MitHoa_Toeic.png" alt=""></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span></span>
            <span></span>
            <span></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item "><a class="nav-link" href="index.html">Home</a></li>
                <li class="nav-item "><a class="nav-link" href="#">Pages</a></li>
                <li class="nav-item "><a class="nav-link" href="#">Shop</a></li>
                <li class="nav-item "><a class="nav-link" href="contact-us.html">Contact</a></li>
            </ul>
            <ul class="navbar-nav justify-content-end">
                <button style="margin-right: 10px" type="button" class="btn btn-primary btn-sm"><fmt:message key="label.login.vn" bundle="${lang}"/></button>
                <button type="button" class="btn btn-secondary btn-sm"><fmt:message key="label.logout.vn" bundle="${lang}"/></button>
            </ul>
            <%--<ul class="navbar-nav justify-content-end">--%>
                <%--<li><a href="#"><i class="icon_search"></i></a></li>--%>
                <%--<li><a href="#"><i class="icon_bag_alt"></i></a></li>--%>
            <%--</ul>--%>
        </div>
    </nav>
</header>
<!--================End Header Menu Area =================-->
