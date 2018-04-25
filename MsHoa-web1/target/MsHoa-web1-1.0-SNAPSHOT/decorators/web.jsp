<%@include file="/common/taglib.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=ed
    ge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%--<link rel="stylesheet" href="<c:url value='/template/web/css/myCss.css' />" />--%>
    <link rel="icon" href="../template/web/img/icon1.png" type="image/x-icon" />
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title><fmt:message key="label.home.vn" bundle="${lang}"/></title>
    <link rel="stylesheet" href="../template/web/css/myCss.css">
    <!-- Icon css link -->
    <link href="../template/web/css/font-awesome.min.css" rel="stylesheet">
    <link href="../template/web/vendors/elegant-icon/style.css" rel="stylesheet">
    <link href="../template/web/vendors/themify-icon/themify-icons.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Poppins" rel="stylesheet">
    <!-- Bootstrap -->
    <link href="../template/web/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../template/web/FileUtils/animate.css">
    <!-- Rev slider css -->
    <link href="../template/web/vendors/revolution/css/settings.css" rel="stylesheet">
    <link href="../template/web/vendors/revolution/css/layers.css" rel="stylesheet">
    <link href="../template/web/vendors/revolution/css/navigation.css" rel="stylesheet">
    <link href="../template/web/vendors/animate-css/animate.css" rel="stylesheet">
    <!-- Extra plugin css -->
    <link href="../template/web/vendors/owl-carousel/owl.carousel.min.css" rel="stylesheet">
    <link href="../template/web/css/style.css" rel="stylesheet">
    <link href="../template/web/css/responsive.css" rel="stylesheet">
<style>
<%@ include file="../template/web/FileUtils/mycss"%>
</style>
    <script src="../template/web/js/jquery-3.2.1.min.js"></script>
    <%--<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>--%>
    <%--<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>--%>
    <dec:head />
</head>
<body>
<%-----------------Header-----------------%>
<%@include file="../common/web/header.jsp"%>
<%-----------------end Header-----------------%>

<%-----------------Body-----------------%>
<dec:body/>
<%-----------------end Body-----------------%>

<%-----------------Footer-----------------%>
<%@include file="../common/web/footer.jsp"%>
<%-----------------end Footer-----------------%>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->

<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="../template/web/js/popper.min.js"></script>
<script src="../template/web/js/bootstrap.min.js"></script>
<!-- Rev slider js -->
<script src="../template/web/vendors/revolution/js/jquery.themepunch.tools.min.js"></script>
<script src="../template/web/vendors/revolution/js/jquery.themepunch.revolution.min.js"></script>
<script src="../template/web/vendors/revolution/js/extensions/revolution.extension.actions.min.js"></script>
<script src="../template/web/vendors/revolution/js/extensions/revolution.extension.video.min.js"></script>
<script src="../template/web/vendors/revolution/js/extensions/revolution.extension.slideanims.min.js"></script>
<script src="../template/web/vendors/revolution/js/extensions/revolution.extension.layeranimation.min.js"></script>
<script src="../template/web/vendors/revolution/js/extensions/revolution.extension.navigation.min.js"></script>
<script src="../template/web/vendors/revolution/js/extensions/revolution.extension.slideanims.min.js"></script>
<!-- Extra plugin css -->
<%--<script src="../template/web/vendors/counterup/jquery.waypoints.min.js"></script>--%>
<%--<script src="../template/web/vendors/counterup/jquery.counterup.min.js"></script>--%>
<%--<script src="../template/web/vendors/counterup/apear.js"></script>--%>
<%--<script src="../template/web/vendors/counterup/countto.js"></script>--%>
<%--<script src="../template/web/vendors/owl-carousel/owl.carousel.min.js"></script>--%>
<%--<script src="../template/web/vendors/parallaxer/jquery.parallax-1.1.3.js"></script>--%>
<!--Tweets-->
<script src="../template/web/vendors/tweet/tweetie.min.js"></script>
<script src="../template/web/vendors/tweet/script.js"></script>
<script src="../template/web/js/theme.js"></script>
</body>
</html>