<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html lang="ko">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <%--  favicons  --%>
    <link rel="apple-touch-icon" sizes="57x57"
          href="${pageContext.request.contextPath}/resources/img/favicon/apple-icon-57x57.png">
    <link rel="apple-touch-icon" sizes="60x60"
          href="${pageContext.request.contextPath}/resources/img/favicon/apple-icon-60x60.png">
    <link rel="apple-touch-icon" sizes="72x72"
          href="${pageContext.request.contextPath}/resources/img/favicon/apple-icon-72x72.png">
    <link rel="apple-touch-icon" sizes="76x76"
          href="${pageContext.request.contextPath}/resources/img/favicon/apple-icon-76x76.png">
    <link rel="apple-touch-icon" sizes="114x114"
          href="${pageContext.request.contextPath}/resources/img/favicon/apple-icon-114x114.png">
    <link rel="apple-touch-icon" sizes="120x120"
          href="${pageContext.request.contextPath}/resources/img/favicon/apple-icon-120x120.png">
    <link rel="apple-touch-icon" sizes="144x144"
          href="${pageContext.request.contextPath}/resources/img/favicon/apple-icon-144x144.png">
    <link rel="apple-touch-icon" sizes="152x152"
          href="${pageContext.request.contextPath}/resources/img/favicon/apple-icon-152x152.png">
    <link rel="apple-touch-icon" sizes="180x180"
          href="${pageContext.request.contextPath}/resources/img/favicon/apple-icon-180x180.png">
    <link rel="icon" type="image/png" sizes="192x192"
          href="${pageContext.request.contextPath}/resources/img/favicon/android-icon-192x192.png">
    <link rel="icon" type="image/png" sizes="32x32"
          href="${pageContext.request.contextPath}/resources/img/favicon/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="96x96"
          href="${pageContext.request.contextPath}/resources/img/favicon/favicon-96x96.png">
    <link rel="icon" type="image/png" sizes="16x16"
          href="${pageContext.request.contextPath}/resources/img/favicon/favicon-16x16.png">
    <link rel="manifest" href="${pageContext.request.contextPath}/resources/img/favicon/manifest.json">
    <meta name="msapplication-TileColor" content="#ffffff">
    <meta name="msapplication-TileImage" content="/ms-icon-144x144.png">
    <meta name="theme-color" content="#ffffff">

    <title>춘천시장</title>

    <%--  Bootstrap  --%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">

    <!--  My Stylesheet  -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/style/r_style.css">

    <%--  JQuery  --%>
    <script src="http://code.jquery.com/jquery-latest.js"></script>
</head>

<body>

<nav class="navbar navbar-expand bg-light fixed-top r-navbar r-bg-primary not-draggable" id="navbar">
    <div class="container-fluid align-text-bottom">
        <a class="navbar-brand" href="/">
            <img src="${pageContext.request.contextPath}/resources/img/icon.png" alt="" width="24"
                 height="24" style="margin: 0;"
                 class="d-inline-block align-text-top not-draggable-img">
            춘천시장
        </a>
        <div class="collapse navbar-collapse scroll-horiz scroll-no-bar" id="navbarNav">
            <ul class="navbar-nav">
                <li classㄹ="nav-item">
                    <a class="nav-link r-active r-nav-link" aria-current="page" href="#">홈</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link r-nav-link" href="#skills">시장 톺아보기</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link r-nav-link" href="#skills">담벼락</a>
                </li>
            </ul>
        </div>
<%--        <c:choose>--%>
<%--            <c:when test="${user != null}">--%>
<%--                <a class="btn btn-outline-success btn-sm" type="submit" href="/logout">로그아웃</a>--%>
<%--            </c:when>--%>
<%--            <c:otherwise>--%>
<%--                <a class="btn btn-outline-success btn-sm" type="submit" href="/login">로그인</a>--%>
<%--            </c:otherwise>--%>
<%--        </c:choose>--%>
    </div>
</nav>

<%-- content --%>
<div class="container">

    <div class="container d-flex row mt-5">

        <c:forEach var="m" items="${markets}">
            <div class="card" style="width: 18rem;">
                <img src="/image/${m.fileId}" class="card-img-top" alt="">
                <div class="card-body">
                    <h5 class="card-title"><c:out value="${m.marketName}"/></h5>
                    <p class="card-text">
                        <c:out value="${m.marketDesc}"/>
                    </p>
                    <a href="#" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#prjModal"
                       onclick="getDocument(${m.getMarketId()})">자세히 보기</a>
                </div>
            </div>
        </c:forEach>

    </div>

</div>

<!-- Scrollable modal -->
<div class="modal fade" id="prjModal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
     aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-scrollable">
        <div class="modal-content r-bg-primary">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="prjModelTitle">Modal title</h1>
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal" aria-label="Close">X</button>
            </div>
            <div class="modal-body">
                <img src="" id="prjModalImg" width="100%"/>
                <div class="container mt-5" id="prjModalBody" style="white-space: pre-line;">

                </div>
            </div>
            <div class="modal-footer">
                <a type="button" class="btn btn-primary" id="prjModalBtnGithub" target="_blank">카카오맵 열기</a>
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
            </div>
        </div>
    </div>
</div>

<%-- Bootstrap --%>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous">
</script>
</body>

<script type="text/javascript">
    function getDocument(marketId) {
        $.ajax({
            url: "/market/" + marketId,
            type: "GET",
            async: true,
            timeout: 3000,
            beforeSend: function () {
                $("#prjModelTitle").text("");
                $("#prjModalBody").text("");
            },
            success: function (data, status, xhr) {
                $("#prjModelTitle").text(data.marketName);
                $("#prjModalImg").attr("src", "/image/" + data.fileId)
                var desc = data.marketDesc + "\n\n운영시간: "
                    + data.openTime + " ~ " + data.closeTime
                    + "\n운영요일: ";
                for (i in data.openDay) {
                    switch (i) {
                        case '0':
                            desc += "일"
                            break
                        case '1':
                            desc += "월"
                            break
                        case '2':
                            desc += "화"
                            break
                        case '3':
                            desc += "수"
                            break
                        case '4':
                            desc += "목"
                            break
                        case '5':
                            desc += "금"
                            break
                        case '6':
                            desc += "토"
                            break
                    }
                }
                $("#prjModalBody").text(desc);
                $("#prjModalBtnGithub").attr("href", "https://map.kakao.com/link/map/" + data.latitude + "," + data.longitude)
            },
            error: function (xhr, status, error) {
                $("#prjModelTitle").text("오류");
                $("#prjModalBody").text("정보를 불러올 수 없습니다.");
            }
        });
    }
</script>

</html>