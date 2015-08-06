<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <script src="<c:url value="/resources/lib/js/angularjs/angular.min.js" />"></script>
    </head>
    <body>
    Layout
        <tiles:insertAttribute name="header" />
        <tiles:insertAttribute name="content" />
        <tiles:insertAttribute name="footer" />
    </body>
</html>